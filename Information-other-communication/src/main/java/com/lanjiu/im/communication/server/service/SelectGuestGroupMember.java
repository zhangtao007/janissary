package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import org.apache.log4j.Logger;

import java.util.List;

public class SelectGuestGroupMember {

    private final Logger logger = Logger.getLogger(SelectGuestGroupMember.class);

    public List<RpcRegisteredGroup> getRegisteredGroup(int groupId){
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcRegisteredGroup> list ;
        transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_REGISTERED_GROUP_ID)
                .setRegisteredGroup(RpcRegisteredGroup.newBuilder().setGroupId(groupId).build())
                .build();
        RegisteredGroupResponse guestGroupResponse = storageAPI.selectRegisteredGroupAPI(transmissionRequest);
        list = guestGroupResponse.getResponseRegisteredGroupList();
        return list;
    }

}
