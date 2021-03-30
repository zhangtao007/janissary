package com.lanjiu.im.grpc.server;

import com.lanjiu.im.grpc.server.impl.FileTransmissionServiceGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;
public class TransferCommunicationServer {

    private static final Logger logger = LoggerFactory.getLogger(TransferCommunicationServer.class);


    private Server server;

    private void start(int port) throws IOException {
        this.server = ServerBuilder.forPort(port).addService(new FileTransmissionServiceGrpcImpl()).build().start();
        logger.info("File_Server started, listening on port:{}" , port);
        System.out.println("File_Server started, listening on :"+port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                TransferCommunicationServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop(){
        if (null != this.server){
            this.server.shutdown();
        }
    }

    //启动后，让该方法等待，不要让它启动后，就退出
    private void awaitTermination() throws InterruptedException{
        if (null != this.server){
            this.server.awaitTermination();
            //this.server.awaitTermination(3000,TimeUnit.MILLISECONDS);
        }
    }

    public static void runServer()
    {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getTransferCommunicationConfig();
        int port = Integer.valueOf(properties.getProperty("server_port"));
        TransferCommunicationServer grpcServer = new TransferCommunicationServer();
        try {
            grpcServer.start(port);
            grpcServer.awaitTermination();//如果不调用该方法，服务一启动就直接退出了,阻塞住服务器端，等待客户端调用
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        runServer();
    }
}
