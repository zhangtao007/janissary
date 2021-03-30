package com.lanjiu.im.grpc.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigFileOperation {

    public static Properties getMessageFriendCommConfig(){
        Properties properties = new Properties();
        try {
            InputStream in = ConfigFileOperation.class.getResourceAsStream("/message_friend_comm.properties");

            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties getMessageGroupStorageConfig(){
        InputStream in = this.getClass().getResourceAsStream("/message_friend_storage.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    //未使用号码表检验周期设置
    public String getBeautifulNumberCycleConfig(){
        String protectDir = "";
        InputStream in = this.getClass().getResourceAsStream("/beautiful_number_auto_check_config.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
            protectDir = properties.getProperty("beautiful_number_check_job_cycle");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return protectDir;
    }

    public Properties getInformationStorageConfig(){
        InputStream in = this.getClass().getResourceAsStream("/information_storage.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Properties getTransferStorageConfig(){
        InputStream in = this.getClass().getResourceAsStream("/transfer_storage.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
