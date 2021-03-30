package com.lanjiu.im.grpc.impl;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.FileJCRC32;
import com.lanjiu.im.grpc.util.FileProperties;
import com.lanjiu.pro.file.*;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileServiceReception {

    //服务保存文件
    public void transmissionFileContentStreamGroupReception(FileProperties fileProperties, FileContent request, StreamObserver<GroupTransmissionResponse> responseObserver) throws IOException {
        String dataType = request.getPackageKind();
        FileJCRC32 jcrc32 = new FileJCRC32();

        if (ConstantsContent.FILE_HEAD.equals(dataType)) {
            BigFileHead bigFileHead = request.getBigFileHead();
            System.out.println("发送大文件请求，文件地址[" + bigFileHead.getServerUrl() + "]文件大小[" + bigFileHead.getLength() + "b]碎片数量[" + bigFileHead.getCount() + "]");
            fileProperties.setFragmentCount(bigFileHead.getCount());
            fileProperties.setFileLength(bigFileHead.getLength());
            fileProperties.setReadCount(0);


            //fileName = String.valueOf(LocalDateTime.now().getSecond());
            GroupTransmissionResponse response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder().setBigFileFoot(BigFileFoot.newBuilder()
                                    .setIsSuccess(true).build())
                                    .setPackageKind(ConstantsContent.FILE_HEAD)
                                    .build())
                            .build());
            responseObserver.onNext(response);
        } else if (ConstantsContent.FILE_FRAGMENT.equals(dataType)) {
            BigFileFragment fragment = request.getBigFileFragment();
            long position = fragment.getPosition();

            String fileName = "1";
            int fragmentCount = fileProperties.getFragmentCount();
            long fileLength = fileProperties.getFileLength();
            String serverfleName = fileProperties.getServerFileName();
            int readCount = fileProperties.getReadCount();

            RandomAccessFile write = new RandomAccessFile(serverfleName, "rw");
            FileChannel writeChannel = write.getChannel();

            write.seek(position);
            writeChannel.write(fragment.getData().asReadOnlyByteBuffer());

            GroupTransmissionResponse response = jcrc32.packageCheckSumGroupResponse(
                    OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder().setBigFileFragment(
                                    BigFileFragment.newBuilder()
                                            .setLength(200)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            responseObserver.onNext(response);

            readCount++;
            fileProperties.setReadCount(readCount);
            if(readCount == fragmentCount && write.length() == fileLength) {
                response = jcrc32.packageCheckSumGroupResponse(
                        OriginalPictureVideoGroupTransmission.newBuilder().setFileContent(
                                FileContent.newBuilder().setBigFileFoot(
                                        BigFileFoot.newBuilder()
                                                .setIsSuccess(true)
                                                .build())
                                        .setPackageKind(ConstantsContent.FILE_FOOT)
                                        .build())
                                .build());
                responseObserver.onNext(response);
                //标识方法调用已完成
                responseObserver.onCompleted();
            }

            writeChannel.close();
            write.close();
            return;
        }
    }

    //服务保存文件-
    public void transmissionFileContentStreamReception(FileProperties fileProperties,FileContent fileContent,StreamObserver<FriendsTransmissionResponse> responseObserver) throws IOException {
        String dataType = fileContent.getPackageKind();
        FileJCRC32 jcrc32 = new FileJCRC32();
        if (ConstantsContent.FILE_HEAD.equals(dataType)) {
            BigFileHead bigFileHead = fileContent.getBigFileHead();
            System.out.println("发送大文件请求，文件类型[" +  "]文件大小[" + bigFileHead.getLength() + "b]碎片数量[" + bigFileHead.getCount() + "]");
            fileProperties.setFragmentCount(bigFileHead.getCount());
            fileProperties.setFileLength(bigFileHead.getLength());
            fileProperties.setReadCount(0);

            //fileName = String.valueOf(LocalDateTime.now().getSecond());
            FriendsTransmissionResponse response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder().setBigFileFoot(BigFileFoot.newBuilder()
                                    .setIsSuccess(true).build())
                                    .setPackageKind(ConstantsContent.FILE_HEAD)
                                    .build())
                            .build());
            responseObserver.onNext(response);
        } else if (ConstantsContent.FILE_FRAGMENT.equals(dataType)) {
            BigFileFragment fragment = fileContent.getBigFileFragment();
            long position = fragment.getPosition();

            String fileName = "1";
            int fragmentCount = fileProperties.getFragmentCount();
            long fileLength = fileProperties.getFileLength();
            String serverfileName = fileProperties.getServerFileName();
            int readCount = fileProperties.getReadCount();


            RandomAccessFile write = new RandomAccessFile(serverfileName, "rw");
            FileChannel writeChannel = write.getChannel();

            write.seek(position);
            writeChannel.write(fragment.getData().asReadOnlyByteBuffer());

            FriendsTransmissionResponse response = jcrc32.packageCheckSumResponse(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                            FileContent.newBuilder().setBigFileFragment(
                                    BigFileFragment.newBuilder()
                                            .setLength(200)
                                            .build())
                                    .setPackageKind(ConstantsContent.FILE_FRAGMENT)
                                    .build())
                            .build());
            responseObserver.onNext(response);

            readCount++;
            fileProperties.setReadCount(readCount);
            if(readCount == fragmentCount && write.length() == fileLength) {
                response = jcrc32.packageCheckSumResponse(
                        OriginalPictureVideoFriendsTransmission.newBuilder().setFileContent(
                                FileContent.newBuilder().setBigFileFoot(
                                        BigFileFoot.newBuilder()
                                                .setIsSuccess(true)
                                                .build())
                                        .setPackageKind(ConstantsContent.FILE_FOOT)
                                        .build())
                                .build());
                responseObserver.onNext(response);
                //标识方法调用已完成
                responseObserver.onCompleted();
            }

            writeChannel.close();
            write.close();
            return;
        }
    }
}
