package com.lanjiu.im.communication.util;

public interface ResponseStatus {

    //协议包校验情况
    String RESPONSE_CHECK_FAILURE = "package check failure";

    // 服务器响应头部状态
    String STATUS_REPORT_SUCCESS ="SUCCESS";

    String STATUS_REPORT_FAILURE ="FAILURE";

    String STATUS_REPORT_EXCEPTION ="EXCEPTION";

    String STATUS_REPORT_REFUSE ="REFUSE";

    // 长连接回执响应
    String STATUS_REPORT_RECEIPT ="RECEIPT";

    String STATUS_REPORT_RECEIPT_OFFLINE ="RECEIPT_OFFLINE";


    String GROUP_CALL_ACK ="GROUP_CALL_ACK";



}
