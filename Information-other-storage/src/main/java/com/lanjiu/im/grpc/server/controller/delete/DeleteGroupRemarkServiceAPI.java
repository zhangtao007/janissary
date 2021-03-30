package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.communication.client.login_regist.login_storageAPI.RegistUserAPI;
import com.lanjiu.im.file.fileTransferAPI.FileStorageAPI;
import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.pojo.AllGroupMemberVO;
import com.lanjiu.im.grpc.util.*;
import com.lanjiu.pro.fileStorage.GroupAvatarRequest;
import com.lanjiu.pro.fileStorage.GroupAvatarResponse;
import com.lanjiu.pro.login.RegisterUser;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeleteGroupRemarkServiceAPI {

    private static final Logger logger = Logger.getLogger(DeleteGroupRemarkServiceAPI.class.getName());

    public GroupRemark deleteGroupRemark(RpcGroupRemark rpcGroupRemark, String kind){
        SqlSession session = DBTools.getSession();
        Integer groupId = rpcGroupRemark.getGroupId();
        Integer groupMemberId = rpcGroupRemark.getGroupMemberId();
        Integer groupMemberIdRemarked = rpcGroupRemark.getGroupMemberIdRemarked();
        String remark = rpcGroupRemark.getRemark();

        GroupRemark groupRemark = new GroupRemark();
        groupRemark.setGroupId(groupId);
        groupRemark.setGroupMemberId(groupMemberId);
        groupRemark.setGroupMemberIdRemarked(groupMemberIdRemarked);
        groupRemark.setRemark(remark);

        boolean bResult = deleteGroupRemarkService(session, groupRemark, kind);
        if(bResult){
            return groupRemark;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean deleteGroupRemarkService(SqlSession session, GroupRemark groupRemark, String kind){
        GroupRemarkMapper guestUserFriendMapper = session.getMapper(GroupRemarkMapper.class);
        int result = 0;
        try {
            if(ConstantsSelectKind.GROUP_REMARK_DELETE_TYPE_BY_GROUP_ID.equals(kind)){
                result = guestUserFriendMapper.deleteGroupRemarkByGroupId(groupRemark.getGroupId());
            }else if(ConstantsSelectKind.GROUP_REMARK_DELETE_TYPE_BY_MEMEBER_REMARKID_ID.equals(kind)){
                result = guestUserFriendMapper.deleteGroupRemarkByMemberRemarkedId(groupRemark.getGroupMemberIdRemarked());
            }else if(ConstantsSelectKind.GROUP_REMARK_DELETE_TYPE_BY_MEMBER_ID.equals(kind)){
                result = guestUserFriendMapper.deleteGroupRemarkByMemberId(groupRemark.getGroupMemberId());
            }else if(ConstantsSelectKind.GROUP_REMARK_DELETE_TYPE_BY_GROUP_ID_AND_MEMBER_ID.equals(kind)){
                result = guestUserFriendMapper.deleteGroupRemarkByGroupIdAndMemberId(groupRemark.getGroupId(), groupRemark.getGroupMemberId());
            }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        System.out.println("result: " + result);
        return result > 0;
    }

    public AllGroupsMemberResponse deleteMembersByGroupOwner(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        String memberIds = request.getRequestKind();//要删除的群成员ID集合
        String[] ids = memberIds.split(",");
        RpcRegisteredGroup registeredGroup = request.getRegisteredGroup();
//        int groupMemberId = registeredGroup.getGroupMemberId();//群主成员ID
        int groupId = registeredGroup.getGroupId();
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        RegisteredGroupMapper groupMapper = session.getMapper(RegisteredGroupMapper.class);
        RegisteredGroupMemberMapper registeredGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupRegisteredUserMemberRelationMapper mapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        try {
            com.lanjiu.im.grpc.AllGroupMemberVO allGroupVO;
            List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupVOSREList = new ArrayList<>() ;
            RegisteredGroup group = groupMapper.getRegisteredGroupByGroupId(groupId);
//            RegisteredGroupMember ownerEntity = registeredGroupMemberMapper.getRegisteredByGroupMemberId(groupMemberId);
            List<com.lanjiu.im.grpc.pojo.AllGroupMemberVO> allGroupMemberVOS = registeredGroupMemberMapper.selectGroupRegisteredMembers(groupId);
            String[] split = group.getGroupPhotoUserIdList().split(",");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(split[i]);
            }
            List<String> list2 = new ArrayList<>();
            for (String id : ids) {
                list2.add(id);
            }
            logger.info("群主踢人群ID："+ groupId +"---被踢的用户ID集合：" + list2.toString());
            if (!Collections.disjoint(list,list2)){//踢出的人在前九个里面
                RegistUserAPI registUserAPI = new RegistUserAPI();
                FileStorageAPI fileStorageAPI = new FileStorageAPI();
                RequestUser userInfo;
                ResponseUser responseUser;
                List<RegisterUser> registerUserListInfo;
                List<String> photoList = new ArrayList<>();
                List<String> list1 = new ArrayList<>();
                for (AllGroupMemberVO vo : allGroupMemberVOS) {
                    list1.add(String.valueOf(vo.getRegisteredUserId()));
                }
                list1.removeAll(list);
                list1.removeAll(list2);
                for (String s : list2) {
                    if(list.contains(s)){
                        list.remove(s);
                    }
                }
                if(list1.size()>0){
                    for (String s : list1) {
                        list.add(s);
                        if(list.size()==9){
                            break;
                        }
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
                int groupAmount = group.getAmount()-list2.size();
                GroupAvatarRequest avatarRequest = GroupAvatarRequest.newBuilder()
                        .setGroupId(String.valueOf(groupId))
                        .setNum(String.valueOf(groupAmount))
                        .addAllAvatarUrl(photoList).build();
                logger.info("群主踢人新合成群头像用户ID集合："+list.toString()+"---群ID："+groupId);
                GroupAvatarResponse groupAvatarResponse = fileStorageAPI.groupMergerPhoto(avatarRequest);
                logger.info("退群返回群头像新url："+groupAvatarResponse.getGroupAvatar());
                String userIdList = String.join(",",list);
                String groupUrl = groupAvatarResponse.getGroupAvatar();
                for (String id : list2) {
                    com.lanjiu.im.grpc.pojo.AllGroupMemberVO groupAndMemberRelation = mapper.getGroupAndMemberRelation(Integer.parseInt(id), groupId);
                    if(null != groupAndMemberRelation){
                        mapper.deleteRegisteredGroupRegisteredUserMemberRelation(groupId,groupAndMemberRelation.getGroupMemberId());
                        registeredGroupMemberMapper.deleteRegisteredGroupMemberByGroupMemberId(groupAndMemberRelation.getGroupMemberId());
                    }
                }
                for (String id : list) {
                    allGroupVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                            .setRegisteredGroupId(groupId)
                            .setRegisteredUserId(Integer.parseInt(id))
                            .setAmount(groupAmount)
                            .setGroupName(group.getGroupName())
                            .setUserPhoto(groupUrl)
                            .build();
                    allGroupVOSREList.add(allGroupVO);
                }
                groupMapper.updateRegisteredGroup(groupId,group.getRegisteredUserId(),group.getGroupName(),group.getGroupAnnouncementId(),group.getCreationTime(),
                                            modificationTime, groupAmount,groupUrl,userIdList);
                AllGroupsMemberResponse allGroupsResponse = AllGroupsMemberResponse.newBuilder()
                        .addAllResponseGroupMemberVo(allGroupVOSREList)
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
                session.commit();
                return allGroupsResponse;
            }else {
                for (String id : list2) {
                    com.lanjiu.im.grpc.pojo.AllGroupMemberVO groupAndMemberRelation = mapper.getGroupAndMemberRelation(Integer.parseInt(id), groupId);
                    if(null != groupAndMemberRelation){
                        mapper.deleteRegisteredGroupRegisteredUserMemberRelation(groupId,groupAndMemberRelation.getGroupMemberId());
                        registeredGroupMemberMapper.deleteRegisteredGroupMemberByGroupMemberId(groupAndMemberRelation.getGroupMemberId());
                    }
                }
                int groupAmount = group.getAmount()-list2.size();
                for (String id : list2) {
                    allGroupVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                            .setRegisteredGroupId(groupId)
                            .setRegisteredUserId(Integer.parseInt(id))
                            .setAmount(groupAmount)
                            .setGroupName(group.getGroupName())
                            .setUserPhoto(group.getGroupPhotoUrl())
                            .build();
                    allGroupVOSREList.add(allGroupVO);
                }
                groupMapper.updateRegisteredGroup(groupId,group.getRegisteredUserId(),group.getGroupName(),group.getGroupAnnouncementId(),group.getCreationTime(),
                        modificationTime, groupAmount,group.getGroupPhotoUrl(),group.getGroupPhotoUserIdList());
                AllGroupsMemberResponse allGroupsResponse = AllGroupsMemberResponse.newBuilder()
                        .addAllResponseGroupMemberVo(allGroupVOSREList)
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
                session.commit();
                session.close();
                return allGroupsResponse;
            }
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }

    public String getNewUserIdAndName(String[] sarr,String[] ids){
        List<String> userList = new ArrayList<>();
        for (String user : sarr) {
            userList.add(user);
        }
        for (String user : sarr) {
            String[] userIdAndName = user.split("-");
            List<String> list = new ArrayList<>();
            for (String d : userIdAndName) {
                list.add(d);
            }
            for (String id : ids) {
                if(String.valueOf(id).equals(list.get(0))){
                    userList.remove(user);
                }
            }
        }
        String newUserIdAndName = "";
        for (String ss : userList) {
            newUserIdAndName = ss+","+newUserIdAndName;
        }
        return newUserIdAndName;
    }

    public AllGroupsMemberResponse groupMemberExitGroupChat(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        RpcRegisteredGroupMember registeredGroupMember = request.getRegisteredGroupMember();
//        int groupMemberId = registeredGroupMember.getGroupMemberId();
        int groupId = registeredGroupMember.getGroupId();
        int registeredUserId = registeredGroupMember.getRegisteredUserId();
        logger.info("退群群号："+groupId+"---退群用户ID："+registeredUserId);
        RegisteredGroupRegisteredUserMemberRelationMapper mapperR = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        RegisteredGroupMapper mapper = session.getMapper(RegisteredGroupMapper.class);
        RegisteredGroupMemberMapper memberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        GroupMemberNicknameMapper groupMemberNicknameMapper = session.getMapper(GroupMemberNicknameMapper.class);
        try {
            com.lanjiu.im.grpc.pojo.AllGroupMemberVO groupAndMemberRelation = mapperR.getGroupAndMemberRelation(registeredUserId, groupId);
            RegisteredGroup registeredGroup = mapper.getRegisteredGroupByGroupId(groupId);

            com.lanjiu.im.grpc.AllGroupMemberVO allGroupVO;
            List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupVOSREList = new ArrayList<>() ;
            if(null!= registeredGroup && registeredGroup.getRegisteredUserId() == registeredUserId){
                List<RegisteredGroupRegisteredUserMemberRelation> relations = mapperR.selectRegisteredGroupRegisteredUserMemberRelationByRegisteredGroupId(groupId);
                for (RegisteredGroupRegisteredUserMemberRelation relation : relations) {
                    mapperR.deleteRegisteredGroupRegisteredUserMemberRelation(groupId,relation.getRegisteredUserMemberId());
                    memberMapper.deleteRegisteredGroupMemberByGroupMemberId(relation.getRegisteredUserMemberId());
                    allGroupVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                            .setRegisteredGroupId(groupId)
                            .setRegisteredUserId(registeredUserId)
                            .build();
                    allGroupVOSREList.add(allGroupVO);
                }
                mapper.deleteRegisteredGroupByGroupId(groupId);
                groupMemberNicknameMapper.deleteByGroupId(groupId);
                session.commit();
            }else {
//                GroupMemberNickname groupMemberNickname = groupMemberNicknameMapper.selectGroupMemberNickname(groupId, registeredUserId, groupMemberId);
//                if(null != groupMemberNickname){
//                    groupMemberNicknameMapper.deleteMemberNickname(groupId,registeredUserId);
//                }
                List<String> list = Arrays.asList(registeredGroup.getGroupPhotoUserIdList().split(","));
                if(list.contains(String.valueOf(registeredUserId))){
                    try {
                        RegistUserAPI registUserAPI = new RegistUserAPI();
                        FileStorageAPI fileStorageAPI = new FileStorageAPI();
                        RequestUser userInfo;
                        ResponseUser responseUser;
                        List<RegisterUser> registerUserListInfo;
                        List<String> photoList = new ArrayList<>();
                        RegisteredGroupMemberMapper registeredGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
                        List<com.lanjiu.im.grpc.pojo.AllGroupMemberVO> allGroupMemberVOS = registeredGroupMemberMapper.selectGroupRegisteredMembers(groupId);//获取所有群成员
                        List<String> list2 = new ArrayList<>();
                        for (AllGroupMemberVO vo : allGroupMemberVOS) {
                            list2.add(String.valueOf(vo.getRegisteredUserId()));
                        }
                        String[] strings = registeredGroup.getGroupPhotoUserIdList().split(",");
                        List<String> list1 = new ArrayList<>();
                        for (int i = 0; i < strings.length; i++) {
                            list1.add(strings[i]);
                        }
                        list2.removeAll(list1);
                        if(list2.size()>0){
                            list1.remove(String.valueOf(registeredUserId));
                            list1.add(list2.get(0));
                        }else {
                            list1.remove(String.valueOf(registeredUserId));
                        }
                        for (String s : list1) {
                            userInfo = RequestUser.newBuilder().setArgs("SEARCH_USER").setRegisterUser(RegisterUser.newBuilder().setUserId(s).build()).build();
                            responseUser = registUserAPI.selectUserInfomation(userInfo);
                            registerUserListInfo = responseUser.getRegisterUserList();
                            if (null != registerUserListInfo && registerUserListInfo.size()>0) {
                                photoList.add(registerUserListInfo.get(0).getUserInfomation().getAvatar());
                            }
                        }
                        GroupAvatarRequest avatarRequest = GroupAvatarRequest.newBuilder()
                                .setGroupId(String.valueOf(groupId))
                                .setNum(String.valueOf(registeredGroup.getAmount()-1))
                                .addAllAvatarUrl(photoList).build();
                        logger.info("退群新合成群头像用户ID集合："+list1.toString()+"---群ID："+groupId);
                        GroupAvatarResponse groupAvatarResponse = fileStorageAPI.groupMergerPhoto(avatarRequest);
                        logger.info("退群返回群头像新url："+groupAvatarResponse.getGroupAvatar());
                        String userIdList = String.join(",",list1);
                        String groupUrl = groupAvatarResponse.getGroupAvatar();
                        mapper.updateRegisteredGroup(registeredGroup.getGroupId(),registeredGroup.getRegisteredUserId(),registeredGroup.getGroupName(),registeredGroup.getGroupAnnouncementId(),
                                registeredGroup.getCreationTime(),registeredGroup.getModificationTime(),registeredGroup.getAmount()-1,groupUrl,userIdList);
                        mapperR.deleteRegisteredGroupRegisteredUserMemberRelation(groupId,groupAndMemberRelation.getGroupMemberId());
                        memberMapper.deleteRegisteredGroupMemberByGroupMemberId(groupAndMemberRelation.getGroupMemberId());
                        allGroupVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                                    .setRegisteredGroupId(groupId)
                                    .setRegisteredUserId(registeredUserId)
                                    .build();
                        allGroupVOSREList.add(allGroupVO);
                        session.commit();
                    }catch (Exception e){
                        e.printStackTrace();
                        session.rollback();
                    }
                }else {
                    mapper.updateRegisteredGroup(registeredGroup.getGroupId(),registeredGroup.getRegisteredUserId(),registeredGroup.getGroupName(),registeredGroup.getGroupAnnouncementId(),
                            registeredGroup.getCreationTime(),registeredGroup.getModificationTime(),registeredGroup.getAmount()-1,registeredGroup.getGroupPhotoUrl(),registeredGroup.getGroupPhotoUserIdList());
                    mapperR.deleteRegisteredGroupRegisteredUserMemberRelation(groupId,groupAndMemberRelation.getGroupMemberId());
                    memberMapper.deleteRegisteredGroupMemberByGroupMemberId(groupAndMemberRelation.getGroupMemberId());
                    allGroupVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                                .setRegisteredGroupId(groupId)
                                .setRegisteredUserId(registeredUserId)
                                .build();
                    allGroupVOSREList.add(allGroupVO);
                    session.commit();
                }
            }
            AllGroupsMemberResponse allGroupsResponse = AllGroupsMemberResponse.newBuilder()
                    .addAllResponseGroupMemberVo(allGroupVOSREList)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            return allGroupsResponse;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
}
