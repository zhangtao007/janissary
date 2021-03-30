package com.lanjiu.im.netty.grpc_pool.gmsgPool;

import com.lanjiu.im.netty.grpc_pool.filePool.GrpcClient;
import com.lanjiu.im.netty.grpc_pool.filePool.GrpcClientPool;
import com.lanjiu.pro.fileStorage.*;
import com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest;
import com.lanjiu.pro.groupStorage.MessageGroupStorageServiceGrpc;
import com.lanjiu.pro.groupStorage.ResponseResult;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class GmsgClient {

    private static final Logger logger = LoggerFactory.getLogger(GmsgClient.class);
    public static String host = "localhost";
    private final ManagedChannel channel;
    private final MessageGroupStorageServiceGrpc.MessageGroupStorageServiceBlockingStub  gmsgBlockingStub;

    public GmsgClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        gmsgBlockingStub = MessageGroupStorageServiceGrpc.newBlockingStub(channel);
    }



    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
    }

    public static Object call(String rpcMethodName , Object...args){
        GmsgClient client =null;

        try {
            client = GmsgClientPool.borrowObject();

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
                GmsgClientPool.returnObject(client);
            }
        }

    }

    //==============groupmessage storage=================
    public Object cleanGmsg(String toId){
        DeleteGroupMembersMsgRequest request = DeleteGroupMembersMsgRequest.newBuilder()
                .setUserId(toId).build();

        ResponseResult response = null;
        logger.info("定期/退出 清理用户离线***群消息："+toId);
        response = gmsgBlockingStub.deleteGroupMembersOffLineMsg(request);
        return response;
    }
}
