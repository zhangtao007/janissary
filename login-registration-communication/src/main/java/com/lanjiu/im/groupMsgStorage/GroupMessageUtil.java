package com.lanjiu.im.groupMsgStorage;

import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import com.lanjiu.pro.groupStorage.DeleteGroupMembersMsgRequest;
import com.lanjiu.pro.groupStorage.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupMessageUtil {

    private  static final Logger logger = LoggerFactory.getLogger(GroupMessageUtil.class);

    //游客退出时grpc调资料设置服务器，删除创建的群；群成员；好友；
    public static boolean cleanGroupMessage(String toId) {

        DeleteGroupMembersMsgRequest request = DeleteGroupMembersMsgRequest.newBuilder()
                .setUserId(toId).build();
        GroupMsgAPI groupMsgAPI = new GroupMsgAPI();
        ResponseResult delGuestResponse = null;
        try {
            delGuestResponse = groupMsgAPI.deleteGuestGroupMessageAPI(request);
        } catch (Exception e) {
            logger.error("用户退出时删除群离线消息接口调用异常！！！,Id:"+toId+" , info:"+e.getMessage());
        }

        if(delGuestResponse.getSuccess() ){
            return true;
        }else{
            logger.error("删除离线群消息接口返回失败,toId:"+toId);
            return false;
        }

    }


    public static void main(String[] args) {

        boolean b = GroupMessageUtil.cleanGroupMessage("10010606");
        System.out.println(b);
    }
}
