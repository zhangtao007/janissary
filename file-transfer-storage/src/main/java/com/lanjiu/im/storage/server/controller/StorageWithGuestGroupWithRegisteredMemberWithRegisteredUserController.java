package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberRegisteredUserPicture;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberRegisteredUserVideo;
import com.lanjiu.im.storage.service.GuestGroupRegisteredMemberRegisteredUserPictureService;
import com.lanjiu.im.storage.service.GuestGroupRegisteredMemberRegisteredUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.RegisteredUser;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithGuestGroupWithRegisteredMemberWithRegisteredUserController {

    public int saveGuestGroupRegisteredMemberRegisteredUserVideoController(SqlSession session, GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupRegisteredMemberRegisteredUserVideoService guestGroupRegisteredMemberRegisteredUserVideoService = new GuestGroupRegisteredMemberRegisteredUserVideoService();
        GuestGroupRegisteredMemberRegisteredUserVideo guestGroupRegisteredMemberRegisteredUserVideo = new GuestGroupRegisteredMemberRegisteredUserVideo();
        guestGroupRegisteredMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberRegisteredUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberRegisteredUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = guestGroupRegisteredMemberRegisteredUserVideoService.insertRecord(session, mapperb, guestGroupRegisteredMemberRegisteredUserVideo);
        return result;
    }

    public int saveGuestGroupRegisteredMemberRegisteredUserPictureController(SqlSession session, GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupRegisteredMemberRegisteredUserPictureService guestGroupRegisteredMemberRegisteredUserPictureService = new GuestGroupRegisteredMemberRegisteredUserPictureService();
        GuestGroupRegisteredMemberRegisteredUserPicture guestGroupRegisteredMemberRegisteredUserPicture = new GuestGroupRegisteredMemberRegisteredUserPicture();
        guestGroupRegisteredMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberRegisteredUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberRegisteredUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = guestGroupRegisteredMemberRegisteredUserPictureService.insertRecord(session, mapperb, guestGroupRegisteredMemberRegisteredUserPicture);
        return result;
    }

    public boolean deleteGuestGroupRegisteredMemberRegisteredUserVideoController(SqlSession session, GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupRegisteredMemberRegisteredUserVideoService guestGroupRegisteredMemberRegisteredUserVideoService = new GuestGroupRegisteredMemberRegisteredUserVideoService();
        GuestGroupRegisteredMemberRegisteredUserVideo guestGroupRegisteredMemberRegisteredUserVideo = new GuestGroupRegisteredMemberRegisteredUserVideo();
        guestGroupRegisteredMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberRegisteredUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberRegisteredUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupRegisteredMemberRegisteredUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupRegisteredMemberRegisteredUserVideoService.deleteRecord(session, mapperb, guestGroupRegisteredMemberRegisteredUserVideo);
        }
        List<GuestGroupRegisteredMemberRegisteredUserVideo> list = guestGroupRegisteredMemberRegisteredUserVideoService.selectRecord(session, mapperb, guestGroupRegisteredMemberRegisteredUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteGuestGroupRegisteredMemberRegisteredUserPictureController(SqlSession session, GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupRegisteredMemberRegisteredUserPictureService guestGroupRegisteredMemberRegisteredUserPictureService = new GuestGroupRegisteredMemberRegisteredUserPictureService();
        GuestGroupRegisteredMemberRegisteredUserPicture guestGroupRegisteredMemberRegisteredUserPicture = new GuestGroupRegisteredMemberRegisteredUserPicture();
        guestGroupRegisteredMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberRegisteredUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberRegisteredUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupRegisteredMemberRegisteredUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupRegisteredMemberRegisteredUserPictureService.deleteRecord(session, mapperb, guestGroupRegisteredMemberRegisteredUserPicture);
        }
        List<GuestGroupRegisteredMemberRegisteredUserPicture> list = guestGroupRegisteredMemberRegisteredUserPictureService.selectRecord(session, mapperb, guestGroupRegisteredMemberRegisteredUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    //task
    public boolean deleteTaskGuestGroupRegisteredMemberRegisteredUserVideoController(SqlSession session, GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb, long day){
        GuestGroupRegisteredMemberRegisteredUserVideoService guestGroupRegisteredMemberRegisteredUserVideoService = new GuestGroupRegisteredMemberRegisteredUserVideoService();
        List<GuestGroupRegisteredMemberRegisteredUserVideo> list = guestGroupRegisteredMemberRegisteredUserVideoService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (GuestGroupRegisteredMemberRegisteredUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupRegisteredMemberRegisteredUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean deleteTaskGuestGroupRegisteredMemberRegisteredUserPictureController(SqlSession session, GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb, long day){
        GuestGroupRegisteredMemberRegisteredUserPictureService guestGroupRegisteredMemberRegisteredUserPictureService = new GuestGroupRegisteredMemberRegisteredUserPictureService();
        List<GuestGroupRegisteredMemberRegisteredUserPicture> list = guestGroupRegisteredMemberRegisteredUserPictureService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (GuestGroupRegisteredMemberRegisteredUserPicture video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupRegisteredMemberRegisteredUserPictureService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
