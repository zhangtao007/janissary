package com.lanjiu.im.storage.server.controller;

import com.lanjiu.im.storage.dao.mapper.impl.*;
import com.lanjiu.im.storage.pojo.GuestUserFriendPicture;
import com.lanjiu.im.storage.pojo.GuestUserFriendVideo;
import com.lanjiu.im.storage.pojo.RegisteredUserFriendPicture;
import com.lanjiu.im.storage.pojo.RegisteredUserFriendVideo;
import com.lanjiu.im.storage.service.GuestUserFriendPictureService;
import com.lanjiu.im.storage.service.GuestUserFriendVideoService;
import com.lanjiu.im.storage.service.RegisteredUserFriendPictureService;
import com.lanjiu.im.storage.service.RegisteredUserFriendVideoService;
import com.lanjiu.im.storage.util.ConfigFileOperation;
import com.lanjiu.im.storage.util.ConstantsContent;
import com.lanjiu.im.storage.util.DBTools;
import com.lanjiu.pro.fileStorage.*;
import io.grpc.ServerBuilder;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorageController {

    public int storageControllerFriend(String userType, String settingsType, OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission){
        Friends friends = originalPictureVideoFriendsTransmission.getFriends();
        FileContent fileContent = originalPictureVideoFriendsTransmission.getFileContent();
        Tourists tourists = originalPictureVideoFriendsTransmission.getTourists();
        RegisteredUser registeredUser = originalPictureVideoFriendsTransmission.getRegisteredUser();
        int result = 0;
        if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_REGISTERED_USER.equals(userType)){
            StorageWithFriendsWithRegisteredUserController storageWithFriendsWithRegisteredUserController = new StorageWithFriendsWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredUserFriendVideoMapper mapperb = session.getMapper(RegisteredUserFriendVideoMapper.class);
                result = storageWithFriendsWithRegisteredUserController.saveRegisteredUserFriendVideoController(session, mapperb, friends, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredUserFriendPictureMapper mapperb = session.getMapper(RegisteredUserFriendPictureMapper.class);
                result = storageWithFriendsWithRegisteredUserController.saveRegisteredUserFriendPictureController(session, mapperb, friends, registeredUser, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_GUEST_USER.equals(userType)){
            StorageWithFriendsWithGuestUserController storageWithFriendsWithGuestUserController = new StorageWithFriendsWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestUserFriendVideoMapper mapperb = session.getMapper(GuestUserFriendVideoMapper.class);
                result = storageWithFriendsWithGuestUserController.saveGuestUserFriendVideoController(session, mapperb, friends, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestUserFriendPictureMapper mapperb = session.getMapper(GuestUserFriendPictureMapper.class);
                result = storageWithFriendsWithGuestUserController.saveGuestUserFriendPictureController(session, mapperb, friends, tourists, fileContent);
            }
        }
        return result;
    }

    //交互服务器调用
    public boolean deleteControllerFriend(String userType, String settingsType, OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission){
        Friends friends = originalPictureVideoFriendsTransmission.getFriends();
        FileContent fileContent = originalPictureVideoFriendsTransmission.getFileContent();
        Tourists tourists = originalPictureVideoFriendsTransmission.getTourists();
        RegisteredUser registeredUser = originalPictureVideoFriendsTransmission.getRegisteredUser();
        boolean bResult = false;
        if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_REGISTERED_USER.equals(userType)){
            StorageWithFriendsWithRegisteredUserController storageWithFriendsWithRegisteredUserController = new StorageWithFriendsWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredUserFriendVideoMapper mapperb = session.getMapper(RegisteredUserFriendVideoMapper.class);
                bResult = storageWithFriendsWithRegisteredUserController.deleteRegisteredUserFriendVideoController(session, mapperb, friends, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredUserFriendPictureMapper mapperb = session.getMapper(RegisteredUserFriendPictureMapper.class);
                bResult = storageWithFriendsWithRegisteredUserController.deleteRegisteredUserFriendPictureController(session, mapperb, friends, registeredUser, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_GUEST_USER.equals(userType)){
            StorageWithFriendsWithGuestUserController storageWithFriendsWithGuestUserController = new StorageWithFriendsWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestUserFriendVideoMapper mapperb = session.getMapper(GuestUserFriendVideoMapper.class);
                bResult = storageWithFriendsWithGuestUserController.deleteGuestUserFriendVideoController(session, mapperb, friends, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestUserFriendPictureMapper mapperb = session.getMapper(GuestUserFriendPictureMapper.class);
                bResult = storageWithFriendsWithGuestUserController.deleteGuestUserFriendPictureController(session, mapperb, friends, tourists, fileContent);
            }
        }
        return bResult;
    }
    //其他服务器调用
    public boolean deleteControllerFriendByFriendId(String userType, String settingsType, OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission){
        Friends friends = originalPictureVideoFriendsTransmission.getFriends();
        FileContent fileContent = originalPictureVideoFriendsTransmission.getFileContent();
        Tourists tourists = originalPictureVideoFriendsTransmission.getTourists();
        RegisteredUser registeredUser = originalPictureVideoFriendsTransmission.getRegisteredUser();
        boolean bResult = false;
        if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_REGISTERED_USER.equals(userType)){
            StorageWithFriendsWithRegisteredUserController storageWithFriendsWithRegisteredUserController = new StorageWithFriendsWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredUserFriendVideoMapper mapperb = session.getMapper(RegisteredUserFriendVideoMapper.class);
                bResult = storageWithFriendsWithRegisteredUserController.deleteRegisteredUserFriendByFriendIdVideoController(session, mapperb, friends, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredUserFriendPictureMapper mapperb = session.getMapper(RegisteredUserFriendPictureMapper.class);
                bResult = storageWithFriendsWithRegisteredUserController.deleteRegisteredUserFriendByFriendIdPictureController(session, mapperb, friends, registeredUser, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_GUEST_USER.equals(userType)){
            StorageWithFriendsWithGuestUserController storageWithFriendsWithGuestUserController = new StorageWithFriendsWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestUserFriendVideoMapper mapperb = session.getMapper(GuestUserFriendVideoMapper.class);
                bResult = storageWithFriendsWithGuestUserController.deleteGuestUserFriendVideoByFriendIdController(session, mapperb, friends, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestUserFriendPictureMapper mapperb = session.getMapper(GuestUserFriendPictureMapper.class);
                bResult = storageWithFriendsWithGuestUserController.deleteGuestUserFriendPictureByFriendIdController(session, mapperb, friends, tourists, fileContent);
            }
        }
        return bResult;
    }

    public int storageControllerGroup(String userType, String settingsType, OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission){
        GroupMember groupMember = originalPictureVideoGroupTransmission.getGroupMember();
        Group group = originalPictureVideoGroupTransmission.getGroup();
        Tourists tourists = originalPictureVideoGroupTransmission.getTourists();
        RegisteredUser registeredUser = originalPictureVideoGroupTransmission.getRegisteredUser();
        FileContent fileContent = originalPictureVideoGroupTransmission.getFileContent();
        int result = 0;
        if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_GUEST_MEMBER_GUEST_USER.equals(userType)){
            StorageWithGuestGroupWithGuestMemberWithGuestUserController storageWithGuestGroupWithGuestMemberWithGuestUserController = new StorageWithGuestGroupWithGuestMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberGuestUserVideoMapper mapperb = session.getMapper(GuestGroupGuestMemberGuestUserVideoMapper.class);
                result = storageWithGuestGroupWithGuestMemberWithGuestUserController.saveGuestGroupGuestMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberGuestUserPictureMapper mapperb = session.getMapper(GuestGroupGuestMemberGuestUserPictureMapper.class);
                result = storageWithGuestGroupWithGuestMemberWithGuestUserController.saveGuestGroupGuestMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_GUEST_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithGuestGroupWithGuestMemberWithRegisteredUserController storageWithGuestGroupWithGuestMemberWithRegisteredUserController = new StorageWithGuestGroupWithGuestMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberRegisteredUserVideoMapper mapperb = session.getMapper(GuestGroupGuestMemberRegisteredUserVideoMapper.class);
                result = storageWithGuestGroupWithGuestMemberWithRegisteredUserController.saveGuestGroupGuestMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberRegisteredUserPictureMapper mapperb = session.getMapper(GuestGroupGuestMemberRegisteredUserPictureMapper.class);
                result = storageWithGuestGroupWithGuestMemberWithRegisteredUserController.saveGuestGroupGuestMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_REGISTERED_MEMBER_GUEST_USER.equals(userType)){
            StorageWithGuestGroupWithRegisteredMemberWithGuestUserController storageWithGuestGroupWithRegisteredMemberWithGuestUserController = new StorageWithGuestGroupWithRegisteredMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberGuestUserVideoMapper mapperb = session.getMapper(GuestGroupRegisteredMemberGuestUserVideoMapper.class);
                result = storageWithGuestGroupWithRegisteredMemberWithGuestUserController.saveGuestGroupRegisteredMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberGuestUserPictureMapper mapperb = session.getMapper(GuestGroupRegisteredMemberGuestUserPictureMapper.class);
                result = storageWithGuestGroupWithRegisteredMemberWithGuestUserController.saveGuestGroupRegisteredMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_REGISTERED_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithGuestGroupWithRegisteredMemberWithRegisteredUserController storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController = new StorageWithGuestGroupWithRegisteredMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb = session.getMapper(GuestGroupRegisteredMemberRegisteredUserVideoMapper.class);
                result = storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController.saveGuestGroupRegisteredMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb = session.getMapper(GuestGroupRegisteredMemberRegisteredUserPictureMapper.class);
                result = storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController.saveGuestGroupRegisteredMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }//----
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_GUEST_MEMBER_GUEST_USER.equals(userType)){
            StorageWithRegisteredGroupWithGuestMemberWithGuestUserController storageWithRegisteredGroupWithGuestMemberWithGuestUserController = new StorageWithRegisteredGroupWithGuestMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberGuestUserVideoMapper mapperb = session.getMapper(RegisteredGroupGuestMemberGuestUserVideoMapper.class);
                result = storageWithRegisteredGroupWithGuestMemberWithGuestUserController.saveRegisteredGroupGuestMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberGuestUserPictureMapper mapperb = session.getMapper(RegisteredGroupGuestMemberGuestUserPictureMapper.class);
                result = storageWithRegisteredGroupWithGuestMemberWithGuestUserController.saveRegisteredGroupGuestMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_GUEST_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithRegisteredGroupWithGuestMemberWithRegisteredUserController storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController = new StorageWithRegisteredGroupWithGuestMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb = session.getMapper(RegisteredGroupGuestMemberRegisteredUserVideoMapper.class);
                result = storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController.saveRegisteredGroupGuestMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb = session.getMapper(RegisteredGroupGuestMemberRegisteredUserPictureMapper.class);
                result = storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController.saveRegisteredGroupGuestMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_REGISTERED_MEMBER_GUEST_USER.equals(userType)){
            StorageWithRegisteredGroupWithRegisteredMemberWithGuestUserController storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController = new StorageWithRegisteredGroupWithRegisteredMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberGuestUserVideoMapper.class);
                result = storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController.saveRegisteredGroupRegisteredMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberGuestUserPictureMapper.class);
                result = storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController.saveRegisteredGroupRegisteredMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_REGISTERED_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController = new StorageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberRegisteredUserVideoMapper.class);
                result = storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController.saveRegisteredGroupRegisteredMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberRegisteredUserPictureMapper.class);
                result = storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController.saveRegisteredGroupRegisteredMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }
        }
        return result;
    }

    //其他服务器调用-----------非文件服务器
    public boolean deleteControllerGroup(String userType, String settingsType, OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission){
        GroupMember groupMember = originalPictureVideoGroupTransmission.getGroupMember();
        Group group = originalPictureVideoGroupTransmission.getGroup();
        Tourists tourists = originalPictureVideoGroupTransmission.getTourists();
        RegisteredUser registeredUser = originalPictureVideoGroupTransmission.getRegisteredUser();
        FileContent fileContent = originalPictureVideoGroupTransmission.getFileContent();
        boolean bResult = false;
        if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_GUEST_MEMBER_GUEST_USER.equals(userType)){
            StorageWithGuestGroupWithGuestMemberWithGuestUserController storageWithGuestGroupWithGuestMemberWithGuestUserController = new StorageWithGuestGroupWithGuestMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberGuestUserVideoMapper mapperb = session.getMapper(GuestGroupGuestMemberGuestUserVideoMapper.class);
                bResult = storageWithGuestGroupWithGuestMemberWithGuestUserController.deleteGuestGroupGuestMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberGuestUserPictureMapper mapperb = session.getMapper(GuestGroupGuestMemberGuestUserPictureMapper.class);
                bResult = storageWithGuestGroupWithGuestMemberWithGuestUserController.deleteGuestGroupGuestMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_GUEST_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithGuestGroupWithGuestMemberWithRegisteredUserController storageWithGuestGroupWithGuestMemberWithRegisteredUserController = new StorageWithGuestGroupWithGuestMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberRegisteredUserVideoMapper mapperb = session.getMapper(GuestGroupGuestMemberRegisteredUserVideoMapper.class);
                bResult = storageWithGuestGroupWithGuestMemberWithRegisteredUserController.deleteGuestGroupGuestMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupGuestMemberRegisteredUserPictureMapper mapperb = session.getMapper(GuestGroupGuestMemberRegisteredUserPictureMapper.class);
                bResult = storageWithGuestGroupWithGuestMemberWithRegisteredUserController.deleteGuestGroupGuestMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_REGISTERED_MEMBER_GUEST_USER.equals(userType)){
            StorageWithGuestGroupWithRegisteredMemberWithGuestUserController storageWithGuestGroupWithRegisteredMemberWithGuestUserController = new StorageWithGuestGroupWithRegisteredMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberGuestUserVideoMapper mapperb = session.getMapper(GuestGroupRegisteredMemberGuestUserVideoMapper.class);
                bResult = storageWithGuestGroupWithRegisteredMemberWithGuestUserController.deleteGuestGroupRegisteredMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberGuestUserPictureMapper mapperb = session.getMapper(GuestGroupRegisteredMemberGuestUserPictureMapper.class);
                bResult = storageWithGuestGroupWithRegisteredMemberWithGuestUserController.deleteGuestGroupRegisteredMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GUEST_GROUP_REGISTERED_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithGuestGroupWithRegisteredMemberWithRegisteredUserController storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController = new StorageWithGuestGroupWithRegisteredMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberRegisteredUserVideoMapper mapperb = session.getMapper(GuestGroupRegisteredMemberRegisteredUserVideoMapper.class);
                bResult = storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController.deleteGuestGroupRegisteredMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                GuestGroupRegisteredMemberRegisteredUserPictureMapper mapperb = session.getMapper(GuestGroupRegisteredMemberRegisteredUserPictureMapper.class);
                bResult = storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController.deleteGuestGroupRegisteredMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }//----
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_GUEST_MEMBER_GUEST_USER.equals(userType)){
            StorageWithRegisteredGroupWithGuestMemberWithGuestUserController storageWithRegisteredGroupWithGuestMemberWithGuestUserController = new StorageWithRegisteredGroupWithGuestMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberGuestUserVideoMapper mapperb = session.getMapper(RegisteredGroupGuestMemberGuestUserVideoMapper.class);
                bResult = storageWithRegisteredGroupWithGuestMemberWithGuestUserController.deleteRegisteredGroupGuestMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberGuestUserPictureMapper mapperb = session.getMapper(RegisteredGroupGuestMemberGuestUserPictureMapper.class);
                bResult = storageWithRegisteredGroupWithGuestMemberWithGuestUserController.deleteRegisteredGroupGuestMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_GUEST_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithRegisteredGroupWithGuestMemberWithRegisteredUserController storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController = new StorageWithRegisteredGroupWithGuestMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberRegisteredUserVideoMapper mapperb = session.getMapper(RegisteredGroupGuestMemberRegisteredUserVideoMapper.class);
                bResult = storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController.deleteRegisteredGroupGuestMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupGuestMemberRegisteredUserPictureMapper mapperb = session.getMapper(RegisteredGroupGuestMemberRegisteredUserPictureMapper.class);
                bResult = storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController.deleteRegisteredGroupGuestMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_REGISTERED_MEMBER_GUEST_USER.equals(userType)){
            StorageWithRegisteredGroupWithRegisteredMemberWithGuestUserController storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController = new StorageWithRegisteredGroupWithRegisteredMemberWithGuestUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberGuestUserVideoMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberGuestUserVideoMapper.class);
                bResult = storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController.deleteRegisteredGroupRegisteredMemberGuestUserVideoController(session, mapperb, group, groupMember, tourists, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberGuestUserPictureMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberGuestUserPictureMapper.class);
                bResult = storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController.deleteRegisteredGroupRegisteredMemberGuestUserPictureController(session, mapperb, group, groupMember, tourists, fileContent);
            }
        }else if(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_REGISTERED_GROUP_REGISTERED_MEMBER_REGISTERED_USER.equals(userType)){
            StorageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController = new StorageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController();
            if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_VIDEO.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberRegisteredUserVideoMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberRegisteredUserVideoMapper.class);
                bResult = storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController.deleteRegisteredGroupRegisteredMemberRegisteredUserVideoController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }else if (ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_PICTURE.equals(settingsType)){
                SqlSession session = DBTools.getSession();
                RegisteredGroupRegisteredMemberRegisteredUserPictureMapper mapperb = session.getMapper(RegisteredGroupRegisteredMemberRegisteredUserPictureMapper.class);
                bResult = storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController.deleteRegisteredGroupRegisteredMemberRegisteredUserPictureController(session, mapperb, group, groupMember, registeredUser, fileContent);
            }
        }
        return bResult;
    }

    //群文件每天定时删除上传超过七天的记录和对应的文件---可配置
    public void deleteControllerGroupByTask(){
        //获取每次任务清楚记录的时间间隔
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        long day = Long.valueOf(configFileOperation.getGroupRecordClearTimeConfig());
//        StorageWithGuestGroupWithGuestMemberWithGuestUserController storageWithGuestGroupWithGuestMemberWithGuestUserController = new StorageWithGuestGroupWithGuestMemberWithGuestUserController();
//        //GuestGroupGuestMemberGuestUserVideo
        SqlSession session = DBTools.getSession();
//        GuestGroupGuestMemberGuestUserVideoMapper guestGroupGuestMemberGuestUserVideoMapper = session.getMapper(GuestGroupGuestMemberGuestUserVideoMapper.class);
//        storageWithGuestGroupWithGuestMemberWithGuestUserController.deleteTaskGuestGroupGuestMemberGuestUserVideoController(session, guestGroupGuestMemberGuestUserVideoMapper, day);
//        //GuestGroupGuestMemberGuestUserPicture
//        GuestGroupGuestMemberGuestUserPictureMapper guestGroupGuestMemberGuestUserPictureMapper = session.getMapper(GuestGroupGuestMemberGuestUserPictureMapper.class);
//        storageWithGuestGroupWithGuestMemberWithGuestUserController.deleteTaskGuestGroupGuestMemberGuestUserPictureController(session, guestGroupGuestMemberGuestUserPictureMapper, day);

//        StorageWithGuestGroupWithGuestMemberWithRegisteredUserController storageWithGuestGroupWithGuestMemberWithRegisteredUserController = new StorageWithGuestGroupWithGuestMemberWithRegisteredUserController();
//        //GuestGroupGuestMemberRegisteredUserVideo
//        GuestGroupGuestMemberRegisteredUserVideoMapper guestGroupGuestMemberRegisteredUserVideoMapper = session.getMapper(GuestGroupGuestMemberRegisteredUserVideoMapper.class);
//        storageWithGuestGroupWithGuestMemberWithRegisteredUserController.deleteTaskGuestGroupGuestMemberRegisteredUserVideoController(session, guestGroupGuestMemberRegisteredUserVideoMapper, day);
//        //GuestGroupGuestMemberRegisteredUserPicture
//        GuestGroupGuestMemberRegisteredUserPictureMapper guestGroupGuestMemberRegisteredUserPictureMapper = session.getMapper(GuestGroupGuestMemberRegisteredUserPictureMapper.class);
//        storageWithGuestGroupWithGuestMemberWithRegisteredUserController.deleteTaskGuestGroupGuestMemberRegisteredUserPictureController(session, guestGroupGuestMemberRegisteredUserPictureMapper, day);

//        StorageWithGuestGroupWithRegisteredMemberWithGuestUserController storageWithGuestGroupWithRegisteredMemberWithGuestUserController = new StorageWithGuestGroupWithRegisteredMemberWithGuestUserController();
//        //GuestGroupRegisteredMemberGuestUserVideo
//        GuestGroupRegisteredMemberGuestUserVideoMapper guestGroupRegisteredMemberGuestUserVideoMapper = session.getMapper(GuestGroupRegisteredMemberGuestUserVideoMapper.class);
//        storageWithGuestGroupWithRegisteredMemberWithGuestUserController.deleteTaskGuestGroupRegisteredMemberGuestUserVideoController(session, guestGroupRegisteredMemberGuestUserVideoMapper, day);
//        //GuestGroupRegisteredMemberGuestUserPicture
//        GuestGroupRegisteredMemberGuestUserPictureMapper guestGroupRegisteredMemberGuestUserPictureMapper = session.getMapper(GuestGroupRegisteredMemberGuestUserPictureMapper.class);
//        storageWithGuestGroupWithRegisteredMemberWithGuestUserController.deleteTaskGuestGroupRegisteredMemberGuestUserPictureController(session, guestGroupRegisteredMemberGuestUserPictureMapper, day);

//        StorageWithGuestGroupWithRegisteredMemberWithRegisteredUserController storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController = new StorageWithGuestGroupWithRegisteredMemberWithRegisteredUserController();
//        //GuestGroupRegisteredMemberRegisteredUserVideo
//        GuestGroupRegisteredMemberRegisteredUserVideoMapper guestGroupRegisteredMemberRegisteredUserVideoMapper = session.getMapper(GuestGroupRegisteredMemberRegisteredUserVideoMapper.class);
//        storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController.deleteTaskGuestGroupRegisteredMemberRegisteredUserVideoController(session, guestGroupRegisteredMemberRegisteredUserVideoMapper, day);
//        //GuestGroupRegisteredMemberRegisteredUserPicture
//        GuestGroupRegisteredMemberRegisteredUserPictureMapper guestGroupRegisteredMemberRegisteredUserPictureMapper = session.getMapper(GuestGroupRegisteredMemberRegisteredUserPictureMapper.class);
//        storageWithGuestGroupWithRegisteredMemberWithRegisteredUserController.deleteTaskGuestGroupRegisteredMemberRegisteredUserPictureController(session, guestGroupRegisteredMemberRegisteredUserPictureMapper, day);

//        StorageWithRegisteredGroupWithGuestMemberWithGuestUserController storageWithRegisteredGroupWithGuestMemberWithGuestUserController = new StorageWithRegisteredGroupWithGuestMemberWithGuestUserController();
//        //RegisteredGroupGuestMemberGuestUserVideo
//        RegisteredGroupGuestMemberGuestUserVideoMapper registeredGroupGuestMemberGuestUserVideoMapper = session.getMapper(RegisteredGroupGuestMemberGuestUserVideoMapper.class);
//        storageWithRegisteredGroupWithGuestMemberWithGuestUserController.deleteTaskRegisteredGroupGuestMemberGuestUserVideoController(session, registeredGroupGuestMemberGuestUserVideoMapper, day);
//        //RegisteredGroupGuestMemberGuestUserPicture
//        RegisteredGroupGuestMemberGuestUserPictureMapper registeredGroupGuestMemberGuestUserPictureMapper = session.getMapper(RegisteredGroupGuestMemberGuestUserPictureMapper.class);
//        storageWithRegisteredGroupWithGuestMemberWithGuestUserController.deleteTaskRegisteredGroupGuestMemberGuestUserPictureController(session, registeredGroupGuestMemberGuestUserPictureMapper, day);

//        StorageWithRegisteredGroupWithGuestMemberWithRegisteredUserController storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController = new StorageWithRegisteredGroupWithGuestMemberWithRegisteredUserController();
//        //RegisteredGroupGuestMemberRegisteredUserVideo
//        RegisteredGroupGuestMemberRegisteredUserVideoMapper registeredGroupGuestMemberRegisteredUserVideoMapper = session.getMapper(RegisteredGroupGuestMemberRegisteredUserVideoMapper.class);
//        storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController.deleteTaskRegisteredGroupGuestMemberRegisteredUserVideoController(session, registeredGroupGuestMemberRegisteredUserVideoMapper, day);
//        //RegisteredGroupGuestMemberRegisteredUserPicture
//        RegisteredGroupGuestMemberRegisteredUserPictureMapper registeredGroupGuestMemberRegisteredUserPictureMapper = session.getMapper(RegisteredGroupGuestMemberRegisteredUserPictureMapper.class);
//        storageWithRegisteredGroupWithGuestMemberWithRegisteredUserController.deleteTaskRegisteredGroupGuestMemberRegisteredUserPictureController(session, registeredGroupGuestMemberRegisteredUserPictureMapper, day);

//        StorageWithRegisteredGroupWithRegisteredMemberWithGuestUserController storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController = new StorageWithRegisteredGroupWithRegisteredMemberWithGuestUserController();
//        //RegisteredGroupRegisteredMemberGuestUserVideo
//        RegisteredGroupRegisteredMemberGuestUserVideoMapper registeredGroupRegisteredMemberGuestUserVideoMapper = session.getMapper(RegisteredGroupRegisteredMemberGuestUserVideoMapper.class);
//        storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController.deleteTaskRegisteredGroupRegisteredMemberGuestUserVideoController(session, registeredGroupRegisteredMemberGuestUserVideoMapper, day);
//        //RegisteredGroupRegisteredMemberGuestUserPicture
//        RegisteredGroupRegisteredMemberGuestUserPictureMapper registeredGroupRegisteredMemberGuestUserPictureMapper = session.getMapper(RegisteredGroupRegisteredMemberGuestUserPictureMapper.class);
//        storageWithRegisteredGroupWithRegisteredMemberWithGuestUserController.deleteTaskRegisteredGroupRegisteredMemberGuestUserPictureController(session, registeredGroupRegisteredMemberGuestUserPictureMapper, day);

        StorageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController = new StorageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController();
        //RegisteredGroupRegisteredMemberRegisteredUserVideo
        RegisteredGroupRegisteredMemberRegisteredUserVideoMapper registeredGroupRegisteredMemberRegisteredUserVideoMapper = session.getMapper(RegisteredGroupRegisteredMemberRegisteredUserVideoMapper.class);
        storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController.deleteTaskRegisteredGroupRegisteredMemberRegisteredUserVideoController(session, registeredGroupRegisteredMemberRegisteredUserVideoMapper, day);
        //RegisteredGroupRegisteredMemberRegisteredUserPicture
        RegisteredGroupRegisteredMemberRegisteredUserPictureMapper registeredGroupRegisteredMemberRegisteredUserPictureMapper = session.getMapper(RegisteredGroupRegisteredMemberRegisteredUserPictureMapper.class);
        storageWithRegisteredGroupWithRegisteredMemberWithRegisteredUserController.deleteTaskRegisteredGroupRegisteredMemberRegisteredUserPictureController(session, registeredGroupRegisteredMemberRegisteredUserPictureMapper, day);
        return ;
    }

    /**
     * 文件服务定期清理好友间的聊天文件图片音视频数据及数据库记录
     */
    public void deleteFriendFilePicVidByTask() {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        long day = Long.valueOf(configFileOperation.getGroupRecordClearTimeConfig());
        long temp = System.currentTimeMillis() - day*24*60*60*1000;
        Date clam_day = new Date(temp);
        SqlSession session = DBTools.getSession();
        List<String>  urls = new ArrayList<>();
        RegisteredUserFriendVideoMapper mapperrv = session.getMapper(RegisteredUserFriendVideoMapper.class);
        RegisteredUserFriendPictureMapper mapperbrp = session.getMapper(RegisteredUserFriendPictureMapper.class);

        RegisteredUserFriendPictureService registeredUserFriendPictureService = new RegisteredUserFriendPictureService();
        List<RegisteredUserFriendPicture> piclist = registeredUserFriendPictureService.selectPicRecordByDay(session, mapperbrp, clam_day);
        if(piclist.size()>0){
            for (RegisteredUserFriendPicture rp:piclist){
                urls.add(rp.getDownloadUrl());
            }
        }

        RegisteredUserFriendVideoService registeredUserFriendVideoService = new RegisteredUserFriendVideoService();
        List<RegisteredUserFriendVideo> vidlist = registeredUserFriendVideoService.selectVidRecordByDay(session, mapperrv, clam_day);
        if(vidlist.size()>0){
            for (RegisteredUserFriendVideo rv :vidlist){
                urls.add(rv.getDownloadUrl());
            }
        }

        //grpc删除本地文件
        StringBuilder sb = new StringBuilder();
        if(urls.size()<= 0){
            return;
        }

         for(String url:urls){
             sb.append(url);
             sb.append(",");
         }
         linkTransferCommunication.deleteFileIsSuccessFulWithFriends(sb.toString());


        //删除数据库记录
        registeredUserFriendPictureService.deletePicRecordByDay(session, mapperbrp, clam_day);
        registeredUserFriendVideoService.deleteVidRecordByDay(session, mapperrv, clam_day);
    }



    /**
     * 注册用户定期清理时，grpc远程清理文件存储和交互服务中记录残留
     */
    public void cleanFileByRegistUserId(int userId){
        SqlSession session = DBTools.getSession();
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        List<String> urllist = new ArrayList<String>();
//        GuestUserFriendPictureMapper mappergp = session.getMapper(GuestUserFriendPictureMapper.class);
//        GuestUserFriendVideoMapper mappergv = session.getMapper(GuestUserFriendVideoMapper.class);
        RegisteredUserFriendVideoMapper mapperrv = session.getMapper(RegisteredUserFriendVideoMapper.class);
        RegisteredUserFriendPictureMapper mapperbrp = session.getMapper(RegisteredUserFriendPictureMapper.class);

        RegisteredUserFriendPictureService registeredUserFriendPictureService = new RegisteredUserFriendPictureService();
        RegisteredUserFriendPicture registeredUserFriendPicture = new RegisteredUserFriendPicture();
        registeredUserFriendPicture.setRegisteredUserId(userId);
        List<RegisteredUserFriendPicture> rplist = registeredUserFriendPictureService.selectRecordByUserId(session, mapperbrp, registeredUserFriendPicture);
        if(rplist.size()>0){
            for (RegisteredUserFriendPicture rp:rplist){
                urllist.add(rp.getDownloadUrl());
            }
        }

        RegisteredUserFriendVideoService registeredUserFriendVideoService = new RegisteredUserFriendVideoService();
        RegisteredUserFriendVideo registeredUserFriendVideo = new RegisteredUserFriendVideo();
        registeredUserFriendVideo.setRegisteredUserId(userId);
        List<RegisteredUserFriendVideo> rvlist = registeredUserFriendVideoService.selectRecordByRegistUserId(session, mapperrv, registeredUserFriendVideo);
        if(rvlist.size()>0){
            for (RegisteredUserFriendVideo rv :rvlist){
                urllist.add(rv.getDownloadUrl());
            }
        }

//        GuestUserFriendPictureService guestUserFriendPictureService = new GuestUserFriendPictureService();
//        GuestUserFriendPicture guestUserFriendPicture = new GuestUserFriendPicture();
//        guestUserFriendPicture.setFriendId(userId);
//        List<GuestUserFriendPicture> gplist = guestUserFriendPictureService.selectRecordOnlyByFriendId(session, mappergp, guestUserFriendPicture);
//        if(gplist.size()>0){
//            for (GuestUserFriendPicture gp:gplist){
//                urllist.add(gp.getDownloadUrl());
//            }
//        }
//
//        GuestUserFriendVideoService guestUserFriendVideoService = new GuestUserFriendVideoService();
//        GuestUserFriendVideo guestUserFriendVideo = new GuestUserFriendVideo();
//        guestUserFriendVideo.setFriendId(userId);
//        List<GuestUserFriendVideo> gvlist = guestUserFriendVideoService.selectRecordOnlyByFriendId(session, mappergv, guestUserFriendVideo);
//        if(gvlist.size()>0){
//            for (GuestUserFriendVideo gv:gvlist){
//                urllist.add(gv.getDownloadUrl());
//            }
//        }

        StringBuilder sb = new StringBuilder();
        if(urllist.size()>0){
            for(String url:urllist){
                sb.append(url);
                sb.append(",");
            }
            linkTransferCommunication.deleteFileIsSuccessFulWithFriends(sb.toString());
        }

        registeredUserFriendPictureService.cleanRegistFile(session, mapperbrp, userId);
        session.close();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("清理用户文件记录："+userId);
        return;
    }


    public static void main(String[] args) {
        StorageController  sc  = new StorageController();
        sc.deleteFriendFilePicVidByTask();
    }
}
