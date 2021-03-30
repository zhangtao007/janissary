package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.RpcGuestGroupMember;
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

public class DeleteGuestGroupMemberServiceAPI {

    private static final Logger logger = Logger.getLogger(DeleteGuestGroupMemberServiceAPI.class.getName());

    public GuestGroupMember deleteGuestGroupMember(RpcGuestGroupMember rpcGuestGroupMember, String kind){
        SqlSession session = DBTools.getSession();
        int groupMemberId = rpcGuestGroupMember.getGroupMemberId();
        if(ConstantsSelectKind.GROUP_MEMBER_DELETE_TYPE_BY_GROUP_MEMBER_ID.equals(kind)){
            if(groupMemberId == 0){
                logger.info(ConstantsPrompt.GROUP_MEMBER_ID_UNDEFAULT_DELETE);
                return null;
            }
        }
        //其他属性
        Integer guestUserId = rpcGuestGroupMember.getGuestUserId();
        String groupRemarks = rpcGuestGroupMember.getGroupRemarks();
        String groupOwner = rpcGuestGroupMember.getGroupOwner();
        String burnAfterReadingSettings = rpcGuestGroupMember.getBurnAfterReadingSettings();
        String burnAfterReadingTimeUnit = rpcGuestGroupMember.getBurnAfterReadingTimeUnit();
        float length = rpcGuestGroupMember.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        Timestamp groupEntryTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
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

        boolean bResult = deleteGuestGroupMemberService(session, guestGroupMember, kind);
        if(bResult){
            return guestGroupMember;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean deleteGuestGroupMemberService(SqlSession session, GuestGroupMember guestGroupMember, String kind){
        //
        int result = 0;
        try {
            if(ConstantsSelectKind.GROUP_DELETE_TYPE_BY_GROUP_ID.equals(kind)){
                //删除游客群成员以及释放游客群成员绑定的注册群的关联记录  4个表
                result = deleteRegisteredGroupGuestUserMemberRelationService(session, guestGroupMember);
                //删除游客群成员以及释放游客群成员绑定的游客群的关联记录  4个表
                result = deleteGuestGroupGuestUserMemberRelationService(session, guestGroupMember);
                ///删除游客群成员关联的群备注表中的记录GroupRemark 1个表
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
    public int deleteGuestGroupGuestUserMemberRelationService(SqlSession session, GuestGroupMember guestGroupMember){
        GuestGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        List<GuestGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupGuestUserMemberRelationList = guestGroupGuestUserMemberRelationMapper.selectGuestGroupGuestUserMemberRelationByGuestUserMemberId(guestGroupMember.getGroupMemberId());
            for (GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation : guestGroupGuestUserMemberRelationList){
                result = deleteGuestGroupGuestGroupMemberByGroupMemberIdService(session, guestGroupGuestUserMemberRelation);
                guestGroupGuestUserMemberRelationMapper.deleteGuestGroupGuestUserMemberRelation(guestGroupGuestUserMemberRelation.getGuestGroupId(), guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放游客群成员以及游客群成员绑定的注册群的关联记录
    public int deleteRegisteredGroupGuestUserMemberRelationService(SqlSession session, GuestGroupMember guestGroupMember){
        RegisteredGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(RegisteredGroupGuestUserMemberRelationMapper.class);
        List<RegisteredGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupGuestUserMemberRelationList = guestGroupGuestUserMemberRelationMapper.selectRegisteredGroupGuestUserMemberRelationByGuestUserMemberId(guestGroupMember.getGroupMemberId());
            for (RegisteredGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation : guestGroupGuestUserMemberRelationList){
                result = deleteRegisteredGroupGuestGroupMemberByGroupMemberIdService(session, guestGroupGuestUserMemberRelation);
                guestGroupGuestUserMemberRelationMapper.deleteRegisteredGroupGuestUserMemberRelation(guestGroupGuestUserMemberRelation.getRegisteredGroupId(), guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放GuestGroupMember的 group member id-----注册群相关记录释放
    public int deleteRegisteredGroupGuestGroupMemberByGroupMemberIdService(SqlSession session, RegisteredGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation){
        GuestGroupMemberMapper guestUserGroupMemberMapper = session.getMapper(GuestGroupMemberMapper.class);
        GroupMemberUsedBeautifulNumberMapper groupUsedBeautifulNumberMapper = session.getMapper(GroupMemberUsedBeautifulNumberMapper.class);
        GroupMemberUnusedBeautifulNumberMapper mapperbGroupMemberUnusedBeautifulNumberMapper = session.getMapper(GroupMemberUnusedBeautifulNumberMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumber = turnIntToObject(guestGroupGuestUserMemberRelation.getGuestUserMemberId());
        //
        int result = 0;
        try {
            result = guestUserGroupMemberMapper.deleteGuestGroupMemberByGroupMemberId(guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            result = groupUsedBeautifulNumberMapper.deleteGroupMemberUsedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = mapperbGroupMemberUnusedBeautifulNumberMapper.insertGroupMemberUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放GuestGroupMember的 group member id-----游客群相关记录释放
    public int deleteGuestGroupGuestGroupMemberByGroupMemberIdService(SqlSession session, GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation){
        GuestGroupMemberMapper guestUserGroupMemberMapper = session.getMapper(GuestGroupMemberMapper.class);
        GroupMemberUsedBeautifulNumberMapper groupUsedBeautifulNumberMapper = session.getMapper(GroupMemberUsedBeautifulNumberMapper.class);
        GroupMemberUnusedBeautifulNumberMapper mapperbGroupMemberUnusedBeautifulNumberMapper = session.getMapper(GroupMemberUnusedBeautifulNumberMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumber = turnIntToObject(guestGroupGuestUserMemberRelation.getGuestUserMemberId());
        //
        int result = 0;
        try {
            result = guestUserGroupMemberMapper.deleteGuestGroupMemberByGroupMemberId(guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            result = groupUsedBeautifulNumberMapper.deleteGroupMemberUsedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = mapperbGroupMemberUnusedBeautifulNumberMapper.insertGroupMemberUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放游客群成员绑定的群备注
    public int deleteGroupRemarkService(SqlSession session, GuestGroupMember guestGroupMember){
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
