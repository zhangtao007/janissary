package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.GuestUserFriendPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.GuestUserFriendVideoMapper;
import com.lanjiu.im.storage.pojo.GuestUserFriendPicture;
import com.lanjiu.im.storage.pojo.GuestUserFriendVideo;
import com.lanjiu.im.storage.service.GuestUserFriendPictureService;
import com.lanjiu.im.storage.service.GuestUserFriendVideoService;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Friends;
import com.lanjiu.pro.fileStorage.Tourists;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithFriendsWithGuestUserController {

    public int saveGuestUserFriendVideoController(SqlSession session, GuestUserFriendVideoMapper mapperb, Friends friends, Tourists tourists, FileContent fileContent){
        GuestUserFriendVideoService guestUserFriendVideoService = new GuestUserFriendVideoService();
        GuestUserFriendVideo guestUserFriendVideo = new GuestUserFriendVideo();
        guestUserFriendVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestUserFriendVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        guestUserFriendVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestUserFriendVideo.setFriendId(Integer.valueOf(friends.getFriendsId()));
        int result = guestUserFriendVideoService.insertRecord(session, mapperb, guestUserFriendVideo);
        return result;
    }

    public int saveGuestUserFriendPictureController(SqlSession session, GuestUserFriendPictureMapper mapperb, Friends friends, Tourists tourists, FileContent fileContent){
        GuestUserFriendPictureService guestUserFriendPictureService = new GuestUserFriendPictureService();
        GuestUserFriendPicture guestUserFriendPicture = new GuestUserFriendPicture();
        guestUserFriendPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestUserFriendPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        guestUserFriendPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestUserFriendPicture.setFriendId(Integer.valueOf(friends.getFriendsId()));
        int result = guestUserFriendPictureService.insertRecord(session, mapperb, guestUserFriendPicture);
        return result;
    }

    public boolean deleteGuestUserFriendVideoController(SqlSession session, GuestUserFriendVideoMapper mapperb, Friends friends, Tourists tourists, FileContent fileContent){
        GuestUserFriendVideoService guestUserFriendVideoService = new GuestUserFriendVideoService();
        GuestUserFriendVideo guestUserFriendVideo = new GuestUserFriendVideo();
        guestUserFriendVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestUserFriendVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        guestUserFriendVideo.setFriendId(Integer.valueOf(friends.getFriendsId()));
        guestUserFriendVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestUserFriendVideoService.deleteRecord(session, mapperb, guestUserFriendVideo);
        List<GuestUserFriendVideo> list = guestUserFriendVideoService.selectRecord(session, mapperb, guestUserFriendVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteGuestUserFriendPictureController(SqlSession session, GuestUserFriendPictureMapper mapperb, Friends friends, Tourists tourists, FileContent fileContent){
        GuestUserFriendPictureService guestUserFriendPictureService = new GuestUserFriendPictureService();
        GuestUserFriendPicture guestUserFriendPicture = new GuestUserFriendPicture();
        guestUserFriendPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestUserFriendPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        guestUserFriendPicture.setFriendId(Integer.valueOf(friends.getFriendsId()));
        guestUserFriendPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestUserFriendPictureService.deleteRecord(session, mapperb, guestUserFriendPicture);
        List<GuestUserFriendPicture> list = guestUserFriendPictureService.selectRecord(session, mapperb, guestUserFriendPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteGuestUserFriendVideoByFriendIdController(SqlSession session, GuestUserFriendVideoMapper mapperb, Friends friends, Tourists tourists, FileContent fileContent){
        GuestUserFriendVideoService guestUserFriendVideoService = new GuestUserFriendVideoService();
        GuestUserFriendVideo guestUserFriendVideo = new GuestUserFriendVideo();
        guestUserFriendVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        guestUserFriendVideo.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        guestUserFriendVideo.setFriendId(Integer.valueOf(friends.getFriendsId()));
        guestUserFriendVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestUserFriendVideoService.deleteRecord(session, mapperb, guestUserFriendVideo);
        List<GuestUserFriendVideo> list = guestUserFriendVideoService.selectRecordByFriendId(session, mapperb, guestUserFriendVideo);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        for (GuestUserFriendVideo video : list){
            String serverUrl = video.getDownloadUrl();
            bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithFriends(serverUrl);
            if(bSuccessful){
                //文件服务器上的文件删除成功时，删除数据库中记录
                guestUserFriendVideoService.deleteRecord(session, mapperb, video);
            }
        }

        list = guestUserFriendVideoService.selectRecordByFriendId(session, mapperb, guestUserFriendVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteGuestUserFriendPictureByFriendIdController(SqlSession session, GuestUserFriendPictureMapper mapperb, Friends friends, Tourists tourists, FileContent fileContent){
        GuestUserFriendPictureService guestUserFriendPictureService = new GuestUserFriendPictureService();
        GuestUserFriendPicture guestUserFriendPicture = new GuestUserFriendPicture();
        guestUserFriendPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        guestUserFriendPicture.setGuestUserId(Integer.valueOf(tourists.getTemporaryId()));
        guestUserFriendPicture.setFriendId(Integer.valueOf(friends.getFriendsId()));
        guestUserFriendPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        guestUserFriendPictureService.deleteRecord(session, mapperb, guestUserFriendPicture);
        List<GuestUserFriendPicture> list = guestUserFriendPictureService.selectRecordByFriendId(session, mapperb, guestUserFriendPicture);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        for (GuestUserFriendPicture video : list){
            //调用文件交互服务器，删除对应文件
            String serverUrl = video.getDownloadUrl();
            bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithFriends(serverUrl);
            //删除数据库中记录
            if(bSuccessful){
                guestUserFriendPictureService.deleteRecord(session, mapperb, video);
            }
        }

        list = guestUserFriendPictureService.selectRecordByFriendId(session, mapperb, guestUserFriendPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }
}
