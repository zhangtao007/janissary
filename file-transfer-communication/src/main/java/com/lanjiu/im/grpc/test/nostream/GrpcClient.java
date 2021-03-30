package com.lanjiu.im.grpc.test.nostream;

import com.lanjiu.pro.file.FileTransmissionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GrpcClient {

    private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());

    private static ManagedChannel managedChannel = null;

    private static FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub = null;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public GrpcClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    GrpcClient(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = FileTransmissionServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
    public static void main(String[] args) throws InterruptedException {
        uploadFileWithFriends();
//        downloadFileWithFriends();
//        downloadFileWithGroup();
    }

    public static void downloadFileWithFriends()
    {
        GrpcClient client = new GrpcClient("localhost", 8866);
        DownloadFileCommon downloadFileCommon = new DownloadFileCommon();
        //客户端访问服务端的stub，阻塞方式的stub
        //好友下载文件
        downloadFileCommon.downloadFileWithFriends(blockingStub);
    }

    public static void downloadFileWithGroup()
    {
        GrpcClient client = new GrpcClient("localhost", 8866);
        DownloadFileCommon downloadFileCommon = new DownloadFileCommon();
        //客户端访问服务端的stub，阻塞方式的stub
        //群成员下载文件
        downloadFileCommon.downloadFileWithGroup(blockingStub);
    }

    public static void uploadFileWithGroup()
    {
        GrpcClient client = new GrpcClient("localhost", 8866);
        UploadFileCommon uploadFileCommon = new UploadFileCommon();
        //客户端访问服务端的stub，阻塞方式的stub
        //群成员上传文件
        uploadFileCommon.upLoadFileWithGroup(blockingStub);
    }

    public static void uploadFileWithFriends()
    {
        GrpcClient client = new GrpcClient("localhost", 8866);
        UploadFileCommon uploadFileCommon = new UploadFileCommon();
        //客户端访问服务端的stub，阻塞方式的stub
        //好友上传文件
        uploadFileCommon.upLoadFileWithFriends(blockingStub);
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }
}
