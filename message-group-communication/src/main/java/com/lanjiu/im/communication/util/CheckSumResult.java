package com.lanjiu.im.communication.util;


import com.lanjiu.pro.business.BusinessProtocolMessageStandard;

public class CheckSumResult {
    public boolean b_result;
    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg;

    public CheckSumResult(boolean b_result, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        this.b_result = b_result;
        this.msg = msg;
    }

    public CheckSumResult(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        this.msg = msg;
    }

    public boolean isB_result() {
        return b_result;
    }

    public void setB_result(boolean b_result) {
        this.b_result = b_result;
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage getMsg() {
        return msg;
    }

    public void setMsg(BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) {
        this.msg = msg;
    }
}

