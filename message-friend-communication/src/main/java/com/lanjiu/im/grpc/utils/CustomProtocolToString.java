package com.lanjiu.im.grpc.utils;



import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;

import java.util.List;

public class CustomProtocolToString {

    CustomEntityToString customEntityToString;

    public CustomProtocolToString() {
        customEntityToString = new CustomEntityToString();
    }

    public String toStringRegisteredUserProtocol(BusinessProtocolMessages.RegisteredUserProtocol registeredUserProtocol) {
        return customEntityToString.toStringUser(registeredUserProtocol.getRegisteredUser())
                + registeredUserProtocol.getStatusDetail();
    }

    public String toStringLoginProtocol(BusinessProtocolMessages.LoginProtocol loginProtocol) {
        return loginProtocol.getUserType()
                + customEntityToString.toStringUser(loginProtocol.getTouristsUser())
                + customEntityToString.toStringUser(loginProtocol.getRegisteredUser())
                + loginProtocol.getStatusDetail();
    }

    public String toStringLogoutProtocol(BusinessProtocolMessages.LogoutProtocol logoutProtocol) {
        return logoutProtocol.getUserType()
                + customEntityToString.toStringUser(logoutProtocol.getTouristsUser())
                + customEntityToString.toStringUser(logoutProtocol.getRegisteredUser())
                + logoutProtocol.getStatusDetail();
    }

    public String toStringFindUserProtocol(BusinessProtocolMessages.FindUserProtocol findUserProtocol) {
        StringBuilder builder = new StringBuilder(findUserProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(findUserProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(findUserProtocol.getRegisteredUser()));
        builder.append(customEntityToString.toStringSearch(findUserProtocol.getSearch()));
        List<BusinessProtocolEntities.TouristsUser> touristsList = findUserProtocol.getTouristsFindList();
        for (BusinessProtocolEntities.TouristsUser tourists : touristsList)
            builder.append(customEntityToString.toStringUser(tourists));
        List<BusinessProtocolEntities.RegisteredUser> registeredUserList = findUserProtocol.getRegisteredFindList();
        for (BusinessProtocolEntities.RegisteredUser registeredUser : registeredUserList)
            builder.append(customEntityToString.toStringUser(registeredUser));
        builder.append(findUserProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringFriendListProtocol(BusinessProtocolMessages.FriendListProtocol friendListProtocol) {
        StringBuilder builder = new StringBuilder(friendListProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(friendListProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(friendListProtocol.getRegisteredUser()));
        List<BusinessProtocolEntities.TouristsFriend> touristsList = friendListProtocol.getTouristsFriendList();
        for (BusinessProtocolEntities.TouristsFriend friend : touristsList)
            builder.append(customEntityToString.toStringFriend(friend));
        List<BusinessProtocolEntities.RegisteredFriend> registeredUserList = friendListProtocol.getRegisteredFriendList();
        for (BusinessProtocolEntities.RegisteredFriend friend : registeredUserList)
            builder.append(customEntityToString.toStringFriend(friend));
        builder.append(friendListProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringFriendInfoProtocol(BusinessProtocolMessages.FriendInfoProtocol friendInfoProtocol) {
        return friendInfoProtocol.getUserType()
                + customEntityToString.toStringUser(friendInfoProtocol.getTouristsUser())
                + customEntityToString.toStringUser(friendInfoProtocol.getRegisteredUser())
                + customEntityToString.toStringFriend(friendInfoProtocol.getTouristsFriend())
                + customEntityToString.toStringFriend(friendInfoProtocol.getRegisteredFriend())
                + friendInfoProtocol.getStatusDetail();
    }

    public String toStringFriendOnlineStatusChangeProtocol(BusinessProtocolMessages.FriendOnlineStatusChangeProtocol friendOnlineStatusChangeProtocol) {
        return friendOnlineStatusChangeProtocol.getUserType()
                + customEntityToString.toStringFriend(friendOnlineStatusChangeProtocol.getTouristsFriend())
                + customEntityToString.toStringFriend(friendOnlineStatusChangeProtocol.getRegisteredFriend())
                + friendOnlineStatusChangeProtocol.getStatusDetail();
    }

    public String toStringFriendAddProtocol(BusinessProtocolMessages.FriendAddProtocol friendAddProtocol) {
        StringBuilder builder = new StringBuilder(friendAddProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(friendAddProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(friendAddProtocol.getRegisteredUser()));
        List<BusinessProtocolEntities.TouristsFriend> touristsList = friendAddProtocol.getTouristsFriendList();
        for (BusinessProtocolEntities.TouristsFriend friend : touristsList)
            builder.append(customEntityToString.toStringFriend(friend));
        List<BusinessProtocolEntities.RegisteredFriend> registeredUserList = friendAddProtocol.getRegisteredFriendList();
        for (BusinessProtocolEntities.RegisteredFriend friend : registeredUserList)
            builder.append(customEntityToString.toStringFriend(friend));
        builder.append(friendAddProtocol.getLeaveMessage());
        builder.append(friendAddProtocol.getOperation());
        builder.append(friendAddProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringFriendDeleteProtocol(BusinessProtocolMessages.FriendDeleteProtocol friendDeleteProtocol) {
        return friendDeleteProtocol.getUserType()
                + customEntityToString.toStringUser(friendDeleteProtocol.getTouristsUser())
                + customEntityToString.toStringUser(friendDeleteProtocol.getRegisteredUser())
                + customEntityToString.toStringFriend(friendDeleteProtocol.getTouristsFriend())
                + customEntityToString.toStringFriend(friendDeleteProtocol.getRegisteredFriend())
                + friendDeleteProtocol.getStatusDetail();
    }

    public String toStringFindGroupProtocol(BusinessProtocolMessages.FindGroupProtocol findGroupProtocol) {
        StringBuilder builder = new StringBuilder(findGroupProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(findGroupProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(findGroupProtocol.getRegisteredUser()));
        builder.append(customEntityToString.toStringSearch(findGroupProtocol.getSearch()));
        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList = findGroupProtocol.getTouristsGroupList();
        for (BusinessProtocolEntities.TouristsGroup group : touristsGroupList)
            builder.append(customEntityToString.toStringGroup(group));
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = findGroupProtocol.getRegisteredGroupList();
        for (BusinessProtocolEntities.RegisteredGroup group : registeredGroupList)
            builder.append(customEntityToString.toStringGroup(group));
        builder.append(findGroupProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringGroupListProtocol(BusinessProtocolMessages.GroupListProtocol groupListProtocol) {
        StringBuilder builder = new StringBuilder(groupListProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(groupListProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(groupListProtocol.getRegisteredUser()));
        List<BusinessProtocolEntities.TouristsGroup> touristsGroupList = groupListProtocol.getTouristsGroupList();
        for (BusinessProtocolEntities.TouristsGroup group : touristsGroupList)
            builder.append(customEntityToString.toStringGroup(group));
        List<BusinessProtocolEntities.RegisteredGroup> registeredGroupList = groupListProtocol.getRegisteredGroupList();
        for (BusinessProtocolEntities.RegisteredGroup group : registeredGroupList)
            builder.append(customEntityToString.toStringGroup(group));
        builder.append(groupListProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringGroupCreateProtocol(BusinessProtocolMessages.GroupCreateProtocol groupCreateProtocol) {
        StringBuilder builder = new StringBuilder(groupCreateProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(groupCreateProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(groupCreateProtocol.getRegisteredUser()));
        List<BusinessProtocolEntities.TouristsGroupMember> touristsGroupMemberList = groupCreateProtocol.getTouristsGroupMemberList();
        for (BusinessProtocolEntities.TouristsGroupMember touristsGroupMember : touristsGroupMemberList)
            builder.append(customEntityToString.toStringGroupMember(touristsGroupMember));
        List<BusinessProtocolEntities.RegisteredGroupMember> registeredGroupMemberList = groupCreateProtocol.getRegisteredGroupMemberList();
        for (BusinessProtocolEntities.RegisteredGroupMember registeredGroupMember : registeredGroupMemberList)
            builder.append(customEntityToString.toStringGroupMember(registeredGroupMember));
        builder.append(customEntityToString.toStringGroup(groupCreateProtocol.getTouristsGroup()));
        builder.append(customEntityToString.toStringGroup(groupCreateProtocol.getRegisteredGroup()));
        builder.append(groupCreateProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringGroupInfoProtocol(BusinessProtocolMessages.GroupInfoProtocol groupInfoProtocol) {
        StringBuilder builder = new StringBuilder(groupInfoProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(groupInfoProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(groupInfoProtocol.getRegisteredUser()));
        builder.append(customEntityToString.toStringGroup(groupInfoProtocol.getTouristsGroup()));
        builder.append(customEntityToString.toStringGroup(groupInfoProtocol.getRegisteredGroup()));
        List<BusinessProtocolEntities.TouristsGroupMember> touristsGroupMemberList = groupInfoProtocol.getTouristsGroupMemberList();
        for (BusinessProtocolEntities.TouristsGroupMember touristsGroupMember : touristsGroupMemberList)
            builder.append(customEntityToString.toStringGroupMember(touristsGroupMember));
        List<BusinessProtocolEntities.RegisteredGroupMember> registeredGroupMemberList = groupInfoProtocol.getRegisteredGroupMemberList();
        for (BusinessProtocolEntities.RegisteredGroupMember registeredGroupMember : registeredGroupMemberList)
            builder.append(customEntityToString.toStringGroupMember(registeredGroupMember));
        builder.append(groupInfoProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringGroupMemberOnlineStatusChangeProtocol(BusinessProtocolMessages.GroupMemberOnlineStatusChangeProtocol groupMemberOnlineStatusChangeProtocol) {
        return groupMemberOnlineStatusChangeProtocol.getUserType()
                + customEntityToString.toStringGroupMember(groupMemberOnlineStatusChangeProtocol.getTouristsGroupMember())
                + customEntityToString.toStringGroupMember(groupMemberOnlineStatusChangeProtocol.getRegisteredGroupMember())
                + groupMemberOnlineStatusChangeProtocol.getStatusDetail();
    }

    public String toStringGroupMemberAddProtocol(BusinessProtocolMessages.GroupMemberAddProtocol groupMemberAddProtocol) {
        return groupMemberAddProtocol.getUserType()
                + customEntityToString.toStringUser(groupMemberAddProtocol.getTouristsUser())
                + customEntityToString.toStringUser(groupMemberAddProtocol.getRegisteredUser())
                + customEntityToString.toStringGroupMember(groupMemberAddProtocol.getTouristsGroupMember())
                + customEntityToString.toStringGroupMember(groupMemberAddProtocol.getRegisteredGroupMember())
                + groupMemberAddProtocol.getAddType()
                + groupMemberAddProtocol.getOperation()
                + groupMemberAddProtocol.getStatusDetail();
    }

    public String toStringGroupMemberDeleteProtocol(BusinessProtocolMessages.GroupMemberDeleteProtocol groupMemberDeleteProtocol) {
        return groupMemberDeleteProtocol.getUserType()
                + customEntityToString.toStringUser(groupMemberDeleteProtocol.getTouristsUser())
                + customEntityToString.toStringUser(groupMemberDeleteProtocol.getRegisteredUser())
                + customEntityToString.toStringGroupMember(groupMemberDeleteProtocol.getTouristsGroupMember())
                + customEntityToString.toStringGroupMember(groupMemberDeleteProtocol.getRegisteredGroupMember())
                + groupMemberDeleteProtocol.getStatusDetail();
    }

    public String toStringGroupAnnouncementProtocol(BusinessProtocolMessages.GroupAnnouncementProtocol groupAnnouncementProtocol) {
        return groupAnnouncementProtocol.getUserType()
                + customEntityToString.toStringUser(groupAnnouncementProtocol.getTouristsUser())
                + customEntityToString.toStringUser(groupAnnouncementProtocol.getRegisteredUser())
                + customEntityToString.toStringGroup(groupAnnouncementProtocol.getTouristsGroup())
                + customEntityToString.toStringGroup(groupAnnouncementProtocol.getRegisteredGroup())
                + groupAnnouncementProtocol.getOperation()
                + groupAnnouncementProtocol.getStatusDetail();
    }

    public String toStringPersonalInfoProtocol(BusinessProtocolMessages.PersonalInfoProtocol personalInfoProtocol) {
        return personalInfoProtocol.getUserType()
                + customEntityToString.toStringUser(personalInfoProtocol.getTouristsUser())
                + customEntityToString.toStringUser(personalInfoProtocol.getRegisteredUser())
                + customEntityToString.toStringUser(personalInfoProtocol.getSettingsTouristsUser())
                + customEntityToString.toStringUser(personalInfoProtocol.getSettingsRegisteredUser())
                + personalInfoProtocol.getOperation()
                + personalInfoProtocol.getStatusDetail();
    }

    public String toStringPersonalSettingsProtocol(BusinessProtocolMessages.PersonalSettingsProtocol personalSettingsProtocol) {
        return personalSettingsProtocol.getUserType()
                + customEntityToString.toStringUser(personalSettingsProtocol.getTouristsUser())
                + customEntityToString.toStringUser(personalSettingsProtocol.getRegisteredUser())
                + customEntityToString.toStringSettings(personalSettingsProtocol.getSettings())
                + personalSettingsProtocol.getOperation()
                + personalSettingsProtocol.getStatusDetail();
    }

    public String toStringFriendSettingsProtocol(BusinessProtocolMessages.FriendSettingsProtocol friendSettingsProtocol) {
        return friendSettingsProtocol.getUserType()
                + customEntityToString.toStringUser(friendSettingsProtocol.getTouristsUser())
                + customEntityToString.toStringUser(friendSettingsProtocol.getRegisteredUser())
                + customEntityToString.toStringFriend(friendSettingsProtocol.getTouristsFriend())
                + customEntityToString.toStringFriend(friendSettingsProtocol.getRegisteredFriend())
                + friendSettingsProtocol.getOperation()
                + friendSettingsProtocol.getStatusDetail();
    }

    public String toStringGroupSettingsProtocol(BusinessProtocolMessages.GroupSettingsProtocol groupSettingsProtocol) {
        return groupSettingsProtocol.getUserType()
                + customEntityToString.toStringUser(groupSettingsProtocol.getTouristsUser())
                + customEntityToString.toStringUser(groupSettingsProtocol.getRegisteredUser())
                + customEntityToString.toStringGroup(groupSettingsProtocol.getTouristsGroup())
                + customEntityToString.toStringGroup(groupSettingsProtocol.getRegisteredGroup())
                + groupSettingsProtocol.getOperation()
                + groupSettingsProtocol.getStatusDetail();
    }

    public String toStringGroupMemberSettingsProtocol(BusinessProtocolMessages.GroupMemberSettingsProtocol groupMemberSettingsProtocol) {
        return groupMemberSettingsProtocol.getUserType()
                + customEntityToString.toStringUser(groupMemberSettingsProtocol.getTouristsUser())
                + customEntityToString.toStringUser(groupMemberSettingsProtocol.getRegisteredUser())
                + customEntityToString.toStringGroupMember(groupMemberSettingsProtocol.getTouristsGroupMember())
                + customEntityToString.toStringGroupMember(groupMemberSettingsProtocol.getRegisteredGroupMember())
                + groupMemberSettingsProtocol.getOperation()
                + groupMemberSettingsProtocol.getStatusDetail();
    }

    public String toStringNotificationsProtocol(BusinessProtocolMessages.NotificationsProtocol notificationsProtocol) {
        StringBuilder builder = new StringBuilder(notificationsProtocol.getUserType());
        List<BusinessProtocolEntities.SysNotify> sysNotifyList = notificationsProtocol.getSysNotifyList();
        for (BusinessProtocolEntities.SysNotify sysNotify : sysNotifyList)
            builder.append(customEntityToString.toStringSysNotify(sysNotify));
        List<BusinessProtocolEntities.TouristsNotify> touristsNotifyList = notificationsProtocol.getTouristsNotifyList();
        for (BusinessProtocolEntities.TouristsNotify touristsNotify : touristsNotifyList)
            builder.append(customEntityToString.toStringNotify(touristsNotify));
        List<BusinessProtocolEntities.RegisteredNotify> registeredNotifyList = notificationsProtocol.getRegisteredNotifyList();
        for (BusinessProtocolEntities.RegisteredNotify registeredNotify : registeredNotifyList)
            builder.append(customEntityToString.toStringNotify(registeredNotify));
        builder.append(notificationsProtocol.getStatusDetail());
        return builder.toString();
    }

    public String toStringSysNotifyProtocol(BusinessProtocolMessages.SysNotifyProtocol sysNotifyProtocol) {
        return customEntityToString.toStringSysNotify(sysNotifyProtocol.getSysNotify())
                + sysNotifyProtocol.getStatusDetail();
    }

    public String toStringUserNotifyProtocol(BusinessProtocolMessages.UserNotifyProtocol userNotifyProtocol) {
        return userNotifyProtocol.getUserType()
                + customEntityToString.toStringNotify(userNotifyProtocol.getTouristsNotify())
                + customEntityToString.toStringNotify(userNotifyProtocol.getRegisteredNotify())
                + userNotifyProtocol.getStatusDetail();
    }

    public String toStringFriendChatProtocol(BusinessProtocolMessages.FriendChatProtocol friendChatProtocol) {
        return friendChatProtocol.getUserType()
                + customEntityToString.toStringUser(friendChatProtocol.getTouristsUser())
                + customEntityToString.toStringUser(friendChatProtocol.getRegisteredUser())
                + customEntityToString.toStringChatMessage(friendChatProtocol.getChatMessage())
                + customEntityToString.toStringFriend(friendChatProtocol.getTouristsFriend())
                + customEntityToString.toStringFriend(friendChatProtocol.getRegisteredFriend())
                + friendChatProtocol.getStatusDetail();
    }

    public String toStringGroupChatProtocol(BusinessProtocolMessages.GroupChatProtocol groupChatProtocol) {
        return groupChatProtocol.getUserType()
                + customEntityToString.toStringUser(groupChatProtocol.getTouristsUser())
                + customEntityToString.toStringUser(groupChatProtocol.getRegisteredUser())
                + customEntityToString.toStringChatMessage(groupChatProtocol.getChatMessage())
                + customEntityToString.toStringGroupMember(groupChatProtocol.getTouristsGroupMember())
                + customEntityToString.toStringGroupMember(groupChatProtocol.getRegisteredGroupMember())
                + groupChatProtocol.getStatusDetail();
    }

    public String toStringDelFriendOffMessageProtocol(BusinessProtocolMessages.DelFriendOffMessageProtocol delFriendOffMessageProtocol) {
        return delFriendOffMessageProtocol.getUserType()
                + customEntityToString.toStringUser(delFriendOffMessageProtocol.getRegisteredUser())
                + customEntityToString.toStringUser(delFriendOffMessageProtocol.getTouristsUser())
                + customEntityToString.toStringChatMessage(delFriendOffMessageProtocol.getChatMessage())
                + customEntityToString.toStringFriend(delFriendOffMessageProtocol.getRegisteredFriend())
                + customEntityToString.toStringFriend(delFriendOffMessageProtocol.getTouristsFriend())
                + delFriendOffMessageProtocol.getMsgfromId();

    }

    public String toStringOffFriendMessageListProtocol(BusinessProtocolMessages.OffFriendMessageListProtocol offFriendMessageListProtocol) {
        StringBuilder builder = new StringBuilder(offFriendMessageListProtocol.getUserType());
        builder.append(customEntityToString.toStringUser(offFriendMessageListProtocol.getTouristsUser()));
        builder.append(customEntityToString.toStringUser(offFriendMessageListProtocol.getRegisteredUser()));
        List<BusinessProtocolEntities.RegistFriendOffMessage> touristsList = offFriendMessageListProtocol.getRegistFriendOffMessageList();
        for (BusinessProtocolEntities.RegistFriendOffMessage message : touristsList) {
            builder.append(customEntityToString.toStringFriend(message.getRegisteredFriend()));
            builder.append(message.getMsgId());
            builder.append(message.getMsgFromUserId());
            builder.append(message.getMsgTime());
        }
        List<BusinessProtocolEntities.TouristFriendOffMessage> touristFriendOffMessageList = offFriendMessageListProtocol.getTouristFriendOffMessageList();
        for (BusinessProtocolEntities.TouristFriendOffMessage message : touristFriendOffMessageList){
            builder.append(customEntityToString.toStringFriend(message.getTouristsFriend()));
            builder.append(message.getMsgId());
            builder.append(message.getMsgFromUserId());
            builder.append(message.getMsgTime());
        }
        builder.append(offFriendMessageListProtocol.getStatusDetail());
        return builder.toString();

    }

    public String toStringAudioAndVideoCallProtocol(BusinessProtocolMessages.AudioAndVideoCallProtocol audioAndVideoCallProtocol) {
        return audioAndVideoCallProtocol.getServer()
                + customEntityToString.toStringRoom(audioAndVideoCallProtocol.getRoom())
                + customEntityToString.toStringCallUser(audioAndVideoCallProtocol.getFromUser())
                + customEntityToString.toStringCallUser(audioAndVideoCallProtocol.getToUser())
                +customEntityToString.toStringCallGroup(audioAndVideoCallProtocol.getToGroup())
                + audioAndVideoCallProtocol.getToType()
                + audioAndVideoCallProtocol.getType()
                + audioAndVideoCallProtocol.getStatusDetail()
               ;

    }


    public String toStringHead(BusinessProtocolMessageStandard.Head head) {
        return  head.getMsgType()
                + head.getMsgContentType()
                + head.getFromId()
                + head.getToId()
                + head.getTimestamp()
                + head.getStatusReport()
                + head.getUniqueIdentify()
                + head.getToken();
    }



}
