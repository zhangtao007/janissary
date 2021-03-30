package com.lanjiu.im.storage.server.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GroupRecordJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //游客
        System.out.println("test job");
    }
}
