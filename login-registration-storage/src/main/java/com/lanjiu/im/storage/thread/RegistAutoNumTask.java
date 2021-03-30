package com.lanjiu.im.storage.thread;

import com.lanjiu.im.storage.util.NumSupportCheck;
import com.lanjiu.im.storage.util.PropertyConf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RegistAutoNumTask  extends Thread {



    public void run() {

        PropertyConf conf = new PropertyConf("/auto_number.properties");
        int minNum = Integer.parseInt(conf.getValue("min_auto_number"));
        int everyNum = Integer.parseInt(conf.getValue("every_auto_num"));
        int second = Integer.parseInt(conf.getValue("second"));


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                NumSupportCheck numSupportCheck = new NumSupportCheck();
                numSupportCheck.autoSupportNumber(minNum,everyNum);
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 5, second, TimeUnit.SECONDS);

    }
}
