package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberRegisteredUserPicture;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberRegisteredUserVideo;
import com.lanjiu.im.storage.service.RegisteredGroupRegisteredMemberRegisteredUserPictureService;
import com.lanjiu.im.storage.service.RegisteredGroupRegisteredMemberRegisteredUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.RegisteredUser;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController {

    public int saveRegisteredGroupRegisteredMemberRegisteredUserVideoController(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupRegisteredMemberRegisteredUserVideoService registeredGroupRegisteredMemberRegisteredUserVideoService = new RegisteredGroupRegisteredMemberRegisteredUserVideoService();
        RegisteredGroupRegisteredMemberRegisteredUserVideo registeredGroupRegisteredMemberRegisteredUserVideo = new RegisteredGroupRegisteredMemberRegisteredUserVideo();
        registeredGroupRegisteredMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberRegisteredUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberRegisteredUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = registeredGroupRegisteredMemberRegisteredUserVideoService.insertRecord(session, mapperb, registeredGroupRegisteredMemberRegisteredUserVideo);
        return result;
    }

    public int saveRegisteredGroupRegisteredMemberRegisteredUserPictureController(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupRegisteredMemberRegisteredUserPictureService registeredGroupRegisteredMemberRegisteredUserPictureService = new RegisteredGroupRegisteredMemberRegisteredUserPictureService();
        RegisteredGroupRegisteredMemberRegisteredUserPicture registeredGroupRegisteredMemberRegisteredUserPicture = new RegisteredGroupRegisteredMemberRegisteredUserPicture();
        registeredGroupRegisteredMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberRegisteredUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberRegisteredUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = registeredGroupRegisteredMemberRegisteredUserPictureService.insertRecord(session, mapperb, registeredGroupRegisteredMemberRegisteredUserPicture);
        return result;
    }

    public boolean deleteRegisteredGroupRegisteredMemberRegisteredUserVideoController(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupRegisteredMemberRegisteredUserVideoService registeredGroupRegisteredMemberRegisteredUserVideoService = new RegisteredGroupRegisteredMemberRegisteredUserVideoService();
        RegisteredGroupRegisteredMemberRegisteredUserVideo registeredGroupRegisteredMemberRegisteredUserVideo = new RegisteredGroupRegisteredMemberRegisteredUserVideo();
        registeredGroupRegisteredMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberRegisteredUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberRegisteredUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupRegisteredMemberRegisteredUserVideoService.deleteRecord(session, mapperb, registeredGroupRegisteredMemberRegisteredUserVideo);
        }
        List<RegisteredGroupRegisteredMemberRegisteredUserVideo> list = registeredGroupRegisteredMemberRegisteredUserVideoService.selectRecord(session, mapperb, registeredGroupRegisteredMemberRegisteredUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteRegisteredGroupRegisteredMemberRegisteredUserPictureController(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupRegisteredMemberRegisteredUserPictureService registeredGroupRegisteredMemberRegisteredUserPictureService = new RegisteredGroupRegisteredMemberRegisteredUserPictureService();
        RegisteredGroupRegisteredMemberRegisteredUserPicture registeredGroupRegisteredMemberRegisteredUserPicture = new RegisteredGroupRegisteredMemberRegisteredUserPicture();
        registeredGroupRegisteredMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberRegisteredUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberRegisteredUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupRegisteredMemberRegisteredUserPictureService.deleteRecord(session, mapperb, registeredGroupRegisteredMemberRegisteredUserPicture);
        }
        List<RegisteredGroupRegisteredMemberRegisteredUserPicture> list = registeredGroupRegisteredMemberRegisteredUserPictureService.selectRecord(session, mapperb, registeredGroupRegisteredMemberRegisteredUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    //task
    public boolean deleteTaskRegisteredGroupRegisteredMemberRegisteredUserVideoController(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb, long day){
        RegisteredGroupRegisteredMemberRegisteredUserVideoService registeredGroupRegisteredMemberRegisteredUserVideoService = new RegisteredGroupRegisteredMemberRegisteredUserVideoService();
        List<RegisteredGroupRegisteredMemberRegisteredUserVideo> list = registeredGroupRegisteredMemberRegisteredUserVideoService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupRegisteredMemberRegisteredUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupRegisteredMemberRegisteredUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean deleteTaskRegisteredGroupRegisteredMemberRegisteredUserPictureController(SqlSession session, RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb, long day){
        RegisteredGroupRegisteredMemberRegisteredUserPictureService registeredGroupRegisteredMemberRegisteredUserPictureService = new RegisteredGroupRegisteredMemberRegisteredUserPictureService();
        List<RegisteredGroupRegisteredMemberRegisteredUserPicture> list = registeredGroupRegisteredMemberRegisteredUserPictureService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupRegisteredMemberRegisteredUserPicture video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupRegisteredMemberRegisteredUserPictureService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
