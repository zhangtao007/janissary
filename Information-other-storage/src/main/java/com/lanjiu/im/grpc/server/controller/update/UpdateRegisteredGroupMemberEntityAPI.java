package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupMapper;
import com.lanjiu.im.grpc.pojo.RegisteredGroup;
import com.lanjiu.im.grpc.pojo.RegisteredGroupMember;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


public class UpdateRegisteredGroupMemberEntityAPI {

    private static final Logger logger = Logger.getLogger(UpdateRegisteredGroupMemberEntityAPI.class.getName());

    public RegisteredGroupMemberResponse updateRegisteredGroupMember(TransmissionRequest request){
        RegisteredGroupMemberResponse guestGroupMemberResponse = null;
        RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
        RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
        UpdateRegisteredGroupMemberServiceAPI guestGroupMemberService = new UpdateRegisteredGroupMemberServiceAPI();
        RegisteredGroupMember guestGroupMember = guestGroupMemberService.updateRegisteredGroupMember(rpcRegisteredGroupMember);
        if(null == guestGroupMember){
            return null;
        }
        guestGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                .addResponseData(RpcRegisteredGroupMember.newBuilder()
                        .setGroupMemberId(guestGroupMember.getGroupMemberId())
                        .setRegisteredUserId(guestGroupMember.getRegisteredUserId())
                        .setGroupRemarks(guestGroupMember.getGroupRemarks())
                        .setGroupOwner(guestGroupMember.getGroupOwner())
                        .setBurnAfterReadingSettings(guestGroupMember.getBurnAfterReadingSettings())
                        .setBurnAfterReadingTimeUnit(guestGroupMember.getBurnAfterReadingTimeUnit())
                        .setBurnAfterReadingTimeLength(guestGroupMember.getBurnAfterReadingTimeLength().floatValue())
                        .setGroupEntryTime(guestGroupMember.getGroupEntryTime().getTime())
                        .setOfflineMessageSetting(guestGroupMember.getOfflineMessageSetting())
                        .build())
                .addRegisteredGroupData(rpcRegisteredGroup)
                .addGuestGroupData(rpcGuestGroup)
                .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                .build();
        return guestGroupMemberResponse;
    }

    public RegisteredGroupMemberResponse updateRegtGroupMemberRemark(TransmissionRequest request){
        RpcRegisteredGroupMember registeredGroupMember = request.getRegisteredGroupMember();
        RpcRegisteredUserFriend registeredUserFriend = request.getRegisteredUserFriend();
        UpdateRegisteredGroupMemberServiceAPI memberServiceAPI = new UpdateRegisteredGroupMemberServiceAPI();
        RpcRegisteredGroupMember rpcRegisteredGroupMember = memberServiceAPI.updateRegtGroupMemberRemark(registeredGroupMember,registeredUserFriend);
        if(null != rpcRegisteredGroupMember){
            RegisteredGroupMemberResponse response = RegisteredGroupMemberResponse.newBuilder()
                    .addResponseData(RpcRegisteredGroupMember.newBuilder()
                            .setGroupId(rpcRegisteredGroupMember.getGroupId())
                            .setGroupMemberId(rpcRegisteredGroupMember.getGroupMemberId())
                            .setRegisteredUserId(rpcRegisteredGroupMember.getRegisteredUserId())
                            .build())
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            return response;
        }
        return null;
    }

    public AllGroupsMemberResponse updateRegisteredGroupServcie(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        RegisteredGroupMapper mapper = session.getMapper(RegisteredGroupMapper.class);
        int groupId = request.getAllGroupMemberVo().getRegisteredGroupId();
        String userPhoto = request.getAllGroupMemberVo().getUserPhoto();
        String userIdList = request.getAllGroupMemberVo().getAnnouncementContent();
        logger.info("更新群合成头像群ID:"+groupId+"--新头像地址："+userPhoto+"--新头像ID集合："+userIdList);
        try {
            RegisteredGroup group = mapper.getRegisteredGroupByGroupId(groupId);
            mapper.updateRegisteredGroup(groupId,group.getRegisteredUserId(),group.getGroupName(),group.getGroupAnnouncementId(),group.getCreationTime(),
                    group.getModificationTime(),group.getAmount(),userPhoto,userIdList);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
}
