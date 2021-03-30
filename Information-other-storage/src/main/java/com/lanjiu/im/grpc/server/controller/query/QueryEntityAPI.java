package com.lanjiu.im.grpc.server.controller.query;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.service.*;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class QueryEntityAPI {

    private static final Logger logger = Logger.getLogger(QueryEntityAPI.class.getName());

    //某个注册用户关联的注册群成员列表和群列表（包含注册群和游客群）
    public RegisteredGroupResponse selectRegisteredGroupByRegisteredUserId(TransmissionRequest request,SqlSession session){
        QueryGroupWithRegisteredUserIdService queryGroupWithRegisteredUserId = new QueryGroupWithRegisteredUserIdService();
        List<RegisteredGroupMember> guestGroupMemberList = queryGroupWithRegisteredUserId.selectGroupMemberListWithRegisteredUserId(request ,session);
        List<RpcRegisteredGroupMember> rpcRegisteredGroupMemberList = new ArrayList<RpcRegisteredGroupMember>();
        List<RpcGuestGroup> rpcGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        List<RpcGuestGroup> rpcAddGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcAddRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = null;
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        GroupRemark groupRemark = null;
        int groupId = request.getRegisteredGroup().getGroupId();
        int registeredUserId = request.getRegisteredGroup().getRegisteredUserId();
        GroupMemberRemarkUtils groupMemberRemarkUtils = new GroupMemberRemarkUtils();
        List<RegisteredGroupMember> listGroupOwner = groupMemberRemarkUtils.getActionRegisteredGroupMemberWhoIsGroupOwner(registeredUserId, groupId);
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        int memberId = 0;
        for (RegisteredGroupMember guestGroupMember : guestGroupMemberList){
            memberId = guestGroupMember.getGroupMemberId();
            rpcGuestGroupList = queryGroupWithRegisteredUserId.selectGuestGroupWithRegisteredGroupMemberId(session, memberId);
            //commonUtils.isHave(list)
            CommonUtils<RpcGuestGroup> commonUtils = new CommonUtils<>();
            if (commonUtils.isHave(rpcGuestGroupList)){
                rpcAddGuestGroupList.addAll(rpcGuestGroupList);
            }
            rpcRegisteredGroupList = queryGroupWithRegisteredUserId.selectRegisteredGroupWithRegisteredGroupMemberId(session, memberId);
            //commonUtils.isHave(list)
            CommonUtils<RpcRegisteredGroup> commonUtils2 = new CommonUtils<>();
            if (commonUtils2.isHave(rpcRegisteredGroupList)){
                rpcAddRegisteredGroupList.addAll(rpcRegisteredGroupList);
            }

            //-------备注
            if(null != listGroupOwner){
                for(RegisteredGroupMember registeredGroupMember : listGroupOwner){
                    groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupId, registeredGroupMember.getGroupMemberId(), memberId);
                }
            }
            //-------备注
            if(groupRemark != null){
                rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                        .setGroupMemberId(memberId)
                        .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                        .setGroupRemarks(groupRemark.getRemark())
                        .setGroupOwner(guestGroupMember.getGroupOwner())
                        .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                        .setGroupId(groupId)
                        .build();
            }else {
                rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                        .setGroupMemberId(memberId)
                        .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                        .setGroupRemarks(guestGroupMember.getGroupRemarks())
                        .setGroupOwner(guestGroupMember.getGroupOwner())
                        .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                        .setGroupId(groupId)
                        .build();
            }

            rpcRegisteredGroupMemberList.add(rpcRegisteredGroupMember);
        }

        RegisteredGroupResponse guestGroupResponse =  RegisteredGroupResponse.newBuilder()
                .addAllResponseRegisteredGroupMember(rpcRegisteredGroupMemberList)
                .addAllResponseRegisteredGroup(rpcAddRegisteredGroupList)
                .addAllResponseGuestGroup(rpcAddGuestGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //某个注册用户关联的注册群成员列表和群列表（包含注册群和游客群）
    public RegisteredGroupResponse selectRegisteredGroupByGroupIdAndRegisteredUserId(TransmissionRequest request,SqlSession session){
        int originalGroupId = request.getRegisteredGroup().getGroupId();
        //registered group member
        QueryGroupWithGroupIdAndRegisteredUserIdService queryGroupWithRegisteredUserId = new QueryGroupWithGroupIdAndRegisteredUserIdService();
        List<RegisteredGroupMember> registeredGroupMemberList = queryGroupWithRegisteredUserId.selectRegisteredGroupMemberList(request ,session);
        List<RpcRegisteredGroupMember> rpcRegisteredGroupMemberList = new ArrayList<RpcRegisteredGroupMember>();
        List<RpcGuestGroup> rpcGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        List<RpcGuestGroup> rpcAddGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcAddRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = null;
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        GroupRemark groupRemark = null;
        int groupId = request.getRegisteredGroup().getGroupId();
        int registeredUserId = request.getRegisteredGroup().getRegisteredUserId();
        GroupMemberRemarkUtils groupMemberRemarkUtils = new GroupMemberRemarkUtils();
        List<RegisteredGroupMember> listGroupOwner = groupMemberRemarkUtils.getActionRegisteredGroupMemberWhoIsGroupOwner(registeredUserId, groupId);
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        int memberId = 0;
        for (RegisteredGroupMember guestGroupMember : registeredGroupMemberList){
            memberId = guestGroupMember.getGroupMemberId();
            rpcGuestGroupList = queryGroupWithRegisteredUserId.selectGuestGroupWithGroupIdAndRegisteredGroupMemberId(session, memberId, originalGroupId);
            //commonUtils.isHave(list)
            CommonUtils<RpcGuestGroup> commonUtils = new CommonUtils<>();
            if (commonUtils.isHave(rpcGuestGroupList)){
                if(!rpcAddGuestGroupList.containsAll(rpcGuestGroupList)){
                    rpcAddGuestGroupList.addAll(rpcGuestGroupList);
                }

                //-------备注
                if(null != listGroupOwner){
                    for(RegisteredGroupMember registeredGroupMember : listGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupId, registeredGroupMember.getGroupMemberId(), memberId);
                    }
                }
                //-------备注

                if(groupRemark != null){
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }else {
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }

                rpcRegisteredGroupMemberList.add(rpcRegisteredGroupMember);
            }
            rpcRegisteredGroupList = queryGroupWithRegisteredUserId.selectRegisteredGroupWithGroupIdAndRegisteredGroupMemberId(session, memberId, originalGroupId);
            //commonUtils.isHave(list)
            CommonUtils<RpcRegisteredGroup> commonUtils1 = new CommonUtils<>();
            if (commonUtils1.isHave(rpcRegisteredGroupList)){
                if(!rpcAddRegisteredGroupList.containsAll(rpcRegisteredGroupList)){
                    rpcAddRegisteredGroupList.addAll(rpcRegisteredGroupList);
                }
                //-------备注
                if(null != listGroupOwner){
                    for(RegisteredGroupMember registeredGroupMember : listGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupId, registeredGroupMember.getGroupMemberId(), memberId);
                    }
                }
                //-------备注

                if(groupRemark != null){
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }else {
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }

                rpcRegisteredGroupMemberList.add(rpcRegisteredGroupMember);
            }
        }

        //Guest group member
        QueryGroupWithGroupIdAndGuestUserIdService queryGroupWithGuestUserId = new QueryGroupWithGroupIdAndGuestUserIdService();
        List<GuestGroupMember> guestGroupMemberList = queryGroupWithGuestUserId.selectGuestGroupMemberList(request ,session);
        List<RpcGuestGroupMember> rpcGuestGroupMemberList = new ArrayList<RpcGuestGroupMember>();
        RpcGuestGroupMember rpcGuestGroupMember = null;

        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        groupRemark = null;
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新

        for (GuestGroupMember guestGroupMember : guestGroupMemberList){
            memberId = guestGroupMember.getGroupMemberId();
            rpcGuestGroupList = queryGroupWithGuestUserId.selectGuestGroupWithGuestGroupMemberIdAndGroupId(session, memberId, originalGroupId);
            //commonUtils.isHave(list)
            CommonUtils<RpcGuestGroup> commonUtils1 = new CommonUtils<>();
            if (commonUtils1.isHave(rpcGuestGroupList)){

                if(!rpcAddGuestGroupList.containsAll(rpcGuestGroupList)){
                    rpcAddGuestGroupList.addAll(rpcGuestGroupList);
                }

                //-------备注----注册群主是否给游客成员设置了备注
                if(null != listGroupOwner){
                    for(RegisteredGroupMember registeredGroupMember : listGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupId, registeredGroupMember.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----注册群主是否给游客成员设置了备注

                if(null != groupRemark){
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }else {
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }

                rpcGuestGroupMemberList.add(rpcGuestGroupMember);
            }
            //commonUtils.isHave(list)
            CommonUtils<RpcRegisteredGroup> commonUtils = new CommonUtils<>();
            rpcRegisteredGroupList = queryGroupWithGuestUserId.selectRegisteredGroupWithGuestGroupMemberIdAndGroupId(session, memberId, originalGroupId);
            if (commonUtils.isHave(rpcRegisteredGroupList)){
                if(!rpcAddRegisteredGroupList.containsAll(rpcRegisteredGroupList)){
                    rpcAddRegisteredGroupList.addAll(rpcRegisteredGroupList);
                }
                //-------备注----注册群主是否给游客成员设置了备注
                if(null != listGroupOwner){
                    for(RegisteredGroupMember registeredGroupMember : listGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupId, registeredGroupMember.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----注册群主是否给游客成员设置了备注

                if(null != groupRemark){
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }else {
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(originalGroupId)
                            .build();
                }

                rpcGuestGroupMemberList.add(rpcGuestGroupMember);
            }
        }
        RegisteredGroupResponse guestGroupResponse =  RegisteredGroupResponse.newBuilder()
                .addAllResponseRegisteredGroupMember(rpcRegisteredGroupMemberList)
                .addAllResponseGuestGroupMember(rpcGuestGroupMemberList)
                .addAllResponseRegisteredGroup(rpcAddRegisteredGroupList)
                .addAllResponseGuestGroup(rpcAddGuestGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //通过群名查找注册群
    public RegisteredGroupResponse selectRegisteredGroupByGroupName(TransmissionRequest request,SqlSession session){
        String groupName = request.getRegisteredGroup().getGroupName();
        RegisteredGroupService registeredGroupService = new RegisteredGroupService();
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        List<RegisteredGroup> registeredGroupList = registeredGroupService.selectAllRecords(session, registeredGroupMapper);
        String tempName = "";
        List<RpcRegisteredGroup> rpcRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        for (RegisteredGroup registeredGroup : registeredGroupList){
            tempName = registeredGroup.getGroupName();
            if(null != tempName){
                if(tempName.equals(groupName)){
                    rpcRegisteredGroupList.add(RpcRegisteredGroup.newBuilder()
                            .setRegisteredUserId(registeredGroup.getRegisteredUserId())
                            .setGroupId(registeredGroup.getGroupId())
                            .setGroupName(registeredGroup.getGroupName())
                            .setGroupAnnouncementId(registeredGroup.getGroupAnnouncementId())
                            .setCreationTime(registeredGroup.getCreationTime().getTime())
                            .setModificationTime(registeredGroup.getModificationTime().getTime())
                            .setAmount(registeredGroup.getAmount()).build());
                }
            }
        }

        RegisteredGroupResponse guestGroupResponse =  RegisteredGroupResponse.newBuilder()
                .addAllResponseRegisteredGroup(rpcRegisteredGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //查找注册群---group id 精确
    public RegisteredGroupResponse selectRegisteredGroupByGroupId(TransmissionRequest request,SqlSession session){
        int groupId = request.getRegisteredGroup().getGroupId();
        if(0 == groupId){
            RegisteredGroupResponse guestGroupResponse =  RegisteredGroupResponse.newBuilder()
                    .addResponseRegisteredGroup(request.getRegisteredGroup())
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR)
                    .build();
            logger.info(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR);
            return guestGroupResponse;
        }
        RegisteredGroup registeredGroup1 = new RegisteredGroup();
        registeredGroup1.setGroupId(groupId);
        RegisteredGroupService registeredGroupService = new RegisteredGroupService();
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        List<RegisteredGroup> registeredGroupList = registeredGroupService.selectRegisteredGroupByGroupId(session, registeredGroupMapper, registeredGroup1);
        List<RpcRegisteredGroup> rpcRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        for (RegisteredGroup registeredGroup : registeredGroupList){
            rpcRegisteredGroupList.add(RpcRegisteredGroup.newBuilder()
                    .setRegisteredUserId(registeredGroup.getRegisteredUserId())
                    .setGroupId(registeredGroup.getGroupId())
                    .setGroupName(registeredGroup.getGroupName())
                    .setGroupAnnouncementId(registeredGroup.getGroupAnnouncementId())
                    .setCreationTime(registeredGroup.getCreationTime().getTime())
                    .setModificationTime(registeredGroup.getModificationTime().getTime())
                    .setAmount(registeredGroup.getAmount()).build());
        }

        RegisteredGroupResponse guestGroupResponse =  RegisteredGroupResponse.newBuilder()
                .addAllResponseRegisteredGroup(rpcRegisteredGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //查找注册群---group id 模糊
    public RegisteredGroupResponse selectRegisteredGroupByGroupIdLike(TransmissionRequest request,SqlSession session){
        int groupId = request.getRegisteredGroup().getGroupId();
        if(0 == groupId){
            RegisteredGroupResponse guestGroupResponse =  RegisteredGroupResponse.newBuilder()
                    .addResponseRegisteredGroup(request.getRegisteredGroup())
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR)
                    .build();
            logger.info(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR);
            return guestGroupResponse;
        }
        RegisteredGroup registeredGroup1 = new RegisteredGroup();
        registeredGroup1.setGroupId(groupId);
        RegisteredGroupService registeredGroupService = new RegisteredGroupService();
        RegisteredGroupMapper registeredGroupMapper = session.getMapper(RegisteredGroupMapper.class);
        List<RegisteredGroup> registeredGroupList = registeredGroupService.selectRegisteredGroupByGroupIdLike(session, registeredGroupMapper, registeredGroup1);
        List<RpcRegisteredGroup> rpcRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        for (RegisteredGroup registeredGroup : registeredGroupList){
            rpcRegisteredGroupList.add(RpcRegisteredGroup.newBuilder()
                    .setRegisteredUserId(registeredGroup.getRegisteredUserId())
                    .setGroupId(registeredGroup.getGroupId())
                    .setGroupName(registeredGroup.getGroupName())
                    .setGroupAnnouncementId(registeredGroup.getGroupAnnouncementId())
                    .setCreationTime(registeredGroup.getCreationTime().getTime())
                    .setModificationTime(registeredGroup.getModificationTime().getTime())
                    .setAmount(registeredGroup.getAmount()).build());
        }

        RegisteredGroupResponse guestGroupResponse =  RegisteredGroupResponse.newBuilder()
                .addAllResponseRegisteredGroup(rpcRegisteredGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //通过群名查找游客群
    public GuestGroupResponse selectGuestGroupByGroupName(TransmissionRequest request,SqlSession session){
        String groupName = request.getGuestGroup().getGroupName();
        GuestGroupService guestGroupService = new GuestGroupService();
        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        List<GuestGroup> guestGroupList = guestGroupService.selectAllRecords(session, guestGroupMapper);
        String tempName = "";
        List<RpcGuestGroup> rpcGuestGroupList = new ArrayList<RpcGuestGroup>();
        for (GuestGroup registeredGroup : guestGroupList){
            tempName = registeredGroup.getGroupName();
            if(null != tempName){
                if(tempName.equals(groupName)){
                    rpcGuestGroupList.add(RpcGuestGroup.newBuilder()
                            .setGuestUserId(registeredGroup.getGuestUserId())
                            .setGroupId(registeredGroup.getGroupId())
                            .setGroupName(registeredGroup.getGroupName())
                            .setGroupAnnouncementId(registeredGroup.getGroupAnnouncementId())
                            .setCreationTime(registeredGroup.getCreationTime().getTime())
                            .setModificationTime(registeredGroup.getModificationTime().getTime())
                            .setAmount(registeredGroup.getAmount()).build());
                }
            }
        }

        GuestGroupResponse guestGroupResponse =  GuestGroupResponse.newBuilder()
                .addAllResponseGuestGroup(rpcGuestGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //通过群名查找游客群--group id 精确
    public GuestGroupResponse selectGuestGroupByGroupId(TransmissionRequest request,SqlSession session){
        int groupId = request.getGuestGroup().getGroupId();
        if(0 == groupId){
            GuestGroupResponse guestGroupResponse =  GuestGroupResponse.newBuilder()
                    .addResponseGuestGroup(request.getGuestGroup())
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR)
                    .build();
            logger.info(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR);
            return guestGroupResponse;
        }
        GuestGroupService guestGroupService = new GuestGroupService();
        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        GuestGroup guestGroup = new GuestGroup();
        guestGroup.setGroupId(request.getGuestGroup().getGroupId());
        List<GuestGroup> guestGroupList = guestGroupService.selectGuestGroupByGroupId(session, guestGroupMapper, guestGroup);
        List<RpcGuestGroup> rpcGuestGroupList = new ArrayList<RpcGuestGroup>();
        for (GuestGroup registeredGroup : guestGroupList){
            rpcGuestGroupList.add(RpcGuestGroup.newBuilder()
                    .setGuestUserId(registeredGroup.getGuestUserId())
                    .setGroupId(registeredGroup.getGroupId())
                    .setGroupName(registeredGroup.getGroupName())
                    .setGroupAnnouncementId(registeredGroup.getGroupAnnouncementId())
                    .setCreationTime(registeredGroup.getCreationTime().getTime())
                    .setModificationTime(registeredGroup.getModificationTime().getTime())
                    .setAmount(registeredGroup.getAmount()).build());
        }

        GuestGroupResponse guestGroupResponse =  GuestGroupResponse.newBuilder()
                .addAllResponseGuestGroup(rpcGuestGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //通过群名查找游客群--group id 精确
    public GuestGroupResponse selectGuestGroupByGroupIdLike(TransmissionRequest request,SqlSession session){
        int groupId = request.getGuestGroup().getGroupId();
        if(0 == groupId){
            GuestGroupResponse guestGroupResponse =  GuestGroupResponse.newBuilder()
                    .addResponseGuestGroup(request.getGuestGroup())
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR)
                    .build();
            logger.info(ConstantsContent.RESPONSE_FAILURE_REQUEST_ERROR);
            return guestGroupResponse;
        }
        GuestGroupService guestGroupService = new GuestGroupService();
        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        GuestGroup guestGroup = new GuestGroup();
        guestGroup.setGroupId(request.getGuestGroup().getGroupId());
        List<GuestGroup> guestGroupList = guestGroupService.selectGuestGroupByGroupIdLike(session, guestGroupMapper, guestGroup);
        List<RpcGuestGroup> rpcGuestGroupList = new ArrayList<RpcGuestGroup>();
        for (GuestGroup registeredGroup : guestGroupList){
            rpcGuestGroupList.add(RpcGuestGroup.newBuilder()
                    .setGuestUserId(registeredGroup.getGuestUserId())
                    .setGroupId(registeredGroup.getGroupId())
                    .setGroupName(registeredGroup.getGroupName())
                    .setGroupAnnouncementId(registeredGroup.getGroupAnnouncementId())
                    .setCreationTime(registeredGroup.getCreationTime().getTime())
                    .setModificationTime(registeredGroup.getModificationTime().getTime())
                    .setAmount(registeredGroup.getAmount()).build());
        }

        GuestGroupResponse guestGroupResponse =  GuestGroupResponse.newBuilder()
                .addAllResponseGuestGroup(rpcGuestGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //某个游客用户关联的游客群成员列表和群列表（包含注册群和游客群）
    public GuestGroupResponse selectGuestGroupByGuestUserId(TransmissionRequest request,SqlSession session){
        QueryGroupWithGuestUserIdService queryGroupWithGuestUserId = new QueryGroupWithGuestUserIdService();
        List<GuestGroupMember> guestGroupMemberList = queryGroupWithGuestUserId.selectGroupMemberListWithGuestUserId(request ,session);
        List<RpcGuestGroupMember> rpcGuestGroupMemberList = new ArrayList<RpcGuestGroupMember>();
        List<RpcGuestGroup> rpcAddGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcAddRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        List<RpcGuestGroup> rpcGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        RpcGuestGroupMember rpcGuestGroupMember = null;
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        GroupRemark groupRemark = null;
        int groupId = request.getGuestGroup().getGroupId();
        int guestUserId = request.getGuestGroup().getGuestUserId();
        GroupMemberRemarkUtils groupMemberRemarkUtils = new GroupMemberRemarkUtils();
        List<GuestGroupMember> listGuestGroupOwner = groupMemberRemarkUtils.getActionGuestGroupMemberWhoIsGroupOwner(guestUserId, groupId);
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        int memberId = 0;
        for (GuestGroupMember guestGroupMember : guestGroupMemberList){
            memberId = guestGroupMember.getGroupMemberId();
            rpcGuestGroupList = queryGroupWithGuestUserId.selectGuestGroupWithGuestGroupMemberId(session, memberId);
            //commonUtils.isHave(list)
            CommonUtils<RpcGuestGroup> commonUtils1 = new CommonUtils<>();
            if (commonUtils1.isHave(rpcGuestGroupList)){
                groupId = rpcGuestGroupList.get(0).getGroupId();
                rpcAddGuestGroupList.addAll(rpcGuestGroupList);
                //-------备注----游客群主群主是否给游客成员设置了备注
                if(null != listGuestGroupOwner){
                    for(GuestGroupMember guestGroupMember1 : listGuestGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupId, guestGroupMember1.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----游客群主是否给游客成员设置了备注
                if(null != groupRemark){
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupId)
                            .build();
                }else {
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupId)
                            .build();
                }

                rpcGuestGroupMemberList.add(rpcGuestGroupMember);
            }
            rpcRegisteredGroupList = queryGroupWithGuestUserId.selectRegisteredGroupWithGuestGroupMemberId(session, memberId);
            //commonUtils.isHave(list)
            CommonUtils<RpcRegisteredGroup> commonUtils = new CommonUtils<>();
            if (commonUtils.isHave(rpcRegisteredGroupList)){
                groupId = rpcRegisteredGroupList.get(0).getGroupId();
                rpcAddRegisteredGroupList.addAll(rpcRegisteredGroupList);
                //-------备注----游客群主群主是否给游客成员设置了备注
                if(null != listGuestGroupOwner){
                    for(GuestGroupMember guestGroupMember1 : listGuestGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupId, guestGroupMember1.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----游客群主是否给游客成员设置了备注
                if(null != groupRemark){
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupId)
                            .build();
                }else {
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupId)
                            .build();
                }

                rpcGuestGroupMemberList.add(rpcGuestGroupMember);
            }
        }

        GuestGroupResponse guestGroupResponse =  GuestGroupResponse.newBuilder()
                .addAllResponseGuestGroupMember(rpcGuestGroupMemberList)
                .addAllResponseRegisteredGroup(rpcAddRegisteredGroupList)
                .addAllResponseGuestGroup(rpcAddGuestGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //某个游客用户关联的游客群成员列表和群列表（包含注册群和游客群）
    public GuestGroupResponse selectGuestGroupByGuestUserIdAndGroupId(TransmissionRequest request,SqlSession session){
        int groupOriginalId = request.getGuestGroup().getGroupId();
        //Guest group member
        QueryGroupWithGroupIdAndGuestUserIdService queryGroupWithGuestUserId = new QueryGroupWithGroupIdAndGuestUserIdService();
        List<GuestGroupMember> guestGroupMemberList = queryGroupWithGuestUserId.selectGuestGroupMemberList(request ,session);
        List<RpcGuestGroupMember> rpcGuestGroupMemberList = new ArrayList<RpcGuestGroupMember>();
        List<RpcGuestGroup> rpcAddGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcAddRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        List<RpcGuestGroup> rpcGuestGroupList = new ArrayList<RpcGuestGroup>();
        List<RpcRegisteredGroup> rpcRegisteredGroupList = new ArrayList<RpcRegisteredGroup>();
        RpcGuestGroupMember rpcGuestGroupMember = null;
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        GroupRemark groupRemark = null;
        int guestUserId = request.getGuestGroup().getGuestUserId();
        GroupMemberRemarkUtils groupMemberRemarkUtils = new GroupMemberRemarkUtils();
        List<GuestGroupMember> listGuestGroupOwner = groupMemberRemarkUtils.getActionGuestGroupMemberWhoIsGroupOwner(guestUserId, groupOriginalId);
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        int memberId = 0;
        for (GuestGroupMember guestGroupMember : guestGroupMemberList){
            memberId = guestGroupMember.getGroupMemberId();
            rpcGuestGroupList = queryGroupWithGuestUserId.selectGuestGroupWithGuestGroupMemberIdAndGroupId(session, memberId, groupOriginalId);
            //commonUtils.isHave(list)
            CommonUtils<RpcGuestGroup> commonUtils = new CommonUtils<>();
            if (commonUtils.isHave(rpcGuestGroupList)){
                if(!rpcAddGuestGroupList.containsAll(rpcGuestGroupList)){
                    rpcAddGuestGroupList.addAll(rpcGuestGroupList);
                }
                //-------备注----游客群主群主是否给游客成员设置了备注
                if(null != listGuestGroupOwner){
                    for(GuestGroupMember guestGroupMember1 : listGuestGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupOriginalId, guestGroupMember1.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----游客群主是否给游客成员设置了备注
                if(null != groupRemark){
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }else {
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }

                rpcGuestGroupMemberList.add(rpcGuestGroupMember);
            }
            rpcRegisteredGroupList = queryGroupWithGuestUserId.selectRegisteredGroupWithGuestGroupMemberIdAndGroupId(session, memberId, groupOriginalId);
            //commonUtils.isHave(list)
            CommonUtils<RpcRegisteredGroup> commonUtils1 = new CommonUtils<>();
            if (commonUtils1.isHave(rpcRegisteredGroupList)){
                if(!rpcAddRegisteredGroupList.containsAll(rpcRegisteredGroupList)){
                    rpcAddRegisteredGroupList.addAll(rpcRegisteredGroupList);
                }
                //-------备注----游客群主群主是否给游客成员设置了备注
                if(null != listGuestGroupOwner){
                    for(GuestGroupMember guestGroupMember1 : listGuestGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupOriginalId, guestGroupMember1.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----游客群主是否给游客成员设置了备注
                if(null != groupRemark){
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }else {
                    rpcGuestGroupMember = RpcGuestGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setGuestUserId(guestGroupMember.getGuestUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }

                rpcGuestGroupMemberList.add(rpcGuestGroupMember);
            }
        }

        //registered group member
        QueryGroupWithGroupIdAndRegisteredUserIdService queryGroupWithRegisteredUserId = new QueryGroupWithGroupIdAndRegisteredUserIdService();
        List<RegisteredGroupMember> registeredGroupMembers = queryGroupWithRegisteredUserId.selectRegisteredGroupMemberList(request ,session);
        List<RpcRegisteredGroupMember> rpcRegisteredGroupMemberList = new ArrayList<RpcRegisteredGroupMember>();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = null;
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        groupRemark = null;
        //-------备注------每个成员在每个群里的备注是唯一的，只能重复更新
        for (RegisteredGroupMember guestGroupMember : registeredGroupMembers){
            memberId = guestGroupMember.getGroupMemberId();
            rpcGuestGroupList = queryGroupWithRegisteredUserId.selectGuestGroupWithGroupIdAndRegisteredGroupMemberId(session, memberId, groupOriginalId);
            //commonUtils.isHave(list)
            CommonUtils<RpcGuestGroup> commonUtils1 = new CommonUtils<>();
            if (commonUtils1.isHave(rpcGuestGroupList)){
                if(!rpcAddGuestGroupList.containsAll(rpcGuestGroupList)){
                    rpcAddGuestGroupList.addAll(rpcGuestGroupList);
                }

                //-------备注----游客群主群主是否给注册成员设置了备注
                if(null != listGuestGroupOwner){
                    for(GuestGroupMember guestGroupMember1 : listGuestGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupOriginalId, guestGroupMember1.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----游客群主是否给注册成员设置了备注

                if(null != groupRemark){
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }else {
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }

                rpcRegisteredGroupMemberList.add(rpcRegisteredGroupMember);
            }
            rpcRegisteredGroupList = queryGroupWithRegisteredUserId.selectRegisteredGroupWithGroupIdAndRegisteredGroupMemberId(session, memberId, groupOriginalId);
            //commonUtils.isHave(list)
            CommonUtils<RpcRegisteredGroup> commonUtils = new CommonUtils<>();
            if (commonUtils.isHave(rpcRegisteredGroupList)){
                if(!rpcAddRegisteredGroupList.containsAll(rpcRegisteredGroupList)){
                    rpcAddRegisteredGroupList.addAll(rpcRegisteredGroupList);
                }
                //-------备注----游客群主群主是否给注册成员设置了备注
                if(null != listGuestGroupOwner){
                    for(GuestGroupMember guestGroupMember1 : listGuestGroupOwner){
                        groupRemark = groupMemberRemarkUtils.selectGroupMemberRemark(groupOriginalId, guestGroupMember1.getGroupMemberId(), memberId);
                    }
                }
                //-------备注----游客群主是否给注册成员设置了备注

                if(null != groupRemark){
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(groupRemark.getRemark())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }else {
                    rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(memberId)
                            .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                            .setGroupRemarks(guestGroupMember.getGroupRemarks())
                            .setGroupOwner(guestGroupMember.getGroupOwner())
                            .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                            .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                            .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                            .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                            .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                            .setGroupId(groupOriginalId)
                            .build();
                }

                rpcRegisteredGroupMemberList.add(rpcRegisteredGroupMember);
            }
        }
        GuestGroupResponse guestGroupResponse =  GuestGroupResponse.newBuilder()
                .addAllResponseRegisteredGroupMember(rpcRegisteredGroupMemberList)
                .addAllResponseGuestGroupMember(rpcGuestGroupMemberList)
                .addAllResponseRegisteredGroup(rpcAddRegisteredGroupList)
                .addAllResponseGuestGroup(rpcAddGuestGroupList)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return guestGroupResponse;

    }

    //某个注册用户关联的注册群成员列表
    public RegisteredGroupMemberResponse selectRegisteredGroupMemberByRegisteredUserId(TransmissionRequest request,SqlSession session){
        RegisteredGroupMemberMapper mapperb = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupMemberService guestUserFriendService = new RegisteredGroupMemberService();
        RegisteredGroupMember registeredGroupMember = new RegisteredGroupMember();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
        registeredGroupMember.setRegisteredUserId(rpcRegisteredGroupMember.getRegisteredUserId());
        registeredGroupMember.setGroupMemberId(rpcRegisteredGroupMember.getGroupMemberId());
        List<RegisteredGroupMember> list = guestUserFriendService.selectRegisteredGroupMemberByRegisteredUserId(session, mapperb, registeredGroupMember);
        List<RpcRegisteredGroupMember> listResponse = new ArrayList<RpcRegisteredGroupMember>();
        //commonUtils.isHave(list)
        CommonUtils<RegisteredGroupMember> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (RegisteredGroupMember  registeredGroupMember1: list){
                listResponse.add(RpcRegisteredGroupMember.newBuilder()
                        .setGroupMemberId(registeredGroupMember1.getGroupMemberId())
                        .setRegisteredUserId(registeredGroupMember1.getRegisteredUserId())
                        .setGroupRemarks(registeredGroupMember1.getGroupRemarks())
                        .setGroupOwner(registeredGroupMember1.getGroupOwner())
                        .setBurnAfterReadingSettings(registeredGroupMember1.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(registeredGroupMember1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(registeredGroupMember1.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(registeredGroupMember1.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(registeredGroupMember1.getOfflineMessageSetting())
                        .build());
            }
            RegisteredGroupMemberResponse guestGroupMemberResponse =  RegisteredGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestGroupMemberResponse;
        }else {
            RegisteredGroupMemberResponse guestGroupMemberResponse =  RegisteredGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestGroupMemberResponse;
        }

    }

    //某个注册用户关联的注册群成员列表---member id模糊匹配
    public RegisteredGroupMemberResponse selectRegisteredGroupMemberByRegisteredMemberIdLike(TransmissionRequest request,SqlSession session){
        RegisteredGroupMemberMapper mapperb = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupMemberService guestUserFriendService = new RegisteredGroupMemberService();
        RegisteredGroupMember registeredGroupMember = new RegisteredGroupMember();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
        registeredGroupMember.setRegisteredUserId(rpcRegisteredGroupMember.getRegisteredUserId());
        registeredGroupMember.setGroupMemberId(rpcRegisteredGroupMember.getGroupMemberId());
        List<RegisteredGroupMember> list = guestUserFriendService.selectRegisteredGroupMemberByGroupMemberIdLike(session, mapperb, registeredGroupMember);
        List<RpcRegisteredGroupMember> listResponse = new ArrayList<RpcRegisteredGroupMember>();
        //commonUtils.isHave(list)
        CommonUtils<RegisteredGroupMember> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (RegisteredGroupMember  registeredGroupMember1: list){
                listResponse.add(RpcRegisteredGroupMember.newBuilder()
                        .setGroupMemberId(registeredGroupMember1.getGroupMemberId())
                        .setRegisteredUserId(registeredGroupMember1.getRegisteredUserId())
                        .setGroupRemarks(registeredGroupMember1.getGroupRemarks())
                        .setGroupOwner(registeredGroupMember1.getGroupOwner())
                        .setBurnAfterReadingSettings(registeredGroupMember1.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(registeredGroupMember1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(registeredGroupMember1.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(registeredGroupMember1.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(registeredGroupMember1.getOfflineMessageSetting())
                        .build());
            }
            RegisteredGroupMemberResponse guestGroupMemberResponse =  RegisteredGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestGroupMemberResponse;
        }else {
            RegisteredGroupMemberResponse guestGroupMemberResponse =  RegisteredGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestGroupMemberResponse;
        }

    }

    //某个注册用户关联的注册群成员列表---member id精确匹配
    public RegisteredGroupMemberResponse selectRegisteredGroupMemberByRegisteredMemberId(TransmissionRequest request,SqlSession session){
        RegisteredGroupMemberMapper mapperb = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredGroupMemberService guestUserFriendService = new RegisteredGroupMemberService();
        RegisteredGroupMember registeredGroupMember = new RegisteredGroupMember();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
        registeredGroupMember.setRegisteredUserId(rpcRegisteredGroupMember.getRegisteredUserId());
        registeredGroupMember.setGroupMemberId(rpcRegisteredGroupMember.getGroupMemberId());
        List<RegisteredGroupMember> list = guestUserFriendService.selectRegisteredGroupMemberByGroupMemberId(session, mapperb, registeredGroupMember);
        List<RpcRegisteredGroupMember> listResponse = new ArrayList<RpcRegisteredGroupMember>();
        //commonUtils.isHave(list)
        CommonUtils<RegisteredGroupMember> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (RegisteredGroupMember  registeredGroupMember1: list){
                listResponse.add(RpcRegisteredGroupMember.newBuilder()
                        .setGroupMemberId(registeredGroupMember1.getGroupMemberId())
                        .setRegisteredUserId(registeredGroupMember1.getRegisteredUserId())
                        .setGroupRemarks(registeredGroupMember1.getGroupRemarks())
                        .setGroupOwner(registeredGroupMember1.getGroupOwner())
                        .setBurnAfterReadingSettings(registeredGroupMember1.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(registeredGroupMember1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(registeredGroupMember1.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(registeredGroupMember1.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(registeredGroupMember1.getOfflineMessageSetting())
                        .build());
            }
            RegisteredGroupMemberResponse guestGroupMemberResponse =  RegisteredGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestGroupMemberResponse;
        }else {
            RegisteredGroupMemberResponse guestGroupMemberResponse =  RegisteredGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestGroupMemberResponse;
        }

    }

    //游客群成员模糊匹配---member id
    public GuestGroupMemberResponse selectGuestGroupMemberByGuestMemberIdLike(TransmissionRequest request,SqlSession session){
        GuestGroupMemberMapper mapperb = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupMemberService guestUserFriendService = new GuestGroupMemberService();
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        guestGroupMember.setGuestUserId(rpcGuestGroupMember.getGuestUserId());
        guestGroupMember.setGroupMemberId(rpcGuestGroupMember.getGroupMemberId());
        List<GuestGroupMember> list = guestUserFriendService.selectGuestGroupMemberByGroupMemberIdLike(session, mapperb, guestGroupMember);
        List<RpcGuestGroupMember> listResponse = new ArrayList<RpcGuestGroupMember>();
        //commonUtils.isHave(list)
        CommonUtils<GuestGroupMember> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (GuestGroupMember  guestGroupMember1: list){
                listResponse.add(RpcGuestGroupMember.newBuilder()
                        .setGroupMemberId(guestGroupMember1.getGroupMemberId())
                        .setGuestUserId(guestGroupMember1.getGuestUserId())
                        .setGroupRemarks(guestGroupMember1.getGroupRemarks())
                        .setGroupOwner(guestGroupMember1.getGroupOwner())
                        .setBurnAfterReadingSettings(guestGroupMember1.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(guestGroupMember1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestGroupMember1.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(guestGroupMember1.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(guestGroupMember1.getOfflineMessageSetting())
                        .build());
            }
            GuestGroupMemberResponse guestGroupMemberResponse =  GuestGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestGroupMemberResponse;
        }else {
            GuestGroupMemberResponse guestGroupMemberResponse =  GuestGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestGroupMemberResponse;
        }

    }

    //游客群成员精确匹配---member id
    public GuestGroupMemberResponse selectGuestGroupMemberByGuestMemberId(TransmissionRequest request,SqlSession session){
        GuestGroupMemberMapper mapperb = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupMemberService guestUserFriendService = new GuestGroupMemberService();
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        guestGroupMember.setGuestUserId(rpcGuestGroupMember.getGuestUserId());
        guestGroupMember.setGroupMemberId(rpcGuestGroupMember.getGroupMemberId());
        List<GuestGroupMember> list = guestUserFriendService.selectGuestGroupMemberByGroupMemberId(session, mapperb, guestGroupMember);
        List<RpcGuestGroupMember> listResponse = new ArrayList<RpcGuestGroupMember>();
        //commonUtils.isHave(list)
        CommonUtils<GuestGroupMember> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (GuestGroupMember  guestGroupMember1: list){
                listResponse.add(RpcGuestGroupMember.newBuilder()
                        .setGroupMemberId(guestGroupMember1.getGroupMemberId())
                        .setGuestUserId(guestGroupMember1.getGuestUserId())
                        .setGroupRemarks(guestGroupMember1.getGroupRemarks())
                        .setGroupOwner(guestGroupMember1.getGroupOwner())
                        .setBurnAfterReadingSettings(guestGroupMember1.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(guestGroupMember1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestGroupMember1.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(guestGroupMember1.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(guestGroupMember1.getOfflineMessageSetting())
                        .build());
            }
            GuestGroupMemberResponse guestGroupMemberResponse =  GuestGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestGroupMemberResponse;
        }else {
            GuestGroupMemberResponse guestGroupMemberResponse =  GuestGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestGroupMemberResponse;
        }

    }

    //某个游客用户关联的游客群成员列表
    public GuestGroupMemberResponse selectGuestGroupMemberByGuestUserId(TransmissionRequest request,SqlSession session){
        GuestGroupMemberMapper mapperb = session.getMapper(GuestGroupMemberMapper.class);
        GuestGroupMemberService guestUserFriendService = new GuestGroupMemberService();
        GuestGroupMember guestGroupMember = new GuestGroupMember();
        RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
        guestGroupMember.setGuestUserId(rpcGuestGroupMember.getGuestUserId());
        guestGroupMember.setGroupMemberId(rpcGuestGroupMember.getGroupMemberId());
        List<GuestGroupMember> list = guestUserFriendService.selectGuestGroupMemberByGuestUserId(session, mapperb, guestGroupMember);
        List<RpcGuestGroupMember> listResponse = new ArrayList<RpcGuestGroupMember>();
        //commonUtils.isHave(list)
        CommonUtils<GuestGroupMember> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (GuestGroupMember  guestGroupMember1: list){
                listResponse.add(RpcGuestGroupMember.newBuilder()
                        .setGroupMemberId(guestGroupMember1.getGroupMemberId())
                        .setGuestUserId(guestGroupMember1.getGuestUserId())
                        .setGroupRemarks(guestGroupMember1.getGroupRemarks())
                        .setGroupOwner(guestGroupMember1.getGroupOwner())
                        .setBurnAfterReadingSettings(guestGroupMember1.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(guestGroupMember1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestGroupMember1.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(guestGroupMember1.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(guestGroupMember1.getOfflineMessageSetting())
                        .build());
            }
            GuestGroupMemberResponse guestGroupMemberResponse =  GuestGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestGroupMemberResponse;
        }else {
            GuestGroupMemberResponse guestGroupMemberResponse =  GuestGroupMemberResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestGroupMemberResponse;
        }

    }

    //某个游客用户关联的游客好友列表
    public GuestUserFriendResponse selectGuestUserFriendByGuestUserId(TransmissionRequest request,SqlSession session){
        GuestUserFriendMapper mapperb = session.getMapper(GuestUserFriendMapper.class);
        GuestUserFriendService guestUserFriendService = new GuestUserFriendService();
        GuestUserFriend guestUserFriend = new GuestUserFriend();
        RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
        guestUserFriend.setGuestUserId(rpcGuestUserFriend.getGuestUserId());
        guestUserFriend.setFriendId(rpcGuestUserFriend.getFriendId());
        List<GuestUserFriend> list = guestUserFriendService.selectGuestUserFriendByGuestUserId(session, mapperb, guestUserFriend);
        List<RpcGuestUserFriend> listResponse = new ArrayList<>();
        //commonUtils.isHave(list)
        CommonUtils<GuestUserFriend> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (GuestUserFriend  guestUserFriend1: list){
                listResponse.add(RpcGuestUserFriend.newBuilder()
                        .setGuestUserId(guestUserFriend1.getGuestUserId())
                        .setFriendId(guestUserFriend1.getFriendId())
                        .setFriendUserId(guestUserFriend1.getFriendUserId())
                        .setFriendComment(guestUserFriend1.getFriendComment())
                        .setCreationTime(guestUserFriend1.getCreationTime().getTime())
                        .setModificationTime(guestUserFriend1.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend1.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend1.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend1.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend1.getFriendNickName())
                        .build());
            }
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestUserFriendResponse;
        }else {
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestUserFriendResponse;
        }

    }

    //某个用户被加为好友的游客好友列表---用户可能为注册用户，也可能为游客用户
    public GuestUserFriendResponse selectGuestUserFriendByFriendUserId(TransmissionRequest request,SqlSession session){
        GuestUserFriendMapper mapperb = session.getMapper(GuestUserFriendMapper.class);
        GuestUserFriendService guestUserFriendService = new GuestUserFriendService();
        GuestUserFriend guestUserFriend = new GuestUserFriend();
        RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
        guestUserFriend.setGuestUserId(rpcGuestUserFriend.getGuestUserId());
        guestUserFriend.setFriendUserId(rpcGuestUserFriend.getFriendUserId());
        List<GuestUserFriend> list = guestUserFriendService.selectGuestUserFriendByFriendUserId(session, mapperb, guestUserFriend);
        List<RpcGuestUserFriend> listResponse = new ArrayList<RpcGuestUserFriend>();
        //commonUtils.isHave(list)
        CommonUtils<GuestUserFriend> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (GuestUserFriend  guestUserFriend1: list){
                listResponse.add(RpcGuestUserFriend.newBuilder()
                        .setGuestUserId(guestUserFriend1.getGuestUserId())
//                        .setFriendId(guestUserFriend1.getFriendId())
                        .setFriendUserId(guestUserFriend1.getFriendUserId())
                        .setFriendComment(guestUserFriend1.getFriendComment())
//                        .setCreationTime(guestUserFriend1.getCreationTime().getTime())
//                        .setModificationTime(guestUserFriend1.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend1.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend1.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend1.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend1.getFriendNickName())
                        .build());
            }
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestUserFriendResponse;
        }else {
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestUserFriendResponse;
        }

    }

    //好友列表 --friend id 精确
    public GuestUserFriendResponse selectGuestUserFriendByFriendId(TransmissionRequest request,SqlSession session){
        GuestUserFriendMapper mapperb = session.getMapper(GuestUserFriendMapper.class);
        GuestUserFriendService guestUserFriendService = new GuestUserFriendService();
        GuestUserFriend guestUserFriend = new GuestUserFriend();
        RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
        guestUserFriend.setGuestUserId(rpcGuestUserFriend.getGuestUserId());
        guestUserFriend.setFriendId(rpcGuestUserFriend.getFriendId());
        List<GuestUserFriend> list = guestUserFriendService.selectGuestUserFriendByFriendId(session, mapperb, guestUserFriend);
        List<RpcGuestUserFriend> listResponse = new ArrayList<RpcGuestUserFriend>();
        //commonUtils.isHave(list)
        CommonUtils<GuestUserFriend> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (GuestUserFriend  guestUserFriend1: list){
                listResponse.add(RpcGuestUserFriend.newBuilder()
                        .setGuestUserId(guestUserFriend1.getGuestUserId())
                        .setFriendId(guestUserFriend1.getFriendId())
                        .setFriendUserId(guestUserFriend1.getFriendUserId())
                        .setFriendComment(guestUserFriend1.getFriendComment())
                        .setCreationTime(guestUserFriend1.getCreationTime().getTime())
                        .setModificationTime(guestUserFriend1.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend1.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend1.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend1.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend1.getFriendNickName())
                        .build());
            }
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestUserFriendResponse;
        }else {
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestUserFriendResponse;
        }

    }

    //好友列表 --friend id 模糊
    public GuestUserFriendResponse selectGuestUserFriendByFriendIdLike(TransmissionRequest request,SqlSession session){
        GuestUserFriendMapper mapperb = session.getMapper(GuestUserFriendMapper.class);
        GuestUserFriendService guestUserFriendService = new GuestUserFriendService();
        GuestUserFriend guestUserFriend = new GuestUserFriend();
        RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
        guestUserFriend.setGuestUserId(rpcGuestUserFriend.getGuestUserId());
        guestUserFriend.setFriendId(rpcGuestUserFriend.getFriendId());
        List<GuestUserFriend> list = guestUserFriendService.selectGuestUserFriendByFriendIdLike(session, mapperb, guestUserFriend);
        List<RpcGuestUserFriend> listResponse = new ArrayList<RpcGuestUserFriend>();
        //commonUtils.isHave(list)
        CommonUtils<GuestUserFriend> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (GuestUserFriend  guestUserFriend1: list){
                listResponse.add(RpcGuestUserFriend.newBuilder()
                        .setGuestUserId(guestUserFriend1.getGuestUserId())
                        .setFriendId(guestUserFriend1.getFriendId())
                        .setFriendUserId(guestUserFriend1.getFriendUserId())
                        .setFriendComment(guestUserFriend1.getFriendComment())
                        .setCreationTime(guestUserFriend1.getCreationTime().getTime())
                        .setModificationTime(guestUserFriend1.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend1.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend1.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend1.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend1.getFriendNickName())
                        .build());
            }
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestUserFriendResponse;
        }else {
            GuestUserFriendResponse guestUserFriendResponse =  GuestUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestUserFriendResponse;
        }

    }

    //某个注册用户关联的注册好友列表
    public RegisteredUserFriendResponse selectRegisteredUserFriendByRegisteredUserId(TransmissionRequest request,SqlSession session){
        RegisteredUserFriendMapper mapperb = session.getMapper(RegisteredUserFriendMapper.class);
        RegisteredUserFriendService guestUserFriendService = new RegisteredUserFriendService();
        RegisteredUserFriend guestUserFriend = new RegisteredUserFriend();
        RpcRegisteredUserFriend rpcRegisteredUserFriend = request.getRegisteredUserFriend();
        guestUserFriend.setRegisteredUserId(rpcRegisteredUserFriend.getRegisteredUserId());
        guestUserFriend.setFriendId(rpcRegisteredUserFriend.getFriendId());
        List<RegisteredUserFriend> list = guestUserFriendService.selectRegisteredUserFriendByRegisteredUserId(session, mapperb, guestUserFriend);
        List<RpcRegisteredUserFriend> listResponse = new ArrayList<>();
        //commonUtils.isHave(list)
        CommonUtils<RegisteredUserFriend> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (RegisteredUserFriend  guestUserFriend1: list){
                listResponse.add(RpcRegisteredUserFriend.newBuilder()
                        .setRegisteredUserId(guestUserFriend1.getRegisteredUserId())
                        .setFriendId(guestUserFriend1.getFriendId())
                        .setFriendUserId(guestUserFriend1.getFriendUserId())
                        .setFriendComment(guestUserFriend1.getFriendComment())
                        .setCreationTime(guestUserFriend1.getCreationTime().getTime())
                        .setModificationTime(guestUserFriend1.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend1.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend1.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend1.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend1.getFriendNickName())
                        .build());
            }
            RegisteredUserFriendResponse guestUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestUserFriendResponse;
        }else {
            RegisteredUserFriendResponse guestUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestUserFriendResponse;
        }

    }

    //某个用户被加为好友的注册好友列表---用户可能为注册用户，也可能为游客用户
    public RegisteredUserFriendResponse selectRegisteredUserFriendByFriendUserId(TransmissionRequest request,SqlSession session){
        RegisteredUserFriendMapper mapperb = session.getMapper(RegisteredUserFriendMapper.class);
        RegisteredUserFriendService registeredUserFriendService = new RegisteredUserFriendService();
        RegisteredUserFriend registeredUserFriend = new RegisteredUserFriend();
        RpcRegisteredUserFriend rpcRegisteredUserFriend = request.getRegisteredUserFriend();
        registeredUserFriend.setRegisteredUserId(rpcRegisteredUserFriend.getRegisteredUserId());
        registeredUserFriend.setFriendUserId(rpcRegisteredUserFriend.getFriendUserId());
        List<RegisteredUserFriend> registerList = registeredUserFriendService.selectRegisteredUserFriendByFriendUserId(session, mapperb, registeredUserFriend);
        List<RpcRegisteredUserFriend> listResponse = new ArrayList<>();
        //commonUtils.isHave(list)
        CommonUtils<RegisteredUserFriend> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(registerList)){
            for (RegisteredUserFriend  regUserFriend: registerList){
                listResponse.add(RpcRegisteredUserFriend.newBuilder()
                        .setRegisteredUserId(regUserFriend.getRegisteredUserId())
                        .setFriendId(regUserFriend.getFriendId())
                        .setFriendUserId(regUserFriend.getFriendUserId())
                        .setFriendComment(regUserFriend.getFriendComment())
//                        .setCreationTime(guestUserFriend1.getCreationTime().getTime())
//                        .setModificationTime(guestUserFriend1.getModificationTime().getTime())
                        .setOfflineMessageSetting(regUserFriend.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(regUserFriend.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(regUserFriend.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(regUserFriend.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(regUserFriend.getFriendComment())
                        .build());
            }
            RegisteredUserFriendResponse guestUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestUserFriendResponse;
        }else {
            RegisteredUserFriendResponse guestUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestUserFriendResponse;
        }

    }


    //注册好友列表 --friend模糊
    public RegisteredUserFriendResponse selectRegisteredUserFriendByFriendIdLike(TransmissionRequest request,SqlSession session){
        RegisteredUserFriendMapper mapperb = session.getMapper(RegisteredUserFriendMapper.class);
        RegisteredUserFriendService guestUserFriendService = new RegisteredUserFriendService();
        RegisteredUserFriend guestUserFriend = new RegisteredUserFriend();
        RpcRegisteredUserFriend rpcRegisteredUserFriend = request.getRegisteredUserFriend();
        guestUserFriend.setRegisteredUserId(rpcRegisteredUserFriend.getRegisteredUserId());
        guestUserFriend.setFriendId(rpcRegisteredUserFriend.getFriendId());
        List<RegisteredUserFriend> list = guestUserFriendService.selectRegisteredUserFriendByFriendIdLike(session, mapperb, guestUserFriend);
        List<RpcRegisteredUserFriend> listResponse = new ArrayList<RpcRegisteredUserFriend>();
        //commonUtils.isHave(list)
        CommonUtils<RegisteredUserFriend> commonUtils = new CommonUtils<>();
        if(commonUtils.isHave(list)){
            for (RegisteredUserFriend  guestUserFriend1: list){
                listResponse.add(RpcRegisteredUserFriend.newBuilder()
                        .setRegisteredUserId(guestUserFriend1.getRegisteredUserId())
                        .setFriendId(guestUserFriend1.getFriendId())
                        .setFriendUserId(guestUserFriend1.getFriendUserId())
                        .setFriendComment(guestUserFriend1.getFriendComment())
                        .setCreationTime(guestUserFriend1.getCreationTime().getTime())
                        .setModificationTime(guestUserFriend1.getModificationTime().getTime())
                        .setOfflineMessageSetting(guestUserFriend1.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(guestUserFriend1.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(guestUserFriend1.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestUserFriend1.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(guestUserFriend1.getFriendNickName())
                        .build());
            }
            RegisteredUserFriendResponse guestUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestUserFriendResponse;
        }else {
            RegisteredUserFriendResponse guestUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                    .addAllResponseData(listResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS_NULL);
            return guestUserFriendResponse;
        }

    }

    //注册好友列表 --friend精确
    public RegisteredUserFriendResponse selectRegisteredUserFriendByFriendId(TransmissionRequest request,SqlSession session){
        RegisteredUserFriendMapper mapperb = session.getMapper(RegisteredUserFriendMapper.class);
        int userId = request.getRegisteredUserFriend().getRegisteredUserId();//自己ID
        int friendId = request.getRegisteredUserFriend().getFriendId();//好友ID
        logger.info("查询好友个人资料用户ID：" +userId +"---好友ID：" + friendId);
        try {
            RegisteredUserFriend relation = mapperb.getRelationByRegisteredUserIdAndFriendUserId(userId, friendId);
            if(null != relation){
                RpcRegisteredUserFriend friend = RpcRegisteredUserFriend.newBuilder()
                        .setFriendId(relation.getFriendId())
                        .setRegisteredUserId(relation.getRegisteredUserId())
                        .setFriendUserId(relation.getFriendUserId())
                        .setFriendComment(relation.getFriendComment())
                        .setOfflineMessageSetting(relation.getOfflineMessageSetting())
                        .setBurnAfterReadingSetting(relation.getBurnAfterReadingSetting())
                        .setBurnAfterReadingTimeUnit(relation.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(relation.getBurnAfterReadingTimeLength().floatValue())
                        .setFriendNickName(relation.getFriendNickName())
                        .build();
                RegisteredUserFriendResponse registeredUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                        .addResponseData(friend)
                        .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                        .build();
                session.commit();
                session.close();
                return registeredUserFriendResponse;
            }else {
                RegisteredUserFriendResponse registeredUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info("查询好友个人资料失败");
                return registeredUserFriendResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
            RegisteredUserFriendResponse registeredUserFriendResponse =  RegisteredUserFriendResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info("查询好友个人资料异常");
            session.rollback();
            return registeredUserFriendResponse;
        }

    }

    public BurnAfterReadingPriorityResponse selectBurnAfterReadingPriority(SqlSession session){
        BurnAfterReadingPriorityMapper burnAfterReadingPriorityMapper = session.getMapper(BurnAfterReadingPriorityMapper.class);
        BurnAfterReadingPriorityService burnAfterReadingPriorityService = new BurnAfterReadingPriorityService();
        List<RpcBurnAfterReadingPriority> listResponse = new ArrayList<RpcBurnAfterReadingPriority>();
        List<BurnAfterReadingPriority> burnAfterReadingPriorityList = burnAfterReadingPriorityService.selectAllRecords(session,burnAfterReadingPriorityMapper);
        for (BurnAfterReadingPriority  burnAfterReadingPriority: burnAfterReadingPriorityList){
            listResponse.add(RpcBurnAfterReadingPriority.newBuilder()
                    .setType(burnAfterReadingPriority.getType())
                    .setPriority(burnAfterReadingPriority.getPriority())
                    .build());
        }
        BurnAfterReadingPriorityResponse burnAfterReadingPriorityResponse =  BurnAfterReadingPriorityResponse.newBuilder()
                .addAllResponseData(listResponse)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return burnAfterReadingPriorityResponse;
    }

    public OfflineMessagePriorityResponse selectOfflineMessagePriority(SqlSession session){
        OfflineMessagePriorityMapper offlineMessagePriorityMapper = session.getMapper(OfflineMessagePriorityMapper.class);
        OfflineMessagePriorityService offlineMessagePriorityService = new OfflineMessagePriorityService();
        List<RpcOfflineMessagePriority> listResponse = new ArrayList<RpcOfflineMessagePriority>();
        List<OfflineMessagePriority> offlineMessagePriorityList = offlineMessagePriorityService.selectAllRecords(session,offlineMessagePriorityMapper);
        for (OfflineMessagePriority  offlineMessagePriority: offlineMessagePriorityList){
            listResponse.add(RpcOfflineMessagePriority.newBuilder()
                    .setType(offlineMessagePriority.getType())
                    .setPriority(offlineMessagePriority.getPriority())
                    .build());
        }
        OfflineMessagePriorityResponse offlineMessagePriorityResponse =  OfflineMessagePriorityResponse.newBuilder()
                .addAllResponseData(listResponse)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return offlineMessagePriorityResponse;
    }

    public GroupAnnouncementsResponse selectGroupAnnouncements(TransmissionRequest request, SqlSession session){
        GroupAnnouncementsMapper groupAnnouncementsMapper = session.getMapper(GroupAnnouncementsMapper.class);
        GroupAnnouncementsService groupAnnouncementsService = new GroupAnnouncementsService();
        List<RpcGroupAnnouncements> listResponse = new ArrayList<RpcGroupAnnouncements>();
        int groupId = request.getGroupAnnouncements().getGroupAnnouncementId();
        if (groupId == 0){
            groupId = request.getGuestGroup().getGroupId();
        }
        if (groupId == 0){
            groupId = request.getRegisteredGroup().getGroupId();
        }
        GroupAnnouncements groupAnnouncements1 = new GroupAnnouncements();
        groupAnnouncements1.setGroupAnnouncementId(groupId);
        groupAnnouncements1.setAnnouncementTitle(request.getGroupAnnouncements().getAnnouncementTitle());
        groupAnnouncements1.setAnnouncementContent(request.getGroupAnnouncements().getAnnouncementContent());
        List<GroupAnnouncements> groupAnnouncementsList = groupAnnouncementsService.selectGroupAnnouncementsByGroupAnnouncementId(session, groupAnnouncementsMapper, groupAnnouncements1);
        for (GroupAnnouncements  groupAnnouncements: groupAnnouncementsList){
            listResponse.add(RpcGroupAnnouncements.newBuilder()
                    .setGroupAnnouncementId(groupAnnouncements.getGroupAnnouncementId())
                    .setAnnouncementTitle(groupAnnouncements.getAnnouncementTitle())
                    .setAnnouncementContent(groupAnnouncements.getAnnouncementContent())
                    .build());
        }
        GroupAnnouncementsResponse groupAnnouncementsResponse =  GroupAnnouncementsResponse.newBuilder()
                .addAllResponseData(listResponse)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return groupAnnouncementsResponse;
    }

    public GroupRemarkResponse selectGroupRemark(TransmissionRequest request, SqlSession session){
        GroupRemarkMapper groupRemarkMapper = session.getMapper(GroupRemarkMapper.class);
        GroupRemarkService groupRemarkService = new GroupRemarkService();
        List<RpcGroupRemark> listResponse = new ArrayList<RpcGroupRemark>();
        RpcGroupRemark rpcGroupRemark= request.getGroupRemark();
        GroupRemark groupRemark1 = new GroupRemark();
        groupRemark1.setGroupId(rpcGroupRemark.getGroupId());
        groupRemark1.setGroupMemberId(rpcGroupRemark.getGroupMemberId());
        groupRemark1.setGroupMemberIdRemarked(rpcGroupRemark.getGroupMemberIdRemarked());
        groupRemark1.setRemark(rpcGroupRemark.getRemark());
        List<GroupRemark> groupRemarkList = groupRemarkService.selectGroupRemarkWithGroupWithGroupMember(session, groupRemarkMapper, groupRemark1);
        for (GroupRemark  groupRemark: groupRemarkList){
            listResponse.add(RpcGroupRemark.newBuilder()
                    .setGroupId(groupRemark.getGroupId())
                    .setGroupMemberId(groupRemark.getGroupMemberId())
                    .setGroupMemberIdRemarked(groupRemark.getGroupMemberIdRemarked())
                    .setRemark(groupRemark.getRemark())
                    .build());
        }
        GroupRemarkResponse groupRemarkResponse =  GroupRemarkResponse.newBuilder()
                .addAllResponseData(listResponse)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        logger.info(ConstantsContent.RESPONSE_SUCCESS);
        return groupRemarkResponse;
    }

    public AllGroupsMemberResponse selectGroupMembers(String groupId){
        QueryGroupWithGuestUserIdService service = new QueryGroupWithGuestUserIdService();
        return service.selectGroupMembersInfoList(groupId);
    }

    public GuestGroupResponse searchGroupById(String groupId){
        QueryGroupWithGuestUserIdService service = new QueryGroupWithGuestUserIdService();
        return service.searchGroupById(groupId);
    }

    public AllGroupsMemberResponse searchAllGroupByUserId(TransmissionRequest request){
        QueryGroupWithGuestUserIdService service = new QueryGroupWithGuestUserIdService();
        return service.searchAllGroupByUserId(request);
    }

    public RegisteredGroupResponse queryGroupInfoByListId(TransmissionRequest request){
        QueryGroupWithGuestUserIdService service = new QueryGroupWithGuestUserIdService();
        return service.queryGroupInfoByListId(request);
    }

    public RpcRegisteredUserFriend  queryFriendRelation(TransmissionRequest request){
        QueryRegisteredFriendInfoService friendInfoService = new QueryRegisteredFriendInfoService();
        return friendInfoService.queryFriendRelation(request);
    }

    //某个注册用户关联的注册群成员列表和群列表（包含注册群和游客群）
    public GroupMemberNicknameResponse selectGroupMemberNickname(TransmissionRequest request){
        return new QueryGroupMemberNicknameService().selectGroupMemberNickname(request);
    }
}
