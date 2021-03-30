package com.lanjiu.im.grpc.test.nostream;

import com.lanjiu.im.grpc.*;
import com.lanjiu.pro.file.FileTransmissionServiceGrpc;

import java.io.IOException;
import java.util.logging.Logger;

public class UploadFileCommon {

    private static final Logger logger = Logger.getLogger(UploadFileCommon.class.getName());

    public void upLoadFileWithFriends(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) {
        logger.info("上传文件");
        FileClientOperation fileClientOperation = new FileClientOperation();
        //客户端和服务端流式通信--->处理服务器端返回数据
        try {
            fileClientOperation.transmissionFileContentSend(blockingStub);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void upLoadFileWithGroup(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) {
        logger.info("上传文件");
        FileClientOperation fileClientOperation = new FileClientOperation();
        //客户端和服务端流式通信--->处理服务器端返回数据
        try {
            fileClientOperation.transmissionFileContentGroupSend(blockingStub);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
