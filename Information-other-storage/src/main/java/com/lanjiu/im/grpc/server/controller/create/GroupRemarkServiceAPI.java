package com.lanjiu.im.grpc.server.controller.create;

import com.lanjiu.im.grpc.RpcGroupRemark;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupRemarkMapper;
import com.lanjiu.im.grpc.pojo.GroupRemark;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class GroupRemarkServiceAPI {

    private static final Logger logger = Logger.getLogger(GroupRemarkServiceAPI.class.getName());

    public GroupRemark createGroupRemark(RpcGroupRemark rpcGroupRemark){
        SqlSession session = DBTools.getSession();
        Integer groupId = rpcGroupRemark.getGroupId();
        if((0 == groupId)){
            logger.info(ConstantsDefault.GROUP_REMARK_GROUP_ID_UNDEFAULT);
            return null;
        }
        Integer groupMemberId = rpcGroupRemark.getGroupMemberId();
        if((0 == groupMemberId)){
            logger.info(ConstantsDefault.GROUP_REMARK_GROUP_MEMBER_ID_UNDEFAULT);
            return null;
        }
        Integer groupMemberIdRemarked = rpcGroupRemark.getGroupMemberIdRemarked();
        if((0 == groupMemberIdRemarked)){
            logger.info(ConstantsDefault.GROUP_REMARK_GROUP_MEMBER_REMARKED_ID_UNDEFAULT);
            return null;
        }
        String remark = rpcGroupRemark.getRemark();
        if(("".equals(remark))||(null == remark)){
            logger.info(ConstantsDefault.GROUP_REMARK_CONTENT_UNDEFAULT);
            return null;
        }
        GroupRemark groupRemark = new GroupRemark();
        groupRemark.setGroupId(groupId);
        groupRemark.setGroupMemberId(groupMemberId);
        groupRemark.setGroupMemberIdRemarked(groupMemberIdRemarked);
        groupRemark.setRemark(remark);

        boolean bResult = insertGroupRemark(session, groupRemark);
        if(bResult){
            return groupRemark;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean insertGroupRemark(SqlSession session, GroupRemark groupRemark){
        GroupRemarkMapper guestUserFriendMapper = session.getMapper(GroupRemarkMapper.class);
        //
        int result = 0;
        try {
            result = guestUserFriendMapper.insertGroupRemark(groupRemark.getGroupId(),
                    groupRemark.getGroupMemberId(),
                    groupRemark.getGroupMemberIdRemarked(),
                    groupRemark.getRemark());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
}
