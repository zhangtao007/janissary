package com.lanjiu.im.storage.thread;

import com.lanjiu.im.storage.util.PropertyConf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BeautifulNumberSet extends Thread{


    public void run() {

        PropertyConf conf = new PropertyConf("/beautiful.properties");
        int beautifulNum = Integer.parseInt(conf.getValue("beautiful_num"));
        int beautifulNumPass = Integer.parseInt(conf.getValue("beautiful_num_pass"));
        int removeNum = Integer.parseInt(conf.getValue("remove_num"));
        int second = Integer.parseInt(conf.getValue("second"));


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //查询靓号已用库是否存在该号；
                //若没有使用，则插入
                //同时将该用户插入注册用户表；



            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 5, second, TimeUnit.SECONDS);

    }
}
