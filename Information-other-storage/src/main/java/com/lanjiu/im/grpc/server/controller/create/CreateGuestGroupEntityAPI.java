package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.pojo.AllGroupMemberVO;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class CreateGuestGroupEntityAPI {

    private static final Logger logger = Logger.getLogger(CreateGuestGroupEntityAPI.class.getName());

    public GuestGroupResponse createGuestGroup(TransmissionRequest request){
        GuestGroupServiceAPI guestGroupService = new GuestGroupServiceAPI();
        List<AllGroupMemberVO> allGroupMemberVOList = guestGroupService.createGuestGroup(request);
        List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupMemberVOListResponse = new ArrayList<>();
        if(null != allGroupMemberVOList && allGroupMemberVOList.size()>0){
            for(AllGroupMemberVO groupMemberVO : allGroupMemberVOList){
                allGroupMemberVOListResponse.add(com.lanjiu.im.grpc.AllGroupMemberVO.newBuilder()
                        .setGroupMemberId(groupMemberVO.getGroupMemberId())
                        .setGuestGroupId(groupMemberVO.getGuestGroupId())
                        .setGuestUserId(Integer.valueOf(groupMemberVO.getGuestUserId()))
                        .setGroupRemarks(groupMemberVO.getGroupRemarks())
                        .setGroupOwner((groupMemberVO.getGroupOwner().equals("Yes"))?"Yes": ConstantsDefault.GROUP_MEMBER_MASTER_NO)
                        .setAnnouncementContent(ConstantsDefault.GROUP_ANNOUNCEMENTS_CONTENT)
                        .setGroupName(groupMemberVO.getGroupName())
                        .setAmount(groupMemberVO.getAmount()).build());
            }
            GuestGroupResponse guestGroupResponse = GuestGroupResponse.newBuilder()
                    .addAllResponseGroupMemberVo(allGroupMemberVOListResponse)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
            logger.info(ConstantsContent.RESPONSE_SUCCESS);
            return guestGroupResponse;
        }
        return null;
    }
}
