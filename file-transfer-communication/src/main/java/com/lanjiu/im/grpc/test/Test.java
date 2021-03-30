package com.lanjiu.im.grpc.test;

import com.lanjiu.im.grpc.util.ConfigFileOperation;
import com.lanjiu.im.grpc.util.DeleteFileUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoField.NANO_OF_SECOND;


public class Test {
    public static void main(String[] args) {
//        String serverUrl = "F:\\file-server\\friend\\1572706703449.mkv";
//        System.out.println("fileName :" + serverUrl);
//        try {
//            RandomAccessFile read = new RandomAccessFile(serverUrl, "r");
//            FileChannel readChannel = read.getChannel();
//            long length = read.length();
//            System.out.println(length);
//            readChannel.close();
//            read.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        DeleteFileUtil deleteFileUtil = new DeleteFileUtil();
//        boolean bResult = deleteFileUtil.deleteFile(serverUrl);
//        System.out.println(bResult);

//        String time = String.valueOf(java.sql.Timestamp.valueOf(LocalDateTime.now()).getTime());
//        String path = "F:/file-server/group/XXXX.wav";
//        int n = path.lastIndexOf(".");
//        String f = path.substring(n,path.length());
//        RandomAccessFile read = null;
//        try {
//            read = new RandomAccessFile(path, "r");
//            long length = 0;
//            try {
//                length = read.length();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println(length);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        FileChannel readChannel = read.getChannel();
//        try {
//            readChannel.close();
//            read.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(f);
    }


}
