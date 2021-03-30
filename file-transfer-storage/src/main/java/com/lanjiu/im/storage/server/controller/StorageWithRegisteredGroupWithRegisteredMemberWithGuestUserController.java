package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.RegisteredGroupRegisteredMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberGuestUserPicture;
import com.lanjiu.im.storage.pojo.RegisteredGroupRegisteredMemberGuestUserVideo;
import com.lanjiu.im.storage.service.RegisteredGroupRegisteredMemberGuestUserPictureService;
import com.lanjiu.im.storage.service.RegisteredGroupRegisteredMemberGuestUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.Tourists;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithRegisteredGroupWithRegisteredMemberWithGuestUserController {

    public int saveRegisteredGroupRegisteredMemberGuestUserVideoController(SqlSession session, RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupRegisteredMemberGuestUserVideoService registeredGroupRegisteredMemberGuestUserVideoService = new RegisteredGroupRegisteredMemberGuestUserVideoService();
        RegisteredGroupRegisteredMemberGuestUserVideo registeredGroupRegisteredMemberGuestUserVideo = new RegisteredGroupRegisteredMemberGuestUserVideo();
        registeredGroupRegisteredMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberGuestUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberGuestUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = registeredGroupRegisteredMemberGuestUserVideoService.insertRecord(session, mapperb, registeredGroupRegisteredMemberGuestUserVideo);
        return result;
    }

    public int saveRegisteredGroupRegisteredMemberGuestUserPictureController(SqlSession session, RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupRegisteredMemberGuestUserPictureService registeredGroupRegisteredMemberGuestUserPictureService = new RegisteredGroupRegisteredMemberGuestUserPictureService();
        RegisteredGroupRegisteredMemberGuestUserPicture registeredGroupRegisteredMemberGuestUserPicture = new RegisteredGroupRegisteredMemberGuestUserPicture();
        registeredGroupRegisteredMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberGuestUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberGuestUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = registeredGroupRegisteredMemberGuestUserPictureService.insertRecord(session, mapperb, registeredGroupRegisteredMemberGuestUserPicture);
        return result;
    }

    public boolean deleteRegisteredGroupRegisteredMemberGuestUserVideoController(SqlSession session, RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupRegisteredMemberGuestUserVideoService registeredGroupRegisteredMemberGuestUserVideoService = new RegisteredGroupRegisteredMemberGuestUserVideoService();
        RegisteredGroupRegisteredMemberGuestUserVideo registeredGroupRegisteredMemberGuestUserVideo = new RegisteredGroupRegisteredMemberGuestUserVideo();
        registeredGroupRegisteredMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberGuestUserVideo.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberGuestUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupRegisteredMemberGuestUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupRegisteredMemberGuestUserVideoService.deleteRecord(session, mapperb, registeredGroupRegisteredMemberGuestUserVideo);
        }
        List<RegisteredGroupRegisteredMemberGuestUserVideo> list = registeredGroupRegisteredMemberGuestUserVideoService.selectRecord(session, mapperb, registeredGroupRegisteredMemberGuestUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteRegisteredGroupRegisteredMemberGuestUserPictureController(SqlSession session, RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        RegisteredGroupRegisteredMemberGuestUserPictureService registeredGroupRegisteredMemberGuestUserPictureService = new RegisteredGroupRegisteredMemberGuestUserPictureService();
        RegisteredGroupRegisteredMemberGuestUserPicture registeredGroupRegisteredMemberGuestUserPicture = new RegisteredGroupRegisteredMemberGuestUserPicture();
        registeredGroupRegisteredMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredGroupRegisteredMemberGuestUserPicture.setRegisteredGroupId(Integer.valueOf(group.getGroupId()));
        registeredGroupRegisteredMemberGuestUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        registeredGroupRegisteredMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredGroupRegisteredMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = registeredGroupRegisteredMemberGuestUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            registeredGroupRegisteredMemberGuestUserPictureService.deleteRecord(session, mapperb, registeredGroupRegisteredMemberGuestUserPicture);
        }
        List<RegisteredGroupRegisteredMemberGuestUserPicture> list = registeredGroupRegisteredMemberGuestUserPictureService.selectRecord(session, mapperb, registeredGroupRegisteredMemberGuestUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    //task
    public boolean deleteTaskRegisteredGroupRegisteredMemberGuestUserVideoController(SqlSession session, RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb, long day){
        RegisteredGroupRegisteredMemberGuestUserVideoService registeredGroupRegisteredMemberGuestUserVideoService = new RegisteredGroupRegisteredMemberGuestUserVideoService();
        List<RegisteredGroupRegisteredMemberGuestUserVideo> list = registeredGroupRegisteredMemberGuestUserVideoService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupRegisteredMemberGuestUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupRegisteredMemberGuestUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean deleteTaskRegisteredGroupRegisteredMemberGuestUserPictureController(SqlSession session, RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb, long day){
        RegisteredGroupRegisteredMemberGuestUserPictureService registeredGroupRegisteredMemberGuestUserPictureService = new RegisteredGroupRegisteredMemberGuestUserPictureService();
        List<RegisteredGroupRegisteredMemberGuestUserPicture> list = registeredGroupRegisteredMemberGuestUserPictureService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (RegisteredGroupRegisteredMemberGuestUserPicture video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    registeredGroupRegisteredMemberGuestUserPictureService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
