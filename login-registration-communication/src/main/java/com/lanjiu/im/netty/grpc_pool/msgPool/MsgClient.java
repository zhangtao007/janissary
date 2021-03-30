package com.lanjiu.im.netty.grpc_pool.msgPool;

import com.lanjiu.im.netty.clean.NotifyCleanOnLine;
import com.lanjiu.im.netty.grpc_pool.filePool.GrpcClient;
import com.lanjiu.im.netty.server.LoginRegistCommServerHandler;
import com.lanjiu.im.util.ConstType;
import com.lanjiu.im.util.ConstantKind;
import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.im.util.JCRC32;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.friend_msg.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class MsgClient {

    private static final Logger logger = LoggerFactory.getLogger(MsgClient.class);
    public static String host = "localhost";
    private final ManagedChannel channel;
    private final MessageFriendServiceGrpc.MessageFriendServiceBlockingStub msgBlockingStub;

    public MsgClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        msgBlockingStub = MessageFriendServiceGrpc.newBlockingStub(channel);
    }



    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(10, TimeUnit.SECONDS);
    }

    public static Object call(String rpcMethodName , Object...args){
        MsgClient client =null;

        try {
            client = MsgCLientPool.borrowObject();

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
                MsgCLientPool.returnObject(client);
            }
        }

    }

    //==============friendmessage storage=================
    public Object cleanMsg(String toId){
        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder()
                .setRet(ConstantKind.MESSAGE_REQUEST_DELETE_TO_ID)
                .addFriendMessage(FriendMessage.newBuilder()
                        .setToId(Integer.parseInt(toId)).build())
                .addNotifyDelMsg(NotifyDelMsg.newBuilder()
                        .setDeltoId(Integer.parseInt(toId)).build())
                .build();
        //通知客户端该用户所有好友及群成员清理在线消息
        Channel ch = (Channel) LoginRegistCommServerHandler.ctxMap.get(LoginRegistCommServerHandler.CHANNEL);
        long currentTimeMillis = System.currentTimeMillis();
        //推送客户端
        NotifyCleanOnLine.notifyAllRelete(ch,toId,currentTimeMillis);
        //调用消息服务器
        ResponseFriendMessage response = null;
        logger.info("定期/退出 清理用户离线消息："+toId);
        response = msgBlockingStub.removeFriendMessage(requestFriendMessage);
        return response;
    }
}
