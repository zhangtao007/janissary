package com.lanjiu.im.grpc.server.controller.query;

import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.service.*;
import com.lanjiu.im.grpc.util.CommonUtils;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class GroupMemberRemarkUtils {

    public GroupRemark selectGroupMemberRemark(int groupId, int groupMemberId, int groupMemberRemarkedId){
        //还需以被添加人的角色检索记录
        GroupRemark groupRemark1 = new GroupRemark();
        groupRemark1.setGroupId(groupId);
        groupRemark1.setGroupMemberId(groupMemberId);
        groupRemark1.setGroupMemberIdRemarked(groupMemberRemarkedId);
        SqlSession session =DBTools.getSession();
        GroupRemarkMapper groupRemarkMapper = session.getMapper(GroupRemarkMapper.class);
        GroupRemarkService groupRemarkService = new GroupRemarkService();
        //设置后的备注数据
        GroupRemark groupRemark = null;
        List<GroupRemark> groupRemarkList = groupRemarkService.selectGroupRemarkWithGroupWithGroupMember(session, groupRemarkMapper, groupRemark1);
        CommonUtils<GroupRemark> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(groupRemarkList)){
            groupRemark = groupRemarkList.get(0);
        }

        return groupRemark;
    }

    //查询出该群的所有注册群主列表
    public List<RegisteredGroupMember> getActionRegisteredGroupMemberWhoIsGroupOwner(int registeredUserId, int groupId){
        List<GuestGroupRegisteredUserMemberRelation> guestGroupRegisteredUserMemberRelationList = null;
        List<RegisteredGroupRegisteredUserMemberRelation> registeredGroupRegisteredUserMemberRelationList = null;
        CommonUtils<GuestGroupRegisteredUserMemberRelation> commonUtils = new CommonUtils<>();
        CommonUtils<RegisteredGroupRegisteredUserMemberRelation> commonUtils1 = new CommonUtils<>();
        SqlSession session =DBTools.getSession();
        RegisteredGroupMemberMapper mapperb = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupMemberService guestUserFriendService = new RegisteredGroupMemberService();
        RegisteredGroupMember registeredGroupMember = new RegisteredGroupMember();
        registeredGroupMember.setRegisteredUserId(registeredUserId);
        List<RegisteredGroupMember> listGroupOwner = new ArrayList<>();
        int memberId = 0;
        List<RegisteredGroupMember> list = guestUserFriendService.selectRegisteredGroupMemberByRegisteredUserId(session, mapperb, registeredGroupMember);
        for (RegisteredGroupMember registeredGroupMember1 : list){
            memberId = registeredGroupMember1.getGroupMemberId();
            guestGroupRegisteredUserMemberRelationList = selectGuestGroupWithGroupIdAndRegisteredGroupMemberId(session, memberId, groupId);
            if(commonUtils.isHave(guestGroupRegisteredUserMemberRelationList)){
                listGroupOwner.add(registeredGroupMember1);
            }
            registeredGroupRegisteredUserMemberRelationList = selectRegisteredGroupWithRegisteredGroupMemberId(session, memberId, groupId);
            if(commonUtils1.isHave(registeredGroupRegisteredUserMemberRelationList)){
                listGroupOwner.add(registeredGroupMember1);
            }
        }
        CommonUtils<RegisteredGroupMember> commonUtils2 = new CommonUtils<>();
        if(commonUtils2.isHave(listGroupOwner)){
            return listGroupOwner;
        }else {
            return null;
        }
    }

    public List<GuestGroupRegisteredUserMemberRelation> selectGuestGroupWithGroupIdAndRegisteredGroupMemberId(SqlSession session, int registeredGroupMember, int originalGroupId) {
        GuestGroupRegisteredUserMemberRelationMapper guestGroupRegisteredUserMemberRelationMapper = session.getMapper(GuestGroupRegisteredUserMemberRelationMapper.class);
        GuestGroupRegisteredUserMemberRelationService guestGroupRegisteredUserMemberRelationService = new GuestGroupRegisteredUserMemberRelationService();
        List<GuestGroupRegisteredUserMemberRelation> guestGroupRegisteredUserMemberRelationList = new ArrayList<GuestGroupRegisteredUserMemberRelation>();
        GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation = new GuestGroupRegisteredUserMemberRelation();
        guestGroupRegisteredUserMemberRelation.setRegisteredUserMemberId(registeredGroupMember);
        guestGroupRegisteredUserMemberRelation.setGuestGroupId(originalGroupId);
        guestGroupRegisteredUserMemberRelationList = guestGroupRegisteredUserMemberRelationService.selectAllGuestGroupRegisteredUserMemberRelationByGroupIdAndMemberId(session, guestGroupRegisteredUserMemberRelationMapper, guestGroupRegisteredUserMemberRelation);
        return guestGroupRegisteredUserMemberRelationList;
    }

    public List<RegisteredGroupRegisteredUserMemberRelation> selectRegisteredGroupWithRegisteredGroupMemberId(SqlSession session, int guestGroupMember, int groupId) {
        RegisteredGroupRegisteredUserMemberRelationMapper registeredGroupRegisteredUserMemberRelationMapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        RegisteredGroupRegisteredUserMemberRelationService registeredGroupRegisteredUserMemberRelationService = new RegisteredGroupRegisteredUserMemberRelationService();

        List<RegisteredGroupRegisteredUserMemberRelation> registeredGroupRegisteredUserMemberRelationList = new ArrayList<RegisteredGroupRegisteredUserMemberRelation>();
        RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation = new RegisteredGroupRegisteredUserMemberRelation();
        registeredGroupRegisteredUserMemberRelation.setRegisteredUserMemberId(guestGroupMember);
        registeredGroupRegisteredUserMemberRelation.setRegisteredGroupId(groupId);

        registeredGroupRegisteredUserMemberRelationList = registeredGroupRegisteredUserMemberRelationService.selectAllRegisteredGroupRegisteredUserMemberRelationByGroupIdAndMemberId(session, registeredGroupRegisteredUserMemberRelationMapper, registeredGroupRegisteredUserMemberRelation);
        return registeredGroupRegisteredUserMemberRelationList;
    }

    //查询出该群的所有游客群主列表
    public List<GuestGroupMember> getActionGuestGroupMemberWhoIsGroupOwner(int registeredUserId, int groupId){
        List<GuestGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList = null;
        List<RegisteredGroupGuestUserMemberRelation> registeredGroupGuestUserMemberRelationList = null;
        CommonUtils<GuestGroupGuestUserMemberRelation> commonUtils = new CommonUtils<>();
        CommonUtils<RegisteredGroupGuestUserMemberRelation> commonUtils1 = new CommonUtils<>();
        SqlSession session =DBTools.getSession();
        GuestGroupMemberMapper mapperb = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupMemberService guestUserFriendService = new GuestGroupMemberService();
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        guestGroupMember.setGuestUserId(registeredUserId);
        List<GuestGroupMember> listGroupOwner = new ArrayList<>();
        int memberId = 0;
        List<GuestGroupMember> list = guestUserFriendService.selectGuestGroupMemberByGuestUserId(session, mapperb, guestGroupMember);
        for (GuestGroupMember guestGroupMember1 : list){
            memberId = guestGroupMember1.getGroupMemberId();
            guestGroupGuestUserMemberRelationList = selectGuestGroupWithGroupIdAndGuestGroupMemberId(session, memberId, groupId);
            if(commonUtils.isHave(guestGroupGuestUserMemberRelationList)){
                listGroupOwner.add(guestGroupMember1);
            }
            registeredGroupGuestUserMemberRelationList = selectRegisteredGroupWithGuestGroupMemberId(session, memberId, groupId);
            if(commonUtils1.isHave(registeredGroupGuestUserMemberRelationList)){
                listGroupOwner.add(guestGroupMember1);
            }
        }
        CommonUtils<GuestGroupMember> commonUtils2 = new CommonUtils<>();
        if(commonUtils2.isHave(listGroupOwner)){
            return listGroupOwner;
        }else {
            return null;
        }
    }

    public List<GuestGroupGuestUserMemberRelation> selectGuestGroupWithGroupIdAndGuestGroupMemberId(SqlSession session, int guestGroupMember, int originalGroupId) {
        GuestGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        GuestGroupGuestUserMemberRelationService guestGroupGuestUserMemberRelationService = new GuestGroupGuestUserMemberRelationService();
        List<GuestGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList = new ArrayList<GuestGroupGuestUserMemberRelation>();
        GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation = new GuestGroupGuestUserMemberRelation();
        guestGroupGuestUserMemberRelation.setGuestUserMemberId(guestGroupMember);
        guestGroupGuestUserMemberRelation.setGuestGroupId(originalGroupId);
        guestGroupGuestUserMemberRelationList = guestGroupGuestUserMemberRelationService.selectAllGuestGroupGuestUserMemberRelationByGroupIdAndMemberId(session, guestGroupGuestUserMemberRelationMapper, guestGroupGuestUserMemberRelation);
        return guestGroupGuestUserMemberRelationList;
    }

    public List<RegisteredGroupGuestUserMemberRelation> selectRegisteredGroupWithGuestGroupMemberId(SqlSession session, int guestGroupMember, int groupId) {
        RegisteredGroupGuestUserMemberRelationMapper registeredGroupGuestUserMemberRelationMapper = session.getMapper(RegisteredGroupGuestUserMemberRelationMapper.class);
        RegisteredGroupGuestUserMemberRelationService registeredGroupGuestUserMemberRelationService = new RegisteredGroupGuestUserMemberRelationService();

        List<RegisteredGroupGuestUserMemberRelation> registeredGroupGuestUserMemberRelationList = new ArrayList<RegisteredGroupGuestUserMemberRelation>();
        RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation = new RegisteredGroupGuestUserMemberRelation();
        registeredGroupGuestUserMemberRelation.setGuestUserMemberId(guestGroupMember);
        registeredGroupGuestUserMemberRelation.setRegisteredGroupId(groupId);

        registeredGroupGuestUserMemberRelationList = registeredGroupGuestUserMemberRelationService.selectAllRegisteredGroupGuestUserMemberRelationByGroupIdAndMemberId(session, registeredGroupGuestUserMemberRelationMapper, registeredGroupGuestUserMemberRelation);
        return registeredGroupGuestUserMemberRelationList;
    }

}
