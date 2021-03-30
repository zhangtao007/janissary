package com.lanjiu.im.grpc.server.controller.insert;

import com.lanjiu.im.communication.client.login_regist.login_storageAPI.RegistUserAPI;
import com.lanjiu.im.file.fileTransferAPI.FileStorageAPI;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.server.controller.GetRegisteredGroupMemberBeautifulNumberId;
import com.lanjiu.im.grpc.util.ConstantsDefault;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertGroupMemberServiceAPI {

    private static final Logger logger = Logger.getLogger(InsertGroupMemberServiceAPI.class.getName());

    public List<com.lanjiu.im.grpc.AllGroupMemberVO> insertInviteUsersJoinGroup(int groupId, String[] memberIds, Integer fromId){
        logger.info("邀请入群群ID："+groupId+"---入群用户ID集合："+ Arrays.toString(memberIds)+"---发起人："+fromId);
        SqlSession session = DBTools.getSession();
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        RegisteredGroupMemberMapper registeredGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        GetRegisteredGroupMemberBeautifulNumberId getRegisteredGroupMemberBeautifulNumberId = new GetRegisteredGroupMemberBeautifulNumberId();
        RegisteredGroupRegisteredUserMemberRelationMapper regRelMapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
//        RegisteredUserFriendMapper userFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        String grpRemark = ConstantsDefault.GROUP_MEMBER_REMARK_DEFAULT;
        String groupOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;
        String burnAfterReadingSettingOff = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        String timeUnitSecond = ConstantsDefault.TIME_UNIT_SECOND;
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(0);
        Timestamp groupEntryTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String offlineMessageSettingOff = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupMemberVOList = new ArrayList<>();
        try {
            RegisteredGroup registeredGroup = registeredGroupMapper.getRegisteredGroupByGroupId(groupId);
            String[] ids = registeredGroup.getGroupPhotoUserIdList().split(",");
            List<String> list = new ArrayList<>();//原
            Collections.addAll(list, ids);
            List<String> list1 = new ArrayList<>();//加
            Collections.addAll(list1, memberIds);
            int groupAmount = registeredGroup.getAmount()+list1.size();
            if (list.size()<9){
                RegistUserAPI registUserAPI = new RegistUserAPI();
                FileStorageAPI fileStorageAPI = new FileStorageAPI();
                RequestUser userInfo;
                ResponseUser responseUser;
                List<RegisterUser> registerUserListInfo;
                List<String> photoList = new ArrayList<>();
                for (String s : list1) {
                    if (list.size() == 9){
                        break;
                    }else {
                        list.add(s);
                    }
                }
//                String groupName = "";
                for (int i = 0; i < list.size(); i++) {
                    if(i == list.size()-1){
                        userInfo = RequestUser.newBuilder().setArgs("SEARCH_USER").setRegisterUser(RegisterUser.newBuilder()
                                .setUserId(list.get(i)).build()).build();
                        responseUser = registUserAPI.selectUserInfomation(userInfo);
                        registerUserListInfo = responseUser.getRegisterUserList();
                        if (null != registerUserListInfo && registerUserListInfo.size()>0) {
//                            groupName += registerUserListInfo.get(0).getUserInfomation().getNickname();
                            photoList.add(registerUserListInfo.get(0).getUserInfomation().getAvatar());
                        }
                    }else {
                        userInfo = RequestUser.newBuilder().setArgs("SEARCH_USER").setRegisterUser(RegisterUser.newBuilder()
                                .setUserId(list.get(i)).build()).build();
                        responseUser = registUserAPI.selectUserInfomation(userInfo);
                        registerUserListInfo = responseUser.getRegisterUserList();
                        if (null != registerUserListInfo && registerUserListInfo.size()>0) {
//                            groupName += registerUserListInfo.get(0).getUserInfomation().getNickname()+"、";
                            photoList.add(registerUserListInfo.get(0).getUserInfomation().getAvatar());
                        }
                    }
                }
                GroupAvatarRequest avatarRequest = GroupAvatarRequest.newBuilder()
                        .setGroupId(String.valueOf(groupId))
                        .setNum(String.valueOf(groupAmount))
                        .addAllAvatarUrl(photoList).build();
                logger.info("群主邀请入群或者申请入群新合成群头像用户ID集合："+list.toString()+"---群ID："+groupId);
                long startTime=System.currentTimeMillis();
                GroupAvatarResponse groupAvatarResponse = fileStorageAPI.groupMergerPhoto(avatarRequest);
                long endTime=System.currentTimeMillis();
                logger.info("群主邀请入群或者申请入群新合成群头像接口耗时："+(endTime - startTime));
                logger.info("返回群头像新url："+groupAvatarResponse.getGroupAvatar());
                String userIdList = String.join(",",list);
                String groupUrl = groupAvatarResponse.getGroupAvatar();
                for (String id : list1) {
                    Integer registeredGroupMemberId = getRegisteredGroupMemberBeautifulNumberId.getRegisterGroupMemberId();
                    Integer registerUserId = Integer.valueOf(id);
                    com.lanjiu.im.grpc.AllGroupMemberVO allGroupMemberVO;
                    registeredGroupMemberMapper.insertRegisteredGroupMember(registeredGroupMemberId,registerUserId,null,grpRemark,groupOwner,burnAfterReadingSettingOff,
                            timeUnitSecond,burnAfterReadingTimeLength,groupEntryTime,offlineMessageSettingOff);
                    regRelMapper.insertRegisteredGroupRegisteredUserMemberRelation(groupId,registeredGroupMemberId);
                    allGroupMemberVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder().setRegisteredGroupId(groupId)
                            .setGroupMemberId(registeredGroupMemberId)
                            .setUserPhoto(groupUrl)
                            .setRegisteredUserId(registerUserId).build();
                    allGroupMemberVOList.add(allGroupMemberVO);
                }
                registeredGroupMapper.updateRegisteredGroup(groupId,registeredGroup.getRegisteredUserId(),registeredGroup.getGroupName(),registeredGroup.getGroupAnnouncementId(),
                                        registeredGroup.getCreationTime(),groupEntryTime,groupAmount,groupUrl,userIdList);
                session.commit();
            }else {
                for (String id : list1) {
                    Integer registeredGroupMemberId = getRegisteredGroupMemberBeautifulNumberId.getRegisterGroupMemberId();
                    Integer registerUserId = Integer.valueOf(id);
                    com.lanjiu.im.grpc.AllGroupMemberVO allGroupMemberVO;
                    registeredGroupMemberMapper.insertRegisteredGroupMember(registeredGroupMemberId,registerUserId,null,grpRemark,groupOwner,burnAfterReadingSettingOff,
                            timeUnitSecond,burnAfterReadingTimeLength,groupEntryTime,offlineMessageSettingOff);
                    regRelMapper.insertRegisteredGroupRegisteredUserMemberRelation(groupId,registeredGroupMemberId);
                    allGroupMemberVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder().setRegisteredGroupId(groupId)
                            .setGroupMemberId(registeredGroupMemberId)
                            .setUserPhoto(registeredGroup.getGroupPhotoUrl())
                            .setRegisteredUserId(registerUserId).build();
                    allGroupMemberVOList.add(allGroupMemberVO);
                }
                registeredGroupMapper.updateRegisteredGroup(groupId,registeredGroup.getRegisteredUserId(),registeredGroup.getGroupName(),registeredGroup.getGroupAnnouncementId(),
                        registeredGroup.getCreationTime(),groupEntryTime,groupAmount,registeredGroup.getGroupPhotoUrl(),registeredGroup.getGroupPhotoUserIdList());
                session.commit();
                session.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return allGroupMemberVOList;
    }

}
