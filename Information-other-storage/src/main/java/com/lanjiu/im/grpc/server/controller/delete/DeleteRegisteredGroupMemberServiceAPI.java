package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.RpcRegisteredGroupMember;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.ConstantsSelectKind;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class DeleteRegisteredGroupMemberServiceAPI {

    private static final Logger logger = Logger.getLogger(DeleteRegisteredGroupMemberServiceAPI.class.getName());

    public RegisteredGroupMember deleteRegisteredGroupMember(RpcRegisteredGroupMember rpcRegisteredGroupMember, String kind){
        SqlSession session = DBTools.getSession();
        int groupMemberId = rpcRegisteredGroupMember.getGroupMemberId();
        if(ConstantsSelectKind.GROUP_MEMBER_DELETE_TYPE_BY_GROUP_MEMBER_ID.equals(kind)){
            if(groupMemberId == 0){
                logger.info(ConstantsPrompt.GROUP_MEMBER_ID_UNDEFAULT_DELETE);
                return null;
            }
        }
        //其他属性
        Integer guestUserId = rpcRegisteredGroupMember.getRegisteredUserId();
        String groupRemarks = rpcRegisteredGroupMember.getGroupRemarks();
        String groupOwner = rpcRegisteredGroupMember.getGroupOwner();
        String burnAfterReadingSettings = rpcRegisteredGroupMember.getBurnAfterReadingSettings();
        String burnAfterReadingTimeUnit = rpcRegisteredGroupMember.getBurnAfterReadingTimeUnit();
        float length = rpcRegisteredGroupMember.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        Timestamp groupEntryTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String offlineMessageSetting = rpcRegisteredGroupMember.getOfflineMessageSetting();
        //构建游客群成员对象
        RegisteredGroupMember guestGroupMember = new RegisteredGroupMember();
        guestGroupMember.setGroupMemberId(groupMemberId);
        guestGroupMember.setRegisteredUserId(guestUserId);
        guestGroupMember.setGroupOwner(groupOwner);
        guestGroupMember.setGroupRemarks(groupRemarks);
        guestGroupMember.setBurnAfterReadingSettings(burnAfterReadingSettings);
        guestGroupMember.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        guestGroupMember.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        guestGroupMember.setGroupEntryTime(groupEntryTime);
        guestGroupMember.setOfflineMessageSetting(offlineMessageSetting);

        boolean bResult = deleteRegisteredGroupMemberService(session, guestGroupMember, kind);
        if(bResult){
            return guestGroupMember;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean deleteRegisteredGroupMemberService(SqlSession session, RegisteredGroupMember guestGroupMember, String kind){
        //
        int result = 0;
        try {
            if(ConstantsSelectKind.GROUP_DELETE_TYPE_BY_GROUP_ID.equals(kind)){
                //删除注册群成员以及释放注册群成员绑定的注册群的关联记录  4个表
                result = deleteRegisteredGroupRegisteredUserMemberRelationService(session, guestGroupMember);
                //删除注册群成员以及释放注册群成员绑定的游客群的关联记录  4个表
                result = deleteGuestGroupRegisteredUserMemberRelationService(session, guestGroupMember);
                ///删除注册群成员关联的群备注表中的记录GroupRemark 1个表
                result = deleteGroupRemarkService(session, guestGroupMember);
            }
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

    //释放游客群成员以及游客群成员绑定的游客群的关联记录
    public int deleteGuestGroupRegisteredUserMemberRelationService(SqlSession session, RegisteredGroupMember guestGroupMember){
        GuestGroupRegisteredUserMemberRelationMapper guestGroupRegisteredUserMemberRelationMapper = session.getMapper(GuestGroupRegisteredUserMemberRelationMapper.class);
        List<GuestGroupRegisteredUserMemberRelation> guestGroupRegisteredUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupRegisteredUserMemberRelationList = guestGroupRegisteredUserMemberRelationMapper.selectGuestGroupRegisteredUserMemberRelationByRegisteredUserMemberId(guestGroupMember.getGroupMemberId());
            for (GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation : guestGroupRegisteredUserMemberRelationList){
                result = deleteGuestGroupRegisteredGroupMemberByGroupMemberIdService(session, guestGroupRegisteredUserMemberRelation);
                guestGroupRegisteredUserMemberRelationMapper.deleteGuestGroupRegisteredUserMemberRelation(guestGroupRegisteredUserMemberRelation.getGuestGroupId(), guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放游客群成员以及游客群成员绑定的注册群的关联记录
    public int deleteRegisteredGroupRegisteredUserMemberRelationService(SqlSession session, RegisteredGroupMember guestGroupMember){
        RegisteredGroupRegisteredUserMemberRelationMapper guestGroupRegisteredUserMemberRelationMapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        List<RegisteredGroupRegisteredUserMemberRelation> guestGroupRegisteredUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupRegisteredUserMemberRelationList = guestGroupRegisteredUserMemberRelationMapper.selectRegisteredGroupRegisteredUserMemberRelationByRegisteredUserMemberId(guestGroupMember.getGroupMemberId());
            for (RegisteredGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation : guestGroupRegisteredUserMemberRelationList){
                result = deleteRegisteredGroupRegisteredGroupMemberByGroupMemberIdService(session, guestGroupRegisteredUserMemberRelation);
                guestGroupRegisteredUserMemberRelationMapper.deleteRegisteredGroupRegisteredUserMemberRelation(guestGroupRegisteredUserMemberRelation.getRegisteredGroupId(), guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放RegisteredGroupMember的 group member id-----注册群相关联记录释放
    public int deleteRegisteredGroupRegisteredGroupMemberByGroupMemberIdService(SqlSession session, RegisteredGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation){
        RegisteredGroupMemberMapper guestUserGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        GroupMemberUsedBeautifulNumberRealMapper groupUsedBeautifulNumberRealMapper = session.getMapper(GroupMemberUsedBeautifulNumberRealMapper.class);
        GroupMemberUnusedBeautifulNumberRealMapper mapperbGroupMemberUnusedBeautifulNumberRealMapper = session.getMapper(GroupMemberUnusedBeautifulNumberRealMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumberReal = turnIntToObject(guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
        //
        int result = 0;
        try {
            result = guestUserGroupMemberMapper.deleteRegisteredGroupMemberByGroupMemberId(guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            result = groupUsedBeautifulNumberRealMapper.deleteGroupMemberUsedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(),
                    friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
            result = mapperbGroupMemberUnusedBeautifulNumberRealMapper.insertGroupMemberUnusedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(),
                    friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放RegisteredGroupMember的 group member id-----游客群相关联记录释放
    public int deleteGuestGroupRegisteredGroupMemberByGroupMemberIdService(SqlSession session, GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation){
        RegisteredGroupMemberMapper guestUserGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        GroupMemberUsedBeautifulNumberRealMapper groupUsedBeautifulNumberRealMapper = session.getMapper(GroupMemberUsedBeautifulNumberRealMapper.class);
        GroupMemberUnusedBeautifulNumberRealMapper mapperbGroupMemberUnusedBeautifulNumberRealMapper = session.getMapper(GroupMemberUnusedBeautifulNumberRealMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumberReal = turnIntToObject(guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
        //
        int result = 0;
        try {
            result = guestUserGroupMemberMapper.deleteRegisteredGroupMemberByGroupMemberId(guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            result = groupUsedBeautifulNumberRealMapper.deleteGroupMemberUsedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(),
                    friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
            result = mapperbGroupMemberUnusedBeautifulNumberRealMapper.insertGroupMemberUnusedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(),
                    friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放游客群成员绑定的群备注
    public int deleteGroupRemarkService(SqlSession session, RegisteredGroupMember guestGroupMember){
        GroupRemarkMapper groupRemarkMapper = session.getMapper(GroupRemarkMapper.class);
        int result = 0;
        try {

            result = groupRemarkMapper.deleteGroupRemarkByMemberId(guestGroupMember.getGroupMemberId());
            result = groupRemarkMapper.deleteGroupRemarkByMemberRemarkedId(guestGroupMember.getGroupMemberId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public BeautifulNumberAuto turnIntToObject(int number){
        BeautifulNumberAuto beautifulNumberAuto = new BeautifulNumberAuto();
        String nConfig = String.valueOf(number);

        String tenMillion = nConfig.substring(0, 1);
        beautifulNumberAuto.setTenMillion(Integer.valueOf(tenMillion));

        String oneMillion = nConfig.substring(1, 2);
        beautifulNumberAuto.setOneMillion(Integer.valueOf(oneMillion));

        String oneHundredThousand = nConfig.substring(2, 3);
        beautifulNumberAuto.setOneHundredThousand(Integer.valueOf(oneHundredThousand));

        String tenThousand = nConfig.substring(3, 4);
        beautifulNumberAuto.setTenThousand(Integer.valueOf(tenThousand));

        String oneThousand = nConfig.substring(4, 5);
        beautifulNumberAuto.setOneThousand(Integer.valueOf(oneThousand));

        String oneHundred = nConfig.substring(5, 6);
        beautifulNumberAuto.setOneHundred(Integer.valueOf(oneHundred));

        String ten = nConfig.substring(6, 7);
        beautifulNumberAuto.setTen(Integer.valueOf(ten));

        String one = nConfig.substring(7, 8);
        beautifulNumberAuto.setOne(Integer.valueOf(one));

        return beautifulNumberAuto;
    }
}
