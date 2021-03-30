package com.lanjiu.im.file;

import com.lanjiu.im.file.util.ConfigFileOperation;
import com.lanjiu.pro.fileStorage.FileStorageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FileTransferStorageServer {

    private static ManagedChannel managedChannel = null;

    public static FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub=null;


    /** Construct server connecting to HelloWorld server at {@code host:port}. */
    public FileTransferStorageServer(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct server for accessing HelloWorld server using the existing channel. */
    FileTransferStorageServer(ManagedChannel channel) {
        this.managedChannel = channel;
        blockingStub = FileStorageServiceGrpc.newBlockingStub(channel);
    }
    public static void shutdown() throws InterruptedException {
        managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public static FileStorageServiceGrpc.FileStorageServiceBlockingStub transformStorageCommunition(FileStorageServiceGrpc.FileStorageServiceBlockingStub blockingStub){
        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getFileTransferStorageConfig();
        String address = properties.getProperty("server_address");
        int port = Integer.valueOf(properties.getProperty("server_port"));
        FileTransferStorageServer client = new FileTransferStorageServer(address, port);
        blockingStub = client.blockingStub;
        return blockingStub;
    }

    public static void shutdownNow() throws InterruptedException {
        managedChannel.shutdownNow();
    }
}
