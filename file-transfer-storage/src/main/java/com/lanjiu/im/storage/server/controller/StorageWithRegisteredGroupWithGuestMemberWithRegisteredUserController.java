package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberRegisteredUserPicture;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberRegisteredUserVideo;
import com.lanjiu.im.storage.service.RegisteredGroupGuestMemberRegisteredUserPictureService;
import com.lanjiu.im.storage.service.RegisteredGroupGuestMemberRegisteredUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.RegisteredUser;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithRegisteredGroupWithGuestMemberWithRegisteredUserController {

    public int saveRegisteredGroupGuestMemberRegisteredUserVideoController(SqlSession session, RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupGuestMemberRegisteredUserVideoService registeredGroupGuestMemberRegisteredUserVideoService = new RegisteredGroupGuestMemberRegisteredUserVideoService();
        RegisteredGroupGuestMemberRegisteredUserVideo registeredGroupGuestMemberRegisteredUserVideo = new RegisteredGroupGuestMemberRegisteredUserVideo();
        registeredGroupGuestMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberRegisteredUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberRegisteredUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = registeredGroupGuestMemberRegisteredUserVideoService.insertRecord(session, mapperb, registeredGroupGuestMemberRegisteredUserVideo);
        return result;
    }

    public int saveRegisteredGroupGuestMemberRegisteredUserPictureController(SqlSession session, RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupGuestMemberRegisteredUserPictureService registeredGroupGuestMemberRegisteredUserPictureService = new RegisteredGroupGuestMemberRegisteredUserPictureService();
        RegisteredGroupGuestMemberRegisteredUserPicture registeredGroupGuestMemberRegisteredUserPicture = new RegisteredGroupGuestMemberRegisteredUserPicture();
        registeredGroupGuestMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberRegisteredUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberRegisteredUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = registeredGroupGuestMemberRegisteredUserPictureService.insertRecord(session, mapperb, registeredGroupGuestMemberRegisteredUserPicture);
        return result;
    }

    public boolean deleteRegisteredGroupGuestMemberRegisteredUserVideoController(SqlSession session, RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupGuestMemberRegisteredUserVideoService registeredGroupGuestMemberRegisteredUserVideoService = new RegisteredGroupGuestMemberRegisteredUserVideoService();
        RegisteredGroupGuestMemberRegisteredUserVideo registeredGroupGuestMemberRegisteredUserVideo = new RegisteredGroupGuestMemberRegisteredUserVideo();
        registeredGroupGuestMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberRegisteredUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberRegisteredUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupGuestMemberRegisteredUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupGuestMemberRegisteredUserVideoService.deleteRecord(session, mapperb, registeredGroupGuestMemberRegisteredUserVideo);
        }
        List<RegisteredGroupGuestMemberRegisteredUserVideo> list = registeredGroupGuestMemberRegisteredUserVideoService.selectRecord(session, mapperb, registeredGroupGuestMemberRegisteredUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteRegisteredGroupGuestMemberRegisteredUserPictureController(SqlSession session, RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredGroupGuestMemberRegisteredUserPictureService registeredGroupGuestMemberRegisteredUserPictureService = new RegisteredGroupGuestMemberRegisteredUserPictureService();
        RegisteredGroupGuestMemberRegisteredUserPicture registeredGroupGuestMemberRegisteredUserPicture = new RegisteredGroupGuestMemberRegisteredUserPicture();
        registeredGroupGuestMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberRegisteredUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberRegisteredUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupGuestMemberRegisteredUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupGuestMemberRegisteredUserPictureService.deleteRecord(session, mapperb, registeredGroupGuestMemberRegisteredUserPicture);
        }
        List<RegisteredGroupGuestMemberRegisteredUserPicture> list = registeredGroupGuestMemberRegisteredUserPictureService.selectRecord(session, mapperb, registeredGroupGuestMemberRegisteredUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    //task
    public boolean deleteTaskRegisteredGroupGuestMemberRegisteredUserVideoController(SqlSession session, RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb, long day){
        RegisteredGroupGuestMemberRegisteredUserVideoService registeredGroupGuestMemberRegisteredUserVideoService = new RegisteredGroupGuestMemberRegisteredUserVideoService();
        List<RegisteredGroupGuestMemberRegisteredUserVideo> list = registeredGroupGuestMemberRegisteredUserVideoService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupGuestMemberRegisteredUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupGuestMemberRegisteredUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean deleteTaskRegisteredGroupGuestMemberRegisteredUserPictureController(SqlSession session, RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb, long day){
        RegisteredGroupGuestMemberRegisteredUserPictureService registeredGroupGuestMemberRegisteredUserPictureService = new RegisteredGroupGuestMemberRegisteredUserPictureService();
        List<RegisteredGroupGuestMemberRegisteredUserPicture> list = registeredGroupGuestMemberRegisteredUserPictureService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupGuestMemberRegisteredUserPicture video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupGuestMemberRegisteredUserPictureService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
