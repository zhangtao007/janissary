package com.lanjiu.im.netty.common;


import com.alibaba.fastjson.JSON;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AliyunSmsUtils {
    private static final Logger logger = LoggerFactory.getLogger(AliyunSmsUtils.class);

    static final String product ="Dysmsapi";
    static final String  domain ="dysmsapi.aliyuncs.com";
//    static final String accessKeyId = "LTAI4GBF1xb8o6TrF2myHDJw";
//    static final String accessKeySecret = "Z27rqTk34XdVANwJBqZr6vNs7RbkL0";

    static final String accessKeyId = "LTAI4FkuUQAYCVcuR6HszZaP";
    static final String accessKeySecret = "t4ozbryStW6SFhPhM6oz3Xkom1B8CY";




    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

  /*  public static boolean sendSms(String telephone, String code) throws Exception {
        com.aliyun.dysmsapi20170525.Client client = AliyunSmsUtils.createClient(accessKeyId, accessKeySecret);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("")
                .setPhoneNumbers(telephone)
                .setTemplateCode("SMS_212980326")
                .setTemplateParam("{\"code\":\"" + code + "\"}");

        SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
        if(sendSmsResponse.getBody().getCode().equalsIgnoreCase("OK")){
            return true;
        }
        logger.error("阿里云短信发送失败："+telephone);
        return false;
    }*/




    // 验证手机号
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        String regex="^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
        p = Pattern.compile(regex);
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

    //生成验证码
    public static String getVCode(){
        long vcode = Math.round(Math.random()*1000000);
        return String.valueOf(vcode);
    }





    //老版SDK [弃用]
    public static boolean sendSms(String telephone, String code) throws ClientException {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", telephone);
        request.putQueryParameter("SignName", "无痕通讯");
        request.putQueryParameter("TemplateCode", "SMS_179070346");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
           if(response.getHttpResponse().getStatus() == 200 && response != null){
               String data = response.getData();
               Map map = JSON.parseObject(data, Map.class);
//               logger.info("短信发送状态:{}" +  map.get("Message"));
               if(map.get("Message").equals("OK")){
                   return true;
               }

           }

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }






}
