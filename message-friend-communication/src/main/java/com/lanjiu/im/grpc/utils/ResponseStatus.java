package com.lanjiu.im.grpc.utils;

public interface ResponseStatus {

    String TO_ID_ERROR = "check to id";

    //协议包校验情况
    String RESPONSE_CHECK_FAILURE = "package check failure";

    // 服务器响应头部状态
    String STATUS_REPORT_SUCCESS ="SUCCESS";

    String STATUS_REPORT_FAILURE ="FAILURE";

    String STATUS_REPORT_EXCEPTION ="EXCEPTION";

    String STATUS_REPORT_REFUSE ="REFUSE";

    String RECEIPT_OFFLINE  ="RECEIPT_OFFLINE";

    String DELETE_OFF_MSG = "DELETE_OFF_MSG ";

    String STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS ="请检查对应类型的交互服务器是否在启动状态.";

    String STATUS_REPORT_UNKNOW_MSGTYPE ="Unknow  MsgType";


    String STATUS_REPORT_RECEIPT ="RECEIPT";



    //用户信息查询失败
    String RESPONSE_USER_INFORMATION_SELECT_FAILURE = "user information select null";
}
