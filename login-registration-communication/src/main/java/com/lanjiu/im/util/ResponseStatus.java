package com.lanjiu.im.util;

public interface ResponseStatus {

    String TO_ID_ERROR = "check to id";

    //协议包校验情况
    String RESPONSE_CHECK_FAILURE = "package check failure";

    // 服务器响应头部状态
    String STATUS_REPORT_SUCCESS ="SUCCESS";

    String STATUS_REPORT_FAILURE ="FAILURE";

    String STATUS_REPORT_EXCEPTION ="EXCEPTION";

    String STATUS_REPORT_FAILURE_CHECK_SERVER_STATUS ="请检查对应类型的交互服务器是否在启动状态.";

    String STATUS_REPORT_UNKNOW_MSGTYPE ="Unknow  MsgType";

    //用户信息查询失败
    String RESPONSE_USER_INFORMATION_SELECT_FAILURE = "user information select null";

    //单点登录限制
    String OTHER_ALREADY_LOGIN = "该账号当前已登录！";

    //用户搜索字段限制8位纯数字
    String INPUT_ERROR_FIND_USER ="请输入8位数ID号搜索！";

    //请求参数错误
    String PARAMETERS_ERROR = "parameters error";
}
