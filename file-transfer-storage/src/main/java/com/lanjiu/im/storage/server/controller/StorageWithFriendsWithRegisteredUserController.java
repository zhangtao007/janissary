package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.RegisteredUserFriendPictureMapper;
import com.lanjiu.im.storage.dao.mapper.impl.RegisteredUserFriendVideoMapper;
import com.lanjiu.im.storage.pojo.RegisteredUserFriendPicture;
import com.lanjiu.im.storage.pojo.RegisteredUserFriendVideo;
import com.lanjiu.im.storage.service.RegisteredUserFriendPictureService;
import com.lanjiu.im.storage.service.RegisteredUserFriendVideoService;
import com.lanjiu.pro.fileStorage.FileContent;
import com.lanjiu.pro.fileStorage.Friends;
import com.lanjiu.pro.fileStorage.RegisteredUser;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class StorageWithFriendsWithRegisteredUserController {

    public int saveRegisteredUserFriendVideoController(SqlSession session, RegisteredUserFriendVideoMapper mapperb, Friends friends, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredUserFriendVideoService registeredUserFriendVideoService = new RegisteredUserFriendVideoService();
        RegisteredUserFriendVideo registeredUserFriendVideo = new RegisteredUserFriendVideo();
        registeredUserFriendVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredUserFriendVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        registeredUserFriendVideo.setFriendId(Integer.valueOf(friends.getFriendsId()));
        registeredUserFriendVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        int result = registeredUserFriendVideoService.insertRecord(session, mapperb, registeredUserFriendVideo);
        return result;
    }

    public int saveRegisteredUserFriendPictureController(SqlSession session, RegisteredUserFriendPictureMapper mapperb, Friends friends, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredUserFriendPictureService registeredUserFriendPictureService = new RegisteredUserFriendPictureService();
        RegisteredUserFriendPicture registeredUserFriendPicture = new RegisteredUserFriendPicture();
        registeredUserFriendPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredUserFriendPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        registeredUserFriendPicture.setFriendId(Integer.valueOf(friends.getFriendsId()));
        registeredUserFriendPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        int result = registeredUserFriendPictureService.insertRecord(session, mapperb, registeredUserFriendPicture);
        return result;
    }

    public boolean deleteRegisteredUserFriendVideoController(SqlSession session, RegisteredUserFriendVideoMapper mapperb, Friends friends, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredUserFriendVideoService registeredUserFriendVideoService = new RegisteredUserFriendVideoService();
        RegisteredUserFriendVideo registeredUserFriendVideo = new RegisteredUserFriendVideo();
        registeredUserFriendVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredUserFriendVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        registeredUserFriendVideo.setFriendId(Integer.valueOf(friends.getFriendsId()));
        registeredUserFriendVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredUserFriendVideoService.deleteRecord(session, mapperb, registeredUserFriendVideo);
        List<RegisteredUserFriendVideo> list = registeredUserFriendVideoService.selectRecord(session, mapperb, registeredUserFriendVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteRegisteredUserFriendByFriendIdVideoController(SqlSession session, RegisteredUserFriendVideoMapper mapperb, Friends friends, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredUserFriendVideoService registeredUserFriendVideoService = new RegisteredUserFriendVideoService();
        RegisteredUserFriendVideo registeredUserFriendVideo = new RegisteredUserFriendVideo();
        registeredUserFriendVideo.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredUserFriendVideo.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        registeredUserFriendVideo.setFriendId(Integer.valueOf(friends.getFriendsId()));
        registeredUserFriendVideo.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        List<RegisteredUserFriendVideo> list = registeredUserFriendVideoService.selectRecordByFriendId(session, mapperb, registeredUserFriendVideo);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        for (RegisteredUserFriendVideo video : list){
            //调用文件交互服务器，删除对应文件
            String serverUrl = video.getDownloadUrl();
            bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithFriends(serverUrl);
            //删除数据库中记录
            if(bSuccessful){
                registeredUserFriendVideoService.deleteRecord(session, mapperb, video);
            }
        }

        list = registeredUserFriendVideoService.selectRecordByFriendId(session, mapperb, registeredUserFriendVideo);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteRegisteredUserFriendPictureController(SqlSession session, RegisteredUserFriendPictureMapper mapperb, Friends friends, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredUserFriendPictureService registeredUserFriendPictureService = new RegisteredUserFriendPictureService();
        RegisteredUserFriendPicture registeredUserFriendPicture = new RegisteredUserFriendPicture();
        registeredUserFriendPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredUserFriendPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        registeredUserFriendPicture.setFriendId(Integer.valueOf(friends.getFriendsId()));
        registeredUserFriendPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredUserFriendPictureService.deleteRecord(session, mapperb, registeredUserFriendPicture);
        List<RegisteredUserFriendPicture> list = registeredUserFriendPictureService.selectRecord(session, mapperb, registeredUserFriendPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }

    public boolean deleteRegisteredUserFriendByFriendIdPictureController(SqlSession session, RegisteredUserFriendPictureMapper mapperb, Friends friends, RegisteredUser registeredUser, FileContent fileContent){
        RegisteredUserFriendPictureService registeredUserFriendPictureService = new RegisteredUserFriendPictureService();
        RegisteredUserFriendPicture registeredUserFriendPicture = new RegisteredUserFriendPicture();
        registeredUserFriendPicture.setCreationTime(Date.valueOf(LocalDate.now()));
        registeredUserFriendPicture.setRegisteredUserId(Integer.valueOf(registeredUser.getUserId()));
        registeredUserFriendPicture.setFriendId(Integer.valueOf(friends.getFriendsId()));
        registeredUserFriendPicture.setDownloadUrl(fileContent.getBigFileHead().getServerUrl());
        registeredUserFriendPictureService.deleteRecord(session, mapperb, registeredUserFriendPicture);
        List<RegisteredUserFriendPicture> list = registeredUserFriendPictureService.selectRecordByFriendId(session, mapperb, registeredUserFriendPicture);
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        boolean bSuccessful = false;
        for (RegisteredUserFriendPicture picture : list){
            //调用文件交互服务器，删除对应文件
            String serverUrl = picture.getDownloadUrl();
            bSuccessful = linkTransferCommunication.deleteFileIsSuccessFulWithFriends(serverUrl);
            if(bSuccessful){
                //删除数据库中记录
                registeredUserFriendPictureService.deleteRecord(session, mapperb, picture);
            }
        }

        list = registeredUserFriendPictureService.selectRecordByFriendId(session, mapperb, registeredUserFriendPicture);
        if (null != list){
            if (list.size() > 0){
                return false;
            }
        }
        return true;
    }
}
