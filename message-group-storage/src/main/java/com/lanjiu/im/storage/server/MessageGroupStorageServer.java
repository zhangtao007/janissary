package com.lanjiu.im.storage.server;

import com.lanjiu.im.storage.server.impl.MessageGroupStorageServiceGrpcImpl;
import com.lanjiu.im.storage.server.job.MainScheduler;
import com.lanjiu.im.storage.util.ConfigFileOperation;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import java.io.IOException;
import java.util.Properties;

public class MessageGroupStorageServer {

    private static final Logger logger = Logger.getLogger(MessageGroupStorageServer.class.getName());

    private Server server;

    private void start(int port) throws IOException {
        this.server = ServerBuilder.forPort(port).addService(new MessageGroupStorageServiceGrpcImpl()).build().start();
        Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
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

    private static void runServer() {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getMessageGroupStorageConfig();
        int port = Integer.valueOf(properties.getProperty("server_port"));
        MessageGroupStorageServer grpcServer = new MessageGroupStorageServer();
        try {
            grpcServer.start(port);
            grpcServer.awaitTermination();//如果不调用该方法，服务一启动就直接退出了,阻塞住服务器端，等待客户端调用
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            MainScheduler.schedulerJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        runServer();
    }
}
