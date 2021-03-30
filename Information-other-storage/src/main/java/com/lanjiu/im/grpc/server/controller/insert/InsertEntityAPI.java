package com.lanjiu.im.grpc.server.controller.insert;

import com.lanjiu.im.grpc.AllGroupsMemberResponse;
import com.lanjiu.im.grpc.TransmissionRequest;

public class InsertEntityAPI {

    public AllGroupsMemberResponse insertInviteUsersJoinGroup(TransmissionRequest request){
        InsertGroupMemberEntityAPI insertGroupMemberServiceAPI = new InsertGroupMemberEntityAPI();
        return insertGroupMemberServiceAPI.insertInviteUsersJoinGroup(request);
    }
}
