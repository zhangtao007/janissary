package com.lanjiu.im.groupMsgStorage;

import com.lanjiu.im.groupMsgStorage.gmClient.LinkCommon;
import com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest;
import com.lanjiu.pro.groupStorage.ResponseResult;

public class GroupMsgAPI {

    /**
     * 用户退出或清理，群消息清理
     * @param request
     * @return
     */
    public ResponseResult deleteGuestGroupMessageAPI(DeleteGroupMembersMsgRequest request) {
        LinkCommon common = new LinkCommon();
        ResponseResult responseResult = common.deleteGroupMembersOffLineMsg(request);
        return responseResult;
    }
}
