package com.lanjiu.im.communication.util;


import com.lanjiu.pro.business.BusinessProtocolEntities;

import java.util.List;

public class CustomEntityToString {

    public String toStringUser(BusinessProtocolEntities.TouristsUser touristsUser) {
        return touristsUser.getTemporaryId()
                + touristsUser.getNickname()
                + touristsUser.getAvatar();
    }

    public String toStringUser(BusinessProtocolEntities.RegisteredUser registeredUser) {
        return registeredUser.getUserId()
                + registeredUser.getSecret()
                + registeredUser.getNickname()
                + registeredUser.getPhone()
                + registeredUser.getAvatar()
                + registeredUser.getCaptcha();
    }

    public String toStringSettings(BusinessProtocolEntities.Settings settings) {
        return String.valueOf(settings.getOfflineMessage())
                + settings.getSnapchatStatus()
                + settings.getSnapchatTimeLength()
                + settings.getSnapchatTimeUnit()
                + settings.getExitClean()
                + settings.getTimerClean()
                + settings.getOnlineStatus();
    }

    public String toStringFriend(BusinessProtocolEntities.TouristsFriend friend) {
        return friend.getFriendId()
                + friend.getFriendUserId()
                + friend.getFriendNickname()
                + friend.getFriendAvatar()
                + friend.getFriendAlias()
                + friend.getUserType()
                + friend.getOnlineStatus()
                + toStringSettings(friend.getSettings());
    }

    public String toStringFriend(BusinessProtocolEntities.RegisteredFriend friend) {
        return friend.getFriendId()
                + friend.getFriendUserId()
                + friend.getFriendNickname()
                + friend.getFriendAvatar()
                + friend.getFriendAlias()
                + friend.getUserType()
                + friend.getOnlineStatus()
                + toStringSettings(friend.getSettings());
    }

    public String toStringGroupAnnouncements(BusinessProtocolEntities.GroupAnnouncements groupAnnouncements) {
        return groupAnnouncements.getAnnouncementId()
                + groupAnnouncements.getAnnouncementTitle()
                + groupAnnouncements.getAnnouncementContent();
    }

    public String toStringGroup(BusinessProtocolEntities.TouristsGroup group) {
        return group.getGroupId()
                + group.getGroupName()
                + group.getGroupAvatar()
                + group.getMemberCount()
                + group.getGroupType()
                + group.getGroupOwnerUserId()
                + toStringGroupAnnouncements(group.getGroupAnnouncements())
                + toStringSettings(group.getSettings());
    }

    public String toStringGroup(BusinessProtocolEntities.RegisteredGroup group) {
        return group.getGroupId()
                + group.getGroupName()
                + group.getGroupAvatar()
                + group.getMemberCount()
                + group.getGroupType()
                + group.getGroupOwnerUserId()
                + toStringGroupAnnouncements(group.getGroupAnnouncements())
                + toStringSettings(group.getSettings());
    }

    public String toStringGroupMember(BusinessProtocolEntities.TouristsGroupMember groupMember) {
        return groupMember.getGroupMemberId()
                + groupMember.getGroupMemberUserId()
                + groupMember.getGroupMemberName()
                + groupMember.getGroupMemberAvatar()
                + groupMember.getGroupMemberType()
                + groupMember.getGroupMemberNick()
                + groupMember.getGroupMemberAlias()
                + groupMember.getUserType()
                + groupMember.getOnlineStatus()
                + toStringGroup(groupMember.getGroup());
    }

    public String toStringGroupMember(BusinessProtocolEntities.RegisteredGroupMember groupMember) {
        return groupMember.getGroupMemberId()
                + groupMember.getGroupMemberUserId()
                + groupMember.getGroupMemberName()
                + groupMember.getGroupMemberAvatar()
                + groupMember.getGroupMemberType()
                + groupMember.getGroupMemberNick()
                + groupMember.getGroupMemberAlias()
                + groupMember.getUserType()
                + groupMember.getOnlineStatus()
                + toStringGroup(groupMember.getGroup());
    }

    public String toStringFriendNotify(BusinessProtocolEntities.TouristsFriendNotify friendNotify) {
        return friendNotify.getStatus()
                + toStringFriend(friendNotify.getFriend())
                + friendNotify.getLeaveMessage();
    }

    public String toStringFriendNotify(BusinessProtocolEntities.RegisteredFriendNotify friendNotify) {
        return friendNotify.getStatus()
                + toStringFriend(friendNotify.getFriend())
                + friendNotify.getLeaveMessage();
    }

    public String toStringGroupNotify(BusinessProtocolEntities.TouristsGroupNotify groupNotify) {
        return groupNotify.getType()
                + groupNotify.getStatus()
                + toStringGroupMember(groupNotify.getGroupMember())
                + groupNotify.getLeaveMessage();
    }

    public String toStringGroupNotify(BusinessProtocolEntities.RegisteredGroupNotify groupNotify) {
        return groupNotify.getType()
                + groupNotify.getStatus()
                + toStringGroupMember(groupNotify.getGroupMember())
                + groupNotify.getLeaveMessage();
    }

    public String toStringNotify(BusinessProtocolEntities.TouristsNotify notify){
        return notify.getNotifyType()
                + toStringFriendNotify(notify.getFriendNotify())
                + toStringGroupNotify(notify.getGroupNotify());
    }

    public String toStringNotify(BusinessProtocolEntities.RegisteredNotify notify){
        return notify.getNotifyType()
                + toStringFriendNotify(notify.getFriendNotify())
                + toStringGroupNotify(notify.getGroupNotify());
    }


    public String toStringPicture(BusinessProtocolEntities.Picture picture) {
        return picture.getUrl()
                + TextFormatEscaperUtils.escapeBytes(picture.getThumbnail())
                + picture.getPos()
                + picture.getLength();
    }

    public String toStringVideo(BusinessProtocolEntities.Video video) {
        return video.getUrl()
                + TextFormatEscaperUtils.escapeBytes(video.getThumbnail())
                + video.getPos()
                + video.getLength();
    }

    public String toStringVoice(BusinessProtocolEntities.Voice voice) {
        return TextFormatEscaperUtils.escapeBytes(voice.getContent())
                + voice.getPos()
                + voice.getLength();

    }

    public String toStringText(BusinessProtocolEntities.Text text) {
        return text.getContent()
                + text.getLength();
    }

    public String toStringFile(BusinessProtocolEntities.File file) {
        return file.getUrl()
                + file.getPos()
                + file.getLength();
    }

    public String toStringSysNotify(BusinessProtocolEntities.SysNotify sysNotify) {
        return sysNotify.getNotifyId()
                + sysNotify.getTitle()
                + sysNotify.getContent()
                + sysNotify.getAuthor()
                + sysNotify.getDate()
                + sysNotify.getUrl()
                + toStringPicture(sysNotify.getPicture());
    }

    public String toStringChatMessage(BusinessProtocolEntities.ChatMessage chatMessage){
        return chatMessage.getMsgId()
                + chatMessage.getChatType()
                + toStringText(chatMessage.getText())
                + toStringPicture(chatMessage.getPicture())
                + toStringVideo(chatMessage.getVideo())
                + toStringVoice(chatMessage.getVoice())
                + toStringFile(chatMessage.getFile());
    }

    public String toStringSearch(BusinessProtocolEntities.Search search) {
        return search.getKeyword();
    }

    public String toStringRoom(BusinessProtocolEntities.Room room){
        return room.getRoomId()
                + room.getRoomPwd()
                + room.getClientRole()
                + room.getOnlyAudio();
    }

    public String toStringCallUser(BusinessProtocolEntities.CallUser callUser){
        return callUser.getUserId()
                + callUser.getUserName()
                + callUser.getUserAvatar();
    }

    public String toStringCallGroup(BusinessProtocolEntities.CallGroup callGroup) {
        StringBuilder builder = new StringBuilder(callGroup.getGroupId());
        builder.append(callGroup.getCallMemberIds());
        List<BusinessProtocolEntities.CallUser> members = callGroup.getCallMembersList();
        for (BusinessProtocolEntities.CallUser member : members)
            builder.append(toStringCallUser(member));
        return builder.toString();
    }

}
