package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.AllGroupMemberVO;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class CreateRegisteredGroupEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateRegisteredGroupEntityAPI.class.getName());

    public RegisteredGroupResponse createRegisteredGroup(TransmissionRequest request) throws Exception {
        RegisteredGroupServiceAPI registeredGroupService = new RegisteredGroupServiceAPI();
        List<AllGroupMemberVO> allGroupMemberVOList = registeredGroupService.createRegisteredGroup(request);
        List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupMemberVOListResponse = new ArrayList<>();
        if(null != allGroupMemberVOList && allGroupMemberVOList.size() > 0){
            for( AllGroupMemberVO groupMemberVO : allGroupMemberVOList ){
                allGroupMemberVOListResponse.add(com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                        .setGroupMemberId(groupMemberVO.getGroupMemberId())
                        .setRegisteredGroupId(groupMemberVO.getRegisteredGroupId())
                        .setAnnouncementTitle(groupMemberVO.getAnnouncementTitle())//放置群头像字段
                        .setRegisteredUserId(groupMemberVO.getRegisteredUserId())
                        .setGroupRemarks(groupMemberVO.getGroupRemarks())
                        .setGroupOwner((groupMemberVO.getGroupOwner().equals("Yes"))?"Yes":ConstantsDefault.GROUP_MEMBER_MASTER_NO)
                        .setAnnouncementContent(ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT)
                        .setGroupName(groupMemberVO.getGroupName())
                        .setAmount(groupMemberVO.getAmount()).build());
            }
            RegisteredGroupResponse registeredGroupResponse = RegisteredGroupResponse.newBuilder()
                    .addAllResponseGroupMemberVo(allGroupMemberVOListResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return registeredGroupResponse;
        }
        return null;
    }
}
