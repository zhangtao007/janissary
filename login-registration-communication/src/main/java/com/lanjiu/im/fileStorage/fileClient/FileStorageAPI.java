package com.lanjiu.im.fileStorage.fileClient;


import com.lanjiu.pro.fileStorage.FriendsTransmissionRequest;
import com.lanjiu.pro.fileStorage.GroupTransmissionRequest;


public class FileStorageAPI {


    public void deleteFileInformationWithFriend(FriendsTransmissionRequest request){
        FileLinkTransferCommunication linkTransferCommunication = new FileLinkTransferCommunication();
        linkTransferCommunication.deleteFileIsSuccessFulWithFriends(request);
    }

    public void cleanFileWithUserId(FriendsTransmissionRequest request){
        FileLinkTransferCommunication linkTransferCommunication = new FileLinkTransferCommunication();
        linkTransferCommunication.cleanFileWithUserID(request);
    }
}
