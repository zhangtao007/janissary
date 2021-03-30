package com.lanjiu.im.grpc.test.nostream;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.FileJCRC32;
import com.lanjiu.im.grpc.util.FilePackageCheckSumResult;
import com.lanjiu.im.grpc.util.FileProperties;
import com.lanjiu.pro.file.*;
import io.grpc.StatusRuntimeException;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class DownloadFileCommon {

    private static final Logger logger = Logger.getLogger(DownloadFileCommon.class.getName());

    public void downloadFileWithGroup(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) {
        logger.info("downloadFile");
        FileJCRC32 jcrc32 = new FileJCRC32();
        FileProperties fileProperties = null;
        GroupTransmissionRequest request = null;
        try {
            fileProperties = judgeSampleFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //数据包完整性校验装载
        if (0 == fileProperties.getPosition()){
            request = jcrc32.packageCheckSumGroupRequest(
                    OriginalPictureVideoGroupTransmission.newBuilder()
                            .setFileContent(FileContent.newBuilder().setPackageKind(ConstantsContent.FILE_DOWNLOAD))
                            .build());
        }else {//断点续传
            request = jcrc32.packageCheckSumGroupRequest(
                    OriginalPictureVideoGroupTransmission
                            .newBuilder()
                            .setFileContent(
                                    FileContent.newBuilder()
                                            .setBigFileFragment(
                                                    BigFileFragment.newBuilder()
                                                            .setPosition(fileProperties.getPosition())
                                                            .build())
                                            .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                            ).build());
        }
        FileClientOperation fileClientOperation = new FileClientOperation();

        try {
            GroupTransmissionResponse groupTransmissionResponse = blockingStub.originalGroupTransmissionDownload(request);
            //数据包完整性校验
            FilePackageCheckSumResult checkSumResult = jcrc32.checkSumValidateGroupResponse(groupTransmissionResponse);
            if (checkSumResult.b_result) {
                FileContent fileContent = groupTransmissionResponse.getGroupPictureVideoMessage().getFileContent();
                try {
                    fileClientOperation.transmissionFileContentGroupReception(fileProperties,fileContent,blockingStub);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("数据包完整性校验失败");
            }
        } catch (StatusRuntimeException e) {
            try {
                GrpcClient.shutdownNow();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GrpcClient.downloadFileWithGroup();
            return;
        }
    }

    public void downloadFileWithFriends(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub) {
        logger.info("downloadFile");
        FileJCRC32 jcrc32 = new FileJCRC32();
        FileProperties fileProperties = null;
        FriendsTransmissionRequest request = null;
        try {
            fileProperties = judgeSampleFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //数据包完整性校验装载
        if (0 == fileProperties.getPosition()){
            request = jcrc32.packageCheckSumRequest(
                    OriginalPictureVideoFriendsTransmission
                            .newBuilder()
                            .setFileContent(FileContent.newBuilder().setPackageKind(ConstantsContent.FILE_DOWNLOAD))
                            .build());
        }else {//断点续传
            request = jcrc32.packageCheckSumRequest(
                    OriginalPictureVideoFriendsTransmission
                            .newBuilder()
                            .setFileContent(
                                    FileContent.newBuilder()
                                            .setBigFileFragment(
                                                    BigFileFragment.newBuilder()
                                                            .setPosition(fileProperties.getPosition())
                                                            .build())
                                            .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                            ).build());
        }
        FileClientOperation fileClientOperation = new FileClientOperation();

        try {
            FriendsTransmissionResponse friendsTransmissionResponse = blockingStub.originalFriendsTransmissionDownload(request);
            //数据包完整性校验
            FilePackageCheckSumResult checkSumResult = jcrc32.checkSumValidateFriendsResponse(friendsTransmissionResponse);
            if (checkSumResult.b_result) {
                FileContent fileContent = friendsTransmissionResponse.getFriendsPictureVideoMessage().getFileContent();
                try {
                    fileClientOperation.transmissionFileContentFriendsReception(fileProperties,fileContent,blockingStub);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("数据包完整性校验失败");
            }
        } catch (StatusRuntimeException e) {
            try {
                GrpcClient.shutdownNow();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            GrpcClient.downloadFileWithFriends();
            return;
        }
    }

    public FileProperties judgeSampleFile() throws IOException {
        FileProperties fileProperties = new FileProperties();
        String configFile = "config.properties";
        InputStream isConfig = new FileInputStream(configFile);
        Properties properties = new Properties();
        properties.load(isConfig);
        isConfig.close();
        int position = Integer.valueOf(properties.getProperty("position"));
        String fileName = properties.getProperty("file_name");
        String suffix = properties.getProperty("file_suffix");
        String writeLength = properties.getProperty("writeLength");
        String readCount = properties.getProperty("readCount");
        String fragmentCount = properties.getProperty("fragmentCount");
        String fileLength = properties.getProperty("fileLength");
        fileProperties.setPosition(position);
//        fileProperties.setSuffixName(suffix);
//        fileProperties.setFileName(fileName);
        fileProperties.setClientFileName(fileName+suffix);
        fileProperties.setReadCount(Integer.valueOf(readCount));
        fileProperties.setWriteLength(Long.valueOf(writeLength));
        fileProperties.setFragmentCount(Integer.valueOf(fragmentCount));
        fileProperties.setFileLength(Integer.valueOf(fileLength));

        return fileProperties;
    }

    public FileProperties protectPosition(FileProperties fileProperties) throws IOException {
        String configFile = "config.properties";
        InputStream isConfig = new FileInputStream(configFile);
        Properties properties = new Properties();
        properties.load(isConfig);
        isConfig.close();
        String position = String.valueOf(fileProperties.getPosition());
        String writeLength = String.valueOf(fileProperties.getWriteLength());
        String readCount = String.valueOf(fileProperties.getReadCount());
        String fragmentCount = String.valueOf(fileProperties.getFragmentCount());
        String fileLength = String.valueOf(fileProperties.getFileLength());
        properties.setProperty("position",position);
        properties.setProperty("writeLength",writeLength);
        properties.setProperty("readCount",readCount);
        properties.setProperty("fileLength",fileLength);
        properties.setProperty("fragmentCount",fragmentCount);
        OutputStream outputStream = null;
        outputStream = new FileOutputStream(configFile);
        properties.store(outputStream,"set");

        return fileProperties;
    }
}
