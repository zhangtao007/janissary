package com.lanjiu.im.netty.grpc_pool.msgPool;

import com.lanjiu.im.util.PropertyConf;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class MsgCLientPool {
    private static GenericObjectPool<MsgClient> objectPool = null;

    static{
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        //池中的最大连接
        poolConfig.setMaxTotal(100);
        //最少的空闲连接
        poolConfig.setMinIdle(0);
        //最多的空闲连接
        poolConfig.setMaxIdle(10);
        //当连接池资源耗尽时，调用者最大阻塞时间，超时时抛出异常，单位：毫秒
        poolConfig.setMaxWaitMillis(-1);
        //连接池存放池化对象方式，true放在空闲队列最前面，false放在最后面
        poolConfig.setLifo(true);
        //连接空闲的最小时间，达到此值后空闲的连接可能会被移除，默认30分钟
        poolConfig.setMinEvictableIdleTimeMillis(100L*60L*30L);
        //连接耗尽时是否阻塞，默认为true
        poolConfig.setBlockWhenExhausted(true);
        objectPool = new GenericObjectPool<>(new MsgClientFactory(),poolConfig);
    }

    public static MsgClient  borrowObject(){
        MsgClient client = null;
        try {
            client = objectPool.borrowObject();
            return client;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createClient();
    }

    public static void returnObject(MsgClient client){

        try {
            objectPool.returnObject(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static MsgClient createClient() {
        PropertyConf propertyConf = new PropertyConf("/message_friend_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        return new MsgClient(address,port);
    }
}
