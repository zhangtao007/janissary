package com.lanjiu.im.grpc.client.pool_model;


import com.lanjiu.pro.file.FileTransmissionServiceGrpc;


public class PoolUtil {

	private static FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub = null;

	//获取grpc连接客户端存根
	public static FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub get() {
        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub stub = TransferCommucatoinClient.linkTransferCommunication(blockingStub);
		return stub;
	}


}
