package com.lanjiu.im.grpc.impl;

import com.google.protobuf.ByteString;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.FileJCRC32;
import com.lanjiu.pro.file.FriendsTransmissionResponse;
import com.lanjiu.pro.file.GroupTransmissionResponse;
import io.grpc.stub.StreamObserver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Properties;

public class FileServiceSend {

    public void transmissionFileContentFriendsSend(StreamObserver<FriendsTransmissionResponse> responseObserver) throws IOException {
/*
        FileJCRC32 jcrc32 = new FileJCRC32();
        String configFile = "config_old.properties";
        InputStream isConfig = new FileInputStream(configFile);
        Properties properties = new Properties();
        properties.load(isConfig);
        isConfig.close();
        String fileName = properties.getProperty("file_name");
        String suffix = properties.getProperty("file_suffix");
        System.out.println(fileName);
        RandomAccessFile read = new RandomAccessFile(fileName, "r");
        FileChannel readChannel = read.getChannel();
        long length = read.length();
        int count = (int) (length % ConstantsContent.FRAGMENT_LENGTH == 0 ? length / ConstantsContent.FRAGMENT_LENGTH : length / ConstantsContent.FRAGMENT_LENGTH + 1);
        //构建传输结构体
        FriendsTransmissionResponse response = jcrc32.packageCheckSumResponse(
                OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                        FileContent.newBuilder().setBigFileHead(
                                BigFileHead.newBuilder()
                                        .setCount(count)
                                        .setLength(length)
                                        .setSuffix(suffix)
                                        .build())
                                .setPackageKind(ConstantsContent.FILE_HEAD)
                                .build())
                        .build());
        responseObserver.onNext(response);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int i = 0;
        int position = 0;
        int size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        while (i < count) {
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, position, size);
            //构建传输结构体
            response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder()
                                    .setBigFileFragment(
                                            BigFileFragment.newBuilder()
                                                    .setData(ByteString.copyFrom(mappedByteBuffer))
                                                    .setLength(size)
                                                    .setPosition(position)
                                                    .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            responseObserver.onNext(response);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            i++;
            position = i * ConstantsContent.FRAGMENT_LENGTH;
            size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        }
        System.out.println("download");
        readChannel.close();
        read.close();*/
    }

    public void transmissionFileContentGroupSend(StreamObserver<GroupTransmissionResponse> responseObserver) throws IOException {

      /*  FileJCRC32 jcrc32 = new FileJCRC32();
        String configFile = "config_old.properties";
        InputStream isConfig = new FileInputStream(configFile);
        Properties properties = new Properties();
        properties.load(isConfig);
        isConfig.close();
        String fileName = properties.getProperty("file_name");
        String suffix = properties.getProperty("file_suffix");
        System.out.println(fileName);
        RandomAccessFile read = new RandomAccessFile(fileName, "r");
        FileChannel readChannel = read.getChannel();
        long length = read.length();
        int count = (int) (length % ConstantsContent.FRAGMENT_LENGTH == 0 ? length / ConstantsContent.FRAGMENT_LENGTH : length / ConstantsContent.FRAGMENT_LENGTH + 1);
        //构建传输结构体
        GroupTransmissionResponse response = jcrc32.packageCheckSumGroupResponse(
                OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                        FileContent.newBuilder().setBigFileHead(
                                BigFileHead.newBuilder()
                                        .setCount(count)
                                        .setLength(length)
                                        .setSuffix(suffix)
                                        .build())
                                .setPackageKind(ConstantsContent.FILE_HEAD)
                                .build())
                        .build());
        responseObserver.onNext(response);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        int i = 0;
        int position = 0;
        int size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        while (i < count) {
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, position, size);
            //构建传输结构体
            response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder()
                                    .setBigFileFragment(
                                            BigFileFragment.newBuilder()
                                                    .setData(ByteString.copyFrom(mappedByteBuffer))
                                                    .setLength(size)
                                                    .setPosition(position)
                                                    .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            responseObserver.onNext(response);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            i++;
            position = i * ConstantsContent.FRAGMENT_LENGTH;
            size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        }
        System.out.println("download");
        readChannel.close();
        read.close();
        */
    }
}
