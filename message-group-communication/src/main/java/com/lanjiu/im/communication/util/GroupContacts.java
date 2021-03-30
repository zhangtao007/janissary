package com.lanjiu.im.communication.util;

/**
 * @description:
 * @author: Panwei
 * @date: 2019/11/13 17:31
 */
public interface GroupContacts {

    interface UserType {
        // UserType
        String REGISTERED_USER = "100";
        String TOURISTS_USER = "101";
    }

    /**
     * 在线状态
     */
    interface OnlineState {
        String ONLINE = "20001";
        String OFFLINE = "20002";
    }


    String GROU_OWNER_RETREAT = "DISSLOVE";

    /**
     * 离线消息类型
     */
    interface OffLineMsgType {

        //0：内容为文本
        int TEXT = 0;

        //1：内容为图片
        int PICTURE = 1;

        //2：内容为视频
        int VIDEO = 2;

        //3：内容为语音
        int VOICE = 3;

        //4：内容为文件
        int FILE = 4;

        //5：创建群
        int CREATE = 42;

        //6：邀请入群（无同意、拒绝）
        int INVITE_IN = 6;

        //7：申请入群
        int REQ_JOIN_IN = 10;

        //8：申请拒绝
        int REQ_REFUSE = 12;

        //9：申请同意
        int REQ_CONSENT = 43;

        //9：踢出群
        int KICK_OUT = 44;

        //45: 退出群组
        int EXIT_GROUP = 45;

        //46: 解散群组
        int GROUP_DISSOLVE = 46;

        //47: 撤回消息
        int DEL_GROUP_MSG = 47;
    }

    /**
     * 客户端MsgType 00000(功能代码)+0(用户类型代码)
     */
    interface MsgType {

        // 心跳包
        String HEART_PACKAGE = "0";

        // 创建群
        String GROUP_CREATE_TOURISTS = "10025" + UserType.TOURISTS_USER;
        String GROUP_CREATE_REGISTERED = "10026" + UserType.REGISTERED_USER;

        // 邀请入群
        String GROUP_MEMBER_INVITE_TOURISTS = "10031" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_INVITE_REGISTERED = "10032" + UserType.REGISTERED_USER;

        // 申请入群
        String GROUP_MEMBER_APPLY_TOURISTS = "10037" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_APPLY_REGISTERED = "10038" + UserType.REGISTERED_USER;

        // 同意申请
        String GROUP_MEMBER_APPLY_AGREE_TOURISTS = "10039" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_APPLY_AGREE_REGISTERED = "10040" + UserType.REGISTERED_USER;

        // 拒绝申请
        String GROUP_MEMBER_APPLY_REFUSE_TOURISTS = "10041" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_APPLY_REFUSE_REGISTERED = "10042" + UserType.REGISTERED_USER;

        // 多人聊天(群聊)
        String GROUP_CHAT_TOURISTS = "10101" + UserType.TOURISTS_USER;
        String GROUP_CHAT_REGISTERED = "10102" + UserType.REGISTERED_USER;

        // 群聊天消息存储
        String GROUP_CHAT_MESSAGE_STORAGE = "20003";

        // 群聊天-消息发送人响应
        String GROUP_CHART_SEND_NOTIFY =  "20005000";

        // 群聊天-拉取离线消息
        String GROUP_CHART_OFF_LINE_MSG =  "20006000";

        // 群聊天-删除离线消息
        String DELETE_GROUP_CHART_OFF_LINE_MSG =  "20007000";

        // 群聊天-踢出成员
        String GROUP_MEMBER_DELETE = "10111002";

        // 群成员主动退群
        String GROUP_MEMBER_EXIT = "10111003";

        // 群群主退群
        String GROUP_OWNER_EXIT = "10111004";

        // 群聊天消息撤回/删除
        String DEL_GROUP_MSG = "10200100";

        // 响应在线群用户聊天消息撤回/删除
        String RES_ONLINE_USER_DEL_GROUP_MSG = "10201100";

        // 离线群用户聊天消息撤回/删除消息存储
        String DEL_GROUP_MSG_STORAGE = "10202100";

        // 删除指定离线消息
        String DEL_GROUP_OFF_LINE_MSG_STORAGE = "10203100";

        //音视频交互类消息
        String AUDIO_AND_VIDEO_CALL = "50000000";

        //音视频通话类消息存储到离线用户下（IM与GroupMessage服务交互）
        String GROUP_AUDIO_VIDEO_SAVE ="20005";




    }
}
