package com.lanjiu.im.grpc.utils;

/**
 * @description:
 * @author: Panwei
 * @date: 2019/11/13 17:31
 */
public interface IMSContacts {

    interface ResponseCode {

        String STATUS_REPORT_SUCCESS ="SUCCESS";
        String STATUS_REPORT_FAILURE ="FAILURE";
    }

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


    /**
     * 类型
     */
    interface Type {
        // 申请
        int APPLY = 0;
        // 邀请
        int INVITE = 1;
    }

    /**
     * 消息状态类型
     */
    interface MsgContentType {
        //消息类型为0，内容为文本
        int TEXT = 0;

        //消息类型为1，内容为图片
        int PICTURE = 1;

        //消息类型为2，内容为视频
        int VIDEO = 2;

        //消息类型为3，内容为语音
        int VOICE = 3;

        //消息类型为4，内容为文件
        int FILE = 4;

        //消息类型为5，INVITE_TOURISTS,群主邀请游客用户的消息
        int INVITE_TOURISTS = 5;

        //消息类型为6，INVITE_REGISTERED，群主邀请注册用户的消息
        int INVITE_REGISTERED = 6;

        //消息类型为7，INVITE_REFUSE_TOURISTS,游客用户拒绝群主邀请的消息
        int INVITE_REFUSE_TOURISTS = 7;

        //消息类型为8，INVITE_REFUSE_REGISTERED,注册用户拒绝群主邀请的消息
        int INVITE_REFUSE_REGISTERED = 8;

        //消息类型为9，APPLY_TOURISTS,游客用户申请入群的消息
        int APPLY_TOURISTS = 9;

        //消息类型为10，APPLY_REGISTERED，注册用户申请入群的消息
        int APPLY_REGISTERED = 10;

        //消息类型为11，APPLY_REFUSE_TOURISTS,游客群主拒绝申请入群的消息
        int APPLY_REFUSE_TOURISTS = 11;

        //消息类型为12，APPLY_REFUSE_REGISTERED,注册群主拒绝申请入群的消息
        int APPLY_REFUSE_REGISTERED = 12;

        //消息类型13，游客用户好友申请
        int APPLY_FRIEND_TOURISTS = 13;

        //消息类型14，注册用户好友申请
        int APPLY_FRIEND_REGISTERED = 14;

        //消息类型15，游客用户好友申请拒绝
        int APPLY_REFUSE_FRIEND_TOURISTS = 15;

        //消息类型16，注册用户好友申请拒绝
        int APPLY_REFUSE_FRIEND_REGISTERED = 16;

        //消息类型17，注册用户删除离线消息指令
        int DEL_OFF_MESSAGE_REGISTERED = 17;

        //消息类型18，游客删除离线消息指令
        int DEL_OFF_MESSAGE_TOURISTS = 18;

        //消息类型15，游客用户好友申请同意
        int APPLY_AGREE_FRIEND_TOURISTS = 19;

        //消息类型16，注册用户好友申请同意
        int APPLY_AGREE_FRIEND_REGISTERED = 20;

        //消息类型21，游客删除好友
        int DELETE_FRIEND_TOURISTS = 21;

        //消息类型22，注册用户删除好友
        int DELETE_FRIEND_REGISTERED = 22;
        //消息类型23，定期删除在线消息
        int TIME_CLEAR_ONLINE = 23;
    }


    /**
     * 消息状态类型
     */
    interface MsgStatusType {
        //消息服务器首次返回信息到IM服务器，IM服务器发送到手机客户端成功
        int FIRST_SERVER_IM_SUCCESS = 200;

        //消息服务器首次返回信息到IM服务器，IM服务器发送到手机客户端失败
        int FIRST_SERVER_IM_FAILURE = 400;

        //消息服务器首次返回信息到IM服务器，IM服务器发送到手机客户端失败,接收消息用户设置了离线消息处理，保存离线消息，返回处理结果给消息发送的手机客户端
        int FIRST_SERVER_IM_FAILURE_OFFLINE = 201;

        //消息服务器首次返回信息到IM服务器，IM服务器发送到手机客户端失败,接收消息用户未设置离线消息处理，不保存离线消息，返回处理结果给消息发送的手机客户端
        int FIRST_SERVER_IM_FAILURE_NO_OFFLINE = 401;

        //消息类型为4，内容为文件
        int FILE = 4;
    }


    /**
     * 操作类型
     */
    interface Operation {
        // 申请 or 邀请
        int APPLY = 1;

        // 同意
        int AGREE = 2;

        // 拒绝
        int REFUSE = 3;

        // 新增群公告
        int ADD_GROUP_ANNOUNCEMENT = 4;
        // 修改群公告
        int EDIT_GROUP_ANNOUNCEMENT = 5;
        // 删除群公告
        int DEL_GROUP_ANNOUNCEMENT = 6;
        // 更新群公告
        int GET_GROUP_ANNOUNCEMENT = 7;

        // 设置昵称
        int SETTINGS_NICK = 8;
        // 设置头像
        int SETTINGS_AVATAR = 9;
        // 获取验证码
        int SETTINGS_VERIFY_CODE = 10;
        // 重置密码-验证
        int RESET_SECRET_VERIFY = 11;
        // 重置密码
        int RESET_SECRET = 12;
        // 设置手机
        int SETTINGS_PHONE = 13;
        // 修改手机
        int UPDATE_PHONE = 14;

        // 阅后即焚开关（好友）
        int SNAPCHAT_STATUS_FRIEND = 15;
        // 阅后即焚开关（群）
        int SNAPCHAT_STATUS_GROUP = 16;
        // 阅后即焚时长（好友）
        int SNAPCHAT_LENGTH_FRIEND = 17;
        // 阅后即焚时长（群）
        int SNAPCHAT_LENGTH_GROUP = 18;


        // 设置是否接收离线消息
        int OFFLINE_MESSAGE = 19;


        // 设置是否每次退出清理
        int SETTINGS_EXIT_CLEAN = 20;
        // 设置定期清理周期
        int SETTINGS_TIMER_CLEAN = 21;

        // 设置备注
        int FRIEND_ALIAS = 22;

        // 设置群名称
        int GROUP_NAME = 23;

        // 设置群昵称
        int GROUP_MEMBER_NICK = 24;
        // 设置群备注
        int GROUP_MEMBER_ALIAS = 25;
    }

    /**
     * 客户端MsgType 00000(功能代码)+0(用户类型代码)
     */
    interface MsgType {

        //心跳
        String HEART_PACKAGE = "0";
        // 注册
        String REGISTER = "10000" + UserType.REGISTERED_USER;

        // 登录
        String LOGIN_TOURISTS = "10001" + UserType.TOURISTS_USER;
        String LOGIN_REGISTERED = "10002" + UserType.REGISTERED_USER;

        // 登出
        String LOGOUT_TOURISTS = "10003" + UserType.TOURISTS_USER;
        String LOGOUT_REGISTERED = "10004" + UserType.REGISTERED_USER;

        // 查找好友
        String FRIEND_FIND_TOURISTS = "10005" + UserType.TOURISTS_USER;
        String FRIEND_FIND_REGISTERED = "10006" + UserType.REGISTERED_USER;

        // 获取好友列表
        String FRIEND_LIST_TOURISTS = "10007" + UserType.TOURISTS_USER;
        String FRIEND_LIST_REGISTERED = "10008" + UserType.REGISTERED_USER;

        // 好友资料
        String FRIEND_INFO_TOURISTS = "10009" + UserType.TOURISTS_USER;
        String FRIEND_INFO_REGISTERED = "10010" + UserType.REGISTERED_USER;

        // 更新好友在线状态
        String FRIEND_ONLINE_STATUS_TOURISTS = "10011" + UserType.TOURISTS_USER;
        String FRIEND_ONLINE_STATUS_REGISTERED = "10012" + UserType.REGISTERED_USER;

        // 申请加好友
        String FRIEND_APPLY_TOURISTS = "10013" + UserType.TOURISTS_USER;
        String FRIEND_APPLY_REGISTERED = "10014" + UserType.REGISTERED_USER;

        // 同意好友申请
        String FRIEND_APPLY_AGREE_TOURISTS = "10015" + UserType.TOURISTS_USER;
        String FRIEND_APPLY_AGREE_REGISTERED = "10016" + UserType.REGISTERED_USER;

        // 拒绝好友申请
        String FRIEND_APPLY_REFUSE_TOURISTS = "10017" + UserType.TOURISTS_USER;
        String FRIEND_APPLY_REFUSE_REGISTERED = "10018" + UserType.REGISTERED_USER;

        // 删除好友
        String FRIEND_DELETE_TOURISTS = "10019" + UserType.TOURISTS_USER;
        String FRIEND_DELETE_REGISTERED = "10020" + UserType.REGISTERED_USER;

        // 查找群组
        String GROUP_FIND_TOURISTS = "10021" + UserType.TOURISTS_USER;
        String GROUP_FIND_REGISTERED = "10022" + UserType.REGISTERED_USER;

        // 获取群组列表
        String GROUP_LIST_TOURISTS = "10023" + UserType.TOURISTS_USER;
        String GROUP_LIST_REGISTERED = "10024" + UserType.REGISTERED_USER;

        // 创建群
        String GROUP_CREATE_TOURISTS = "10025" + UserType.TOURISTS_USER;
        String GROUP_CREATE_REGISTERED = "10026" + UserType.REGISTERED_USER;

        // 群资料
        String GROUP_INFO_TOURISTS = "10027" + UserType.TOURISTS_USER;
        String GROUP_INFO_REGISTERED = "10028" + UserType.REGISTERED_USER;

        // 更新群成员在线状态
        String GROUP_MEMBER_ONLINE_STATUS_TOURISTS = "10029" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_ONLINE_STATUS_REGISTERED = "10030" + UserType.REGISTERED_USER;

        // 邀请入群
        String GROUP_MEMBER_INVITE_TOURISTS = "10031" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_INVITE_REGISTERED = "10032" + UserType.REGISTERED_USER;

        // 同意邀请
        String GROUP_MEMBER_INVITE_AGREE_TOURISTS = "10033" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_INVITE_AGREE_REGISTERED = "10034" + UserType.REGISTERED_USER;

        // 拒绝邀请
        String GROUP_MEMBER_INVITE_REFUSE_TOURISTS = "10035" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_INVITE_REFUSE_REGISTERED = "10036" + UserType.REGISTERED_USER;

        // 申请入群
        String GROUP_MEMBER_APPLY_TOURISTS = "10037" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_APPLY_REGISTERED = "10038" + UserType.REGISTERED_USER;

        // 同意申请
        String GROUP_MEMBER_APPLY_AGREE_TOURISTS = "10039" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_APPLY_AGREE_REGISTERED = "10040" + UserType.REGISTERED_USER;

        // 拒绝申请
        String GROUP_MEMBER_APPLY_REFUSE_TOURISTS = "10041" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_APPLY_REFUSE_REGISTERED = "10042" + UserType.REGISTERED_USER;

        // 删除群成员
        String GROUP_MEMBER_DELETE_TOURISTS = "10043" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_DELETE_REGISTERED = "10044" + UserType.REGISTERED_USER;

        // 新增群公告
        String GROUP_ANNOUNCEMENT_INSERT_TOURISTS = "10045" + UserType.TOURISTS_USER;
        String GROUP_ANNOUNCEMENT_INSERT_REGISTERED = "10046" + UserType.REGISTERED_USER;

        // 修改群公告
        String GROUP_ANNOUNCEMENT_UPDATE_TOURISTS = "10047" + UserType.TOURISTS_USER;
        String GROUP_ANNOUNCEMENT_UPDATE_REGISTERED = "10048" + UserType.REGISTERED_USER;

        // 删除群公告
        String GROUP_ANNOUNCEMENT_DELETE_TOURISTS = "10049" + UserType.TOURISTS_USER;
        String GROUP_ANNOUNCEMENT_DELETE_REGISTERED = "" + UserType.REGISTERED_USER;

        // 更新群公告
        String GROUP_ANNOUNCEMENT_SELECT_TOURISTS = "10050" + UserType.TOURISTS_USER;
        String GROUP_ANNOUNCEMENT_SELECT_REGISTERED = "10051" + UserType.REGISTERED_USER;

        // 设置昵称
        String PERSONAL_NICKNAME_TOURISTS = "10052" + UserType.TOURISTS_USER;
        String PERSONAL_NICKNAME_REGISTERED = "10053" + UserType.REGISTERED_USER;

        // 设置头像
        String PERSONAL_AVATAR_TOURISTS = "10054" + UserType.TOURISTS_USER;
        String PERSONAL_AVATAR_REGISTERED = "10055" + UserType.REGISTERED_USER;

        // 获取验证码
        String VERIFICATION_CODE = "10056" + UserType.REGISTERED_USER;

        // 重置密码-验证
        String RESET_SECRET_VERIFY = "10057" + UserType.REGISTERED_USER;

        // 重置密码-更改
        String RESET_SECRET = "10058" + UserType.REGISTERED_USER;

        // 设置手机
        String SETUP_PHONE = "10059" + UserType.REGISTERED_USER;

        // 修改手机
        String SETUP_PHONE_EDIT = "10060" + UserType.REGISTERED_USER;

        // 设置-是否接收离线消息
        String PERSONAL_OFFLINE_MSG_TOURISTS = "10061" + UserType.TOURISTS_USER;
        String PERSONAL_OFFLINE_MSG_REGISTERED = "10062" + UserType.REGISTERED_USER;

        // 设置-好友阅后即焚
        String PERSONAL_FRIEND_SNAPCHAT_TOURISTS = "10063" + UserType.TOURISTS_USER;
        String PERSONAL_FRIEND_SNAPCHAT_REGISTERED = "10064" + UserType.REGISTERED_USER;

        // 设置-好友阅后即焚时长
        String PERSONAL_FRIEND_SNAPCHAT_LENGTH_TOURISTS = "10065" + UserType.TOURISTS_USER;
        String PERSONAL_FRIEND_SNAPCHAT_LENGTH_REGISTERED = "10066" + UserType.REGISTERED_USER;

        // 设置-群阅后即焚开关
        String PERSONAL_GROUP_SNAPCHAT_TOURISTS = "10067" + UserType.TOURISTS_USER;
        String PERSONAL_GROUP_SNAPCHAT_REGISTERED = "10068" + UserType.REGISTERED_USER;

        // 设置-群阅后即焚时长
        String PERSONAL_GROUP_SNAPCHAT_LENGTH_TOURISTS = "10069" + UserType.TOURISTS_USER;
        String PERSONAL_GROUP_SNAPCHAT_LENGTH_REGISTERED = "10070" + UserType.REGISTERED_USER;

        // 设置-是否每次退出清理
        String PERSONAL_EXIT_CLEAN_TOURISTS = "10071" + UserType.TOURISTS_USER;
        String PERSONAL_EXIT_CLEAN_REGISTERED = "10072" + UserType.REGISTERED_USER;

        // 设置-定期清理周期
        String PERSONAL_TIMER_CLEAN_TOURISTS = "10073" + UserType.TOURISTS_USER;
        String PERSONAL_TIMER_CLEAN_REGISTERED = "10074" + UserType.REGISTERED_USER;

        // 设置好友备注
        String FRIEND_ALIAS_TOURISTS = "10075" + UserType.TOURISTS_USER;
        String FRIEND_ALIAS_REGISTERED = "10076" + UserType.REGISTERED_USER;

        // 好友设置阅后即焚
        String FRIEND_SNAPCHAT_TOURISTS = "10077" + UserType.TOURISTS_USER;
        String FRIEND_SNAPCHAT_REGISTERED = "10078" + UserType.REGISTERED_USER;

        // 设置阅后即焚时长
        String FRIEND_SNAPCHAT_LENGTH_TOURISTS = "10079" + UserType.TOURISTS_USER;
        String FRIEND_SNAPCHAT_LENGTH_REGISTERED = "10080" + UserType.REGISTERED_USER;

        // 好友设置是否离线消息接收
        String FRIEND_OFFLINE_MSG_TOURISTS = "10081" + UserType.TOURISTS_USER;
        String FRIEND_OFFLINE_MSG_REGISTERED = "10082" + UserType.REGISTERED_USER;

        // 设置群名称
        String GROUP_NAME_TOURISTS = "10083" + UserType.TOURISTS_USER;
        String GROUP_NAME_REGISTERED = "10084" + UserType.REGISTERED_USER;

        // 设置阅后即焚开关
        String GROUP_SNAPCHAT_TOURISTS = "10085" + UserType.TOURISTS_USER;
        String GROUP_SNAPCHAT_REGISTERED = "10086" + UserType.REGISTERED_USER;

        // 设置阅后即焚时长
        String GROUP_SNAPCHAT_LENGTH_TOURISTS = "10087" + UserType.TOURISTS_USER;
        String GROUP_SNAPCHAT_LENGTH_REGISTERED = "10088" + UserType.REGISTERED_USER;

        // 设置群成员群昵称
        String GROUP_MEMBER_NICK_TOURISTS = "10089" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_NICK_REGISTERED = "10090" + UserType.REGISTERED_USER;

        // 设置群成员备注
        String GROUP_MEMBER_ALIAS_TOURISTS = "10091" + UserType.TOURISTS_USER;
        String GROUP_MEMBER_ALIAS_REGISTERED = "10092" + UserType.REGISTERED_USER;

        // 通知列表
        String NOTIFICATIONS_TOURISTS = "10093" + UserType.TOURISTS_USER;
        String NOTIFICATIONS_REGISTERED = "10094" + UserType.REGISTERED_USER;

        // 系统通知
        String SYS_NOTIFICATIONS_TOURISTS = "10095" + UserType.TOURISTS_USER;
        String SYS_NOTIFICATIONS_REGISTERED = "10096" + UserType.REGISTERED_USER;

        // 用户消息通知
        String USER_NOTIFICATIONS_TOURISTS = "10097" + UserType.TOURISTS_USER;
        String USER_NOTIFICATIONS_REGISTERED = "10098" + UserType.REGISTERED_USER;

        // 单人聊天(1v1)
        String FRIEND_CHAT_TOURISTS = "10099" + UserType.TOURISTS_USER;
        String FRIEND_CHAT_REGISTERED = "10100" + UserType.REGISTERED_USER;

        // 多人聊天(群聊)
        String GROUP_CHAT_TOURISTS = "10101" + UserType.TOURISTS_USER;
        String GROUP_CHAT_REGISTERED = "10102" + UserType.REGISTERED_USER;

        //删除好友离线消息的指令
        String DEL_FRIEND_OFF_MESSAGE_REGIST = "10103" + UserType.REGISTERED_USER;
        String DEL_FRIEND_OFF_MESSAGE_TOURIST = "10104" + UserType.TOURISTS_USER;

        //捞取好友离线消息）
        String GET_OFF_MESSAGE_REGIST = "10105" + UserType.REGISTERED_USER;
        String GET_OFF_MESSAGE_TOURIST =  "10106" + UserType.TOURISTS_USER;

        //IMServer 删除离线消息
        String  REMOVE_MSG_BY_IM = "40000";


        // 定期清理-删除用户在线接收消息
        String DEL_ON_LINE_RECEIVE = "10302100";

        //音视频交互类消息
        String AUDIO_AND_VIDEO_CALL = "50000000";

    }
}
