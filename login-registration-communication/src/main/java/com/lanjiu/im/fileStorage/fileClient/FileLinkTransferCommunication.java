package com.lanjiu.im.fileStorage.fileClient;


import com.lanjiu.im.util.ConstantsContent;
import com.lanjiu.pro.fileStorage.*;

import java.util.ArrayList;
import java.util.List;


public class FileLinkTransferCommunication {

    private static FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub = null;

    public static FileStorageServiceGrpc.FileStorageServiceBlockingStub linkTransferCommunication(){
        FileStorageServiceGrpc.FileStorageServiceBlockingStub stub = TransferStorageClient.linkTransferCommunication(blockingStub);
        return stub;
    }


    public boolean deleteFileIsSuccessFulWithFriends(FriendsTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        FriendsTransmissionResponse response = null;
        OriginalPictureVideoFriendsTransmission friendsPictureVideoMessage = request.getFriendsPictureVideoMessage();
        String userType = friendsPictureVideoMessage.getUserType();
        String settingsType = friendsPictureVideoMessage.getSettingsType();
        String serverUrl = friendsPictureVideoMessage.getFileContent().getBigFileHead().getServerUrl();
        String frindsId = friendsPictureVideoMessage.getFriends().getFriendsId();
        String userId = friendsPictureVideoMessage.getTourists().getTemporaryId();
        String registeredUserId = friendsPictureVideoMessage.getRegisteredUser().getUserId();
        //调用文件存储服务器，保存对应文件记录
        FriendsTransmissionRequest requestStorage =
                FriendsTransmissionRequest.newBuilder()
                        .setFriendsPictureVideoMessage(OriginalPictureVideoFriendsTransmission.newBuilder()
                                .setFileContent(FileContent.newBuilder()
                                        .setBigFileHead(BigFileHead.newBuilder()
                                                .setServerUrl(serverUrl)
                                                .build())
                                        .build())
                                .setFriends(Friends.newBuilder()
                                        .setFriendsId(frindsId)
                                        .build())
                                .setTourists(Tourists.newBuilder()
                                        .setTemporaryId(userId)
                                        .build())
                                .setRegisteredUser(RegisteredUser.newBuilder()
                                        .setUserId(registeredUserId)
                                        .build())
                                .setUserType(userType)
                                .setSettingsType(settingsType)
                                .build())
                        .build();
        response = blockingStub.deleteFileInformationWithFriendByFriendId(requestStorage);

        try {
            TransferStorageClient.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(response.getFriendsPictureVideoMessage().getHead().getStatusReport().equals(ConstantsContent.FILE_DELETE_SUCCESS)){
            return true;
        }
        return false;
    }

    public boolean cleanFileWithUserID(FriendsTransmissionRequest request){
        blockingStub = linkTransferCommunication();
        FriendsTransmissionResponse response = null;
        response = blockingStub.cleanFileWithUserId(request);
        try {
            TransferStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(response.getFriendsPictureVideoMessage().getHead().getStatusReport().equals(ConstantsContent.FILE_DELETE_SUCCESS)){
            return true;
        }
        return false;
    }


    public boolean mergeGroupAvatar(GroupAvatarRequest request){
        blockingStub = linkTransferCommunication();
        GroupAvatarResponse response = null;
        response = blockingStub.mergeGroupAvatar(request);
        try {
            TransferStorageClient.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(response.getResult().equals(ConstantsContent.FILE_DELETE_SUCCESS)){
            System.out.println("群头像地址："+response.getGroupAvatar());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FileLinkTransferCommunication client = new FileLinkTransferCommunication();
        List<String> sourcePics = new ArrayList<>();
        sourcePics.add("D:\\file_server\\avatar\\10010055df6bf22411f0430a9813b3029d994448.jpg");
        sourcePics.add("D:\\file_server\\avatar\\10010032a8c01fc60f894986b33d51d07b1d2c28.gif");
        sourcePics.add("D:\\file_server\\avatar\\10010032a608893d7a794a61b21d2128f5fbebd3.jpg");
        sourcePics.add("D:\\file_server\\avatar\\10010045c72c9ae5678e45e0943095ce05d3a576.jpg");
//        sourcePics.add("D:\\file_server\\avatar\\10010065e4d5d1359bf8419ca0f15bce71cf052f.jpg");
//        sourcePics.add("D:\\file_server\\avatar\\10010093e3ec85428b264b70ae8fe6ca0ecc7bc9.png");
        GroupAvatarRequest request = GroupAvatarRequest.newBuilder().setGroupId("100aa911").setNum("4")
                .addAllAvatarUrl(sourcePics)
                .build();
        client.mergeGroupAvatar(request);
    }
}
