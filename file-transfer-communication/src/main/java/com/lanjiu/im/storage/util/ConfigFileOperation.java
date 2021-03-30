package com.lanjiu.im.storage.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public String getGroupRecordClearConfig(){
        String protectDir = "";
        InputStream in = this.getClass().getResourceAsStream("/group_record_config.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
            protectDir = properties.getProperty("group_record_clear_job_cycle");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return protectDir;
    }

    public String getGroupRecordClearTimeConfig(){
        String protectDir = "";
        InputStream in = this.getClass().getResourceAsStream("/group_record_config.properties");
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
            protectDir = properties.getProperty("group_record_clear_time_cycle");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return protectDir;
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
}
