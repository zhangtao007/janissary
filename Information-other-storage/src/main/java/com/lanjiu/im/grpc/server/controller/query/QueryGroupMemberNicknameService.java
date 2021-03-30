package com.lanjiu.im.grpc.server.controller.query;

import com.lanjiu.im.grpc.GroupMemberNicknameResponse;
import com.lanjiu.im.grpc.RpcGroupMemberNickname;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberNicknameMapper;
import com.lanjiu.im.grpc.pojo.GroupMemberNickname;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QueryGroupMemberNicknameService {

    private static final Logger logger = Logger.getLogger(QueryGroupMemberNicknameService.class.getName());

    public GroupMemberNicknameResponse selectGroupMemberNickname(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        GroupMemberNicknameMapper nicknameMapper = session.getMapper(GroupMemberNicknameMapper.class);
        int groupId = Integer.parseInt(request.getRequestKind());
        int userId = request.getRegisteredGroupMember().getRegisteredUserId();
        logger.info("用户群："+groupId+"---用户ID："+userId);
        List<GroupMemberNickname> groupMemberNicknames = nicknameMapper.selectMemberNickname(groupId, userId);
        if (groupMemberNicknames == null || groupMemberNicknames.isEmpty()){
            return GroupMemberNicknameResponse.newBuilder().build();
        }
        List<RpcGroupMemberNickname> response = new ArrayList<>(groupMemberNicknames.size());
        groupMemberNicknames.forEach(memberNickname -> {
            RpcGroupMemberNickname build = RpcGroupMemberNickname.newBuilder()
                    .setGroupId(memberNickname.getGroupId())
                    .setUserId(memberNickname.getUserId())
                    .setGroupMemberId(memberNickname.getGroupMemberId())
                    .setNickRemark(memberNickname.getNickRemark())
                    .build();
            response.add(build);
        });
        return GroupMemberNicknameResponse.newBuilder().addAllResponseData(response).build();
    }

}
