package com.lanjiu.im.storage.server.job;

import com.lanjiu.im.storage.server.controller.StorageController;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 好友和群文件每天定时删除上传超过七天的记录和对应的文件---可配置
 *
 */

public class GroupRecordJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        StorageController storageController = new StorageController();
        storageController.deleteControllerGroupByTask();
        storageController.deleteFriendFilePicVidByTask();
    }
}
