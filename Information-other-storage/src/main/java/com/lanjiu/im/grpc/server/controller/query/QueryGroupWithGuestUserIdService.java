package com.lanjiu.im.grpc.server.controller.query;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.pojo.AllGroupMemberVO;
import com.lanjiu.im.grpc.service.*;
import com.lanjiu.im.grpc.util.CommonUtils;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QueryGroupWithGuestUserIdService {

    private static final Logger logger = Logger.getLogger(QueryGroupWithGuestUserIdService.class.getName());

    public List<RpcGuestGroup> selectGuestGroupWithGuestGroupMemberId(SqlSession session, int guestGroupMember) {
        GuestGroupGuestUserMemberRelationMapper guestGroupGuestUserMemberRelationMapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        GuestGroupGuestUserMemberRelationService guestGroupGuestUserMemberRelationService = new GuestGroupGuestUserMemberRelationService();

        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        GuestGroupService guestGroupService = new GuestGroupService();

        List<GuestGroupGuestUserMemberRelation> guestGroupGuestUserMemberRelationList ;
        GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation = new GuestGroupGuestUserMemberRelation();
        guestGroupGuestUserMemberRelation.setGuestUserMemberId(guestGroupMember);
        List<RpcGuestGroup> guestGroupList = new ArrayList<>();
        GuestGroup guestGroup = new GuestGroup();
        List<GuestGroup> guestGroupListTemp ;
        GuestGroup guestGroupTemp ;
        RpcGuestGroup rpcGuestGroup ;
        guestGroupGuestUserMemberRelationList = guestGroupGuestUserMemberRelationService.selectGuestGroupGuestUserMemberRelationByGuestUserMemberId(session, guestGroupGuestUserMemberRelationMapper, guestGroupGuestUserMemberRelation);
        for (GuestGroupGuestUserMemberRelation guestGroupGuestUserMemberRelation1 : guestGroupGuestUserMemberRelationList){
            guestGroup.setGroupId(guestGroupGuestUserMemberRelation1.getGuestGroupId());
            guestGroupListTemp = guestGroupService.selectGuestGroupByGroupId(session, guestGroupMapper, guestGroup);
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

    public List<GuestGroupMember> selectGroupMemberListWithGuestUserId(TransmissionRequest request, SqlSession session) {
        GuestGroupMemberMapper mapperb = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupMemberService guestUserFriendService = new GuestGroupMemberService();
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        guestGroupMember.setGuestUserId(rpcGuestGroupMember.getGuestUserId());
        List<GuestGroupMember> list = guestUserFriendService.selectGuestGroupMemberByGuestUserId(session, mapperb, guestGroupMember);
        logger.info("GuestGroupMember");
        return list;
    }

    public List<RpcRegisteredGroup> selectRegisteredGroupWithGuestGroupMemberId(SqlSession session, int guestGroupMember) {
        RegisteredGroupGuestUserMemberRelationMapper registeredGroupGuestUserMemberRelationMapper = session.getMapper(RegisteredGroupGuestUserMemberRelationMapper.class);
        RegisteredGroupGuestUserMemberRelationService registeredGroupGuestUserMemberRelationService = new RegisteredGroupGuestUserMemberRelationService();

        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        RegisteredGroupService registeredGroupService = new RegisteredGroupService();

        List<RegisteredGroupGuestUserMemberRelation> registeredGroupGuestUserMemberRelationList;
        RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation = new RegisteredGroupGuestUserMemberRelation();
        registeredGroupGuestUserMemberRelation.setGuestUserMemberId(guestGroupMember);
        List<RpcRegisteredGroup> registeredGroupList = new ArrayList<>();
        RegisteredGroup registeredGroup = new RegisteredGroup();
        List<RegisteredGroup> registeredGroupListTemp ;
        RegisteredGroup registeredGroupTemp ;
        RpcRegisteredGroup rpcRegisteredGroup ;
        registeredGroupGuestUserMemberRelationList = registeredGroupGuestUserMemberRelationService.selectRegisteredGroupGuestUserMemberRelationByGuestUserMemberId(session, registeredGroupGuestUserMemberRelationMapper, registeredGroupGuestUserMemberRelation);
        for (RegisteredGroupGuestUserMemberRelation registeredGroupGuestUserMemberRelation1 : registeredGroupGuestUserMemberRelationList){
            registeredGroup.setGroupId(registeredGroupGuestUserMemberRelation1.getRegisteredGroupId());
            registeredGroupListTemp = registeredGroupService.selectRegisteredGroupByGroupId(session, registeredGroupMapper, registeredGroup);
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
        return registeredGroupList;
    }

    public AllGroupsMemberResponse selectGroupMembersInfoList(String groupId){
        SqlSession session = DBTools.getSession();
        RegisteredGroupMemberMapper registeredGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        try {
            RegisteredGroup registeredGroup = registeredGroupMapper.getRegisteredGroupByGroupId(Integer.parseInt(groupId));
            if(null != registeredGroup){
                List<com.lanjiu.im.grpc.pojo.AllGroupMemberVO> allGroupMemberVOS = registeredGroupMemberMapper.selectGroupRegisteredMembers(Integer.parseInt(groupId));
                List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupMemberVOSREList = new ArrayList<>() ;
                com.lanjiu.im.grpc.AllGroupMemberVO allGroupMemberVO;
                for (AllGroupMemberVO vo : allGroupMemberVOS) {
                    allGroupMemberVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                            .setGroupMemberId(vo.getGroupMemberId())
                            .setRegisteredGroupId(registeredGroup.getGroupId())
                            .setRegisteredUserId(vo.getRegisteredUserId())
                            .setGroupName(vo.getGroupName())
                            .setAmount(allGroupMemberVOS.size())
                            .setGroupOwner(vo.getGroupOwner())
                            .setAnnouncementContent(vo.getAnnouncementContent())
                            .setUserPhoto(null==registeredGroup.getGroupPhotoUrl()?"A":registeredGroup.getGroupPhotoUrl())
                            .build();
                    allGroupMemberVOSREList.add(allGroupMemberVO);
                }
                AllGroupsMemberResponse allGroupsMemberResponse = AllGroupsMemberResponse.newBuilder()
                        .addAllResponseGroupMemberVo(allGroupMemberVOSREList)
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
                session.commit();
                session.close();
                return allGroupsMemberResponse;
            }
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }

    public GuestGroupResponse searchGroupById(String groupId){
        SqlSession session = DBTools.getSession();
        logger.info("------查找群的群ID-----："+groupId);
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        try {
            RegisteredGroup registeredGroups = registeredGroupMapper.getRegisteredGroupByGroupId(Integer.parseInt(groupId.trim()));
            GuestGroupResponse response = null;
            if(null != registeredGroups){
                List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupMemberVO = new ArrayList<>();
                allGroupMemberVO.add(com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                                .setUserPhoto(registeredGroups.getGroupPhotoUrl()).build());
                response = GuestGroupResponse.newBuilder()
                        .addResponseRegisteredGroup(RpcRegisteredGroup.newBuilder()
                                .setGroupId(registeredGroups.getGroupId())
                                .setRegisteredUserId(registeredGroups.getRegisteredUserId())
                                .setGroupName(registeredGroups.getGroupName())
                                .setAmount(registeredGroups.getAmount())
                                .build())
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS).addAllResponseGroupMemberVo(allGroupMemberVO)
                        .build();
            }
            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public AllGroupsMemberResponse searchAllGroupByUserId(TransmissionRequest request){
        String currUserId = request.getRequestKind();//当前用户ID
        logger.info("获取所有群组列表用户ID："+currUserId);
        SqlSession session = DBTools.getSession();
        RegisteredGroupMemberMapper mapper = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupRegisteredUserMemberRelationMapper mapper1 = session.getMapper(RegisteredGroupRegisteredUserMemberRelationMapper.class);
        List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupVOSREList = new ArrayList<>() ;
        try {
            List<AllGroupMemberVO> allGroupVOS = mapper.queryAllGroupByUserId(Integer.parseInt(currUserId));
            com.lanjiu.im.grpc.AllGroupMemberVO allGroupVO;
            if(null != allGroupVOS && allGroupVOS.size()>0){
                for (AllGroupMemberVO vo : allGroupVOS) {
                    List<RegisteredGroupRegisteredUserMemberRelation> memberRelations = mapper1.selectRegisteredGroupRegisteredUserMemberRelationByRegisteredGroupId(vo.getRegisteredGroupId());
                    allGroupVO = com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                            .setRegisteredGroupId(vo.getRegisteredGroupId())
                            .setRegisteredUserId(vo.getRegisteredUserId())
                            .setGroupName(vo.getGroupName())
                            .setAmount(memberRelations.size())
                            .setUserPhoto(null==vo.getUserPhoto()?"A":vo.getUserPhoto())
                            .build();
                    allGroupVOSREList.add(allGroupVO);
                }
                return AllGroupsMemberResponse.newBuilder()
                        .addAllResponseGroupMemberVo(allGroupVOSREList)
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
            }
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }

    public RegisteredGroupResponse queryGroupInfoByListId(TransmissionRequest request){
        RpcRegisteredGroup registeredGroup = request.getRegisteredGroup();
        String groupIds = registeredGroup.getGroupName();
        logger.info("查询所有群信息的群ID集合："+groupIds);
        SqlSession session = DBTools.getSession();
        RegisteredGroupMapper mapper = session.getMapper(RegisteredGroupMapper.class);
        String[] ids = groupIds.split(",");
        if(!"".equals(groupIds) && ids.length>0){
            RegisteredGroupResponse groupResponse ;
            List<RpcRegisteredGroup> list = new ArrayList<>();
            try {
                for (String id : ids) {
                    List<RegisteredGroup> registeredGroups = mapper.selectRegisteredGroupByGroupId(Integer.parseInt(id));
                    if(null != registeredGroups && registeredGroups.size()>0){
                        RpcRegisteredGroup rpcRegisteredGroup = RpcRegisteredGroup.newBuilder()
                                .setGroupId(registeredGroups.get(0).getGroupId())
                                .setGroupName(registeredGroups.get(0).getGroupName())
                                .setAmount(registeredGroups.get(0).getAmount())
                                .build();
                        list.add(rpcRegisteredGroup);
                    }
                }
                logger.info("所有群信息："+list.toString());
                groupResponse = RegisteredGroupResponse.newBuilder()
                                .addAllResponseRegisteredGroup(list)
                                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                                .build();
                session.commit();
                session.close();
                return groupResponse;
            }catch (Exception e){
                e.printStackTrace();
                session.rollback();
            }
        }
        return null;
    }


}
