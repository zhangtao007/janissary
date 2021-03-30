package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.RpcGuestGroupMember;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.server.controller.GetGuestGroupMemberBeautifulNumberId;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GuestGroupMemberGuestGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(GuestGroupMemberGuestGroupServiceAPI.class.getName());

    public GuestGroupMember createGuestGroupMember(RpcGuestGroup rpcGuestGroup, RpcGuestGroupMember rpcGuestGroupMember){
        //分发游客群成员编号
        SqlSession session = DBTools.getSession();
        GetGuestGroupMemberBeautifulNumberId getGuestGroupMemberBeautifulNumberId = new GetGuestGroupMemberBeautifulNumberId();
        GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber = getGuestGroupMemberBeautifulNumberId.getGuestGroupMemberId();
        int groupMemberId = getGuestGroupMemberBeautifulNumberId.getGuestGroupMemberIntId();
        //其他属性
        Integer guestUserId = rpcGuestGroupMember.getGuestUserId();
        if((0 == guestUserId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_USER_ID_UNDEFAULT);
            return null;
        }
        String groupRemarks = rpcGuestGroupMember.getGroupRemarks();
        if(("".equals(groupRemarks))||(null == groupRemarks)){
            groupRemarks = ConstantsDefault.GROUP_MEMBER_REMARK_DEFAULT;
        }
        String groupOwner = rpcGuestGroupMember.getGroupOwner();
        if(("".equals(groupOwner))||(null == groupOwner)){
            groupOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;
        }
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
        Timestamp groupEntryTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String offlineMessageSetting = rpcGuestGroupMember.getOfflineMessageSetting();
        if(("".equals(offlineMessageSetting))||(null == offlineMessageSetting)){
            offlineMessageSetting = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        }
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

        boolean bResult = insertGroupId(session, groupMemberUnusedBeautifulNumber, rpcGuestGroup, guestGroupMember);
        if(bResult){
            return guestGroupMember;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean insertGroupId(SqlSession session, GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber, RpcGuestGroup rpcGuestGroup, GuestGroupMember guestGroupMember){
        GroupMemberUsedBeautifulNumberMapper groupMemberUsedBeautifulNumberMapper = session.getMapper(GroupMemberUsedBeautifulNumberMapper.class);
        GroupMemberUnusedBeautifulNumberMapper groupMemberUnusedBeautifulNumberMapper = session.getMapper(GroupMemberUnusedBeautifulNumberMapper.class);
        GuestGroupMemberMapper guestGroupMemberMapper = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation = generateGuestGroupGuestUserMemberRelation(rpcGuestGroup, guestGroupMember);
        //
        int result = 0;
        try {
            result = guestGroupMemberMapper.insertGuestGroupMember(guestGroupMember.getGroupMemberId(), guestGroupMember.getGuestUserId(),
                    guestGroupMember.getGroupRemarks(), guestGroupMember.getGroupOwner(),
                    guestGroupMember.getBurnAfterReadingSettings(), guestGroupMember.getBurnAfterReadingTimeUnit(),
                    guestGroupMember.getBurnAfterReadingTimeLength(), guestGroupMember.getGroupEntryTime(), guestGroupMember.getOfflineMessageSetting());
            result = guestGroupGuestUserMemberRelationMapper.insertGuestGroupGuestUserMemberRelation(guestGroupGuestUserMemberRelation.getGuestGroupId(),
                    guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            //
            result = groupMemberUsedBeautifulNumberMapper.insertGroupMemberUsedBeautifulNumber(groupMemberUnusedBeautifulNumber.getTenMillion(), groupMemberUnusedBeautifulNumber.getOneMillion(),
                    groupMemberUnusedBeautifulNumber.getOneHundredThousand(), groupMemberUnusedBeautifulNumber.getTenThousand(),
                    groupMemberUnusedBeautifulNumber.getOneThousand(), groupMemberUnusedBeautifulNumber.getOneHundred(),
                    groupMemberUnusedBeautifulNumber.getTen(), groupMemberUnusedBeautifulNumber.getOne());
            result = groupMemberUnusedBeautifulNumberMapper.deleteGroupMemberUnusedBeautifulNumber(groupMemberUnusedBeautifulNumber.getTenMillion(), groupMemberUnusedBeautifulNumber.getOneMillion(),
                    groupMemberUnusedBeautifulNumber.getOneHundredThousand(), groupMemberUnusedBeautifulNumber.getTenThousand(),
                    groupMemberUnusedBeautifulNumber.getOneThousand(), groupMemberUnusedBeautifulNumber.getOneHundred(),
                    groupMemberUnusedBeautifulNumber.getTen(), groupMemberUnusedBeautifulNumber.getOne());
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

    public GuestGroupGuestUserMemberRelation generateGuestGroupGuestUserMemberRelation(RpcGuestGroup rpcGuestGroup, GuestGroupMember guestGroupMember){
        GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation = new GuestGroupGuestUserMemberRelation();
        Integer guestGroupId = rpcGuestGroup.getGroupId();
        Integer guestUserMemberId = guestGroupMember.getGroupMemberId();
        guestGroupGuestUserMemberRelation.setGuestUserMemberId(guestUserMemberId);
        guestGroupGuestUserMemberRelation.setGuestGroupId(guestGroupId);
        return guestGroupGuestUserMemberRelation;
    }
}
