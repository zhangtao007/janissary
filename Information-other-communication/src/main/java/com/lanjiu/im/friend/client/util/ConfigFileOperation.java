package com.lanjiu.im.friend.client.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigFileOperation {

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
}
