package com.lanjiu.im.netty.clean;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QuartzManager {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    static final String jobGroupName = "jobGroup";
    static final String triggerGroupName = "triggerGroup";

    public static void addJob(String jobname, String triggerName, String expression,String userId) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(CleanJob.class).withIdentity(jobname,jobGroupName).build();
            JobDataMap jobDataMap = jobDetail.getJobDataMap();
            Map<String,String> map = new HashMap<String,String>();
            map.put("id",userId);
            map.put("corn",expression);
            jobDataMap.put("ukey",map);
            // 触发器名,触发器组
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName,triggerGroupName)
                    .withSchedule(CronScheduleBuilder.cronSchedule(expression)).build();
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动s
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void modifyJobExpression(String triggerName, String expression) {
        Scheduler sched = null;
        try {
            sched = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(expression)) {
                CronTrigger build = TriggerBuilder.newTrigger().withIdentity(triggerKey)
                        .withSchedule(CronScheduleBuilder.cronSchedule(expression).withMisfireHandlingInstructionDoNothing()).build();
                sched.rescheduleJob(triggerKey,build);
            }

            } catch (SchedulerException e) {
            e.printStackTrace();
        }



    }

    public static void removeJob(String jobName,String triggerName) {
        try {
            Scheduler sched = schedulerFactory.getScheduler();

            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

            sched.pauseTrigger(triggerKey);// 停止触发器
            sched.unscheduleJob(triggerKey);// 移除触发器
            sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void shutdownJobs() {
        try {
            Scheduler sched = schedulerFactory.getScheduler();
            if (!sched.isShutdown()) {
                sched.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
