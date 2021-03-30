package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.RpcRegisteredGroup;
import com.lanjiu.im.grpc.RpcRegisteredGroupMember;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupMemberMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupRegisteredUserMemberRelationMapper;
import com.lanjiu.im.grpc.pojo.GroupMemberUnusedBeautifulNumberReal;
import com.lanjiu.im.grpc.pojo.RegisteredGroupMember;
import com.lanjiu.im.grpc.pojo.RegisteredGroupRegisteredUserMemberRelation;
import com.lanjiu.im.grpc.server.controller.GetRegisteredGroupMemberBeautifulNumberId;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RegisteredGroupMemberRegisteredGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(RegisteredGroupMemberRegisteredGroupServiceAPI.class.getName());

    public RegisteredGroupMember createRegisteredGroupMember(RpcRegisteredGroup rpcRegisteredGroup, RpcRegisteredGroupMember rpcRegisteredGroupMember){
        //分发群成员编号
        SqlSession session = DBTools.getSession();
        GetRegisteredGroupMemberBeautifulNumberId getRegisteredGroupMemberBeautifulNumberId = new GetRegisteredGroupMemberBeautifulNumberId();
        GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumberReal = getRegisteredGroupMemberBeautifulNumberId.getRegisteredGroupMemberId();
        int groupMemberId = getRegisteredGroupMemberBeautifulNumberId.getRegisteredGroupMemberIntId();
        //其他属性
        Integer registeredUserId = rpcRegisteredGroupMember.getRegisteredUserId();
        if((0 == registeredUserId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_USER_ID_UNDEFAULT);
            return null;
        }
        String groupRemarks = rpcRegisteredGroupMember.getGroupRemarks();
        if(("".equals(groupRemarks))||(null == groupRemarks)){
            groupRemarks = ConstantsDefault.GROUP_MEMBER_REMARK_DEFAULT;
        }
        String groupOwner = rpcRegisteredGroupMember.getGroupOwner();
        if(("".equals(groupOwner))||(null == groupOwner)){
            groupOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;
        }
        String burnAfterReadingSettings = rpcRegisteredGroupMember.getBurnAfterReadingSettings();
        if(("".equals(burnAfterReadingSettings))||(null == burnAfterReadingSettings)){
            burnAfterReadingSettings = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        }
        String burnAfterReadingTimeUnit = rpcRegisteredGroupMember.getBurnAfterReadingTimeUnit();
        if(("".equals(burnAfterReadingTimeUnit))||(null == burnAfterReadingTimeUnit)){
            burnAfterReadingTimeUnit = ConstantsDefault.TIME_UNIT_SECOND;
        }
        float length = rpcRegisteredGroupMember.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        Timestamp groupEntryTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String offlineMessageSetting = rpcRegisteredGroupMember.getOfflineMessageSetting();
        if(("".equals(offlineMessageSetting))||(null == offlineMessageSetting)){
            offlineMessageSetting = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        }
        //构建群成员对象
        RegisteredGroupMember registeredGroupMember = new RegisteredGroupMember();
        registeredGroupMember.setGroupMemberId(groupMemberId);
        registeredGroupMember.setRegisteredUserId(registeredUserId);
        registeredGroupMember.setGroupOwner(groupOwner);
        registeredGroupMember.setGroupRemarks(groupRemarks);
        registeredGroupMember.setBurnAfterReadingSettings(burnAfterReadingSettings);
        registeredGroupMember.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        registeredGroupMember.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        registeredGroupMember.setGroupEntryTime(groupEntryTime);
        registeredGroupMember.setOfflineMessageSetting(offlineMessageSetting);

        boolean bResult = insertGroupId(session, groupMemberUnusedBeautifulNumberReal, rpcRegisteredGroup, registeredGroupMember);
        if(bResult){
            return registeredGroupMember;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean insertGroupId(SqlSession session, GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumberReal, RpcRegisteredGroup rpcRegisteredGroup, RegisteredGroupMember registeredGroupMember){
        GroupMemberUsedBeautifulNumberRealMapper groupMemberUsedBeautifulNumberRealMapper = session.getMapper(GroupMemberUsedBeautifulNumberRealMapper.class);
        GroupMemberUnusedBeautifulNumberRealMapper groupMemberUnusedBeautifulNumberRealMapper = session.getMapper(GroupMemberUnusedBeautifulNumberRealMapper.class);
        RegisteredGroupMemberMapper guestGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupRegisteredUserMemberRelationMapper guestGroupRegisteredUserMemberRelationMapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        RegisteredGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation = generateRegisteredGroupRegisteredUserMemberRelation(rpcRegisteredGroup, registeredGroupMember);
        //
        int result = 0;
        try {
            result = guestGroupMemberMapper.insertRegisteredGroupMember(registeredGroupMember.getGroupMemberId(), registeredGroupMember.getRegisteredUserId(),null,
                    registeredGroupMember.getGroupRemarks(), registeredGroupMember.getGroupOwner(),
                    registeredGroupMember.getBurnAfterReadingSettings(), registeredGroupMember.getBurnAfterReadingTimeUnit(),
                    registeredGroupMember.getBurnAfterReadingTimeLength(), registeredGroupMember.getGroupEntryTime(), registeredGroupMember.getOfflineMessageSetting());
            result = guestGroupRegisteredUserMemberRelationMapper.insertRegisteredGroupRegisteredUserMemberRelation(guestGroupRegisteredUserMemberRelation.getRegisteredGroupId(),
                    guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            //
            result = groupMemberUsedBeautifulNumberRealMapper.insertGroupMemberUsedBeautifulNumberReal(groupMemberUnusedBeautifulNumberReal.getTenMillion(), groupMemberUnusedBeautifulNumberReal.getOneMillion(),
                    groupMemberUnusedBeautifulNumberReal.getOneHundredThousand(), groupMemberUnusedBeautifulNumberReal.getTenThousand(),
                    groupMemberUnusedBeautifulNumberReal.getOneThousand(), groupMemberUnusedBeautifulNumberReal.getOneHundred(),
                    groupMemberUnusedBeautifulNumberReal.getTen(), groupMemberUnusedBeautifulNumberReal.getOne());
            result = groupMemberUnusedBeautifulNumberRealMapper.deleteGroupMemberUnusedBeautifulNumberReal(groupMemberUnusedBeautifulNumberReal.getTenMillion(), groupMemberUnusedBeautifulNumberReal.getOneMillion(),
                    groupMemberUnusedBeautifulNumberReal.getOneHundredThousand(), groupMemberUnusedBeautifulNumberReal.getTenThousand(),
                    groupMemberUnusedBeautifulNumberReal.getOneThousand(), groupMemberUnusedBeautifulNumberReal.getOneHundred(),
                    groupMemberUnusedBeautifulNumberReal.getTen(), groupMemberUnusedBeautifulNumberReal.getOne());
            session.commit();
        } catch (Exception e) {
            logger.error("插入群成员表时出现错误，"+registeredGroupMember.toString());
            logger.error("插入群成员表时出现错误，",e);
            e.printStackTrace();
            session.rollback();
            return false;
        }
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }

    public RegisteredGroupRegisteredUserMemberRelation generateRegisteredGroupRegisteredUserMemberRelation(RpcRegisteredGroup rpcRegisteredGroup, RegisteredGroupMember registeredGroupMember){
        RegisteredGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation = new RegisteredGroupRegisteredUserMemberRelation();
        Integer guestGroupId = rpcRegisteredGroup.getGroupId();
        Integer guestUserMemberId = registeredGroupMember.getGroupMemberId();
        guestGroupRegisteredUserMemberRelation.setRegisteredUserMemberId(guestUserMemberId);
        guestGroupRegisteredUserMemberRelation.setRegisteredGroupId(guestGroupId);
        return guestGroupRegisteredUserMemberRelation;
    }
}
