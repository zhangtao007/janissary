package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RegisteredGroupResponse;
import com.lanjiu.im.grpc.RpcRegisteredGroup;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.pojo.RegisteredGroup;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;


public class UpdateRegisteredGroupEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateRegisteredGroupEntityAPI.class.getName());

    public RegisteredGroupResponse updateRegisteredGroup(TransmissionRequest request){
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        UpdateRegisteredGroupServiceAPI registeredGroupService = new UpdateRegisteredGroupServiceAPI();
        RegisteredGroup registeredGroup = registeredGroupService.updateRegisteredGroup(rpcRegisteredGroup);
        if(null == registeredGroup){
            return null;
        }
        RegisteredGroupResponse registeredGroupResponse = RegisteredGroupResponse.newBuilder()
                .addResponseRegisteredGroup(RpcRegisteredGroup.newBuilder()
//                        .setCreationTime(registeredGroup.getCreationTime().getTime())
                        .setGroupName(registeredGroup.getGroupName())
//                        .setAmount(registeredGroup.getAmount())
                        .setModificationTime(registeredGroup.getModificationTime().getTime())
                        .setGroupId(registeredGroup.getGroupId())
//                        .setGroupAnnouncementId(registeredGroup.getGroupAnnouncementId())
                        .setRegisteredUserId(registeredGroup.getRegisteredUserId())
                        .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
        return registeredGroupResponse;
    }
}
