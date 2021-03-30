package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.RpcRegisteredGroup;
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

public class DeleteRegisteredGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(DeleteRegisteredGroupServiceAPI.class.getName());

    public RegisteredGroup deleteRegisteredGroup(RpcRegisteredGroup rpcRegisteredGroup, String kind){
        SqlSession session = DBTools.getSession();
        int groupId = rpcRegisteredGroup.getGroupId();
        if(ConstantsSelectKind.GROUP_DELETE_TYPE_BY_GROUP_ID.equals(kind)){
            if(groupId == 0){
                logger.info(ConstantsPrompt.GROUP_ID_UNDEFAULT_DELETE);
                return null;
            }
        }
        Integer guestUserId = rpcRegisteredGroup.getRegisteredUserId();
        String groupName = rpcRegisteredGroup.getGroupName();
        Integer groupAnnouncementId = groupId;
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Integer amount = rpcRegisteredGroup.getAmount();
        RegisteredGroup guestGroup = new RegisteredGroup();
        guestGroup.setGroupId(groupId);
        guestGroup.setGroupAnnouncementId(groupAnnouncementId);
        guestGroup.setRegisteredUserId(guestUserId);
        guestGroup.setAmount(amount);
        guestGroup.setCreationTime(creationTime);
        guestGroup.setModificationTime(modificationTime);
        guestGroup.setGroupName(groupName);

        boolean bResult = deleteRegisteredGroupService(session, guestGroup, kind);
        if(bResult){
            return guestGroup;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean deleteRegisteredGroupService(SqlSession session, RegisteredGroup guestGroup, String kind){

        int result = 0;
        try {
            if(ConstantsSelectKind.GROUP_DELETE_TYPE_BY_GROUP_ID.equals(kind)){
                //删除注册群即释放注册群id  3个表
                result = deleteRegisteredGroupByGroupIdService(session, guestGroup);
                //删除注册群关联的游客群成员以及释放游客群成员id  4个表
                result = deleteRegisteredGroupGuestUserMemberRelationService(session, guestGroup);
                //删除注册群关联的注册群成员以及释放注册群成员id  4个表
                result = deleteRegisteredGroupRegisteredUserMemberRelationService(session, guestGroup);
                //删除注册群关联的公告  1个表
                result = deleteGroupAnnouncementsService(session, guestGroup);
                ///删除注册群关联的群备注表中的记录GroupRemark 1个表
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

    //释放游客群成员和注册群的关系
    public int deleteRegisteredGroupGuestUserMemberRelationService(SqlSession session, RegisteredGroup guestGroup){
        RegisteredGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(RegisteredGroupGuestUserMemberRelationMapper.class);
        List<RegisteredGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupGuestUserMemberRelationList = guestGroupGuestUserMemberRelationMapper.selectRegisteredGroupGuestUserMemberRelationByRegisteredGroupId(guestGroup.getGroupId());
            for (RegisteredGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation : guestGroupGuestUserMemberRelationList){
                result = deleteGuestGroupMemberByGroupMemberIdService(session, guestGroupGuestUserMemberRelation);
                guestGroupGuestUserMemberRelationMapper.deleteRegisteredGroupGuestUserMemberRelation(guestGroupGuestUserMemberRelation.getRegisteredGroupId(), guestGroupGuestUserMemberRelation.getGuestUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放注册群成员和注册群的关系
    public int deleteRegisteredGroupRegisteredUserMemberRelationService(SqlSession session, RegisteredGroup guestGroup){
        RegisteredGroupRegisteredUserMemberRelationMapper guestGroupRegisteredUserMemberRelationMapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        List<RegisteredGroupRegisteredUserMemberRelation> guestGroupRegisteredUserMemberRelationList = null;
        //
        int result = 0;
        try {
            guestGroupRegisteredUserMemberRelationList = guestGroupRegisteredUserMemberRelationMapper.selectRegisteredGroupRegisteredUserMemberRelationByRegisteredGroupId(guestGroup.getGroupId());
            for (RegisteredGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation : guestGroupRegisteredUserMemberRelationList){
                result = deleteRegisteredGroupMemberByGroupMemberIdService(session, guestGroupRegisteredUserMemberRelation);
                guestGroupRegisteredUserMemberRelationMapper.deleteRegisteredGroupRegisteredUserMemberRelation(guestGroupRegisteredUserMemberRelation.getRegisteredGroupId(),guestGroupRegisteredUserMemberRelation.getRegisteredUserMemberId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放注册群绑定的群备注
    public int deleteGroupRemarkService(SqlSession session, RegisteredGroup guestGroup){
        GroupRemarkMapper groupRemarkMapper = session.getMapper(GroupRemarkMapper.class);
        int result = 0;
        try {

            result = groupRemarkMapper.deleteGroupRemarkByGroupId(guestGroup.getGroupId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //释放注册群绑定的群公共
    public int deleteGroupAnnouncementsService(SqlSession session, RegisteredGroup guestGroup){
        GroupAnnouncementsMapper groupAnnouncementsMapper = session.getMapper(GroupAnnouncementsMapper.class);
        int result = 0;
        try {

            result = groupAnnouncementsMapper.deleteGroupAnnouncements(guestGroup.getGroupId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放RegisteredGroup的 group id
    public int deleteRegisteredGroupByGroupIdService(SqlSession session, RegisteredGroup guestUserGroup){
        RegisteredGroupMapper guestUserGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        GroupUsedBeautifulNumberRealMapper groupUsedBeautifulNumberRealMapper = session.getMapper(GroupUsedBeautifulNumberRealMapper.class);
        GroupUnusedBeautifulNumberRealMapper mapperbGroupUnusedBeautifulNumberRealMapper = session.getMapper(GroupUnusedBeautifulNumberRealMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumberReal = turnIntToObject(guestUserGroup.getGroupId());
        //
        int result = 0;
        try {
            result = guestUserGroupMapper.deleteRegisteredGroupByGroupId(guestUserGroup.getGroupId());
            result = groupUsedBeautifulNumberRealMapper.deleteGroupUsedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(),
                    friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
            result = mapperbGroupUnusedBeautifulNumberRealMapper.insertGroupUnusedBeautifulNumberReal(friendUnusedBeautifulNumberReal.getTenMillion(), friendUnusedBeautifulNumberReal.getOneMillion(),
                    friendUnusedBeautifulNumberReal.getOneHundredThousand(), friendUnusedBeautifulNumberReal.getTenThousand(),
                    friendUnusedBeautifulNumberReal.getOneThousand(), friendUnusedBeautifulNumberReal.getOneHundred(),
                    friendUnusedBeautifulNumberReal.getTen(), friendUnusedBeautifulNumberReal.getOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //需要释放GuestGroupMember的 group member id-----游客群成员释放
    public int deleteGuestGroupMemberByGroupMemberIdService(SqlSession session, RegisteredGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation){
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
    public int deleteRegisteredGroupMemberByGroupMemberIdService(SqlSession session, RegisteredGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation){
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
