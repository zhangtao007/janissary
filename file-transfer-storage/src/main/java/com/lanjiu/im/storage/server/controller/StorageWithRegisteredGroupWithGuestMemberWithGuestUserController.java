package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupGuestMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberGuestUserPicture;
import com.lanjiu.im.storage.pojo.RegisteredGroupGuestMemberGuestUserVideo;
import com.lanjiu.im.storage.service.RegisteredGroupGuestMemberGuestUserPictureService;
import com.lanjiu.im.storage.service.RegisteredGroupGuestMemberGuestUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.Tourists;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithRegisteredGroupWithGuestMemberWithGuestUserController {

    public int saveRegisteredGroupGuestMemberGuestUserVideoController(SqlSession session, RegisteredGroupGuestMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupGuestMemberGuestUserVideoService registeredGroupGuestMemberGuestUserVideoService = new RegisteredGroupGuestMemberGuestUserVideoService();
        RegisteredGroupGuestMemberGuestUserVideo registeredGroupGuestMemberGuestUserVideo = new RegisteredGroupGuestMemberGuestUserVideo();
        registeredGroupGuestMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberGuestUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberGuestUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = registeredGroupGuestMemberGuestUserVideoService.insertRecord(session, mapperb, registeredGroupGuestMemberGuestUserVideo);
        return result;
    }

    public int saveRegisteredGroupGuestMemberGuestUserPictureController(SqlSession session, RegisteredGroupGuestMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupGuestMemberGuestUserPictureService registeredGroupGuestMemberGuestUserPictureService = new RegisteredGroupGuestMemberGuestUserPictureService();
        RegisteredGroupGuestMemberGuestUserPicture registeredGroupGuestMemberGuestUserPicture = new RegisteredGroupGuestMemberGuestUserPicture();
        registeredGroupGuestMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberGuestUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberGuestUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = registeredGroupGuestMemberGuestUserPictureService.insertRecord(session, mapperb, registeredGroupGuestMemberGuestUserPicture);
        return result;
    }

    public boolean deleteRegisteredGroupGuestMemberGuestUserVideoController(SqlSession session, RegisteredGroupGuestMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupGuestMemberGuestUserVideoService registeredGroupGuestMemberGuestUserVideoService = new RegisteredGroupGuestMemberGuestUserVideoService();
        RegisteredGroupGuestMemberGuestUserVideo registeredGroupGuestMemberGuestUserVideo = new RegisteredGroupGuestMemberGuestUserVideo();
        registeredGroupGuestMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberGuestUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberGuestUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupGuestMemberGuestUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupGuestMemberGuestUserVideoService.deleteRecord(session, mapperb, registeredGroupGuestMemberGuestUserVideo);
        }
        List<RegisteredGroupGuestMemberGuestUserVideo> list = registeredGroupGuestMemberGuestUserVideoService.selectRecord(session, mapperb, registeredGroupGuestMemberGuestUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteRegisteredGroupGuestMemberGuestUserPictureController(SqlSession session, RegisteredGroupGuestMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupGuestMemberGuestUserPictureService registeredGroupGuestMemberGuestUserPictureService = new RegisteredGroupGuestMemberGuestUserPictureService();
        RegisteredGroupGuestMemberGuestUserPicture registeredGroupGuestMemberGuestUserPicture = new RegisteredGroupGuestMemberGuestUserPicture();
        registeredGroupGuestMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupGuestMemberGuestUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupGuestMemberGuestUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupGuestMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupGuestMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupGuestMemberGuestUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupGuestMemberGuestUserPictureService.deleteRecord(session, mapperb, registeredGroupGuestMemberGuestUserPicture);
        }
        List<RegisteredGroupGuestMemberGuestUserPicture> list = registeredGroupGuestMemberGuestUserPictureService.selectRecord(session, mapperb, registeredGroupGuestMemberGuestUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    //task
    public boolean deleteTaskRegisteredGroupGuestMemberGuestUserVideoController(SqlSession session, RegisteredGroupGuestMemberGuestUserVideoMapper mapperb, long day){
        RegisteredGroupGuestMemberGuestUserVideoService registeredGroupGuestMemberGuestUserVideoService = new RegisteredGroupGuestMemberGuestUserVideoService();
        List<RegisteredGroupGuestMemberGuestUserVideo> list = registeredGroupGuestMemberGuestUserVideoService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupGuestMemberGuestUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupGuestMemberGuestUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean deleteTaskRegisteredGroupGuestMemberGuestUserPictureController(SqlSession session, RegisteredGroupGuestMemberGuestUserPictureMapper mapperb, long day){
        RegisteredGroupGuestMemberGuestUserPictureService registeredGroupGuestMemberGuestUserPictureService = new RegisteredGroupGuestMemberGuestUserPictureService();
        List<RegisteredGroupGuestMemberGuestUserPicture> list = registeredGroupGuestMemberGuestUserPictureService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupGuestMemberGuestUserPicture video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupGuestMemberGuestUserPictureService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
