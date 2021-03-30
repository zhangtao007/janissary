package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.RpcGuestGroupMember;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.server.controller.GetGuestGroupBeautifulNumberId;
import com.lanjiu.im.grpc.server.controller.GetGuestGroupMemberBeautifulNumberId;
import com.lanjiu.im.grpc.server.controller.GetRegisteredGroupMemberBeautifulNumberId;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GuestGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(GuestGroupServiceAPI.class.getName());

    public List<AllGroupMemberVO> createGuestGroup(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        Integer grpOwnerId = rpcGuestGroup.getGuestUserId();//群主ID
        String grpMemberIds = rpcGuestGroup.getGroupName();//群成员ID集合
        String[] splitId = grpMemberIds.split(",");
        GetGuestGroupBeautifulNumberId getGuestGroupBeautifulNumberId = new GetGuestGroupBeautifulNumberId();
        GroupUnusedBeautifulNumber groupUnusedBeautifulNumber = getGuestGroupBeautifulNumberId.getGuestGroupId();
        int groupId = getGuestGroupBeautifulNumberId.getGuestGroupIntId();//游客群ID
//        Integer guestUserId = rpcGuestGroup.getGuestUserId();
        if((0 == grpOwnerId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_USER_ID_UNDEFAULT);
            return null;
        }
//        String groupName = rpcGuestGroup.getGroupName();
//        if(("".equals(groupName))||(null == groupName)){
//            groupName = ConstantsDefault.GROUP_NAME_DEFAULT;
//        }
        Integer groupAnnouncementId = groupId;//群公告ID，也是群主键ID
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Integer amount = rpcGuestGroup.getAmount();
        if((0 == amount)){
            amount = splitId.length+1;
        }
        GuestGroup guestGroup = new GuestGroup();//群主实体
        guestGroup.setGroupId(groupId);
        guestGroup.setGuestUserId(grpOwnerId);
        guestGroup.setGroupName(ConstantsDefault.GROUP_NAME_DEFAULT);
        guestGroup.setGroupAnnouncementId(groupAnnouncementId);
        guestGroup.setCreationTime(creationTime);
        guestGroup.setModificationTime(modificationTime);
        guestGroup.setAmount(amount);
        List<AllGroupMemberVO> allGroupMemberVOList = insertGroupId(session, groupUnusedBeautifulNumber, guestGroup, grpMemberIds);
//        boolean bResult = insertResultEntity.isbResult();
        if(null != allGroupMemberVOList && allGroupMemberVOList.size() > 0){
            //把memberId传输过去
//            guestGroup.setGroupAnnouncementId(insertResultEntity.getMemberId());
            return allGroupMemberVOList;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public List<AllGroupMemberVO> insertGroupId(SqlSession session, GroupUnusedBeautifulNumber groupUnusedBeautifulNumber, GuestGroup guestGroup, String grpMemberIds){
        GroupUsedBeautifulNumberMapper groupUsedBeautifulNumberMapper = session.getMapper(GroupUsedBeautifulNumberMapper.class);
        GroupUnusedBeautifulNumberMapper mapperbFriendUnusedBeautifulNumberMapper = session.getMapper(GroupUnusedBeautifulNumberMapper.class);
        GroupMemberUsedBeautifulNumberMapper groupMemberUsedBeautifulNumberMapper = session.getMapper(GroupMemberUsedBeautifulNumberMapper.class);
        GroupMemberUnusedBeautifulNumberMapper groupMemberUnusedBeautifulNumberMapper = session.getMapper(GroupMemberUnusedBeautifulNumberMapper.class);
        GroupAnnouncementsMapper groupAnnouncementsMapper = session.getMapper(GroupAnnouncementsMapper.class);
        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        GuestGroupMemberMapper guestGroupMemberMapper = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        GetRegisteredGroupMemberBeautifulNumberId getRegisteredGroupMemberBeautifulNumberId = new GetRegisteredGroupMemberBeautifulNumberId();
//        GuestGroupMember guestGroupMember = generateGroupMember(rpcGuestGroupMember, guestGroup);
//        GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation = generateGuestGroupGuestUserMemberRelation(guestGroupMember, guestGroup);
        GetGuestGroupMemberBeautifulNumberId getGuestGroupMemberBeautifulNumberId = new GetGuestGroupMemberBeautifulNumberId();
        GroupMemberUnusedBeautifulNumber groupMemberUnusedBeautifulNumber = getGuestGroupMemberBeautifulNumberId.getGuestGroupMemberId();
        String[] grpMemberIdsArr = grpMemberIds.split(",");
        String grpRemark = ConstantsDefault.GROUP_MEMBER_REMARK_DEFAULT;
        String groupMemberMasterNo = ConstantsDefault.GROUP_MEMBER_MASTER_NO;
        String burnAfterReadingSettingOff = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        String timeUnitSecond = ConstantsDefault.TIME_UNIT_SECOND;
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(0);
        Timestamp groupEntryTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String offlineMessageSettingOff = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        List<AllGroupMemberVO> allGroupMemberVOList = new ArrayList<>();
        AllGroupMemberVO allGroupMemberVOOwner = new AllGroupMemberVO();
        int result = 0;
        try {
            result = groupUsedBeautifulNumberMapper.insertGroupUsedBeautifulNumber(groupUnusedBeautifulNumber.getTenMillion(), groupUnusedBeautifulNumber.getOneMillion(),
                    groupUnusedBeautifulNumber.getOneHundredThousand(), groupUnusedBeautifulNumber.getTenThousand(),
                    groupUnusedBeautifulNumber.getOneThousand(), groupUnusedBeautifulNumber.getOneHundred(),
                    groupUnusedBeautifulNumber.getTen(), groupUnusedBeautifulNumber.getOne());
            result = mapperbFriendUnusedBeautifulNumberMapper.deleteGroupUnusedBeautifulNumber(groupUnusedBeautifulNumber.getTenMillion(), groupUnusedBeautifulNumber.getOneMillion(),
                    groupUnusedBeautifulNumber.getOneHundredThousand(), groupUnusedBeautifulNumber.getTenThousand(),
                    groupUnusedBeautifulNumber.getOneThousand(), groupUnusedBeautifulNumber.getOneHundred(),
                    groupUnusedBeautifulNumber.getTen(), groupUnusedBeautifulNumber.getOne());
            result = groupAnnouncementsMapper.insertGroupAnnouncements(guestGroup.getGroupAnnouncementId(), ConstantsDefault.GROUP_ANNOUNCEMENTS_TITLE, ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT);
            result = guestGroupMapper.insertGuestGroup(guestGroup.getGuestUserId(), guestGroup.getGroupId(),
                    guestGroup.getGroupName(), guestGroup.getGroupAnnouncementId(),
                    guestGroup.getCreationTime(), guestGroup.getModificationTime(), guestGroup.getAmount());
            //添加群主成员信息
            Integer groupOwnerId = getRegisteredGroupMemberBeautifulNumberId.getGuestGroupMemberId();
            result = guestGroupMemberMapper.insertGuestGroupMember(groupOwnerId, guestGroup.getGuestUserId(),
                    grpRemark, ConstantsDefault.GROUP_MEMBER_MASTER_YES,burnAfterReadingSettingOff, timeUnitSecond,
                    burnAfterReadingTimeLength, groupEntryTime, offlineMessageSettingOff);
            result = guestGroupGuestUserMemberRelationMapper.insertGuestGroupGuestUserMemberRelation(guestGroup.getGroupId(), groupOwnerId);
            allGroupMemberVOOwner.setGroupMemberId(groupOwnerId);
            allGroupMemberVOOwner.setGuestGroupId(guestGroup.getGroupId());
            allGroupMemberVOOwner.setGuestUserId(guestGroup.getGuestUserId());
            allGroupMemberVOOwner.setGroupRemarks(grpRemark);
            allGroupMemberVOOwner.setGroupOwner(ConstantsDefault.GROUP_MEMBER_MASTER_YES);
            allGroupMemberVOOwner.setGroupEntryTime(guestGroup.getCreationTime());
            allGroupMemberVOOwner.setAnnouncementContent(ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT);
            allGroupMemberVOOwner.setGroupName(guestGroup.getGroupName());
            allGroupMemberVOOwner.setAmount(guestGroup.getAmount());
            allGroupMemberVOList.add(allGroupMemberVOOwner);

            //添加群成员信息
            for(String grpMemberId : grpMemberIdsArr){
                AllGroupMemberVO allGroupMemberVO = new AllGroupMemberVO();
                Integer groupMemberId = getRegisteredGroupMemberBeautifulNumberId.getRegisterGroupMemberId();
                result = guestGroupMemberMapper.insertGuestGroupMember(groupMemberId, Integer.valueOf(grpMemberId), grpRemark,
                        groupMemberMasterNo, burnAfterReadingSettingOff, timeUnitSecond, burnAfterReadingTimeLength, groupEntryTime, offlineMessageSettingOff);
                //添加群成员与群关系信息
                result = guestGroupGuestUserMemberRelationMapper.insertGuestGroupGuestUserMemberRelation(guestGroup.getGroupId(), groupMemberId);
                allGroupMemberVO.setGroupMemberId(groupMemberId);
                allGroupMemberVO.setGuestGroupId(guestGroup.getGroupId());
                allGroupMemberVO.setGuestUserId(Integer.valueOf(grpMemberId));
                allGroupMemberVO.setGroupRemarks(grpRemark);
                allGroupMemberVO.setGroupOwner(ConstantsDefault.GROUP_MEMBER_MASTER_NO);
                allGroupMemberVO.setGroupEntryTime(guestGroup.getCreationTime());
                allGroupMemberVO.setAnnouncementContent(ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT);
                allGroupMemberVO.setGroupName(guestGroup.getGroupName());
                allGroupMemberVO.setAmount(guestGroup.getAmount());
                allGroupMemberVOList.add(allGroupMemberVO);
            }

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
//        InsertResultEntity insertResultEntity = new InsertResultEntity();
//        insertResultEntity.setMemberId(guestGroupMember.getGroupMemberId());
        if(result > 0){
//            insertResultEntity.setbResult(true);
            return allGroupMemberVOList;
        }else {
//            insertResultEntity.setbResult(false);
            return null;
        }
    }

    public GuestGroupMember generateGroupMember(RpcGuestGroupMember rpcGuestGroupMember, GuestGroup guestGroup){
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        GetGuestGroupMemberBeautifulNumberId getGuestGroupMemberBeautifulNumberId = new GetGuestGroupMemberBeautifulNumberId();
        Integer groupMemberId = getGuestGroupMemberBeautifulNumberId.getGuestGroupMemberIntId();
        Integer guestUserId = guestGroup.getGuestUserId();
        String groupRemarks = ConstantsDefault.GROUP_MEMBER_REMARK_DEFAULT;
        String groupOwner = ConstantsDefault.GROUP_MEMBER_MASTER_YES;
        String burnAfterReadingSettings = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        String burnAfterReadingTimeUnit = rpcGuestGroupMember.getBurnAfterReadingTimeUnit();
        if(("".equals(burnAfterReadingTimeUnit))||(null == burnAfterReadingTimeUnit)){
            burnAfterReadingTimeUnit = ConstantsDefault.TIME_UNIT_SECOND;
        }
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(0);
        Timestamp groupEntryTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String offlineMessageSetting = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        guestGroupMember.setGroupRemarks(groupRemarks);
        guestGroupMember.setGroupOwner(groupOwner);
        guestGroupMember.setGroupMemberId(groupMemberId);
        guestGroupMember.setGroupEntryTime(groupEntryTime);
        guestGroupMember.setBurnAfterReadingSettings(burnAfterReadingSettings);
        guestGroupMember.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        guestGroupMember.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        guestGroupMember.setOfflineMessageSetting(offlineMessageSetting);
        guestGroupMember.setGuestUserId(guestUserId);
        return guestGroupMember;
    }

    public GuestGroupGuestUserMemberRelation generateGuestGroupGuestUserMemberRelation(GuestGroupMember guestGroupMember, GuestGroup guestGroup){
        GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation = new GuestGroupGuestUserMemberRelation();
        Integer guestGroupId = guestGroup.getGroupId();
        Integer guestUserMemberId = guestGroupMember.getGroupMemberId();
        guestGroupGuestUserMemberRelation.setGuestUserMemberId(guestUserMemberId);
        guestGroupGuestUserMemberRelation.setGuestGroupId(guestGroupId);
        return guestGroupGuestUserMemberRelation;
    }
}
