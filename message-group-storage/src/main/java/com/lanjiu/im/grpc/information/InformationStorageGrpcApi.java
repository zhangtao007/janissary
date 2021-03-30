package com.lanjiu.im.grpc.information;


import com.lanjiu.im.grpc.InformationStorageServiceGrpc;
import com.lanjiu.im.grpc.RegisteredGroupResponse;
import com.lanjiu.im.grpc.TransmissionRequest;
import org.apache.log4j.Logger;

public class InformationStorageGrpcApi {

    private static final Logger log = Logger.getLogger(InformationStorageGrpcApi.class.getName());

    private static InformationStorageServiceGrpc.InformationStorageServiceBlockingStub getInstance(){
        return InformationStorageClient.linkTransferCommunication();
    }

    public RegisteredGroupResponse selectGroupIfo(TransmissionRequest request) {
        log.info("查询群信息入参：" + request);
        RegisteredGroupResponse registeredGroupResponse = getInstance().queryGroupInfoByListId(request);
        log.info("查询群信息响应：" + registeredGroupResponse);
        try {
            InformationStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return registeredGroupResponse;
    }

}
