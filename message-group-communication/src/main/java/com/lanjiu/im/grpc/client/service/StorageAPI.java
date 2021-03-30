package com.lanjiu.im.grpc.client.service;

import com.lanjiu.im.grpc.*;
import org.apache.log4j.Logger;

public class StorageAPI {

    private static final Logger logger = Logger.getLogger(StorageAPI.class.getName());

    public AllGroupsMemberResponse selectGroupMembers(SelectGroupMemberRequest request) {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        return linkTransferCommunication.selectGroupMembers(request);
    }
}
