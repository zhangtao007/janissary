package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberGuestUserPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.GuestGroupGuestMemberGuestUserVideoMapper;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserPicture;
import com.lanjiu.im.storage.pojo.GuestGroupGuestMemberGuestUserVideo;
import com.lanjiu.im.storage.service.GuestGroupGuestMemberGuestUserPictureService;
import com.lanjiu.im.storage.service.GuestGroupGuestMemberGuestUserVideoService;
import com.lanjiu.im.storage.util.TimeCompareUtil;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Group;
import com.lanjiu.pro.fileStorage.GroupMember;
import com.lanjiu.pro.fileStorage.Tourists;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithGuestGroupWithGuestMemberWithGuestUserController {

    public int saveGuestGroupGuestMemberGuestUserVideoController(SqlSession session, GuestGroupGuestMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupGuestMemberGuestUserVideoService guestGroupGuestMemberGuestUserVideoService = new GuestGroupGuestMemberGuestUserVideoService();
        GuestGroupGuestMemberGuestUserVideo guestGroupGuestMemberGuestUserVideo = new GuestGroupGuestMemberGuestUserVideo();
        guestGroupGuestMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberGuestUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberGuestUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = guestGroupGuestMemberGuestUserVideoService.insertRecord(session, mapperb, guestGroupGuestMemberGuestUserVideo);
        return result;
    }

    public int saveGuestGroupGuestMemberGuestUserPictureController(SqlSession session, GuestGroupGuestMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupGuestMemberGuestUserPictureService guestGroupGuestMemberGuestUserPictureService = new GuestGroupGuestMemberGuestUserPictureService();
        GuestGroupGuestMemberGuestUserPicture guestGroupGuestMemberGuestUserPicture = new GuestGroupGuestMemberGuestUserPicture();
        guestGroupGuestMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberGuestUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberGuestUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        int result = guestGroupGuestMemberGuestUserPictureService.insertRecord(session, mapperb, guestGroupGuestMemberGuestUserPicture);
        return result;
    }

    public boolean deleteGuestGroupGuestMemberGuestUserVideoController(SqlSession session, GuestGroupGuestMemberGuestUserVideoMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupGuestMemberGuestUserVideoService guestGroupGuestMemberGuestUserVideoService = new GuestGroupGuestMemberGuestUserVideoService();
        GuestGroupGuestMemberGuestUserVideo guestGroupGuestMemberGuestUserVideo = new GuestGroupGuestMemberGuestUserVideo();
        guestGroupGuestMemberGuestUserVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberGuestUserVideo.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberGuestUserVideo.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberGuestUserVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberGuestUserVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupGuestMemberGuestUserVideo.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupGuestMemberGuestUserVideoService.deleteRecord(session, mapperb, guestGroupGuestMemberGuestUserVideo);
        }
        List<GuestGroupGuestMemberGuestUserVideo> list = guestGroupGuestMemberGuestUserVideoService.selectRecord(session, mapperb, guestGroupGuestMemberGuestUserVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteGuestGroupGuestMemberGuestUserPictureController(SqlSession session, GuestGroupGuestMemberGuestUserPictureMapper mapperb, Group group, GroupMember groupMember, Tourists tourists, FileContent fileContent){
        GuestGroupGuestMemberGuestUserPictureService guestGroupGuestMemberGuestUserPictureService = new GuestGroupGuestMemberGuestUserPictureService();
        GuestGroupGuestMemberGuestUserPicture guestGroupGuestMemberGuestUserPicture = new GuestGroupGuestMemberGuestUserPicture();
        guestGroupGuestMemberGuestUserPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestGroupGuestMemberGuestUserPicture.setGuestGroupId(Integer.valueOf(group.getGroupId()));
        guestGroupGuestMemberGuestUserPicture.setGuestMemberId(Integer.valueOf(groupMember.getGroupMemberId()));
        guestGroupGuestMemberGuestUserPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestGroupGuestMemberGuestUserPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        //调用文件交互服务器，删除对应文件
        String serverUrl = guestGroupGuestMemberGuestUserPicture.getDownloadUrl();
        bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
        if (bSuccessful){
            guestGroupGuestMemberGuestUserPictureService.deleteRecord(session, mapperb, guestGroupGuestMemberGuestUserPicture);
        }

        List<GuestGroupGuestMemberGuestUserPicture> list = guestGroupGuestMemberGuestUserPictureService.selectRecord(session, mapperb, guestGroupGuestMemberGuestUserPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteTaskGuestGroupGuestMemberGuestUserPictureController(SqlSession session, GuestGroupGuestMemberGuestUserPictureMapper mapperb, long day){
        GuestGroupGuestMemberGuestUserPictureService guestGroupGuestMemberGuestUserPictureService = new GuestGroupGuestMemberGuestUserPictureService();
        List<GuestGroupGuestMemberGuestUserPicture> list = guestGroupGuestMemberGuestUserPictureService.selectAllRecords(session, mapperb);
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;

        for (GuestGroupGuestMemberGuestUserPicture picture : list){
            Date createTime = picture.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = picture.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupGuestMemberGuestUserPictureService.deleteRecord(session, mapperb, picture);
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean deleteTaskGuestGroupGuestMemberGuestUserVideoController(SqlSession session, GuestGroupGuestMemberGuestUserVideoMapper mapperb, long day){
        //定时删除记录
        GuestGroupGuestMemberGuestUserVideoService guestGroupGuestMemberGuestUserVideoService = new GuestGroupGuestMemberGuestUserVideoService();
        List<GuestGroupGuestMemberGuestUserVideo> list = guestGroupGuestMemberGuestUserVideoService.selectAllRecords(session, mapperb);
        TimeCompareUtil timeCompareUtil = new TimeCompareUtil();
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        long betweenDay = 0;
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        for (GuestGroupGuestMemberGuestUserVideo video : list){
            Date createTime = video.getCreationTime();
            betweenDay = timeCompareUtil.getDaysBetween(createTime, date);
            if (betweenDay >= day){
                //调用文件交互服务器，删除对应文件
                String serverUrl = video.getDownloadUrl();
                bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithGroup(serverUrl);
                if (bSuccessful){
                    guestGroupGuestMemberGuestUserVideoService.deleteRecord(session, mapperb, video);
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
