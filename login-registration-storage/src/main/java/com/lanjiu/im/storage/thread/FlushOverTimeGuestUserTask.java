package com.lanjiu.im.storage.thread;

import com.lanjiu.im.regist.server.controller.CkeckOTGuestUser;
import com.lanjiu.im.storage.util.PropertyConf;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FlushOverTimeGuestUserTask extends Thread{

    public void run() {
        PropertyConf conf = new PropertyConf("/auto_guest_num.properties");
        int checkOverTime = Integer.parseInt(conf.getValue("check_overtime"));


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                CkeckOTGuestUser.ckeckOverTimeGuest(checkOverTime);
            }
        };
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, checkOverTime, checkOverTime, TimeUnit.SECONDS);

    }
}
