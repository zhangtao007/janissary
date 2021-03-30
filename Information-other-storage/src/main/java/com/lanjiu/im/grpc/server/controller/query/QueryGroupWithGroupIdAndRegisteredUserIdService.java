package com.lanjiu.im.grpc.server.controller.query;

import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.RpcRegisteredGroup;
import com.lanjiu.im.grpc.RpcRegisteredGroupMember;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.service.*;
import com.lanjiu.im.grpc.util.CommonUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QueryGroupWithGroupIdAndRegisteredUserIdService {

    private static final Logger logger = Logger.getLogger(QueryGroupWithGroupIdAndRegisteredUserIdService.class.getName());

    public List<RpcGuestGroup> selectGuestGroupWithGroupIdAndRegisteredGroupMemberId(SqlSession session, int registeredGroupMember, int originalGroupId) {
        GuestGroupRegisteredUserMemberRelationMapper guestGroupRegisteredUserMemberRelationMapper = session.getMapper(GuestGroupRegisteredUserMemberRelationMapper.class);
        GuestGroupRegisteredUserMemberRelationService guestGroupRegisteredUserMemberRelationService = new GuestGroupRegisteredUserMemberRelationService();

        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        GuestGroupService guestGroupService = new GuestGroupService();

        List<GuestGroupRegisteredUserMemberRelation> guestGroupRegisteredUserMemberRelationList = new ArrayList<GuestGroupRegisteredUserMemberRelation>();
        GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation = new GuestGroupRegisteredUserMemberRelation();
        guestGroupRegisteredUserMemberRelation.setRegisteredUserMemberId(registeredGroupMember);
        guestGroupRegisteredUserMemberRelation.setGuestGroupId(originalGroupId);
        List<RpcGuestGroup> guestGroupList = new ArrayList<RpcGuestGroup>();
        GuestGroup guestGroup = new GuestGroup();
        List<GuestGroup> guestGroupListTemp = null;
        GuestGroup guestGroupTemp = null;
        RpcGuestGroup rpcGuestGroup = null;
        guestGroupRegisteredUserMemberRelationList = guestGroupRegisteredUserMemberRelationService.selectAllGuestGroupRegisteredUserMemberRelationByGroupIdAndMemberId(session, guestGroupRegisteredUserMemberRelationMapper, guestGroupRegisteredUserMemberRelation);
        for (GuestGroupRegisteredUserMemberRelation guestGroupRegisteredUserMemberRelation1 : guestGroupRegisteredUserMemberRelationList){
            guestGroup.setGroupId(guestGroupRegisteredUserMemberRelation1.getGuestGroupId());
            guestGroupListTemp = guestGroupService.selectGuestGroupByGroupId(session, guestGroupMapper, guestGroup);
            //commonUtils.isHave(list)
            CommonUtils<GuestGroup> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(guestGroupListTemp)){
                guestGroupTemp = guestGroupListTemp.get(0);
                rpcGuestGroup = RpcGuestGroup.newBuilder()
                        .setGroupId(guestGroupTemp.getGroupId())
                        .setGuestUserId(guestGroupTemp.getGuestUserId())
                        .setGroupName(guestGroupTemp.getGroupName())
                        .setGroupAnnouncementId(guestGroupTemp.getGroupAnnouncementId())
                        .setCreationTime(guestGroupTemp.getCreationTime().getTime())
                        .setModificationTime(guestGroupTemp.getModificationTime().getTime())
                        .setAmount(guestGroupTemp.getAmount())
                        .build();
                guestGroupList.add(rpcGuestGroup);
            }
        }
        logger.info("RpcGuestGroup");
        return guestGroupList;
    }

    public List<RegisteredGroupMember> selectRegisteredGroupMemberList(TransmissionRequest request, SqlSession session) {
        RegisteredGroupMemberMapper mapperb = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupMemberService guestUserFriendService = new RegisteredGroupMemberService();
        RegisteredGroupMember guestGroupMember = new RegisteredGroupMember();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
        guestGroupMember.setRegisteredUserId(rpcRegisteredGroupMember.getRegisteredUserId());
        List<RegisteredGroupMember> list = guestUserFriendService.selectAllRecords(session, mapperb);
        logger.info("RegisteredGroupMember");
        return list;
    }

    public List<RpcRegisteredGroup> selectRegisteredGroupWithGroupIdAndRegisteredGroupMemberId(SqlSession session, int guestGroupMember, int originalGroupId) {
        RegisteredGroupRegisteredUserMemberRelationMapper registeredGroupRegisteredUserMemberRelationMapper = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        RegisteredGroupRegisteredUserMemberRelationService registeredGroupRegisteredUserMemberRelationService = new RegisteredGroupRegisteredUserMemberRelationService();

        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        RegisteredGroupService registeredGroupService = new RegisteredGroupService();

        List<RegisteredGroupRegisteredUserMemberRelation> registeredGroupRegisteredUserMemberRelationList = new ArrayList<RegisteredGroupRegisteredUserMemberRelation>();
        RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation = new RegisteredGroupRegisteredUserMemberRelation();
        registeredGroupRegisteredUserMemberRelation.setRegisteredUserMemberId(guestGroupMember);
        registeredGroupRegisteredUserMemberRelation.setRegisteredGroupId(originalGroupId);
        List<RpcRegisteredGroup> registeredGroupList = new ArrayList<RpcRegisteredGroup>();
        RegisteredGroup registeredGroup = new RegisteredGroup();
        List<RegisteredGroup> registeredGroupListTemp = null;
        RegisteredGroup registeredGroupTemp = null;
        RpcRegisteredGroup rpcRegisteredGroup = null;
        registeredGroupRegisteredUserMemberRelationList = registeredGroupRegisteredUserMemberRelationService.selectAllRegisteredGroupRegisteredUserMemberRelationByGroupIdAndMemberId(session, registeredGroupRegisteredUserMemberRelationMapper, registeredGroupRegisteredUserMemberRelation);
        for (RegisteredGroupRegisteredUserMemberRelation registeredGroupRegisteredUserMemberRelation1 : registeredGroupRegisteredUserMemberRelationList){
            registeredGroup.setGroupId(registeredGroupRegisteredUserMemberRelation1.getRegisteredGroupId());
            registeredGroupListTemp = registeredGroupService.selectRegisteredGroupByGroupId(session, registeredGroupMapper, registeredGroup);
            //commonUtils.isHave(list)
            CommonUtils<RegisteredGroup> commonUtils = new CommonUtils<>();
            if(commonUtils.isHave(registeredGroupListTemp)){
                registeredGroupTemp = registeredGroupListTemp.get(0);
                rpcRegisteredGroup = RpcRegisteredGroup.newBuilder()
                        .setRegisteredUserId(registeredGroupTemp.getRegisteredUserId())
                        .setGroupId(registeredGroupTemp.getGroupId())
                        .setGroupName(registeredGroupTemp.getGroupName())
                        .setGroupAnnouncementId(registeredGroupTemp.getGroupAnnouncementId())
                        .setCreationTime(registeredGroupTemp.getCreationTime().getTime())
                        .setModificationTime(registeredGroupTemp.getModificationTime().getTime())
                        .setAmount(registeredGroupTemp.getAmount())
                        .build();
                registeredGroupList.add(rpcRegisteredGroup);
            }
        }
        logger.info("RpcRegisteredGroup");
        return registeredGroupList;
    }
}
