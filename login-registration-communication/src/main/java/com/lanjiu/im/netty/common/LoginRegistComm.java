package com.lanjiu.im.netty.common;

import com.lanjiu.im.netty.service.RegistService;
import com.lanjiu.im.netty.service.TouristService;
import com.lanjiu.im.util.ConstType;
import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.im.util.JCRC32;
import com.lanjiu.im.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginRegistComm {

    private static final Logger logger = LoggerFactory.getLogger(RegistService.class);

    private static final   Pattern pattern = Pattern.compile("^\\d{8}$");



    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage regist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService  registService = new RegistService();
        return registService.userRegist(unifiedEntranceMessage,head);

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage loginRegistered(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.loginRegistered(unifiedEntranceMessage,head);

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage loginTourists(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristService touristService = new TouristService();
        return touristService.loginTourist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage logoutRegistered(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.logoutRegist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage logoutTourists(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristService touristService = new TouristService();
        return touristService.logoutTourists(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage registPersonSetting(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.registPersonSetting(unifiedEntranceMessage,head);

    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage guestPersonSetting(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristService touristService = new TouristService();
        return touristService.guestPersonSetting(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage registPersonInfo(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.registPersonInfo(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage guestPersonInfo(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristService touristService = new TouristService();
        return touristService.guestPersonInfo(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage findUserRegist(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.findUserRegist(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage findUserGuest(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        TouristService touristService = new TouristService();
        return touristService.findUserGuest(unifiedEntranceMessage,head);
    }


    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage changeStatusOnline(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String fromId = unifiedEntranceMessage.getHead().getFromId();
        Matcher isNum = pattern.matcher(fromId);
        logger.info("IM检测用户连接状态变更<<："+fromId);
        if (!isNum.matches()){
            logger.error("IM修改用户(上线)状态时异常，接收参数非ID:"+fromId);
            JCRC32 jcrc32 = new JCRC32();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.PARAMETERS_ERROR)
                            .build()).build());
            return checkUnifiedEntranceMessage;
        }


        RegistService registService = new RegistService();
         return registService.changeStatusRegist(unifiedEntranceMessage,head);


    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage changeStatusOffline(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        String fromId = unifiedEntranceMessage.getHead().getFromId();
        Matcher isNum = pattern.matcher(fromId);
        logger.info("IM检测用户连接状态变更>>>："+fromId);
        if (!isNum.matches()){
            logger.error("IM修改用户(下线)状态时异常，接收参数非ID:"+fromId);
            JCRC32 jcrc32 = new JCRC32();
            BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnifiedEntranceMessage = jcrc32.packageCheckSum(BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgType(head.getMsgType())
                            .setToken(head.getToken())
                            .setFromId(head.getFromId())
                            .setToId(head.getToId())
                            .setUniqueIdentify(head.getUniqueIdentify())
                            .setStatusReport(ResponseStatus.PARAMETERS_ERROR)
                            .build()).build());
            return checkUnifiedEntranceMessage;
        }
        RegistService registService = new RegistService();
        return registService.changeStatusRegist(unifiedEntranceMessage,head);


    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage setPhone(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.setPhone(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage verificationCode(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.verificationCode(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkVersion(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.checkVersion(unifiedEntranceMessage,head);
    }

    public BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage updateUserDevice(BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage, BusinessProtocolMessageStandard.Head head) {
        RegistService registService = new RegistService();
        return registService.updateUserDevice(unifiedEntranceMessage,head);
    }
}
