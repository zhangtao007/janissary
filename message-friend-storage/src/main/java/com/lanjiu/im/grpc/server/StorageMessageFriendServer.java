package com.lanjiu.im.grpc.server;


import com.lanjiu.im.grpc.server.impl.MessageFriendServiceGrpcImpl;
import com.lanjiu.im.storage.utils.ConfigFileOperation;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class StorageMessageFriendServer {

    private  static  final Logger logger = LoggerFactory.getLogger(StorageMessageFriendServer.class);

    private Server server;

    private  void start(int port) throws IOException{

        this.server = ServerBuilder.forPort(port).addService(new MessageFriendServiceGrpcImpl()).build().start();
        logger.info("Msg_Friend_Server started  on port:{} " ,port);
        System.out.println("Msg_Friend_Server started  on port:"+port);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                StorageMessageFriendServer.this.stop();
                System.err.println("*** server shut down");
            }

        });
    }

    private void stop(){
        if(null != this.server){
            this.server.shutdown();
        }
    }

    //启动后让该方法等待，
    private void awaitTermination() throws InterruptedException {
        if(null != this.server){
            this.server.awaitTermination();
        }
    }

    public static void runServer()
    {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getMessageGroupStorageConfig();
        int port = Integer.valueOf(properties.getProperty("message_friend_storage_port"));
        StorageMessageFriendServer grpcServer = new StorageMessageFriendServer();
        try {
            grpcServer.start(port);
            grpcServer.awaitTermination();//如果不调用该方法，服务一启动就直接退出了,阻塞住服务器端，等待客户端调用
        } catch (IOException e) {
            System.out.println("msg_server error");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("msg_server fail");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        StorageMessageFriendServer.runServer();
    }
}
