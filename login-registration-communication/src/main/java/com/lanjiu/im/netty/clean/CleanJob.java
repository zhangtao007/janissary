package com.lanjiu.im.netty.clean;

import com.lanjiu.im.friendStorage.FriendMessageUtil;
import com.lanjiu.im.groupMsgStorage.GroupMessageUtil;
import com.lanjiu.im.netty.grpc_pool.filePool.GrpcClient;
import com.lanjiu.im.netty.grpc_pool.gmsgPool.GmsgClient;
import com.lanjiu.im.netty.grpc_pool.msgPool.MsgClient;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CleanJob implements Job {

    private  static final Logger logger = LoggerFactory.getLogger(CleanJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Map userMap = (Map) jobDataMap.get("ukey");
        String userId = (String) userMap.get("id");
        String cron = (String) userMap.get("cron");
        logger.info("userId:{} clean  beginning...",userId);


        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                 //定期清理信息资料(根据toId)
                GrpcClient.call("cleanfilesBytime",userId);
                MsgClient.call("cleanMsg",userId);
                GmsgClient.call("cleanGmsg",userId);
            }
        });
    }
}
