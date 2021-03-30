package com.lanjiu.im.communication.redis;

import com.lanjiu.im.communication.util.ConfigFileOperation;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Properties;

public class JedisPool {

    private static redis.clients.jedis.JedisPool readPool;
    private static redis.clients.jedis.JedisPool writePool;

    //静态代码初始化池配置
    static {
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties props = configFileOperation.getRedisServerConfig();
        //创建jedis池配置实例
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(props.getProperty("redis.maxTotal")));
        config.setMaxIdle(Integer.valueOf(props.getProperty("redis.maxIdle")));
        config.setMaxWaitMillis(Long.valueOf(props.getProperty("redis.maxWaitMillis")));
        config.setTestOnBorrow(Boolean.valueOf(props.getProperty("redis.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(props.getProperty("redis.testOnReturn")));

        //根据配置实例化jedis池
        readPool = new redis.clients.jedis.JedisPool(config, props.getProperty("redis.host"), Integer.valueOf(props.getProperty("redis.port")));
        writePool = new redis.clients.jedis.JedisPool(config, props.getProperty("redis.host"), Integer.valueOf(props.getProperty("redis.port")));
    }



    /**获得jedis对象*/
    public static Jedis getReadJedisObject(){
        return readPool.getResource();
    }
    /**获得jedis对象*/
    public static Jedis getWriteJedisObject(){
        return writePool.getResource();
    }

    /** 关闭jedis对象 */
    public static void cole(Jedis jedis){
        if (jedis != null) {
            jedis.close();
        }
    }
}
