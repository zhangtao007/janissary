package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.ConstantsSelectKind;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class DeleteGuestGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(DeleteGuestGroupServiceAPI.class.getName());

    public GuestGroup deleteGuestGroup(RpcGuestGroup rpcGuestGroup, String kind){
        SqlSession session = DBTools.getSession();
        int groupId = rpcGuestGroup.getGroupId();
        if(ConstantsSelectKind.GROUP_DELETE_TYPE_BY_GROUP_ID.equals(kind)){
            if(groupId == 0){
                logger.info(ConstantsPrompt.GROUP_ID_UNDEFAULT_DELETE);
                return null;
            }
        }
        Integer guestUserId = rpcGuestGroup.getGuestUserId();
        String groupName = rpcGuestGroup.getGroupName();
        Integer groupAnnouncementId = groupId;
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Integer amount = rpcGuestGroup.getAmount();
        GuestGroup guestGroup = new GuestGroup();
        guestGroup.setGroupId(groupId);
        guestGroup.setGroupAnnouncementId(groupAnnouncementId);
        guestGroup.setGuestUserId(guestUserId);
        guestGroup.setAmount(amount);
        guestGroup.setCreationTime(creationTime);
        guestGroup.setModificationTime(modificationTime);
        guestGroup.setGroupName(groupName);

        boolean bResult = deleteGuestGroupService(session, guestGroup, kind);
        if(bResult){
            return guestGroup;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean deleteGuestGroupService(SqlSession session, GuestGroup guestGroup, String kind){

        int result = 0;
        try {
            if(ConstantsSelectKind.GROUP_DELETE_TYPE_BY_GROUP_ID.equals(kind)){
                //删除游客群即释放游客群id  3个表
                result = deleteGuestGroupByGroupIdService(session, guestGroup);
                //删除游客群关联的游客群成员以及释放游客群成员id  4个表
                result = deleteGuestGroupGuestUserMemberRelationService(session, guestGroup);
                //删除游客群关联的注册群成员以及释放注册群成员id  4个表
                result = deleteGuestGroupRegisteredUserMemberRelationService(session, guestGroup);
                //删除游客群关联的公告  1个表
                result = deleteGroupAnnouncementsService(session, guestGroup);
                ///删除游客群关联的群备注表中的记录GroupRemark 1个表
                result = deleteGroupRemarkService(session, guestGroup);
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

    //释放游客群成员和游客群的关系
    public int deleteGuestGroupGuestUserMemberRelationService(SqlSession session, GuestGroup guestGroup){
        GuestGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        List<GuestGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupGuestUserMemberRelationList = guestGroupGuestUserMemberRelationMapper.selectGuestGroupGuestUserMemberRelationByGuestGroupId(guestGroup.getGroupId());
            for (GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation : guestGroupGuestUserMemberRelationList){
                result = deleteGuestGroupMemberByGroupMemberIdService(session, guestGroupGuestUserMemberRelation);
                guestGroupGuestUserMemberRelationMapper.deleteGuestGroupGuestUserMemberRelation(guestGroupGuestUserMemberRelation.getGuestGroupId(), guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放注册群成员和游客群的关系
    public int deleteGuestGroupRegisteredUserMemberRelationService(SqlSession session, GuestGroup guestGroup){
        GuestGroupRegisteredUserMemberRelationMapper guestGroupRegisteredUserMemberRelationMapper = session.getMapper(GuestGroupRegisteredUserMemberRelationMapper.class);
        List<GuestGroupRegisteredUserMemberRelation> guestGroupRegisteredUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupRegisteredUserMemberRelationList = guestGroupRegisteredUserMemberRelationMapper.selectGuestGroupRegisteredUserMemberRelationByGuestGroupId(guestGroup.getGroupId());
            for (GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation : guestGroupRegisteredUserMemberRelationList){
                result = deleteRegisteredGroupMemberByGroupMemberIdService(session, guestGroupRegisteredUserMemberRelation);
                guestGroupRegisteredUserMemberRelationMapper.deleteGuestGroupRegisteredUserMemberRelation(guestGroupRegisteredUserMemberRelation.getGuestGroupId(),guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放游客群绑定的群备注
    public int deleteGroupRemarkService(SqlSession session, GuestGroup guestGroup){
        GroupRemarkMapper groupRemarkMapper = session.getMapper(GroupRemarkMapper.class);
        int result = 0;
        try {

            result = groupRemarkMapper.deleteGroupRemarkByGroupId(guestGroup.getGroupId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放游客群绑定的群公共
    public int deleteGroupAnnouncementsService(SqlSession session, GuestGroup guestGroup){
        GroupAnnouncementsMapper groupAnnouncementsMapper = session.getMapper(GroupAnnouncementsMapper.class);
        int result = 0;
        try {

            result = groupAnnouncementsMapper.deleteGroupAnnouncements(guestGroup.getGroupId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放GuestGroup的 group id
    public int deleteGuestGroupByGroupIdService(SqlSession session, GuestGroup guestUserGroup){
        GuestGroupMapper guestUserGroupMapper = session.getMapper(GuestGroupMapper.class);
        GroupUsedBeautifulNumberMapper groupUsedBeautifulNumberMapper = session.getMapper(GroupUsedBeautifulNumberMapper.class);
        GroupUnusedBeautifulNumberMapper mapperbGroupUnusedBeautifulNumberMapper = session.getMapper(GroupUnusedBeautifulNumberMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumber = turnIntToObject(guestUserGroup.getGroupId());
        //
        int result = 0;
        try {
            result = guestUserGroupMapper.deleteGuestGroupByGroupId(guestUserGroup.getGroupId());
            result = groupUsedBeautifulNumberMapper.deleteGroupUsedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = mapperbGroupUnusedBeautifulNumberMapper.insertGroupUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放GuestGroupMember的 group member id-----游客群成员释放
    public int deleteGuestGroupMemberByGroupMemberIdService(SqlSession session, GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation){
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

    //需要释放RegisteredGroupMember的 group member id-----注册群成员释放
    public int deleteRegisteredGroupMemberByGroupMemberIdService(SqlSession session, GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation){
        GroupMemberUsedBeautifulNumberRealMapper groupUsedBeautifulNumberMapper = session.getMapper(GroupMemberUsedBeautifulNumberRealMapper.class);
        GroupMemberUnusedBeautifulNumberRealMapper mapperbGroupMemberUnusedBeautifulNumberMapper = session.getMapper(GroupMemberUnusedBeautifulNumberRealMapper.class);
        RegisteredGroupMemberMapper guestGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumber = turnIntToObject(guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
        //
        int result = 0;
        try {
            result = guestGroupMemberMapper.deleteRegisteredGroupMemberByGroupMemberId(guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            result = groupUsedBeautifulNumberMapper.deleteGroupMemberUsedBeautifulNumberReal(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = mapperbGroupMemberUnusedBeautifulNumberMapper.insertGroupMemberUnusedBeautifulNumberReal(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
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
