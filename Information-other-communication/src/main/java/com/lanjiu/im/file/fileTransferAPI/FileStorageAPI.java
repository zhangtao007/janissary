package com.lanjiu.im.file.fileTransferAPI;

import com.lanjiu.im.file.FileTransferCommon;
import com.lanjiu.pro.fileStorage.GroupAvatarRequest;
import com.lanjiu.pro.fileStorage.GroupAvatarResponse;

public class FileStorageAPI {

    //根据九个群成员ID合成群头像
    public GroupAvatarResponse groupMergerPhoto(GroupAvatarRequest request){
        FileTransferCommon fileTransferCommon = new FileTransferCommon();
        return fileTransferCommon.groupPhotoMerger(request);
    }
}
