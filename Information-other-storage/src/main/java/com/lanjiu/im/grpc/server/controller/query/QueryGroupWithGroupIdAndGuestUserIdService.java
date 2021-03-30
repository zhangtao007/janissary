package com.lanjiu.im.grpc.server.controller.query;

import com.lanjiu.im.grpc.RpcGuestGroup;
import com.lanjiu.im.grpc.RpcGuestGroupMember;
import com.lanjiu.im.grpc.RpcRegisteredGroup;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.service.*;
import com.lanjiu.im.grpc.util.CommonUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QueryGroupWithGroupIdAndGuestUserIdService {

    private static final Logger logger = Logger.getLogger(QueryGroupWithGroupIdAndGuestUserIdService.class.getName());

    public List<RpcGuestGroup> selectGuestGroupWithGuestGroupMemberIdAndGroupId(SqlSession session, int guestGroupMember, int groupOriginalId) {
        GuestGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        GuestGroupGuestUserMemberRelationService guestGroupGuestUserMemberRelationService = new GuestGroupGuestUserMemberRelationService();

        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        GuestGroupService guestGroupService = new GuestGroupService();

        List<GuestGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList = new ArrayList<GuestGroupGuestUserMemberRelation>();
        GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation = new GuestGroupGuestUserMemberRelation();
        guestGroupGuestUserMemberRelation.setGuestUserMemberId(guestGroupMember);
        guestGroupGuestUserMemberRelation.setGuestGroupId(groupOriginalId);
        List<RpcGuestGroup> guestGroupList = new ArrayList<RpcGuestGroup>();
        GuestGroup guestGroup = new GuestGroup();
        List<GuestGroup> guestGroupListTemp = null;
        GuestGroup guestGroupTemp = null;
        RpcGuestGroup rpcGuestGroup = null;
        guestGroupGuestUserMemberRelationList = guestGroupGuestUserMemberRelationService.selectAllGuestGroupGuestUserMemberRelationByGroupIdAndMemberId(session, guestGroupGuestUserMemberRelationMapper, guestGroupGuestUserMemberRelation);
        for (GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation1 : guestGroupGuestUserMemberRelationList){
            guestGroup.setGroupId(guestGroupGuestUserMemberRelation1.getGuestGroupId());
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

    public List<GuestGroupMember> selectGuestGroupMemberList(TransmissionRequest request, SqlSession session) {
        GuestGroupMemberMapper mapperb = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupMemberService guestUserFriendService = new GuestGroupMemberService();
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        guestGroupMember.setGuestUserId(rpcGuestGroupMember.getGuestUserId());
        List<GuestGroupMember> list = guestUserFriendService.selectAllRecords(session, mapperb);
        logger.info("GuestGroupMember");
        return list;
    }

    public List<RpcRegisteredGroup> selectRegisteredGroupWithGuestGroupMemberIdAndGroupId(SqlSession session, int guestGroupMember, int groupOriginalId) {
        RegisteredGroupGuestUserMemberRelationMapper registeredGroupGuestUserMemberRelationMapper = session.getMapper(RegisteredGroupGuestUserMemberRelationMapper.class);
        RegisteredGroupGuestUserMemberRelationService registeredGroupGuestUserMemberRelationService = new RegisteredGroupGuestUserMemberRelationService();

        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        RegisteredGroupService registeredGroupService = new RegisteredGroupService();

        List<RegisteredGroupGuestUserMemberRelation> registeredGroupGuestUserMemberRelationList = new ArrayList<RegisteredGroupGuestUserMemberRelation>();
        RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation = new RegisteredGroupGuestUserMemberRelation();
        registeredGroupGuestUserMemberRelation.setGuestUserMemberId(guestGroupMember);
        registeredGroupGuestUserMemberRelation.setRegisteredGroupId(groupOriginalId);
        List<RpcRegisteredGroup> registeredGroupList = new ArrayList<RpcRegisteredGroup>();
        RegisteredGroup registeredGroup = new RegisteredGroup();
        List<RegisteredGroup> registeredGroupListTemp = null;
        RegisteredGroup registeredGroupTemp = null;
        RpcRegisteredGroup rpcRegisteredGroup = null;
        registeredGroupGuestUserMemberRelationList = registeredGroupGuestUserMemberRelationService.selectAllRegisteredGroupGuestUserMemberRelationByGroupIdAndMemberId(session, registeredGroupGuestUserMemberRelationMapper, registeredGroupGuestUserMemberRelation);
        for (RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation1 : registeredGroupGuestUserMemberRelationList){
            registeredGroup.setGroupId(registeredGroupGuestUserMemberRelation1.getRegisteredGroupId());
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
