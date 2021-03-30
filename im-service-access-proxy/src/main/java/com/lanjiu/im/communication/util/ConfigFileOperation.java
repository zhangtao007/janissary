package com.lanjiu.im.communication.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigFileOperation {

    // IM-通讯服务
    public Properties getImServerConfig(){
        return readerPropertiesConfig("/im_server.properties");
    }

    // 资料服务器
    public Properties getInformationServerConfig(){
        return readerPropertiesConfig("/information_server.properties");
    }

    // 登录注册服务器
    public Properties getLoginRegistrationServerConfig(){
        return readerPropertiesConfig("/login_registration_server.properties");
    }

    // 好友消息服务器
    public Properties getFriendMessageServerConfig(){
        return readerPropertiesConfig("/friend_message_server.properties");
    }

    // 群消息服务器
    public Properties getGroupMessageServerConfig(){
        return readerPropertiesConfig("/group_message_server.properties");
    }

    // redis服务器配置
    public Properties getRedisServerConfig(){
        return readerPropertiesConfig("/redis.properties");
    }

    private Properties readerPropertiesConfig(String resourceName){
        InputStream in = this.getClass().getResourceAsStream(resourceName);
        Properties properties = new Properties();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
            properties.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
