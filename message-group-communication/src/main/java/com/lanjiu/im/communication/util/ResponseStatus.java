package com.lanjiu.im.communication.util;

public interface ResponseStatus {

    //协议包校验情况
    String RESPONSE_CHECK_FAILURE = "package check failure";

    // 服务器响应头部状态
    String STATUS_REPORT_SUCCESS ="SUCCESS";

    String STATUS_REPORT_FAILURE ="FAILURE";

    String STATUS_REPORT_EXCEPTION ="EXCEPTION";

    String STATUS_REPORT_REFUSE ="REFUSE";


    //音视频通话消息类型
    String AVC_SAVE = "AVC_SAVE";
    String AVC_SAVE_TO_OFF_USER ="AVC_SAVE_TO_OFF_USER";
    String AVC_PUSH = "AVC_PUSH";
    String AVC_DEL ="AVC_DEL";

    //客户端回执ack执行删除指令
    String GROUP_CALL_ACK ="GROUP_CALL_ACK";
    //ss
    String STATUS_REPORT_RECEIPT_OFFLINE ="RECEIPT_OFFLINE";
    //房间关闭指令
    String CLOSE ="close";
    String CONNECTING ="connecting";
    String JOIN ="join";
    String LEAVE ="leave";
    String UNANSWERED ="unanswered";
    String INVITE ="invite";

    //查询个人信息参数
    String SEARCH_USER = "SEARCH_USER";
}
