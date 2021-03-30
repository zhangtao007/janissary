package com.lanjiu.im.grpc.server;

import java.io.*;
import java.util.Properties;

public class ConfigFileOperation {

    public Properties getTransferCommunicationConfig(){
        InputStream in = this.getClass().getResourceAsStream("/transfer_communication.properties");
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

    public String getFileProtectUrl(){
        String protectDir = "";
        InputStream in = this.getClass().getResourceAsStream("/file_dir_config.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
            protectDir = properties.getProperty("file_friend_dir");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return protectDir;
    }

    public String getFileProtectUrlWithGroup(){
        String protectDir = "";
        InputStream in = this.getClass().getResourceAsStream("/file_dir_config.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
            protectDir = properties.getProperty("file_group_dir");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return protectDir;
    }

    public String getAvatarFileUrl() {
        String protectDir = "";
        InputStream in = this.getClass().getResourceAsStream("/file_dir_config.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
            protectDir = properties.getProperty("avatar_file_dir");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return protectDir;
    }
}
