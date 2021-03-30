package com.lanjiu.im.storage.util;



import com.lanjiu.pro.fileStorage.FriendsTransmissionRequest;
import com.lanjiu.pro.fileStorage.FriendsTransmissionResponse;
import com.lanjiu.pro.fileStorage.GroupTransmissionRequest;
import com.lanjiu.pro.fileStorage.GroupTransmissionResponse;

public class FilePackageCheckSumResult {
    public boolean b_result;
    public GroupTransmissionResponse msgGroupResponse;
    public GroupTransmissionRequest msgGroupRequest;
    public FriendsTransmissionResponse msgFriendsResponse;
    public FriendsTransmissionRequest msgFriendsRequest;

    public boolean isB_result() {
        return b_result;
    }

    public void setB_result(boolean b_result) {
        this.b_result = b_result;
    }

    public FilePackageCheckSumResult(boolean b_result, GroupTransmissionResponse msgGroupResponse) {
        this.b_result = b_result;
        this.msgGroupResponse = msgGroupResponse;
    }

    public FilePackageCheckSumResult(boolean b_result, GroupTransmissionRequest msgGroupRequest) {
        this.b_result = b_result;
        this.msgGroupRequest = msgGroupRequest;
    }

    public FilePackageCheckSumResult(boolean b_result, FriendsTransmissionResponse msgFriendsResponse) {
        this.b_result = b_result;
        this.msgFriendsResponse = msgFriendsResponse;
    }

    public FilePackageCheckSumResult(boolean b_result, FriendsTransmissionRequest msgFriendsRequest) {
        this.b_result = b_result;
        this.msgFriendsRequest = msgFriendsRequest;
    }

    public GroupTransmissionResponse getMsgGroupResponse() {
        return msgGroupResponse;
    }

    public void setMsgGroupResponse(GroupTransmissionResponse msgGroupResponse) {
        this.msgGroupResponse = msgGroupResponse;
    }

    public GroupTransmissionRequest getMsgGroupRequest() {
        return msgGroupRequest;
    }

    public void setMsgGroupRequest(GroupTransmissionRequest msgGroupRequest) {
        this.msgGroupRequest = msgGroupRequest;
    }

    public FriendsTransmissionResponse getMsgFriendsResponse() {
        return msgFriendsResponse;
    }

    public void setMsgFriendsResponse(FriendsTransmissionResponse msgFriendsResponse) {
        this.msgFriendsResponse = msgFriendsResponse;
    }

    public FriendsTransmissionRequest getMsgFriendsRequest() {
        return msgFriendsRequest;
    }

    public void setMsgFriendsRequest(FriendsTransmissionRequest msgFriendsRequest) {
        this.msgFriendsRequest = msgFriendsRequest;
    }
}
