package com.lanjiu.im.communication.util;

/**
 * @description:
 * @author: Panwei
 * @date: 2019/11/13 17:31
 */
public interface IMSContacts {

    String TOURISTS_USER_IDENTIFY = "7、8、9";

    String GROUP_CHAT_LOG_FILTER = "1、2、3、4";

    String GROU_OWNER_RETREAT = "DISSLOVE";

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
     * 客户端MsgType 00000(功能代码)+0(用户类型代码)
     */
    interface MsgType {

        // 设置类型请求时，toid的值.
        String SET_MSG_TYPE_TO_ID = "-1";

        // 手机断开心跳包
        String HEART_PACKAGE_PHONE_END = "hbend";

        // 返回长连接请求id异常
        String HEART_PACKAGE_RETURN = "ue";

        // 手机正常心跳包
        String HEART_PACKAGE_PHONE = "hb";

        // 心跳包
        String HEART_PACKAGE = "0";

        // 服务端主动发送的心跳包
        String SERVER_HEART_PACKAGE = "reply";

        // 注册
        String REGISTER = "10000" + UserType.REGISTERED_USER;

        // 登录
        String LOGIN_TOURISTS = "10001" + UserType.TOURISTS_USER;
        String LOGIN_REGISTERED = "10002" + UserType.REGISTERED_USER;

        // 退出登录
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

        // 同意入群申请
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

        // 通知列表------->服务端响应类型
        String NOTIFICATIONS_TOURISTS = "10093" + UserType.TOURISTS_USER;
        String NOTIFICATIONS_REGISTERED = "10094" + UserType.REGISTERED_USER;

        // 系统通知------->服务端响应类型
        String SYS_NOTIFICATIONS_TOURISTS = "10095" + UserType.TOURISTS_USER;
        String SYS_NOTIFICATIONS_REGISTERED = "10096" + UserType.REGISTERED_USER;

        // 用户消息通知------->服务端响应类型
        String USER_NOTIFICATIONS_TOURISTS = "10097" + UserType.TOURISTS_USER;
        String USER_NOTIFICATIONS_REGISTERED = "10098" + UserType.REGISTERED_USER;

        // 单人聊天(1v1)
        String FRIEND_CHAT_TOURISTS = "10099" + UserType.TOURISTS_USER;
        String FRIEND_CHAT_REGISTERED = "10100" + UserType.REGISTERED_USER;

        // 多人聊天(群聊)
        String GROUP_CHAT_TOURISTS = "10101" + UserType.TOURISTS_USER;
        String GROUP_CHAT_REGISTERED = "10102" + UserType.REGISTERED_USER;

        // 删除好友离线消息的指令
        String DEL_FRIEND_OFF_MESSAGE_REGIST = "10103" + UserType.REGISTERED_USER;
        String DEL_FRIEND_OFF_MESSAGE_TOURIST = "10104" + UserType.TOURISTS_USER;

        // 捞取好友离线消息）
        String GET_OFF_MESSAGE_REGIST = "10105" + UserType.REGISTERED_USER;
        String GET_OFF_MESSAGE_TOURIST =  "10106" + UserType.TOURISTS_USER;

        // 获取群成员列表
        String GET_GROUP_MEMBERS = "10111000";

        // 获取群列表
        String GET_GROUP_LIST = "10111001";

        // 群聊天消息存储
        String GROUP_CHAT_MESSAGE_STORAGE = "20003";

        // 群消息通知
        String GROUP_MSG_NOTIFY =  "20004";

        // 群聊天-消息发送人响应
        String GROUP_CHART_SEND_NOTIFY =  "20005000";

        // 群聊天-拉去离线消息
        String GROUP_CHART_OFF_LINE_MSG =  "20006000";

        // 群聊天-删除离线消息
        String DELETE_GROUP_CHART_OFF_LINE_MSG =  "20007000";

        // 群聊天-踢出成员
        String GROUP_MEMBER_DELETE = "10111002";

        // 群成员、群主退群
        String GROUP_MEMBER_EXIT = "10111003";

        String GROUP_OWNER_EXIT = "10111004";

        // 修改群备注
        String UPDATE_GROUP_REMARK = "10111004";

        // 检查更新
        String CHECK_FOR_UPDATES = "30000000";

        // 重复登录
        String REPEAT_LOGIN_MSG = "40000000";

        // 群聊天消息撤回/删除
        String DEL_GROUP_MSG = "10200100";

        // 响应在线群用户聊天消息撤回/删除
        String RES_ONLINE_USER_DEL_GROUP_MSG = "10201100";

        // 离线群用户聊天消息撤回/删除消息存储
        String DEL_GROUP_MSG_STORAGE = "10202100";

        // 删除指定离线消息
        String DEL_GROUP_OFF_LINE_MSG_STORAGE = "10203100";

        // 查询个人信息
        String SELECT_USER_INFO = "10301100";

        // 定期清理-删除用户在线接收消息
        String DEL_ON_LINE_RECEIVE = "10302100";

        //音视频交互类消息
        String AUDIO_AND_VIDEO_CALL = "50000000";

        //音视频通话类消息存储到离线的成员（IM与GroupMessage服务交互）
        String GROUP_AUDIO_VIDEO_SAVE_TO_USER ="20005";


        //用户账号绑定设备信息更新
        String USER_DEVICE_UPDATE = "20000100";
    }
}
