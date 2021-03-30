package com.lanjiu.im.storage.util;

import com.lanjiu.pro.fileStorage.*;

public class CustomGRPCEntityToString {

    public String toStringRegisteredUser(RegisteredUser registeredUser){
        return registeredUser.getIpAddress()
                + registeredUser.getNickname()
                + registeredUser.getSecret()
                + registeredUser.getUserId()
                + registeredUser.getUserPhone();
    }
    public String toStringTourists(Tourists tourists){
        return tourists.getIme()
                + tourists.getIpAddress()
                + tourists.getMacAddress()
                + tourists.getTemporaryId();
    }
    public String toStringFriends(Friends friends){
        return friends.getFriendsId()
                + friends.getFriendsNickname()
                + friends.getFriendsUserType()
                + friends.getFriendsOfflineMessage()
                + friends.getFriendsBurnAfterReading()
                + friends.getFriendsOnlineStatus()
                + toStringRegisteredUser(friends.getRegisteredUser())
                + toStringTourists(friends.getTourists());
    }

    public String toStringGroup(Group group){
        return group.getGroupId()
                + group.getGroupNickname()
                + group.getGroupType()
                + group.getGroupQuantity();
    }

    public String toStringGroupMember(GroupMember groupMember){
        return groupMember.getGroupMemberId()
                + groupMember.getGroupMemberNickname()
                + groupMember.getGroupMemberType()
                + toStringTourists(groupMember.getTourists())
                + toStringRegisteredUser(groupMember.getRegisteredUser())
                + toStringGroup(groupMember.getGroup());
    }

    public String toStringPicture(Picture picture){
        return picture.getUrl()
                + TextFormatEscaperUtils.escapeBytes(picture.getOriginPicture())
                + picture.getLength()
                + picture.getPos()
                + TextFormatEscaperUtils.escapeBytes(picture.getThumbnail())
                + toStringFriends(picture.getFriends())
                + toStringGroupMember(picture.getGroupMember());
    }
    public String toStringVideo(Video video){
        return TextFormatEscaperUtils.escapeBytes(video.getOriginVideo())
                + video.getUrl()
                + video.getPos()
                + video.getLength()
                + TextFormatEscaperUtils.escapeBytes(video.getThumbnail())
                + toStringFriends(video.getFriends())
                + toStringGroupMember(video.getGroupMember());
    }
    public String toStringVoice(Voice voice){
        return voice.getAllLength()
                + TextFormatEscaperUtils.escapeBytes(voice.getContent())
                + voice.getLength()
                + voice.getPos()
                + toStringFriends(voice.getFriends())
                + toStringGroupMember(voice.getGroupMember());
    }

    public String toStringExpression(Expression expression){
        return expression.getExpressionId()
                + toStringFriends(expression.getFriends())
                + toStringGroupMember(expression.getGroupMember());
    }

    public String toStringHead(Head head){
        return head.getMsgId()
                + head.getFromId()
                + head.getToId()
                + head.getMsgType()
                + head.getMsgContentType()
                + head.getTimestamp()
                + head.getStatusReport()
                + head.getToken();
    }

    public String toStringOriginalPictureVideoFriendsTransmission(OriginalPictureVideoFriendsTransmission originalPictureVideoFriendsTransmission){
        return originalPictureVideoFriendsTransmission.getStatusDetail()
                + originalPictureVideoFriendsTransmission.getUserType()
                + originalPictureVideoFriendsTransmission.getSettingsType()
                + toStringPicture(originalPictureVideoFriendsTransmission.getPicture())
                + toStringVideo(originalPictureVideoFriendsTransmission.getVideo())
                + toStringFileContent(originalPictureVideoFriendsTransmission.getFileContent())
                + toStringFriends(originalPictureVideoFriendsTransmission.getFriends())
                + toStringTourists(originalPictureVideoFriendsTransmission.getTourists())
                + toStringRegisteredUser(originalPictureVideoFriendsTransmission.getRegisteredUser())
                + toStringHead(originalPictureVideoFriendsTransmission.getHead());
    }
    public String toStringOriginalPictureVideoGroupTransmission(OriginalPictureVideoGroupTransmission originalPictureVideoGroupTransmission){
        return originalPictureVideoGroupTransmission.getStatusDetail()
                + originalPictureVideoGroupTransmission.getUserType()
                + originalPictureVideoGroupTransmission.getSettingsType()
                + toStringPicture(originalPictureVideoGroupTransmission.getPicture())
                + toStringVideo(originalPictureVideoGroupTransmission.getVideo())
                + toStringFileContent(originalPictureVideoGroupTransmission.getFileContent())
                + toStringGroup(originalPictureVideoGroupTransmission.getGroup())
                + toStringGroupMember(originalPictureVideoGroupTransmission.getGroupMember())
                + toStringTourists(originalPictureVideoGroupTransmission.getTourists())
                + toStringRegisteredUser(originalPictureVideoGroupTransmission.getRegisteredUser())
                + toStringHead(originalPictureVideoGroupTransmission.getHead());
    }
    //已使用文件上传下载相关
    public String toStringFileContent(FileContent fileContent){
        return fileContent.getPackageKind()
                + toStringBigFileHead(fileContent.getBigFileHead())
                + toStringBigFileFragment(fileContent.getBigFileFragment())
                + toStringBigFileFoot(fileContent.getBigFileFoot());
    }
    public String toStringBigFileHead(BigFileHead bigFileHead){
        return bigFileHead.getCount()
                + bigFileHead.getLength()
                + bigFileHead.getClientUrl()
                + bigFileHead.getServerUrl();
    }
    public String toStringBigFileFragment(BigFileFragment bigFileFragment){
        return TextFormatEscaperUtils.escapeBytes(bigFileFragment.getData())
                + bigFileFragment.getLength()
                + bigFileFragment.getPosition();
    }
    public String toStringBigFileFoot(BigFileFoot bigFileFoot){
        return String.valueOf(bigFileFoot.getIsSuccess());
    }
}
