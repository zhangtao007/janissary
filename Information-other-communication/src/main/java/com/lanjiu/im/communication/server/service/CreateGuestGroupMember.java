package com.lanjiu.im.communication.server.service;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.client.service.StorageAPI;
import com.lanjiu.im.grpc.client.util.ConstantsSelectKind;
import org.apache.log4j.Logger;

import java.util.List;

public class CreateGuestGroupMember {

    private final Logger logger = Logger.getLogger(CreateGuestGroupMember.class);
    public List<RpcGuestGroup> getGuestGroup(int groupId){
        StorageAPI storageAPI = new StorageAPI();
        TransmissionRequest transmissionRequest ;
        List<RpcGuestGroup> list ;
        transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_GUEST_GROUP_ID)
                .setGuestGroup(RpcGuestGroup.newBuilder().setGroupId(groupId).build())
                .build();
        GuestGroupResponse guestGroupResponse = storageAPI.selectGuestGroupAPI(transmissionRequest);
        list = guestGroupResponse.getResponseGuestGroupList();
        return list;
    }

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
