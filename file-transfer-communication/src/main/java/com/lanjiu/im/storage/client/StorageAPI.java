package com.lanjiu.im.storage.client;


import com.lanjiu.pro.file.FriendsTransmissionRequest;
import com.lanjiu.pro.file.FriendsTransmissionResponse;
import com.lanjiu.pro.file.GroupTransmissionRequest;
import com.lanjiu.pro.file.GroupTransmissionResponse;

public class StorageAPI {

    public void storageFileInformationWithFriend(FriendsTransmissionResponse response)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        FriendsTransmissionRequest request = FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(response.getFriendsPictureVideoMessage())
                .build();
        linkTransferCommunication.storageFileIsSuccessFulWithFriends(request);
    }

    public void storageFileInformationWithGroup(GroupTransmissionResponse response)
    {
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        GroupTransmissionRequest request = GroupTransmissionRequest.newBuilder()
                .setGroupPictureVideoMessage(response.getGroupPictureVideoMessage())
                .build();
        linkTransferCommunication.storageFileIsSuccessFulWithGroup(request);
    }

    public void deleteFileInformationWithFriend(FriendsTransmissionResponse response){
        LinkTransferCommunication linkTransferCommunication = new LinkTransferCommunication();
        FriendsTransmissionRequest request = FriendsTransmissionRequest.newBuilder()
                .setFriendsPictureVideoMessage(response.getFriendsPictureVideoMessage())
                .build();
        linkTransferCommunication.deleteFileIsSuccessFulWithFriends(request);
    }
}
