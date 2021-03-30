package com.lanjiu.im.communication.redis;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.netty.channel.group.ChannelGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class RedisService {

    public static void main(String[] args) {
        stream();
    }
    public static void stream() {
        //Map<String, Integer> map = ImmutableMap.of("A", 1, "B", 2, "C", 3, "D", 2);
        //System.out.println( getKeysByStream(map, 2));
    }

    private static <K, V> Set<K> getKeysByStream(Map<K, V> map, V value) {
        return map.entrySet()
                .stream()
                .filter(kvEntry -> Objects.equals(kvEntry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static void threadTestExecutor(){
//         Executors创建线程池的方法:
//
//       newFixedThreadPool()方法,该方法返回一个固定数量的线程池,该方法的线程数始终不变,当有一个任务提交时,若线程池中空闲,则立即执行;若没有,则会被暂缓在一个任务队列中等待有空闲的线程去执行.
//
//       newSingleThreadExecutor()方法,创建一个线程的线程池,若空闲则执行,若没有空闲线程则暂缓在任务队列中
//
//       newCachedThreadPool()方法,返回一个可根据实际情况调整线程数量的线程池,不限制最大线程数量,若有任务,则创建线程;若无任务,则不创建线程.若果没有任务,则线程在60s后自动回收(空闲时间60s)
//
//       newScheduledThreadPool()方法,该方法返回一个ScheduledExecutorService对象,但该线程池可以指定线程的数量
        ExecutorService executorService0 = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
        executorService0.submit(() ->{

        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        executorService1.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {

            }
        },10, TimeUnit.SECONDS);
    }
}
