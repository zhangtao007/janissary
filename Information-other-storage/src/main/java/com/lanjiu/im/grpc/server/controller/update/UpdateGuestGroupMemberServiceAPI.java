package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RpcGuestGroupMember;
import com.lanjiu.im.grpc.dao.mapper.impl.GuestGroupMemberMapper;
import com.lanjiu.im.grpc.pojo.GuestGroupMember;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UpdateGuestGroupMemberServiceAPI {

    private static final Logger logger = Logger.getLogger(UpdateGuestGroupMemberServiceAPI.class.getName());

    public GuestGroupMember updateGuestGroupMember(RpcGuestGroupMember rpcGuestGroupMember){
        //分发游客群成员编号
        SqlSession session = DBTools.getSession();
        Integer groupMemberId = rpcGuestGroupMember.getGroupMemberId();
        if((0 == groupMemberId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_ID_UNDEFAULT_UPDATE);
            return null;
        }
        //其他属性
        Integer guestUserId = rpcGuestGroupMember.getGuestUserId();
        if((0 == guestUserId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_USER_ID_UNDEFAULT);
            return null;
        }
        String groupRemarks = rpcGuestGroupMember.getGroupRemarks();
        String groupOwner = rpcGuestGroupMember.getGroupOwner();
        String burnAfterReadingSettings = rpcGuestGroupMember.getBurnAfterReadingSettings();
        if(("".equals(burnAfterReadingSettings))||(null == burnAfterReadingSettings)){
            burnAfterReadingSettings = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        }
        String burnAfterReadingTimeUnit = rpcGuestGroupMember.getBurnAfterReadingTimeUnit();
        if(("".equals(burnAfterReadingTimeUnit))||(null == burnAfterReadingTimeUnit)){
            burnAfterReadingTimeUnit = ConstantsDefault.TIME_UNIT_SECOND;
        }
        float length = rpcGuestGroupMember.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        Timestamp groupEntryTime = new Timestamp(rpcGuestGroupMember.getGroupEntryTime());
        String offlineMessageSetting = rpcGuestGroupMember.getOfflineMessageSetting();
        //构建游客群成员对象
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        guestGroupMember.setGroupMemberId(groupMemberId);
        guestGroupMember.setGuestUserId(guestUserId);
        guestGroupMember.setGroupOwner(groupOwner);
        guestGroupMember.setGroupRemarks(groupRemarks);
        guestGroupMember.setBurnAfterReadingSettings(burnAfterReadingSettings);
        guestGroupMember.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        guestGroupMember.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        guestGroupMember.setGroupEntryTime(groupEntryTime);
        guestGroupMember.setOfflineMessageSetting(offlineMessageSetting);

        boolean bResult = updateGuestGroupMemberService(session, guestGroupMember);
        if(bResult){
            return guestGroupMember;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean updateGuestGroupMemberService(SqlSession session, GuestGroupMember guestGroupMember){
        GuestGroupMemberMapper guestGroupMemberMapper = session.getMapper(GuestGroupMemberMapper.class);
        //
        int result = 0;
        try {
            result = guestGroupMemberMapper.updateGuestGroupMember(guestGroupMember.getGroupMemberId(), guestGroupMember.getGuestUserId(),
                    guestGroupMember.getGroupRemarks(), guestGroupMember.getGroupOwner(),
                    guestGroupMember.getBurnAfterReadingSettings(), guestGroupMember.getBurnAfterReadingTimeUnit(),
                    guestGroupMember.getBurnAfterReadingTimeLength(), guestGroupMember.getGroupEntryTime(), guestGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        System.out.println(result);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
}
