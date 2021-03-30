package com.lanjiu.im.grpc.server.controller.insert;

import com.lanjiu.im.grpc.AllGroupsMemberResponse;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupMemberMapper;
import com.lanjiu.im.grpc.util.ConstantsContent;
import org.apache.log4j.Logger;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertGroupMemberEntityAPI {

    private static final Logger logger = Logger.getLogger(InsertGroupMemberEntityAPI.class.getName());

    public AllGroupsMemberResponse insertInviteUsersJoinGroup(TransmissionRequest request){
        Integer groupId = request.getAllGroupMemberVo().getRegisteredGroupId();//群ID
        String[] memberIds = request.getAllGroupMemberVo().getGroupRemarks().split(",");//邀请入群的成员ID集合
        List<String> mList = Arrays.asList(memberIds);
        List<String> mList2 = new ArrayList<>();
        Integer fromId = request.getAllGroupMemberVo().getRegisteredUserId();//邀请人ID
        logger.info("邀请用户入群的群ID："+groupId+"---邀请入群的成员ID集合:"+ Arrays.toString(memberIds) +"---邀请人ID："+fromId);
        SqlSession session = DBTools.getSession();
        RegisteredGroupMemberMapper registeredGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        try {
            List<com.lanjiu.im.grpc.pojo.AllGroupMemberVO> allGroupMemberVOList = registeredGroupMemberMapper.selectGroupRegisteredMembers(groupId);
            allGroupMemberVOList.forEach(allGroupMemberVO -> mList2.add(String.valueOf(allGroupMemberVO.getRegisteredUserId())));
            if(!Collections.disjoint(mList, mList2)){
                logger.info("该用户已是群成员");
                return AllGroupsMemberResponse.newBuilder().setStatusDetail(ConstantsContent.RESPONSE_FAILURE).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        InsertGroupMemberServiceAPI insertGroupMemberServiceAPI = new InsertGroupMemberServiceAPI();
        List<com.lanjiu.im.grpc.AllGroupMemberVO> allGroupMemberVOS = insertGroupMemberServiceAPI.insertInviteUsersJoinGroup(groupId, memberIds,fromId);
        if(null != allGroupMemberVOS && allGroupMemberVOS.size() > 0){
            return AllGroupsMemberResponse.newBuilder()
                    .addAllResponseGroupMemberVo(allGroupMemberVOS)
                    .setStatusDetail(ConstantsContent.RESPONSE_SUCCESS)
                    .build();
        }
        return null;
    }
}
