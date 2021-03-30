package com.lanjiu.im.infomatiom;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.infomatiom.infoclient.StorageAPI;
import com.lanjiu.im.util.IMSContacts;
import com.lanjiu.im.util.ResponseStatus;
import com.lanjiu.pro.business.BusinessProtocolEntities;
import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import com.lanjiu.pro.business.BusinessProtocolMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//grpc调用资料服务器
public class InfomationUtil {

    private  static final Logger logger = LoggerFactory.getLogger(InfomationUtil.class);

    //游客退出时grpc调资料设置服务器，删除创建的群；群成员；好友；
    public static boolean logoutTourist(String toId) {
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setGuestUserFriend(RpcGuestUserFriend.newBuilder()
                        .setGuestUserId(Integer.parseInt(toId)).build())
                .build();

        StorageAPI storageAPI = new StorageAPI();
        AllGroupsMemberResponse delGuestResponse = storageAPI.deleteGuestAllInfoAPI(transmissionRequest);

        if(delGuestResponse.getStatusDetail().equalsIgnoreCase(ResponseStatus.STATUS_REPORT_SUCCESS)
      ){
            return true;
        }else{
            logger.error("删除游客好友关系接口返回失败");
            return false;
        }

    }

    //获取用户的好友
    public static Set<String>  getFriendMembers(String toId){
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind("BY_FRIEND_USER_ID")
                .setRegisteredUserFriend(RpcRegisteredUserFriend.newBuilder()
                        .setRegisteredUserId(Integer.parseInt(toId)).build())
                .build();
        StorageAPI infoStorageAPI = new StorageAPI();
        RegisteredUserFriendResponse registeredUserFriendResponse =null;
        Set<String>  friendsSet = new HashSet<>();
        try {
             registeredUserFriendResponse = infoStorageAPI.selectRegisteredUserFriend(transmissionRequest);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("stack:",e);
            logger.error("资料服务调用好友关系失败："+transmissionRequest.toString());
            return friendsSet;
        }

        if (registeredUserFriendResponse.getStatusDetail().equals(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)){
            return friendsSet;
        }
        if (registeredUserFriendResponse.getResponseDataList().size()>0){
            for (RpcRegisteredUserFriend  vo: registeredUserFriendResponse.getResponseDataList()){
                friendsSet.add(String.valueOf(vo.getFriendUserId()));
            }
        }

        return friendsSet;

    }

    //获取用户所有参与的群成员
    public static Set<String> getUserJoinGroupMember(String toId){
        //1.1获取用户所有参与的群ID
        StorageAPI infoStorageAPI = new StorageAPI();
        Set<String>  memberSet = new HashSet<>();
        List<String> groupList = new ArrayList<String>();

        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder()
                .setRequestKind(toId)
                .build();

        AllGroupsMemberResponse allGroupsMemberResponse=null;
        try {
            allGroupsMemberResponse = infoStorageAPI.searchAllGroupByUserId(transmissionRequest);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("stack:",e);
            logger.error("资料服务调用相关群失败："+transmissionRequest.toString());
            return memberSet;
        }

        if (allGroupsMemberResponse.getStatusDetail().equals(IMSContacts.ResponseCode.STATUS_REPORT_FAILURE)){
            return memberSet;
        }

        if (allGroupsMemberResponse.getResponseGroupMemberVoList().size()>0){
            for (AllGroupMemberVO  vo: allGroupsMemberResponse.getResponseGroupMemberVoList()){
                groupList.add(String.valueOf(vo.getRegisteredGroupId()));
            }
        }

        //1.2查询用户join的群相关成员
        if (groupList.size()>0){
            for (String gid: groupList){
                SelectGroupMemberRequest groupMemberRequest = SelectGroupMemberRequest.newBuilder()
                        .setGroupId(gid)
                        .build();
                Set<String> groupUserSet = selectAllReleteUser(infoStorageAPI, groupMemberRequest);
                memberSet.addAll(groupUserSet);

            }
        }
        return memberSet;

    }

    private static synchronized   Set<String> selectAllReleteUser(StorageAPI infoStorageAPI, SelectGroupMemberRequest groupMemberRequest) {
        AllGroupsMemberResponse allMemberResponse =null;
        Set<String> userSet = new HashSet<>();
        try {
            allMemberResponse = infoStorageAPI.queryGroupMembersInfoList(groupMemberRequest);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("stack:",e);
            logger.error("资料服务调用群相关人失败："+groupMemberRequest.toString());
            return userSet;
        }
        if (allMemberResponse.getResponseGroupMemberVoList().size()>0){
            for (AllGroupMemberVO  vo: allMemberResponse.getResponseGroupMemberVoList()){
                userSet.add(String.valueOf(vo.getRegisteredUserId()));
            }
        }
        return userSet;


    }

    //测试
    public static void main(String[] args) {
//        BusinessProtocolMessageStandard.Head head = BusinessProtocolMessageStandard.Head.newBuilder()
//                .setFromId("70011321")
//                .setToId("1").build();
//        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage =BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
//                .setLogoutProtocol(BusinessProtocolMessages.LogoutProtocol.newBuilder()
//                        .setTouristsUser(BusinessProtocolEntities.TouristsUser.newBuilder()
//                                .setTemporaryId("70011321").build()).build()).build();
//        boolean b = InfomationUtil.logoutTourist("70011321");
//        System.out.println(b);

        Set<String> friendMembers = getFriendMembers("10010260");
        System.out.println(friendMembers.size());
        for (String id : friendMembers){
            System.out.println("10010260的好友ID:"+id);
        }

        Set<String> memberSet = getUserJoinGroupMember("10010260");
        System.out.println("群相关人数："+memberSet.size());
        for (String id : memberSet){
            System.out.println("10010260的群相关ID:"+id);
        }

        Set<String>  userSet = new HashSet<>();
        userSet.addAll(friendMembers);
        userSet.addAll(memberSet);
        if (userSet.contains("10010260"))
            userSet.remove("10010260");

        System.out.println("#####");
        for (String id : userSet){

            System.out.println("10010260的相关人员ID:"+id);
        }

    }
}
