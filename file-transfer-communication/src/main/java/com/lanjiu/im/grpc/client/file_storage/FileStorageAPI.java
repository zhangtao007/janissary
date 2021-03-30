package com.lanjiu.im.grpc.client.file_storage;


import com.lanjiu.pro.fileStorage.FriendsTransmissionRequest;
import com.lanjiu.pro.fileStorage.GroupTransmissionRequest;


public class FileStorageAPI {

    public void storageFileInformationWithFriend(FriendsTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        linkTransferCommunication.storageFileIsSuccessFulWithFriends(request);
    }

    public void storageFileInformationWithGroup(GroupTransmissionRequest request)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        linkTransferCommunication.storageFileIsSuccessFulWithGroup(request);
    }

    public void deleteFileInformationWithFriend(FriendsTransmissionRequest request){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        linkTransferCommunication.deleteFileIsSuccessFulWithFriends(request);
    }
}
