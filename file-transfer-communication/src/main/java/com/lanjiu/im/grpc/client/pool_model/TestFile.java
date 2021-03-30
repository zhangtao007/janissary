package com.lanjiu.im.grpc.client.pool_model;

import com.google.protobuf.ByteString;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.FileJCRC32;
import com.lanjiu.pro.file.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;

public class TestFile {
    public static void main(String[] args) throws IOException, InterruptedException {


        TestFile testFile = new TestFile();

        FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub stub =null;
        Pool pool = new Pool();
        pool.init();
        pool.timer();

        //并发测试
        //连接池初始化5个连接时，并发100线程耗时：13078
        //连接池初始化10个连接时，并发100线程耗时：12160

        CountDownLatch countDownLatch=new CountDownLatch(100);
        long start = System.currentTimeMillis();

        for (int i=0;i<100;i++){

            try {
                stub = pool.get();
                testFile.transmissionFileContentSend(stub,i);
                countDownLatch.countDown();//调用一次，这个计数器就减一

            }finally {
                if(stub != null){
                    pool.release(stub);
                    System.out.println("释放连接对象》》》》》stub:"+stub.toString());
                }
            }

        }
        countDownLatch.await();//阻塞，直至等于0，然后放行
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));

    }




    //send
    public void transmissionFileContentSend(FileTransmissionServiceGrpc.FileTransmissionServiceBlockingStub blockingStub, int msgId) throws IOException {

        FileJCRC32 jcrc32 = new FileJCRC32();
        String configFile = "config.properties";
//        InputStream isConfig = new FileInputStream(configFile);
//        Properties properties = new Properties();
//        properties.load(isConfig);
//        isConfig.close();
//        String fileName = properties.getProperty("file_name");
//        String suffix = properties.getProperty("file_suffix");

        String fileName = "1";
        String suffix = ".png";
        RandomAccessFile read = new RandomAccessFile("F:\\file_server\\avatar\\"+fileName+suffix, "r");
        FileChannel readChannel = read.getChannel();
        long length = read.length();
        int count = (int) (length % ConstantsContent.FRAGMENT_LENGTH == 0 ? length / ConstantsContent.FRAGMENT_LENGTH : length / ConstantsContent.FRAGMENT_LENGTH + 1);
        //构建传输结构体
        FriendsTransmissionRequest request = jcrc32.packageCheckSumRequest(
                OriginalPictureVideoFriendsTransmission.newBuilder().setHead(Head.newBuilder().setMsgId(String.valueOf(msgId)).build()).setFileContent(
                        FileContent.newBuilder().setBigFileHead(
                                BigFileHead.newBuilder()
                                        .setCount(count)
                                        .setLength(length)
                                        .setClientUrl(fileName+suffix)
                                        .build())
                                .setPackageKind(ConstantsContent.FILE_HEAD)
                                .build())
                        .build());
        System.out.println("start");
        FriendsTransmissionResponse friendsTransmissionResponse = blockingStub.originalFriendsTransmissionUpload(request);
        System.out.println("阻塞");
        System.out.println(friendsTransmissionResponse);
        FriendsTransmissionResponse myResponse;
        int i = 0;
        int position = 0;
        int size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        while (count > i) {
            MappedByteBuffer mappedByteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY, position, size);
            //构建传输结构体
            request = jcrc32.packageCheckSumRequest(
                    OriginalPictureVideoFriendsTransmission.newBuilder().setHead(Head.newBuilder().setMsgId(String.valueOf(msgId)).build()).setFileContent(
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
            myResponse = blockingStub.originalFriendsTransmissionUpload(request);
            FileContent fileContent = myResponse.getFriendsPictureVideoMessage().getFileContent();
            System.out.println("碎片发送成功！" + (i + 1));
            String packageKind = fileContent.getPackageKind();
            if (ConstantsContent.FILE_FRAGMENT.equals(packageKind)) {
                i++;
            }else if (ConstantsContent.FILE_FOOT.equals(packageKind)) {
                System.out.println(fileContent.getBigFileFoot().getIsSuccess() ? "文件发送成功" : "文件发送失败");
                break;
            }
            position = i * ConstantsContent.FRAGMENT_LENGTH;
            size = (int) (length - position < ConstantsContent.FRAGMENT_LENGTH ? length - position : ConstantsContent.FRAGMENT_LENGTH);
        }
        System.out.println("ddddddddddddddddddddddddddddd");
        readChannel.close();
        read.close();
    }
}
