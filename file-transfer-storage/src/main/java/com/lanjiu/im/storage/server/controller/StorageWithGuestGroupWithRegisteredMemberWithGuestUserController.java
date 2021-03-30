package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupRegisteredMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberGuestUserPicture;
import com.lanjiu.im.storage.pojo.GuestGroupRegisteredMemberGuestUserVideo;
import com.lanjiu.im.storage.service.GuestGroupRegisteredMemberGuestUserPictureService;
import com.lanjiu.im.storage.service.GuestGroupRegisteredMemberGuestUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.Tourists;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithGuestGroupWithRegisteredMemberWithGuestUserController {

    public int saveGuestGroupRegisteredMemberGuestUserVideoController(SqlSession session, GuestGroupRegisteredMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupRegisteredMemberGuestUserVideoService guestGroupRegisteredMemberGuestUserVideoService = new GuestGroupRegisteredMemberGuestUserVideoService();
        GuestGroupRegisteredMemberGuestUserVideo guestGroupRegisteredMemberGuestUserVideo = new GuestGroupRegisteredMemberGuestUserVideo();
        guestGroupRegisteredMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberGuestUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberGuestUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = guestGroupRegisteredMemberGuestUserVideoService.insertRecord(session, mapperb, guestGroupRegisteredMemberGuestUserVideo);
        return result;
    }

    public int saveGuestGroupRegisteredMemberGuestUserPictureController(SqlSession session, GuestGroupRegisteredMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupRegisteredMemberGuestUserPictureService guestGroupRegisteredMemberGuestUserPictureService = new GuestGroupRegisteredMemberGuestUserPictureService();
        GuestGroupRegisteredMemberGuestUserPicture guestGroupRegisteredMemberGuestUserPicture = new GuestGroupRegisteredMemberGuestUserPicture();
        guestGroupRegisteredMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberGuestUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberGuestUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = guestGroupRegisteredMemberGuestUserPictureService.insertRecord(session, mapperb, guestGroupRegisteredMemberGuestUserPicture);
        return result;
    }

    public boolean deleteGuestGroupRegisteredMemberGuestUserVideoController(SqlSession session, GuestGroupRegisteredMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupRegisteredMemberGuestUserVideoService guestGroupRegisteredMemberGuestUserVideoService = new GuestGroupRegisteredMemberGuestUserVideoService();
        GuestGroupRegisteredMemberGuestUserVideo guestGroupRegisteredMemberGuestUserVideo = new GuestGroupRegisteredMemberGuestUserVideo();
        guestGroupRegisteredMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberGuestUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberGuestUserVideo.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupRegisteredMemberGuestUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupRegisteredMemberGuestUserVideoService.deleteRecord(session, mapperb, guestGroupRegisteredMemberGuestUserVideo);
        }
        List<GuestGroupRegisteredMemberGuestUserVideo> list = guestGroupRegisteredMemberGuestUserVideoService.selectRecord(session, mapperb, guestGroupRegisteredMemberGuestUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteGuestGroupRegisteredMemberGuestUserPictureController(SqlSession session, GuestGroupRegisteredMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupRegisteredMemberGuestUserPictureService guestGroupRegisteredMemberGuestUserPictureService = new GuestGroupRegisteredMemberGuestUserPictureService();
        GuestGroupRegisteredMemberGuestUserPicture guestGroupRegisteredMemberGuestUserPicture = new GuestGroupRegisteredMemberGuestUserPicture();
        guestGroupRegisteredMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupRegisteredMemberGuestUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupRegisteredMemberGuestUserPicture.setRegisteredMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupRegisteredMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupRegisteredMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupRegisteredMemberGuestUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupRegisteredMemberGuestUserPictureService.deleteRecord(session, mapperb, guestGroupRegisteredMemberGuestUserPicture);
        }
        List<GuestGroupRegisteredMemberGuestUserPicture> list = guestGroupRegisteredMemberGuestUserPictureService.selectRecord(session, mapperb, guestGroupRegisteredMemberGuestUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    //task
    public boolean deleteTaskGuestGroupRegisteredMemberGuestUserVideoController(SqlSession session, GuestGroupRegisteredMemberGuestUserVideoMapper mapperb, long day){
        GuestGroupRegisteredMemberGuestUserVideoService guestGroupRegisteredMemberGuestUserVideoService = new GuestGroupRegisteredMemberGuestUserVideoService();
        List<GuestGroupRegisteredMemberGuestUserVideo> list = guestGroupRegisteredMemberGuestUserVideoService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (GuestGroupRegisteredMemberGuestUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupRegisteredMemberGuestUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean deleteTaskGuestGroupRegisteredMemberGuestUserPictureController(SqlSession session, GuestGroupRegisteredMemberGuestUserPictureMapper mapperb, long day){
        GuestGroupRegisteredMemberGuestUserPictureService guestGroupRegisteredMemberGuestUserPictureService = new GuestGroupRegisteredMemberGuestUserPictureService();
        List<GuestGroupRegisteredMemberGuestUserPicture> list = guestGroupRegisteredMemberGuestUserPictureService.selectAllRecords(session, mapperb);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        for (GuestGroupRegisteredMemberGuestUserPicture video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupRegisteredMemberGuestUserPictureService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }

            }
        }
        return true;
    }
}
