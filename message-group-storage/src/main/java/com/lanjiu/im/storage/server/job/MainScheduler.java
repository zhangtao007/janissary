package com.lanjiu.im.storage.server.job;

import com.lanjiu.im.storage.util.ConfigFileOperation;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MainScheduler {

    //创建调度器
    public static Scheduler getScheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }


    public static void schedulerJob() throws SchedulerException{
        //获取任务周期 小时为检查周期的单位
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        int hour = Integer.valueOf(configFileOperation.getBeautifulNumberCycleConfig());
        System.out.println("hour :" + hour);
        int second = hour * 60 * 60;
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(GroupRecordJob.class).withIdentity("beautiful_number_check_job", "beautiful_number_check_job_group").build();
        //创建触发器 每个任务周期执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("beautiful_number_check_trigger", "beautiful_number_check_trigger_group")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(second).repeatForever())
                .build();
        Scheduler scheduler = getScheduler();
        //将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);
        //调度器开始调度任务
        scheduler.start();

    }

}
