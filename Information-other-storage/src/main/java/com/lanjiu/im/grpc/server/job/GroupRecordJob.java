package com.lanjiu.im.grpc.server.job;

import com.lanjiu.im.grpc.server.controller.*;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GroupRecordJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //游客
        AutoAddNumberToGuestFriendUnused autoAddNumberToGuestFriendUnused = new AutoAddNumberToGuestFriendUnused();
        autoAddNumberToGuestFriendUnused.autoAddNumberToGuestFriendUnusedTable();

        AutoAddNumberToGuestGroupMemberUnused autoAddNumberToGuestGroupMemberUnused = new AutoAddNumberToGuestGroupMemberUnused();
        autoAddNumberToGuestGroupMemberUnused.autoAddNumberToGuestGroupMemberUnusedTable();

        AutoAddNumberToGuestGroupUnused autoAddNumberToGuestGroupUnused = new AutoAddNumberToGuestGroupUnused();
        autoAddNumberToGuestGroupUnused.autoAddNumberToGuestGroupUnusedTable();
        //注册
        AutoAddNumberToRegisteredFriendUnused autoAddNumberToRegisteredFriendUnused = new AutoAddNumberToRegisteredFriendUnused();
        autoAddNumberToRegisteredFriendUnused.autoAddNumberToRegisteredFriendUnusedRealTable();

        AutoAddNumberToRegisteredGroupMemberUnused autoAddNumberToRegisteredGroupMemberUnused = new AutoAddNumberToRegisteredGroupMemberUnused();
        autoAddNumberToRegisteredGroupMemberUnused.autoAddNumberToRegisteredGroupMemberUnusedTable();

        AutoAddNumberToRegisteredGroupUnused autoAddNumberToRegisteredGroupUnused = new AutoAddNumberToRegisteredGroupUnused();
        autoAddNumberToRegisteredGroupUnused.autoAddNumberToRegisteredGroupUnusedTable();
    }
}
