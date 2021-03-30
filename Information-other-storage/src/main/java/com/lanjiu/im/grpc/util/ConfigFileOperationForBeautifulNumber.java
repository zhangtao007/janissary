package com.lanjiu.im.grpc.util;

import com.lanjiu.im.grpc.server.entity.BeautiFulNumberConfigEntity;
import java.io.*;
import java.util.Properties;

public class ConfigFileOperationForBeautifulNumber {

    //游客类型
    public Properties getGuestFriendBeautifulNumberConfig(){
        InputStream in = this.getClass().getResourceAsStream(ConstantsContent.BEAUTIFUL_NUMBER_TYPE_GUEST_FRIEND_REAL_CONFIG);
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

    public Properties getGuestGroupBeautifulNumberConfig(){
        InputStream in = this.getClass().getResourceAsStream(ConstantsContent.BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_REAL_CONFIG);
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

    public Properties getGuestGroupMemberBeautifulNumberConfig(){
        InputStream in = this.getClass().getResourceAsStream(ConstantsContent.BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_MEMBER_REAL_CONFIG);
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

    //注册用户类型
    public Properties getRegisteredFriendBeautifulNumberConfig(){
        InputStream in = this.getClass().getResourceAsStream(ConstantsContent.BEAUTIFUL_NUMBER_TYPE_REGISTERED_FRIEND_REAL_CONFIG);
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

    public Properties getRegisteredGroupMemberBeautifulNumberConfig(){
        InputStream in = this.getClass().getResourceAsStream(ConstantsContent.BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP_MEMBER_REAL_CONFIG);
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

    public Properties getRegisteredGroupBeautifulNumberConfig(){
        InputStream in = this.getClass().getResourceAsStream(ConstantsContent.BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP_REAL_CONFIG);
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

    //更新配置文件
    public void updateConfigAuto(BeautiFulNumberConfigEntity beautiFulNumberConfigEntity, String configFile) throws IOException {
        InputStream isConfig = this.getClass().getResourceAsStream(configFile);
        configFile = this.getClass().getResource(configFile).getFile();
        Properties properties = new Properties();
        properties.load(isConfig);
        isConfig.close();
        String tenMillion = beautiFulNumberConfigEntity.getTenMillion();
        String oneMillion = beautiFulNumberConfigEntity.getOneMillion();
        String oneHundredThousand = beautiFulNumberConfigEntity.getOneHundredThousand();
        String tenThousand = beautiFulNumberConfigEntity.getTenThousand();
        String oneThousand = beautiFulNumberConfigEntity.getOneThousand();
        properties.setProperty("ten_million",tenMillion);
        properties.setProperty("one_million",oneMillion);
        properties.setProperty("one_hundred_thousand",oneHundredThousand);
        properties.setProperty("ten_thousand",tenThousand);
        properties.setProperty("one_thousand",oneThousand);
        System.out.println(properties);
        OutputStream outputStream = null;
        outputStream = new FileOutputStream(configFile);
        properties.store(outputStream,"set");

        return ;
    }
}
