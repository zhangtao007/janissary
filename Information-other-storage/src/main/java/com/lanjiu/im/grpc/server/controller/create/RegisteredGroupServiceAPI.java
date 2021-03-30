package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.communication.client.login_regist.login_storageAPI.RegistUserAPI;
import com.lanjiu.im.file.fileTransferAPI.FileStorageAPI;
import com.lanjiu.im.grpc.RpcRegisteredGroup;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.server.controller.GetRegisteredGroupMemberBeautifulNumberId;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import com.lanjiu.pro.fileStorage.GroupAvatarRequest;
import com.lanjiu.pro.fileStorage.GroupAvatarResponse;
import com.lanjiu.pro.login.RegisterUser;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisteredGroupServiceAPI {

    private static final Logger logger = Logger.getLogger(RegisteredGroupServiceAPI.class.getName());

    public List<AllGroupMemberVO> createRegisteredGroup(TransmissionRequest request) throws Exception {
        SqlSession session = DBTools.getSession();
        GroupUnusedBeautifulNumberRealMapper numberRealMapper = session.getMapper(GroupUnusedBeautifulNumberRealMapper.class);
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        Integer grpOwnerId = rpcRegisteredGroup.getRegisteredUserId();//群主ID
        String grpMemberIds = rpcRegisteredGroup.getGroupName();
        String[] splitId = grpMemberIds.split(",");//群成员ID集合
        String groupOwnerName = request.getRequestKind();//群主昵称

        List<GroupUnusedBeautifulNumberReal> numberReals = null;
        try {
            numberReals = numberRealMapper.selectOnlyGroupUnusedBeautifulNumberReal();
        } catch (Exception e) {
            logger.info("从号库获取群id错误",e);
            e.printStackTrace();
            return null;
        }

        int groupIdByNumberReal = this.getRegisteredGroupIdByNumberReal(numberReals.get(0));
        logger.info("群主ID："+grpOwnerId+"--群主昵称："+groupOwnerName+"--群成员ID集合："+grpMemberIds+"--生产群ID："+groupIdByNumberReal);

        FileStorageAPI fileStorageAPI = new FileStorageAPI();
        RegistUserAPI registUserAPI = new RegistUserAPI();
        RequestUser userInfo;
        ResponseUser responseUser;
        List<RegisterUser> registerUserListInfo;
        List<String> photoList = new ArrayList<>();
        List<String> idList = new ArrayList<>();
        String groupName = "";
        RequestUser grpOwner = RequestUser.newBuilder().setArgs("SEARCH_USER").setRegisterUser(RegisterUser.newBuilder()
                .setUserId(String.valueOf(grpOwnerId)).build()).build();
        ResponseUser responseOwner = registUserAPI.selectUserInfomation(grpOwner);
        photoList.add(responseOwner.getRegisterUserList().get(0).getUserInfomation().getAvatar());
        groupName += responseOwner.getRegisterUserList().get(0).getUserInfomation().getNickname()+"、";
        for (int i = 0; i < splitId.length; i++) {
            if(i == splitId.length-1){
                userInfo = RequestUser.newBuilder().setArgs("SEARCH_USER").setRegisterUser(RegisterUser.newBuilder()
                        .setUserId(splitId[i]).build()).build();
                try {
                    responseUser = registUserAPI.selectUserInfomation(userInfo);
                    registerUserListInfo = responseUser.getRegisterUserList();
                    if (null != registerUserListInfo && registerUserListInfo.size()>0) {
                        groupName += registerUserListInfo.get(0).getUserInfomation().getNickname();
                        photoList.add(registerUserListInfo.get(0).getUserInfomation().getAvatar());
                        idList.add(splitId[i]);
                    }
                } catch (Exception e) {
                    logger.error("查询用户信息时调用登录服务异常",e);
                    e.printStackTrace();
                    return null;
                }

            }else {
                userInfo = RequestUser.newBuilder().setArgs("SEARCH_USER").setRegisterUser(RegisterUser.newBuilder()
                        .setUserId(splitId[i]).build()).build();
                try {
                    responseUser = registUserAPI.selectUserInfomation(userInfo);
                    registerUserListInfo = responseUser.getRegisterUserList();
                    if (null != registerUserListInfo && registerUserListInfo.size()>0) {
                        groupName += registerUserListInfo.get(0).getUserInfomation().getNickname()+"、";
                        photoList.add(registerUserListInfo.get(0).getUserInfomation().getAvatar());
                        idList.add(splitId[i]);
                    }
                } catch (Exception e) {
                    logger.error("查询用户信息时调用登录服务异常",e);
                    e.printStackTrace();
                    return null;
                }
            }
        }
        String groupUrl = "";
        //合成群头像
        if (photoList.size()>9){
            GroupAvatarRequest avatarRequest = GroupAvatarRequest.newBuilder()
                                                .setGroupId(String.valueOf(groupIdByNumberReal))
                                                .setNum(String.valueOf(splitId.length+1))
                                                .addAllAvatarUrl(photoList.subList(0,9)).build();
            logger.info("1获取群头像合成的群ID："+groupIdByNumberReal+"---获取群头像的成员ID集合--"+idList.subList(0,9).toString()+"---"+new Date());
            GroupAvatarResponse groupAvatarResponse = fileStorageAPI.groupMergerPhoto(avatarRequest);
            groupUrl += groupAvatarResponse.getGroupAvatar();
            logger.info("返回群头像url："+groupAvatarResponse.getGroupAvatar()+"---"+new Date());
        }else {
            GroupAvatarRequest avatarRequest = GroupAvatarRequest.newBuilder()
                    .setGroupId(String.valueOf(groupIdByNumberReal))
                    .setNum(String.valueOf(splitId.length+1))
                    .addAllAvatarUrl(photoList).build();
            logger.info("2获取群头像合成的群ID："+groupIdByNumberReal+"---获取群头像的成员ID集合--"+idList.toString()+"---"+new Date());
            GroupAvatarResponse groupAvatarResponse = fileStorageAPI.groupMergerPhoto(avatarRequest);
            groupUrl += groupAvatarResponse.getGroupAvatar();
            logger.info("返回群头像url："+groupAvatarResponse.getGroupAvatar()+"---"+new Date());
        }

        Integer groupAnnouncementId = groupIdByNumberReal;//群公告ID，也是群主键ID
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));

        RegisteredGroup registeredGroup = new RegisteredGroup();//群主实体
        registeredGroup.setGroupId(groupIdByNumberReal);
        registeredGroup.setRegisteredUserId(grpOwnerId);
        registeredGroup.setGroupName(groupName);
        registeredGroup.setGroupAnnouncementId(groupAnnouncementId);
        registeredGroup.setCreationTime(creationTime);
        registeredGroup.setModificationTime(modificationTime);
        registeredGroup.setAmount(splitId.length+1);
        registeredGroup.setGroupPhotoUrl(groupUrl);
        registeredGroup.setGroupPhotoUserIdList(grpOwnerId+","+grpMemberIds);

        List<AllGroupMemberVO> allGroupMemberVOList = insertGroup(session, numberReals.get(0), registeredGroup, grpMemberIds,grpOwnerId,groupOwnerName);

        if(null != allGroupMemberVOList && allGroupMemberVOList.size() > 0){
            return allGroupMemberVOList;
        }else {
            logger.info("---创建注册群失败---"+ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }


    public List<AllGroupMemberVO> insertGroup(SqlSession session, GroupUnusedBeautifulNumberReal groupUnusedBeautifulNumberReal, RegisteredGroup registeredGroup, String grpMemberIds,int grpOwnerId,String groupOwnerName){
        GroupUsedBeautifulNumberRealMapper groupUsedBeautifulNumberRealMapper = session.getMapper(GroupUsedBeautifulNumberRealMapper.class);
        GroupUnusedBeautifulNumberRealMapper mapperbFriendUnusedBeautifulNumberRealMapper = session.getMapper(GroupUnusedBeautifulNumberRealMapper.class);
//        GroupMemberUsedBeautifulNumberRealMapper groupMemberUsedBeautifulNumberRealMapper = session.getMapper(GroupMemberUsedBeautifulNumberRealMapper.class);
//        GroupMemberUnusedBeautifulNumberRealMapper groupMemberUnusedBeautifulNumberRealMapper = session.getMapper(GroupMemberUnusedBeautifulNumberRealMapper.class);
//        RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        GroupAnnouncementsMapper groupAnnouncementsMapper = session.getMapper(GroupAnnouncementsMapper.class);
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        RegisteredGroupMemberMapper registeredGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupRegisteredUserMemberRelationMapper registeredGroupRegisteredUserMemberRelationMapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        GetRegisteredGroupMemberBeautifulNumberId getRegisteredGroupMemberBeautifulNumberId = new GetRegisteredGroupMemberBeautifulNumberId();
//        GroupMemberUnusedBeautifulNumberReal groupMemberUnusedBeautifulNumberReal = getRegisteredGroupMemberBeautifulNumberId.getRegisteredGroupMemberId();
//        RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation = generateRegisteredGroupRegisteredUserMemberRelation(grpMemberIds, registeredGroup);
//        String OwnerId = String.valueOf(grpOwnerId);
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

        //群主的user_id_and_name（好友id+昵称）
//        String userIdAndName = queryOtherNickName(grpMemberIdsArr,grpOwnerId, registeredUserFriendMapper,groupOwnerName);

        int result = 0;
        try {
            result = groupUsedBeautifulNumberRealMapper.insertGroupUsedBeautifulNumberReal(groupUnusedBeautifulNumberReal.getTenMillion(), groupUnusedBeautifulNumberReal.getOneMillion(),
                    groupUnusedBeautifulNumberReal.getOneHundredThousand(), groupUnusedBeautifulNumberReal.getTenThousand(),
                    groupUnusedBeautifulNumberReal.getOneThousand(), groupUnusedBeautifulNumberReal.getOneHundred(),
                    groupUnusedBeautifulNumberReal.getTen(), groupUnusedBeautifulNumberReal.getOne());
            result = mapperbFriendUnusedBeautifulNumberRealMapper.deleteGroupUnusedBeautifulNumberReal(groupUnusedBeautifulNumberReal.getTenMillion(), groupUnusedBeautifulNumberReal.getOneMillion(),
                    groupUnusedBeautifulNumberReal.getOneHundredThousand(), groupUnusedBeautifulNumberReal.getTenThousand(),
                    groupUnusedBeautifulNumberReal.getOneThousand(), groupUnusedBeautifulNumberReal.getOneHundred(),
                    groupUnusedBeautifulNumberReal.getTen(), groupUnusedBeautifulNumberReal.getOne());

            result = groupAnnouncementsMapper.insertGroupAnnouncements(registeredGroup.getGroupAnnouncementId(), ConstantsDefault.GROUP_ANNOUNCEMENTS_TITLE, ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT);
            result = registeredGroupMapper.insertRegisteredGroup(registeredGroup.getRegisteredUserId(), registeredGroup.getGroupId(),registeredGroup.getGroupName(),
                                                 registeredGroup.getGroupAnnouncementId(), registeredGroup.getCreationTime(), registeredGroup.getModificationTime(),
                                                 registeredGroup.getAmount(),registeredGroup.getGroupPhotoUrl(),registeredGroup.getGroupPhotoUserIdList());
            //添加群主成员信息
            Integer groupOwnerId = getRegisteredGroupMemberBeautifulNumberId.getRegisterGroupMemberId();//群主memberId
            try {
                result = registeredGroupMemberMapper.insertRegisteredGroupMember(groupOwnerId, registeredGroup.getRegisteredUserId(),"",
                        grpRemark, ConstantsDefault.GROUP_MEMBER_MASTER_YES, burnAfterReadingSettingOff, timeUnitSecond,
                        burnAfterReadingTimeLength, groupEntryTime, offlineMessageSettingOff);
            } catch (Exception e) {
                logger.error("插入群成员表时错误",e);
                e.printStackTrace();
                return null;
            }
            result = registeredGroupRegisteredUserMemberRelationMapper.insertRegisteredGroupRegisteredUserMemberRelation(registeredGroup.getGroupId(), groupOwnerId);
            allGroupMemberVOOwner.setGroupMemberId(groupOwnerId);
            allGroupMemberVOOwner.setRegisteredGroupId(registeredGroup.getGroupId());
            allGroupMemberVOOwner.setRegisteredUserId(registeredGroup.getRegisteredUserId());
            allGroupMemberVOOwner.setAnnouncementTitle(registeredGroup.getGroupPhotoUrl());
            allGroupMemberVOOwner.setGroupRemarks(grpRemark);
            allGroupMemberVOOwner.setGroupOwner(ConstantsDefault.GROUP_MEMBER_MASTER_YES);
            allGroupMemberVOOwner.setGroupEntryTime(registeredGroup.getCreationTime());
            allGroupMemberVOOwner.setAnnouncementContent(ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT);
            allGroupMemberVOOwner.setGroupName(registeredGroup.getGroupName());
            allGroupMemberVOOwner.setAmount(registeredGroup.getAmount());
            allGroupMemberVOList.add(allGroupMemberVOOwner);


            /**
             * 循环插入数据库修改批量插入
             */
            List<RegisteredGroupMember> memberList = new ArrayList<>();
            List<RegisteredGroupRegisteredUserMemberRelation> memRelaList = new ArrayList<>();
            //添加群成员信息
            for(String grpMemberId : grpMemberIdsArr){
                //从号码库获取群成员id（主键）
                Integer groupMemberId = getRegisteredGroupMemberBeautifulNumberId.getRegisterGroupMemberId();
//                result = registeredGroupMemberMapper.insertRegisteredGroupMember(groupMemberId, Integer.valueOf(grpMemberId),null, grpRemark,
//                            groupMemberMasterNo, burnAfterReadingSettingOff, timeUnitSecond,
//                            burnAfterReadingTimeLength, groupEntryTime, offlineMessageSettingOff);
//                //添加群成员与群关系信息
//                result = registeredGroupRegisteredUserMemberRelationMapper.insertRegisteredGroupRegisteredUserMemberRelation(registeredGroup.getGroupId(), groupMemberId);

                //###############################################
                RegisteredGroupMember  groupMember = new RegisteredGroupMember();
                groupMember.setGroupMemberId(groupMemberId);
                groupMember.setRegisteredUserId(Integer.valueOf(grpMemberId));
                groupMember.setUserIdAndName(null);
                groupMember.setGroupRemarks(grpRemark);
                groupMember.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
                groupMember.setBurnAfterReadingSettings(burnAfterReadingSettingOff);
                groupMember.setBurnAfterReadingTimeUnit(timeUnitSecond);
                groupMember.setGroupOwner(groupMemberMasterNo);
                groupMember.setGroupEntryTime(groupEntryTime);
                groupMember.setOfflineMessageSetting(offlineMessageSettingOff);
                memberList.add(groupMember);
                //#################################################
                RegisteredGroupRegisteredUserMemberRelation  gmRelation = new RegisteredGroupRegisteredUserMemberRelation();
                gmRelation.setRegisteredGroupId(registeredGroup.getGroupId());
                gmRelation.setRegisteredUserMemberId(groupMemberId);
                memRelaList.add(gmRelation);

                //####################################################



                AllGroupMemberVO allGroupMemberVO = new AllGroupMemberVO();
                allGroupMemberVO.setGroupMemberId(groupMemberId);
                allGroupMemberVO.setRegisteredGroupId(registeredGroup.getGroupId());
                allGroupMemberVO.setRegisteredUserId(Integer.valueOf(grpMemberId));
                allGroupMemberVO.setAnnouncementTitle(registeredGroup.getGroupPhotoUrl());
                allGroupMemberVO.setGroupRemarks(grpRemark);
                allGroupMemberVO.setGroupOwner(ConstantsDefault.GROUP_MEMBER_MASTER_NO);
                allGroupMemberVO.setGroupEntryTime(registeredGroup.getCreationTime());
                allGroupMemberVO.setAnnouncementContent(ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT);
                allGroupMemberVO.setGroupName(registeredGroup.getGroupName());
                allGroupMemberVO.setAmount(registeredGroup.getAmount());
                allGroupMemberVOList.add(allGroupMemberVO);
            }

            //执行批量插入
            int res = registeredGroupMemberMapper.insertGroupMemberOfBatch(memberList);
            int rest = registeredGroupRegisteredUserMemberRelationMapper.insertGroupMemberRelationOfBatch(memRelaList);
            if(res<0 || rest <0){
                logger.error("批量插入群成员错误&&&&&&&&&&&&&&&&&&&&&&");
                return null;
            }
            session.commit();
            session.close();
        } catch (Exception e) {
            logger.error("insertGroup()方法中操作数据库连接时异常",e);
            e.printStackTrace();
            session.rollback();
            session.close();
            return null;
        }
        if(result > 0){
            return allGroupMemberVOList;
        }else {
            return null;
        }
    }

    public int getRegisteredGroupIdByNumberReal(GroupUnusedBeautifulNumberReal numberReal){
        String groupId = String.valueOf(numberReal.getTenMillion())+numberReal.getOneMillion()
                +numberReal.getOneHundredThousand()+numberReal.getTenThousand()
                +numberReal.getOneThousand()+numberReal.getOneHundred()+numberReal.getTen()+numberReal.getOne();
        return Integer.parseInt(groupId);
    }

    /**
     *返回群成员其他人的昵称或备注；
     * @param grpMemberIdsArr
     * @param registeredUserFriendMapper
     */
    private String queryOtherNickName(String[] grpMemberIdsArr,Integer groupOwnerId, RegisteredUserFriendMapper registeredUserFriendMapper,String groupOwnerName) {
        String othernick="";
        List<RegisteredUserFriend> registFriends;
        StringBuffer buffer = new StringBuffer();
        for (String mid: grpMemberIdsArr){
                try {
                    registFriends = registeredUserFriendMapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(groupOwnerId,Integer.parseInt(mid));
                    if(registFriends.size() >0){
                        othernick = (registFriends.get(0).getFriendComment().equals("") || null == registFriends.get(0).getFriendComment())?
                                registFriends.get(0).getFriendNickName() : registFriends.get(0).getFriendComment();
                        buffer.append(mid);
                        buffer.append("-");
                        buffer.append(othernick);
                        buffer.append(",");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        buffer.append(groupOwnerId+"-"+groupOwnerName);
        return buffer.toString();
    }

}
