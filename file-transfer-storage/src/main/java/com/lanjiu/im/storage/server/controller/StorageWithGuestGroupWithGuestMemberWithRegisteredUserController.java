package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberRegisteredUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberRegisteredUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberRegisteredUserPicture;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberRegisteredUserVideo;
import com.lanjiu.im.storage.service.GuestGroupGuestMemberRegisteredUserPictureService;
import com.lanjiu.im.storage.service.GuestGroupGuestMemberRegisteredUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.RegisteredUser;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithGuestGroupWithGuestMemberWithRegisteredUserController {

    public int saveGuestGroupGuestMemberRegisteredUserVideoController(SqlSession session, GuestGroupGuestMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupGuestMemberRegisteredUserVideoService guestGroupGuestMemberRegisteredUserVideoService = new GuestGroupGuestMemberRegisteredUserVideoService();
        GuestGroupGuestMemberRegisteredUserVideo guestGroupGuestMemberRegisteredUserVideo = new GuestGroupGuestMemberRegisteredUserVideo();
        guestGroupGuestMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberRegisteredUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberRegisteredUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = guestGroupGuestMemberRegisteredUserVideoService.insertRecord(session, mapperb, guestGroupGuestMemberRegisteredUserVideo);
        return result;
    }

    public int saveGuestGroupGuestMemberRegisteredUserPictureController(SqlSession session, GuestGroupGuestMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupGuestMemberRegisteredUserPictureService guestGroupGuestMemberRegisteredUserPictureService = new GuestGroupGuestMemberRegisteredUserPictureService();
        GuestGroupGuestMemberRegisteredUserPicture guestGroupGuestMemberRegisteredUserPicture = new GuestGroupGuestMemberRegisteredUserPicture();
        guestGroupGuestMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberRegisteredUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberRegisteredUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        int result = guestGroupGuestMemberRegisteredUserPictureService.insertRecord(session, mapperb, guestGroupGuestMemberRegisteredUserPicture);
        return result;
    }

    public boolean deleteGuestGroupGuestMemberRegisteredUserVideoController(SqlSession session, GuestGroupGuestMemberRegisteredUserVideoMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupGuestMemberRegisteredUserVideoService guestGroupGuestMemberRegisteredUserVideoService = new GuestGroupGuestMemberRegisteredUserVideoService();
        GuestGroupGuestMemberRegisteredUserVideo guestGroupGuestMemberRegisteredUserVideo = new GuestGroupGuestMemberRegisteredUserVideo();
        guestGroupGuestMemberRegisteredUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberRegisteredUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberRegisteredUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberRegisteredUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberRegisteredUserVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupGuestMemberRegisteredUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupGuestMemberRegisteredUserVideoService.deleteRecord(session, mapperb, guestGroupGuestMemberRegisteredUserVideo);
        }

        List<GuestGroupGuestMemberRegisteredUserVideo> list = guestGroupGuestMemberRegisteredUserVideoService.selectRecord(session, mapperb, guestGroupGuestMemberRegisteredUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteGuestGroupGuestMemberRegisteredUserPictureController(SqlSession session, GuestGroupGuestMemberRegisteredUserPictureMapper mapperb, Group group, GroupMember groupMember, RegisteredUser registeredUser, FileContent fileContent){
        GuestGroupGuestMemberRegisteredUserPictureService guestGroupGuestMemberRegisteredUserPictureService = new GuestGroupGuestMemberRegisteredUserPictureService();
        GuestGroupGuestMemberRegisteredUserPicture guestGroupGuestMemberRegisteredUserPicture = new GuestGroupGuestMemberRegisteredUserPicture();
        guestGroupGuestMemberRegisteredUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberRegisteredUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberRegisteredUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberRegisteredUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberRegisteredUserPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupGuestMemberRegisteredUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupGuestMemberRegisteredUserPictureService.deleteRecord(session, mapperb, guestGroupGuestMemberRegisteredUserPicture);
        }

        List<GuestGroupGuestMemberRegisteredUserPicture> list = guestGroupGuestMemberRegisteredUserPictureService.selectRecord(session, mapperb, guestGroupGuestMemberRegisteredUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    //task
    public boolean deleteTaskGuestGroupGuestMemberRegisteredUserVideoController(SqlSession session, GuestGroupGuestMemberRegisteredUserVideoMapper mapperb, long day){
        GuestGroupGuestMemberRegisteredUserVideoService guestGroupGuestMemberRegisteredUserVideoService = new GuestGroupGuestMemberRegisteredUserVideoService();
        List<GuestGroupGuestMemberRegisteredUserVideo> list = guestGroupGuestMemberRegisteredUserVideoService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (GuestGroupGuestMemberRegisteredUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupGuestMemberRegisteredUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean deleteTaskGuestGroupGuestMemberRegisteredUserPictureController(SqlSession session, GuestGroupGuestMemberRegisteredUserPictureMapper mapperb, long day){
        GuestGroupGuestMemberRegisteredUserPictureService guestGroupGuestMemberRegisteredUserPictureService = new GuestGroupGuestMemberRegisteredUserPictureService();
        List<GuestGroupGuestMemberRegisteredUserPicture> list = guestGroupGuestMemberRegisteredUserPictureService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (GuestGroupGuestMemberRegisteredUserPicture video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){

                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupGuestMemberRegisteredUserPictureService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
