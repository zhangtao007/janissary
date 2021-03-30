package com.lanjiu.im.netty.grpc_pool.filePool;

import com.lanjiu.pro.fileStorage.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class GrpcClient {
    private static final Logger logger = LoggerFactory.getLogger(GrpcClient.class);
    public static String host = "localhost";
    private final ManagedChannel channel;
    private final FileStorageServiceGrpc.FileStorageServiceBlockingStub fileBlockingStub;
//    private final MessageFriendServiceGrpc.MessageFriendServiceBlockingStub msgBlockingStub;

    public GrpcClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        fileBlockingStub = FileStorageServiceGrpc.newBlockingStub(channel);
//        bookBlockingStub = BookServiceGrpc.newBlockingStub(channel);
    }



    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
    }

    public static Object call(String rpcMethodName , Object...args){
        GrpcClient client =null;

        try {
        client = GrpcClientPool.borrowObject();

        Class[] argsTypes = new Class[args.length];
        for (int i = 0; i <args.length ; i++) {
            argsTypes[i] = args[i].getClass();
        }

        Method method = null;

            method = client.getClass().getMethod(rpcMethodName,argsTypes);
            Object result  =method.invoke(client,args);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if(client !=null){
                GrpcClientPool.returnObject(client);
            }
        }

    }

    //==============file storage=================
    public Object cleanfilesBytime(String fromId){
        FriendsTransmissionRequest request = FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                        .setHead(Head.newBuilder()
                                .setFromId(fromId).build())
                        .build())
                .build();

        FriendsTransmissionResponse response = null;
       logger.info("定期/退出 清理用户文件："+fromId);
        response = fileBlockingStub.cleanFileWithUserId(request);
        return response;
    }
}
