package com.lanjiu.im.communication.util;

public interface ResponseStatus {

    String TO_ID_ERROR = "check to id";

    //协议包校验情况
    String RESPONSE_CHECK_FAILURE = "package check failure";

    // 服务器响应头部状态
    String STATUS_REPORT_SUCCESS ="SUCCESS";

    String STATUS_REPORT_FAILURE ="FAILURE";

    String STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS ="请检查对应类型的交互服务器是否在启动状态.";

    //用户信息查询失败
    String RESPONSE_USER_INFORMATION_SELECT_FAILURE = "user information select null";

    //删除好友关联消息成功.
    String RESPONSE_FRIEND_MESSAGE_DELETE_SUCCESS = "删除好友关联消息成功.";

    //群主解散群聊
    final static String GROUP_OWNER_DISSOLVE = "DISSLOVE";

    String STATUS_REPORT_NO_EXIST = "no exist group";
}
