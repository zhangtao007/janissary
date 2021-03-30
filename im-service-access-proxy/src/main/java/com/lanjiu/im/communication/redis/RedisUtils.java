package com.lanjiu.im.communication.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisUtils {

    /**
     * 获取hash表中所有key
     * @param name
     * @return Set<String>
     */
    public static Set<String> hkeys(String name){
        Jedis jedis = JedisPool.getReadJedisObject();
        Set<String> hkeys = jedis.hkeys(name);
        JedisPool.cole(jedis);
        return hkeys;
    }

    /**
     * 从redis hash表中获取
     * @param hashName
     * @param key
     * @return String
     */
    public static String hget(String hashName, String key){
        Jedis jedis = JedisPool.getReadJedisObject();
        String hget = jedis.hget(hashName, key);
        JedisPool.cole(jedis);
        return hget;
    }

    /**
     * 删除hash表的键值对
     * @param hashName
     * @param key
     */
    public static Long hmdel(String hashName, String key){
        Jedis jedis = null;
        try {
            jedis = JedisPool.getWriteJedisObject();
            return jedis.hdel(hashName,key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }

    /**
     * 存放hash表键值对
     * @param hashName
     * @param key
     * @param value
     */
    public static Long setHashKV(String hashName,String key,String value){
        Jedis jedis = null;
        try {
            jedis = JedisPool.getWriteJedisObject();
            return jedis.hset(hashName,key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }

    /**
     * 删除键值对
     * @param k
     * @return
     */
    public static Long del(String k){
        Jedis jedis = null;
        try {
            jedis = JedisPool.getWriteJedisObject();
            return jedis.del(k);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }

    /**
     * 放键值对
     * 永久
     * @param k
     * @param v
     */
    public static String set(String k, String v) {
        Jedis jedis = null;
        try {
            jedis = JedisPool.getWriteJedisObject();
            return jedis.set(k, v);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }

    /**
     * 放键值对
     * @param k
     * @param v
     */
    public static String set(String k, int second, String v) {
        Jedis jedis = null;
        try {
            jedis = JedisPool.getWriteJedisObject();
            return jedis.setex(k, second, v);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }

    /**
     * 根据key取value
     *
     * @param k
     * @return
     */
    public static String get(String k) {
        Jedis jedis = null;
        try {
            jedis = JedisPool.getReadJedisObject();
            return jedis.get(k);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }

    public static List<String> hmget(String key, String... fields) {
        Jedis jedis = null;
        try {
            jedis = JedisPool.getReadJedisObject();
            return jedis.hmget(key, fields);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }

    public static String hmset(String key, Map<String, String> map) {
        Jedis jedis = null;
        try {
            jedis = JedisPool.getReadJedisObject();
            return jedis.hmset(key, map);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JedisPool.cole(jedis);
        }
        return null;
    }
}
