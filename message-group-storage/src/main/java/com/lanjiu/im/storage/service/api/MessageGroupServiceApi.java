package com.lanjiu.im.storage.service.api;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.lanjiu.im.grpc.RegisteredGroupResponse;
import com.lanjiu.im.grpc.RpcRegisteredGroup;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.information.InformationStorageGrpcApi;
import com.lanjiu.im.grpc.login.LoginStorageGrpcApi;
import com.lanjiu.im.storage.dao.GroupMemberReceiveMsgMapper;
import com.lanjiu.im.storage.dao.GroupMsgOffLineMapper;
import com.lanjiu.im.storage.pojo.GroupAudioVideoCallEntity;
import com.lanjiu.im.storage.pojo.GroupAudioVideoCallIndex;
import com.lanjiu.im.storage.pojo.GroupMemberReceiveMsg;
import com.lanjiu.im.storage.pojo.GroupMsgOffLine;
import com.lanjiu.im.storage.pojo.entity.GroupMemberReceiveMsgOffLine;
import com.lanjiu.im.storage.service.GroupMsgOffLineService;
import com.lanjiu.im.storage.service.api.entity.UserInfo;
import com.lanjiu.im.storage.util.CommKeys;
import com.lanjiu.im.storage.util.DBTools;
import com.lanjiu.im.storage.util.ResultUtils;
import com.lanjiu.pro.groupStorage.*;
import com.lanjiu.pro.login.RegisterStorageProto;

import com.mysql.jdbc.StringUtils;
import io.netty.util.internal.StringUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class MessageGroupServiceApi {

    private static final Logger log = Logger.getLogger(MessageGroupServiceApi.class.getName());

    private GroupMemberReceiveMsgMapper receiveMsgMapper;

    private GroupMsgOffLineMapper msgGroupOffMapper;

    private LoginStorageGrpcApi commStorageGrpcApi;

    private InformationStorageGrpcApi informationStorageGrpcApi;

    public MessageGroupServiceApi() {
        SqlSession session = DBTools.getSession();
        this.receiveMsgMapper = session.getMapper(GroupMemberReceiveMsgMapper.class);
        this.msgGroupOffMapper = session.getMapper(GroupMsgOffLineMapper.class);
        this.commStorageGrpcApi = new LoginStorageGrpcApi();
        this.informationStorageGrpcApi = new InformationStorageGrpcApi();
    }

    public ResponseResult saveGroupMassage(GroupMsgOffLineRequest request) {
        SqlSession session = DBTools.getSession();
        try {
            if (request == null){
                return ResultUtils.responseResultSuccessful();
            }
            GroupMsgOffLine offLineMsg = new GroupMsgOffLine();
            offLineMsg.setMsgId(request.getMsgId());
            offLineMsg.setMsgType(request.getMsgType());
            offLineMsg.setFromId(request.getFromId());
            offLineMsg.setGroupId(request.getGroupId());
            offLineMsg.setContent(request.getContent());
            offLineMsg.setEntityUrl(request.getEntityUrl());
            offLineMsg.setSnapChatStatus(request.getSnapchatStatus());
            offLineMsg.setSnapChatTimeLength(request.getSnapchatTimeLength());
            offLineMsg.setDuration(request.getDuration());
            offLineMsg.setGroupName(request.getGroupName());
            offLineMsg.setGroupOwner(request.getGroupOwner());
            offLineMsg.setGroupOwnerNick(request.getGroupOwnerNick());
            offLineMsg.setGroupOwnerUrl(request.getGroupOwnerUrl());
            offLineMsg.setFromMemberId(request.getFromMemberId());
            offLineMsg.setFromMemberName(request.getFromMemberName());
            offLineMsg.setFromMemberAvatar(request.getFromMemberAvatar());
            offLineMsg.setCreateTime(ResultUtils.nowTime());
            log.info("存储消息数据：" + offLineMsg.toString());
            if (CommKeys.KICK_OUT == request.getMsgType()){
                receiveMsgMapper.deleteGroupLineMsgByToId(request.getGroupId(), request.getToId());
            }
            msgGroupOffMapper.insert(offLineMsg);
            log.info("存储消息ID：" + offLineMsg.getId());
            Any pack = Any.pack(GroupMsg.newBuilder().setMsgId(offLineMsg.getId()).build());
            session.commit();
            return ResultUtils.responseResultSuccessful(pack);
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
            session.rollback();
            return ResultUtils.responseResultFail();
        }finally {
            session.close();
        }
    }

    public ResponseResult saveGroupMembersOffLineMsg(GroupMsgOffLineRequest request) {
        if (request == null){
            return ResultUtils.responseResultSuccessful();
        }
        SqlSession session = DBTools.getSession();
        try {
            GroupMemberReceiveMsg receiveMsg = new GroupMemberReceiveMsg();
            receiveMsg.setGroupId(request.getGroupId());
            receiveMsg.setOffLineMsgId(request.getId());
            receiveMsg.setToId(request.getToId());
            receiveMsg.setIsAt(request.getIsAt());
            receiveMsg.setCreateTime(System.currentTimeMillis());
            log.info("存储离线消息：" + CommKeys.toJson(receiveMsg));
            receiveMsgMapper.insert(receiveMsg);
            session.commit();
            return ResultUtils.responseResultSuccessful();
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
            session.rollback();
            return ResultUtils.responseResultFail();
        }finally {
            session.close();
        }
    }

    //根据ids批量删除
    public ResponseResult deleteGroupMsg(GroupMsgOffLineRequest delGroupMsgRequest) {
        String msgIds = delGroupMsgRequest.getMsgId();
        if (StringUtil.isNullOrEmpty(msgIds)){
            return ResultUtils.responseResult(false, "删除消息ID不能为空", Any.newBuilder().build());
        }
        List<String> ids = Arrays.asList(msgIds.split(","));
        List<GroupMsgOffLine> groupMsgOffLines = msgGroupOffMapper.selectByMsgIds(ids);
        if (groupMsgOffLines == null || groupMsgOffLines.isEmpty()) {
            log.info("删除的消息ID:"+ msgIds +"查询无数据");
            return ResultUtils.responseResultSuccessful();
        }
        SqlSession session = DBTools.getSession();
        try {
            List<Integer> collect = groupMsgOffLines.stream().map(GroupMsgOffLine::getId).collect(Collectors.toList());
            receiveMsgMapper.deleteByOffLineMsgIds(collect);
            msgGroupOffMapper.deletePrimaryKeys(collect);
            session.commit();
            return ResultUtils.responseResultSuccessful();
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
            session.rollback();
            return ResultUtils.responseResultFail();
        }finally {
            session.close();
        }
    }
    //群主退出
    public ResponseResult groupOwnerExit(DeleteGroupMembersMsgRequest request) {
        log.info("群主退群-删除群所有离线消息入参" + request);
        List<String> groupIds = request.getGroupIdList().subList(0, 1);
        boolean result = this.deleteGroupOffLineMsg(groupIds);
        log.info("群主退群-删除群所有离线消息结果" + request);
        return ResultUtils.responseResult(result);
    }
    //解散群删除群信息
    private boolean deleteGroupOffLineMsg(List<String> groupIds) {
        SqlSession session = DBTools.getSession();
        try {
            log.info("删除解散群的离线数据：ID：" + groupIds);
            receiveMsgMapper.deleteByGroupIds(groupIds);
            msgGroupOffMapper.deleteByGroupIds(groupIds);
            session.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            log.error("删除群所有离线消息异常" + e);
            session.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    //根据id删除
    public ResponseResult deleteSendOffLineMsg(DeleteGroupMembersMsgRequest request) {
        String userId = request.getUserId();
        if (StringUtil.isNullOrEmpty(userId)){
            return ResultUtils.responseResultSuccessful();
        }
        List<GroupMemberReceiveMsg> receiveMsgs = receiveMsgMapper.selectByToId(userId);
        if (receiveMsgs == null || receiveMsgs.isEmpty()){
            return ResultUtils.responseResultSuccessful();
        }
        SqlSession session1 = DBTools.getSession();
        try {
            receiveMsgMapper.deleteByToId(userId);
            session1.commit();
        }catch (Exception e){
            log.error("删除用户：【"+userId+"】离线接收数据异常" + e);
            e.printStackTrace();
            session1.rollback();
            session1.close();
            return ResultUtils.responseResultFail();
        }
        List<Integer> collect = receiveMsgs.stream().map(GroupMemberReceiveMsg::getOffLineMsgId).collect(Collectors.toList());
        log.info("删除用户：【"+userId+"】群离线接收数据ID：" + collect);
        List<Integer> offLineIds = receiveMsgMapper.selectByOffLineIds(collect);
        List<Integer> list = new ArrayList<>(collect);
        list.removeAll(offLineIds);
        if (list.isEmpty()){
            return ResultUtils.responseResultSuccessful();
        }
        log.info("删除用户：【"+userId+"】群离线主体数据ID：" + list);
        SqlSession session2 = DBTools.getSession();
        try {
            msgGroupOffMapper.deletePrimaryKeys(list);
            session2.commit();
            return ResultUtils.responseResultSuccessful();
        }catch (Exception e){
            log.error("删除用户：【"+userId+"】离线主体数据异常" + e);
            e.printStackTrace();
            session2.rollback();
            session2.close();
            return ResultUtils.responseResultFail();
        }
    }
    //定期清理
    public ResponseResult deleteGroupMembersOffLineMsg(DeleteGroupMembersMsgRequest request) {
        log.info("定期清理接口入参：" + request);
        String userId = request.getUserId();
        if (StringUtil.isNullOrEmpty(userId)){
            return ResultUtils.responseResultSuccessful();
        }
        SqlSession session = DBTools.getSession();
        try {
            // 1、用户发出的消息
            List<GroupMsgOffLine> offLines = msgGroupOffMapper.selectByFromId(userId);
            List<Integer> sendIds = offLines.stream().map(GroupMsgOffLine::getId).collect(Collectors.toList());
            log.info("定期清理--用户【"+userId+"】发送的数据ID：" + sendIds);
            List<Integer> delIds = offLines.stream().filter(v -> CommKeys.REGULAR_CLEAR.contains(v.getMsgType())).map(GroupMsgOffLine :: getId).collect(Collectors.toList());
            log.info("定期清理--删除用户【"+userId+"】发送的数据ID：" + delIds);
            if (delIds != null && !delIds.isEmpty()){
                int msgCount = msgGroupOffMapper.deletePrimaryKeys(delIds);
                log.info("定期清理--删除用户【"+userId+"】发送的消息数量：" + msgCount);
                // 2、其它人接收用户发出的消息
                int count = receiveMsgMapper.deleteByOffLineMsgIds(delIds);
                log.info("定期清理--删除其它人接收用户【"+userId+"】发出的消息数量：" + count);
            }
            // 3、用户接收的消息
            List<GroupMemberReceiveMsgOffLine> relationData = receiveMsgMapper.selectRelationData(userId);
            List<Integer> receiveIds = relationData.stream().map(GroupMemberReceiveMsgOffLine::getId).collect(Collectors.toList());
            log.info("定期清理--用户【"+userId+"】接收的数据ID：" + receiveIds);
            List<Integer> collect = offLines.stream().filter(v -> CommKeys.REGULAR_CLEAR.contains(v.getMsgType())).map(GroupMsgOffLine :: getId).collect(Collectors.toList());
            log.info("定期清理--删除用户【"+userId+"】接收的数据ID：" + collect);
            if (collect != null && !collect.isEmpty()) {
                int receiveCount = receiveMsgMapper.deleteByOffLineMsgIds(collect);
                log.info("定期清理删除用户【"+userId+"】接收的消息数量：" + receiveCount);
            }
            session.commit();
            return ResultUtils.responseResultSuccessful();
        }catch (Exception e){
            log.error(e);
            e.printStackTrace();
            session.rollback();
            return ResultUtils.responseResultFail();
        }finally {
            session.close();
        }
    }

    public ResponseCount selectOffLineGroupMsgCount(SelectOffLineGroupMsgRequest request) {
        String userId = request.getUserId();
        int count = receiveMsgMapper.selectCountByToId(userId);
        log.info("查询用户：【"+userId+"】离线消息总数：" + count);
        return ResponseCount.newBuilder().setCount(count).build();
    }

    public ResponseResult selectOffLineGroupMsg(SelectOffLineGroupMsgRequest request) {
        log.info("==================="+request.getUserId()+"拉取群离线消息开始：===================");
        try {
            String userId = request.getUserId();
            UserInfo user = this.selectUserInfo_v1(userId);
            if (user == null) {
                return ResultUtils.responseResult(false, "用户信息错误", Any.newBuilder().build());
            }
            int start = (request.getPage() - 1) * request.getPageSize();
            log.info("====查询用户【"+userId+"】群离线数据开始：====");
            List<GroupMemberReceiveMsgOffLine> receiveMsgs = receiveMsgMapper.selectPageData(userId, start, request.getPageSize());
            log.info(receiveMsgs);
            log.info("====查询用户【"+userId+"】群离线数据结束：====");
            if (receiveMsgs == null || receiveMsgs.isEmpty()){
                log.info("用户【"+ userId +"】群离线数据为空");
                return ResultUtils.responseResultSuccessful();
            }
            List<GroupOfflineMessage> list = new ArrayList<>();
            receiveMsgs.forEach(v -> {
                GroupOfflineMessage groupMsg;
                if (CommKeys.KICK_OUT == v.getMsgType()){
                    groupMsg = this.dataConversionKictOut_v1(v);
                    log.info("离线数据类型-44：" + groupMsg);
                }else {
                    groupMsg = this.dataConversion_v1(v, user);
                    log.info("离线数据类型-"+v.getMsgType()+"：" + groupMsg);
                }
                list.add(groupMsg);
            });
            log.info("用户【"+ userId +"】的群离线消息长度:" + list.size());
            GroupMsgList build = GroupMsgList.newBuilder().addAllGroupMsg(list).build();
            log.info("==================="+request.getUserId()+"拉取群离线消息结束：===================");
            return ResultUtils.responseResultSuccessful(Any.pack(build));
        }catch (Exception e){
            log.error("查询群离线消息异常：" + e);
            e.printStackTrace();
            log.info("==================="+request.getUserId()+"拉取群离线消息异常：===================");
            return ResultUtils.responseResult(false, "系统异常", Any.newBuilder().build());
        }

    }

    public ResponseResult selectOffLineGroupMsg_v1(SelectOffLineGroupMsgRequest request) {
        log.info("===================拉取群离线消息开始时间：===================" + CommKeys.getTime());
        try {
            String userId = request.getUserId();
            log.info("====查询用户【"+userId+"】信息开始：====" + CommKeys.getTime());
            UserInfo user = this.selectUserInfo_v1(userId);
            log.info("====查询用户【"+userId+"】信息结束：====" + CommKeys.getTime());
            if (user == null) {
                return ResultUtils.responseResult(false, "用户信息错误", Any.newBuilder().build());
            }
            log.info("查询用户信息结果" + CommKeys.toJson(user));
            int start = (request.getPage() - 1) * request.getPageSize();
            log.info("====查询用户【"+userId+"】群离线数据开始时间：====" + CommKeys.getTime());
            // 数据量不大可直接用LIMIT m,n 分页
            List<GroupMemberReceiveMsgOffLine> receiveMsgs = receiveMsgMapper.selectPageData(userId, start, request.getPageSize());
            log.info("====查询用户【"+userId+"】群离线数据结束时间：====" + CommKeys.getTime());
            if (receiveMsgs == null || receiveMsgs.isEmpty()){
                log.info("用户【"+ userId +"】群离线数据为空");
                return ResultUtils.responseResultSuccessful();
            }
            Set<String> groupIds = new HashSet<>();
            Set<String> fromIds = new HashSet<>();
            receiveMsgs.forEach(v -> {
                groupIds.add(v.getGroupId());
                fromIds.add(v.getFromId());
                if (CommKeys.KICK_OUT == v.getMsgType()){
                    String content = v.getContent();
                    if (StringUtil.isNullOrEmpty(content))return;
                    List<String> list = Arrays.asList(content.split(","));
                    fromIds.addAll(list);
                }
            });
            String join = String.join(",", groupIds);
            log.info("用户【"+ userId +"】群离线消息所属群ID：" + join);
            if (StringUtils.isNullOrEmpty(join)){
                return ResultUtils.responseResultSuccessful();
            }
            List<RpcRegisteredGroup> rpcRegisteredGroups = this.selectRegisteredGroupInfo(join);
            if (rpcRegisteredGroups == null) {
                return ResultUtils.responseResultSuccessful();
            }
            // 群信息
            Map<Integer, String> groupMap = rpcRegisteredGroups.stream().collect(Collectors.toMap(RpcRegisteredGroup::getGroupId, RpcRegisteredGroup::getGroupName, (key1, key2) -> key2));
            log.info("用户【"+ userId +"】群离线消息所属群信息：" + groupMap);
            Map<String, UserInfo> userMap = new HashMap<>();
            fromIds.forEach(v ->{
                UserInfo fromUser = this.selectUserInfo_v1(v);
                if (fromUser == null) return;
                userMap.put(v, fromUser);
            });
            List<GroupOfflineMessage> list = new ArrayList<>();
            List<String> delGroupIds = new ArrayList<>();
            receiveMsgs.forEach(v -> {
                Integer groupId = Integer.valueOf(StringUtils.isNullOrEmpty(v.getGroupId()) ? "0" : v.getGroupId());
                String groupName = groupMap.get(groupId);
                if (StringUtil.isNullOrEmpty(groupName)){
                    delGroupIds.add(v.getGroupId());
                    return;
                }
                GroupOfflineMessage groupMsg;
                if (CommKeys.KICK_OUT == v.getMsgType()){
                    groupMsg = this.dataConversionKictOut(v, groupName, user, userMap);
                    log.info("离线数据44groupMsg：" + groupMsg);
                }else {
                    groupMsg = this.dataConversion(v, groupName, user, userMap.get(v.getFromId()));
                }
                list.add(groupMsg);
            });
            if (!delGroupIds.isEmpty()){
                log.info("不存在的群ID：" + delGroupIds);
                this.deleteGroupOffLineMsg(delGroupIds);
            }
            log.info("用户【"+ userId +"】拉取的群离线消息长度【"+ list.size() +"】");
            GroupMsgList build = GroupMsgList.newBuilder().addAllGroupMsg(list).build();
            log.info("===================拉取群离线消息结束时间：===================" + CommKeys.getTime());
            return ResultUtils.responseResultSuccessful(Any.pack(build));
        }catch (Exception e){
            log.error("查询群离线消息异常：" + e);
            e.printStackTrace();
            log.info("===================拉取群离线消息结束时间：===================" + CommKeys.getTime());
            return ResultUtils.responseResult(false, "系统异常", Any.newBuilder().build());
        }

    }

    private List<RpcRegisteredGroup> selectRegisteredGroupInfo(String join) {
        RpcRegisteredGroup build = RpcRegisteredGroup.newBuilder().setGroupName(join).build();
        TransmissionRequest transmissionRequest = TransmissionRequest.newBuilder().setRegisteredGroup(build).build();
        RegisteredGroupResponse registeredGroupResponse = informationStorageGrpcApi.selectGroupIfo(transmissionRequest);
        if (registeredGroupResponse == null || "failure".equals(registeredGroupResponse.getStatusDetail())){
            return null;
        }
        return registeredGroupResponse.getResponseRegisteredGroupList();
    }

    private UserInfo selectUserInfo(String userId) {
        UserInfo user = new UserInfo();
        user.setUserId(userId);
        String substring = userId.substring(0, 1);
        RegisterStorageProto.UserInfomation userInfo;
        if (CommKeys.TOURISTS_USER_IDENTIFY.contains(substring)){
            userInfo = this.selectGuestUser(userId);
        }else {
            userInfo = this.selectRegisterUser(userId);
        }
        if (userInfo == null) return null;
        user.setAvatar(userInfo.getAvatar());
        user.setNickName(userInfo.getNickname());
        return user;
    }

    private UserInfo selectUserInfo_v1(String userId) {
        UserInfo user = new UserInfo();
        user.setUserId(userId);
        RegisterStorageProto.UserInfomation userInfo = this.selectRegisterUser(userId);
        if (userInfo == null) {return null;}
        user.setAvatar(userInfo.getAvatar());
        user.setNickName(userInfo.getNickname());
        return user;
    }

    private RegisterStorageProto.UserInfomation selectGuestUser(String userId){
        RegisterStorageProto.GuestUser guestUser = RegisterStorageProto.GuestUser.newBuilder().setUserId(userId).build();
        RegisterStorageProto.RequestUser requestUser = RegisterStorageProto.RequestUser.newBuilder().setArgs(CommKeys.SEARCH_USER).setGuestUser(guestUser).setUserType(CommKeys.TOURISTS_USER).build();
        log.info("查询游客用户信息入参：" + requestUser);
        RegisterStorageProto.ResponseUser responseUser = commStorageGrpcApi.selectGuestUserInfo(requestUser);
        log.info("查询游客用户信息响应：" + responseUser);
        List<RegisterStorageProto.GuestUser> guestUsers = responseUser.getGuestUserList();
        if (guestUsers == null || guestUsers.isEmpty()) {
            return null;
        }
        return responseUser.getGuestUser(0).getUserInfomation();
    }

    private RegisterStorageProto.UserInfomation selectRegisterUser(String userId){
        RegisterStorageProto.RegisterUser registerUser = RegisterStorageProto.RegisterUser.newBuilder().setUserId(userId).build();
        RegisterStorageProto.RequestUser requestUser = RegisterStorageProto.RequestUser.newBuilder().setArgs(CommKeys.SEARCH_USER).setRegisterUser(registerUser).setUserType(CommKeys.REGISTERED_USER).build();
        log.info("查询注册用户信息入参：" + requestUser);
        RegisterStorageProto.ResponseUser responseUser = commStorageGrpcApi.selectUserInformation(requestUser);
        log.info("查询注册用户信息响应：" + responseUser);
        List<RegisterStorageProto.RegisterUser> registerUsers = responseUser.getRegisterUserList();
        if (registerUsers == null || registerUsers.isEmpty()) {
            return null;
        }
        return responseUser.getRegisterUser(0).getUserInfomation();
    }

    private GroupOfflineMessage dataConversionKictOut_v1(GroupMemberReceiveMsgOffLine offLine) {
        ChatMessage chatMessage = msgContentConversion(offLine);
        return GroupOfflineMessage.newBuilder().setOfflineMessageType(offLine.getMsgType())
                .setUserId(offLine.getGroupOwner())
                .setUserNickname(offLine.getGroupOwnerNick())
                .setUserAvatar(offLine.getGroupOwnerUrl())
                .setGroupId(offLine.getGroupId())
                .setGroupName(StringUtil.isNullOrEmpty(offLine.getGroupName()) ? "" : offLine.getGroupName())
                .setGroupMemberUserId(StringUtil.isNullOrEmpty(offLine.getFromMemberId()) ? "" : offLine.getFromMemberId())
                .setGroupMemberNickname(StringUtil.isNullOrEmpty(offLine.getFromMemberName()) ? "" : offLine.getFromMemberName())
                .setGroupMemberAvatar(StringUtil.isNullOrEmpty(offLine.getFromMemberAvatar()) ? "" : offLine.getFromMemberAvatar())
                .setMsgFromId(offLine.getFromId())
                .setAt(offLine.getIsAt() + "")
                .setChatMessage(chatMessage)
                .setSnapchatStatus(offLine.isSnapChatStatus())
                .setSnapchatTimeLength(offLine.getSnapChatTimeLength())
                .build();
    }

    private GroupOfflineMessage dataConversionKictOut(GroupMemberReceiveMsgOffLine offLine, String groupName, UserInfo user, Map<String,UserInfo> userMap) {
        ChatMessage chatMessage = msgContentConversion(offLine);
        String content = offLine.getContent();
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        if (!StringUtil.isNullOrEmpty(content)){
            List<String> list = Arrays.asList(content.split(","));
            list.forEach(v ->{
                UserInfo userInfo = userMap.get(v);
                log.info("==============:" + userInfo);
                if (userInfo != null){
                    sb.append(userInfo.getNickName());
                    sb.append(",");
                    sb1.append(userInfo.getAvatar());
                    sb1.append(",");
                }
            });
        }
        String nickName = "";
        if (sb.length() > 0){
            nickName = sb.substring(0, sb.length() - 1);
        }
        String avatar = "";
        if (sb1.length() > 0){
            avatar = sb1.substring(0, sb.length() - 1);
        }
        return GroupOfflineMessage.newBuilder().setOfflineMessageType(offLine.getMsgType())
                .setUserId(user.getUserId())
                .setUserNickname(user.getNickName())
                .setUserAvatar(user.getAvatar())
                .setGroupId(offLine.getGroupId())
                .setGroupName(groupName)
                .setGroupMemberUserId(offLine.getContent())
                .setGroupMemberNickname(nickName)
                .setGroupMemberAvatar(avatar)
                .setMsgFromId(offLine.getFromId())
                .setAt(offLine.getIsAt() + "")
                .setChatMessage(chatMessage)
                .setSnapchatStatus(offLine.isSnapChatStatus())
                .setSnapchatTimeLength(offLine.getSnapChatTimeLength())
                .build();
    }

    private GroupOfflineMessage dataConversion_v1(GroupMemberReceiveMsgOffLine offLine, UserInfo user) {
        ChatMessage chatMessage = msgContentConversion(offLine);
        return GroupOfflineMessage.newBuilder().setOfflineMessageType(offLine.getMsgType())
                .setUserId(user.getUserId())
                .setUserNickname(user.getNickName())
                .setUserAvatar(user.getAvatar())
                .setGroupId(offLine.getGroupId())
                .setGroupName(StringUtil.isNullOrEmpty(offLine.getGroupName()) ? "" : offLine.getGroupName())
                .setGroupMemberUserId(StringUtil.isNullOrEmpty(offLine.getFromMemberId()) ? "" : offLine.getFromMemberId())
                .setGroupMemberNickname(StringUtil.isNullOrEmpty(offLine.getFromMemberName()) ? "" : offLine.getFromMemberName())
                .setGroupMemberAvatar(StringUtil.isNullOrEmpty(offLine.getFromMemberAvatar()) ? "" : offLine.getFromMemberAvatar())
                .setMsgFromId(offLine.getFromId())
                .setAt(offLine.getIsAt() + "")
                .setChatMessage(chatMessage)
                .setSnapchatStatus(offLine.isSnapChatStatus())
                .setSnapchatTimeLength(offLine.getSnapChatTimeLength())
                .build();
    }

    private GroupOfflineMessage dataConversion(GroupMemberReceiveMsgOffLine offLine, String groupName, UserInfo user, UserInfo formUser) {
        ChatMessage chatMessage = msgContentConversion(offLine);
        return GroupOfflineMessage.newBuilder().setOfflineMessageType(offLine.getMsgType())
                .setUserId(user.getUserId())
                .setUserNickname(user.getNickName())
                .setUserAvatar(user.getAvatar())
                .setGroupId(offLine.getGroupId())
                .setGroupName(groupName)
                .setGroupMemberUserId(offLine.getFromId())
                .setGroupMemberNickname(StringUtil.isNullOrEmpty(formUser.getNickName()) ? "" : formUser.getNickName())
                .setGroupMemberAvatar(StringUtil.isNullOrEmpty(formUser.getAvatar()) ? "" : formUser.getAvatar())
                .setMsgFromId(offLine.getFromId())
                .setAt(offLine.getIsAt() + "")
                .setChatMessage(chatMessage)
                .setSnapchatStatus(offLine.isSnapChatStatus())
                .setSnapchatTimeLength(offLine.getSnapChatTimeLength())
                .build();
    }

    private static ChatMessage msgContentConversion(GroupMsgOffLine offLine){
        ChatMessage chatMessage;
        switch (offLine.getMsgType()){
            case CommKeys.TEXT:
                Text text = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.TEXT)
                        .setText(text)
                        .build();
                break;
            case CommKeys.PICTURE:
                ByteString picBytes = ByteString.copyFrom(offLine.getContent(), CommKeys.ISO_CHARSET);
                Picture picture = Picture.newBuilder().setThumbnail(picBytes).setUrl(offLine.getEntityUrl()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.PICTURE)
                        .setPicture(picture)
                        .build();
                break;
            case CommKeys.VOICE:
                ByteString voiceBytes = ByteString.copyFrom(offLine.getContent(), CommKeys.ISO_CHARSET);
                Voice voice = Voice.newBuilder().setContent(voiceBytes).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.VOICE)
                        .setVoice(voice)
                        .build();
                break;
            case CommKeys.VIDEO:
                ByteString videoBytes = ByteString.copyFrom(offLine.getContent(), CommKeys.ISO_CHARSET);
                Video video = Video.newBuilder().setThumbnail(videoBytes).setUrl(offLine.getEntityUrl()).setPos(offLine.getDuration()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.VIDEO)
                        .setVideo(video)
                        .build();
                break;
            case CommKeys.FILE:
                File file = File.newBuilder().setUrl(offLine.getEntityUrl()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.FILE)
                        .setFile(file)
                        .build();
                break;
            case CommKeys.CREATE:
                Text createText = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.CREATE)
                        .setText(createText)
                        .build();
                break;
            case CommKeys.INVITE_IN:
                Text inviteText = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.INVITE_IN)
                        .setText(inviteText)
                        .build();
                break;
            case CommKeys.REQ_JOIN_IN:
                Text joinText = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.REQ_JOIN_IN)
                        .setText(joinText)
                        .build();
                break;
            case CommKeys.REQ_REFUSE:
                Text refuseText = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.REQ_REFUSE)
                        .setText(refuseText)
                        .build();
                break;
            case CommKeys.REQ_CONSENT:
                Text consentText = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.REQ_CONSENT)
                        .setText(consentText)
                        .build();
                break;
            case CommKeys.KICK_OUT:
                Text outText = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.KICK_OUT)
                        .setText(outText)
                        .build();
                break;
            case CommKeys.EXIT_GROUP:
                Text text1 = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.EXIT_GROUP)
                        .setText(text1)
                        .build();
                break;
            case CommKeys.DISSOLVE_GROUP:
                Text text2 = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.DISSOLVE_GROUP)
                        .setText(text2)
                        .build();
                break;
            case CommKeys.DEL_GROUP_MSG:
                Text text3 = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(CommKeys.DEL_GROUP_MSG)
                        .setText(text3)
                        .build();
                break;
            default:
                Text detText = Text.newBuilder().setContent(offLine.getContent()).build();
                chatMessage = ChatMessage.newBuilder().setMsgId(offLine.getMsgId())
                        .setChatType(offLine.getMsgType())
                        .setText(detText)
                        .build();
                break;
        }
        return chatMessage;
    }

    public GroupAudioVideoCallResponse saveGroupAudioVideoCallMassage(GroupAudioVideoCallRequest request) {
        SqlSession session = DBTools.getSession();
        GroupAudioVideoMessage gaamsg = request.getGroupAudioVideoMessage();
        GroupAudioVideoCallEntity  entity = new GroupAudioVideoCallEntity();

        //加入、离开、未接听 三种类型更新callmemberIds
        if (gaamsg.getType().equals(CommKeys.ROOM_JOIN) || gaamsg.getType().equals(CommKeys.ROOM_LEAVE) || gaamsg.getType().equals(CommKeys.ROOM_UNANSWERED)){
            return updateCallMemberIds(session,gaamsg);
        }

        //邀请类型处理
        if (gaamsg.getType().equals(CommKeys.ROOM_INVITE)){
            return inviteJoinRomm(session,gaamsg);
        }


        entity.setRoomId(gaamsg.getRoomId());
        entity.setFromUserId(gaamsg.getFromUserId());
        entity.setFromUserName(gaamsg.getFromUserName());
        entity.setFromUserAvatar(gaamsg.getUserAvatar());
        entity.setGroupId(gaamsg.getGroupId());
        entity.setOnlyAudio(gaamsg.getOnlyAudio());
        entity.setJoinMemberIds(gaamsg.getCallMemberIds());
        entity.setMsgId("");//todo
        entity.setType(gaamsg.getType());
        entity.setTime(Long.parseLong(gaamsg.getDetail().substring(1,10)));
        try {
             msgGroupOffMapper.storageAudioVideoCallMsg(entity);
            session.commit();

        } catch (Exception e) {
            session.rollback();
            log.error("音视频通话消息存储错误",e);
            return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_FAIL_MSG).build();
        }finally {
            session.close();
        }
        return GroupAudioVideoCallResponse.newBuilder().setResult(String.valueOf(entity.getId())).build();

    }



    public GroupAudioVideoCallResponse saveCallMsgToOffUser(GroupAudioVideoCallRequest request) {
        SqlSession session = DBTools.getSession();
        GroupAudioVideoMessage message = request.getGroupAudioVideoMessage();
        log.info("保存群成员音视频通话消息："+message.toString());
        GroupAudioVideoCallIndex index = new GroupAudioVideoCallIndex();
        index.setGroupId(message.getGroupId());
        index.setMemberId(message.getCallMemberIds());
        index.setJoin(message.getOnlyAudio());
        index.setGavcId(Integer.parseInt(message.getDetail()));
        index.setTime(System.currentTimeMillis()/1000L);
        int row =0;
        try {
            row = receiveMsgMapper.insertAudioVideoCallIndex(index);
            session.commit();
            return GroupAudioVideoCallResponse.newBuilder().setResult(row+"").build();
        } catch (Exception e) {
            session.rollback();
            log.error("音视频通话消息存储到index表错误",e);
            return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_FAIL_MSG).build();
        } finally {
            session.close();
        }
    }

    public GroupAudioVideoCallResponse pushCallMsgToOffUser(GroupAudioVideoCallRequest request) {
        SqlSession session = DBTools.getSession();
        String toUserId = request.getGroupAudioVideoMessage().getFromUserId();
        if (StringUtil.isNullOrEmpty(toUserId)){
            return null;
        }
        //检查上线用户的音视频通话离线消息总数，若count<0则直接返回；
        int count = 0;
        List<GroupAudioVideoCallEntity> msgList= new ArrayList<>();
        List<GroupAudioVideoMessage>  responseList = new ArrayList<>();
        try {
            count = receiveMsgMapper.selectAudioCallCount(toUserId);
        } catch (Exception e) {
            log.error("音视频通话消息总数查询错误，UserId:"+toUserId+"，："+e);
            return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_FAIL_MSG).build();
        }
        if(count<=0){
            session.close();
            return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_SUCCESS_MSG).build();
        }
        try {
            msgList = msgGroupOffMapper.getAudioCallMsg(toUserId);
        } catch (Exception e) {
            log.error("音视频通话消息文本查询错误，UserId:"+toUserId+"，："+e);
            return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_FAIL_MSG).build();
        }

        if (msgList.size()>=0){
            for (GroupAudioVideoCallEntity entity : msgList){
                GroupAudioVideoMessage message = GroupAudioVideoMessage.newBuilder()
                        .setRoomId(entity.getRoomId())
                        .setOnlyAudio(entity.getOnlyAudio())
                        .setGroupId(entity.getGroupId())
                        .setFromUserId(entity.getFromUserId())
                        .setFromUserName(entity.getFromUserName())
                        .setUserAvatar(entity.getFromUserAvatar())
                        .setCallMemberIds(entity.getJoinMemberIds())
                        .setType(entity.getType())
                        .setDetail(String.valueOf(entity.getTime()))
                        .setOther(String.valueOf(entity.getId())) //Id主键
                        .build();
                log.info("查询的推送消息："+message);
                responseList.add(message);
            }
        }

        return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_SUCCESS_MSG).addAllGroupAudioVideoMessage(responseList).build();

    }

    public GroupAudioVideoCallResponse deleteCallMsgToOffUser(GroupAudioVideoCallRequest request) {
        String delUser = request.getGroupAudioVideoMessage().getFromUserId();
        int msgId = Integer.parseInt(request.getGroupAudioVideoMessage().getDetail());
        SqlSession session = DBTools.getSession();
        int row  =receiveMsgMapper.deleteAudioVideoCallOfUserIndex(delUser,msgId);
        if (row>=0){
            session.commit();
            session.close();
            return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_SUCCESS_MSG).build();
        }
        session.close();
        log.error("删除音视频通话消息index失败，user："+delUser+",msgId:"+msgId);
        return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_FAIL_MSG).build();
    }

    /**
     * 房间关闭类型处理
     */
    public void closeRoomByGroupId(GroupAudioVideoCallRequest request) {
            SqlSession session = DBTools.getSession();
            String groupId = request.getGroupAudioVideoMessage().getGroupId();
            try {
                msgGroupOffMapper.removeAudioVideoCallMsgByRoomId(groupId);
                receiveMsgMapper.removeAudioVideoCallIndexByRoomId(groupId);
                session.commit();
            } catch (Exception e) {
                log.error("群【"+groupId+"】通话房间关闭执行消息删除时错误，",e);
                session.rollback();
            } finally {
                session.close();
            }

    }

    /**
     * 有成员加入或离开或未接听时，更新callmemberIds;
     */
    private GroupAudioVideoCallResponse updateCallMemberIds(SqlSession session,GroupAudioVideoMessage gaamsg) {
        GroupAudioVideoCallEntity  entity = new GroupAudioVideoCallEntity();
        entity.setRoomId(gaamsg.getRoomId());
        entity.setFromUserId(gaamsg.getFromUserId());
        entity.setGroupId(gaamsg.getGroupId());
        entity.setJoinMemberIds(gaamsg.getCallMemberIds()); //todo  加入时的传参callmemberIds是否为最新的通话参与者；
        entity.setTime(Long.parseLong(gaamsg.getDetail().substring(1,10)));
        int res = msgGroupOffMapper.updateAudioCallMsgJoin(entity);
        if (res<=0){
            log.error("加入群视频通话时更新callmemberIds字段失败,"+entity.toString());
        }
        session.commit();
        session.close();
        return GroupAudioVideoCallResponse.newBuilder().setResult(String.valueOf(entity.getId())).build();
    }

    /**
     * 邀请其他人进入通话房间
     */
    private GroupAudioVideoCallResponse inviteJoinRomm(SqlSession session, GroupAudioVideoMessage gaamsg) {

        //消息表增加一条邀请记录，callmemberIds只有被邀请人。
        //index表增加关联记录
        GroupAudioVideoCallEntity  entity = new GroupAudioVideoCallEntity();
        entity.setRoomId(gaamsg.getRoomId());
        entity.setFromUserId(gaamsg.getFromUserId());
        entity.setFromUserName(gaamsg.getFromUserName());
        entity.setFromUserAvatar(gaamsg.getUserAvatar());
        entity.setGroupId(gaamsg.getGroupId());
        entity.setOnlyAudio(gaamsg.getOnlyAudio());
        entity.setJoinMemberIds(gaamsg.getCallMemberIds());
        entity.setMsgId("");//todo
        entity.setType(gaamsg.getType());
        entity.setTime(Long.parseLong(gaamsg.getDetail().substring(1,10)));
        try {
            msgGroupOffMapper.storageAudioVideoCallMsg(entity);
            session.commit();

        } catch (Exception e) {
            session.rollback();
            log.error("音视频通话消息存储错误",e);
            return GroupAudioVideoCallResponse.newBuilder().setResult(CommKeys.RESULT_FAIL_MSG).build();
        }finally {
            session.close();
        }
        return GroupAudioVideoCallResponse.newBuilder().setResult(String.valueOf(entity.getId())).build();
    }

    public static void main(String[] args) {
        MessageGroupServiceApi api = new MessageGroupServiceApi();
      /*    GroupAudioVideoCallRequest request =GroupAudioVideoCallRequest.newBuilder()
                .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                        .setRoomId("100123")
                        .setOnlyAudio(false)
                        .setFromUserId("10010198")
                        .setFromUserName("nike")
                        .setUserAvatar("//dagg.gas.sa")
                        .setGroupId("10010555")
                        .setCallMemberIds("10010212,10010365,10010582")
                        .setType("create")
                        .setDetail("1592569345026").build()).build();
        GroupAudioVideoCallResponse response = api.saveGroupAudioVideoCallMassage(request);
        System.out.println("插入的主键："+response.getResult());*/

     /*   GroupAudioVideoCallRequest request = GroupAudioVideoCallRequest.newBuilder()
                .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                        .setGroupId("10010999")
                        .setOnlyAudio(true)
                        .setCallMemberIds("10010198")
                        .setDetail("6")
                        .setOther("").build()).build();
        GroupAudioVideoCallResponse response = api.saveCallMsgToOffUser(request);
        System.out.println(response.getResult());*/

//       GroupAudioVideoCallRequest request = GroupAudioVideoCallRequest.newBuilder()
//                .setArgs("")
//                .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
//                        .setFromUserId("10010260").build())
//                .build();
//        GroupAudioVideoCallResponse response = api.pushCallMsgToOffUser(request);
//        System.out.println(response.getResult());
//        System.out.println("离线消息："+response.getGroupAudioVideoMessageList().size());

      /*GroupAudioVideoCallRequest request = GroupAudioVideoCallRequest.newBuilder()
              .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                      .setFromUserId("10010198")
                      .setDetail("6").build()).build();
        GroupAudioVideoCallResponse response = api.deleteCallMsgToOffUser(request);
        System.out.println(response.getResult());
*/

  /*    GroupAudioVideoCallRequest request= GroupAudioVideoCallRequest.newBuilder()
              .setGroupAudioVideoMessage(GroupAudioVideoMessage.newBuilder()
                      .setGroupId("10010555")
                      .setType("close")
                      .build()).build();
        GroupAudioVideoCallResponse response = api.saveGroupAudioVideoCallMassage(request);
        System.out.println(response.getResult());
*/
    }


}
