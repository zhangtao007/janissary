package com.lanjiu.im.file;

import com.lanjiu.pro.fileStorage.FileStorageServiceGrpc;
import com.lanjiu.pro.fileStorage.GroupAvatarRequest;
import com.lanjiu.pro.fileStorage.GroupAvatarResponse;

public class FileTransferCommon {

    public static FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub=null;

    public static  FileStorageServiceGrpc.FileStorageServiceBlockingStub FileTransferCommon(){
        FileStorageServiceGrpc.FileStorageServiceBlockingStub stub = FileTransferStorageServer.transformStorageCommunition(blockingStub);
        return stub;
    }


    public GroupAvatarResponse groupPhotoMerger(GroupAvatarRequest request) {
        blockingStub =FileTransferCommon();
        GroupAvatarResponse response = null;
        response = blockingStub.mergeGroupAvatar(request);
        try {
            FileTransferStorageServer.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  response;
    }

}
