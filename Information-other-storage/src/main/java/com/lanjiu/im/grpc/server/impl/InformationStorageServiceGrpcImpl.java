package com.lanjiu.im.grpc.server.impl;

import com.lanjiu.im.grpc.*;
import com.lanjiu.im.grpc.server.controller.create.CreateEntityAPI;
import com.lanjiu.im.grpc.server.controller.delete.DeleteEntityAPI;
import com.lanjiu.im.grpc.server.controller.insert.InsertEntityAPI;
import com.lanjiu.im.grpc.server.controller.query.QueryEntityAPI;
import com.lanjiu.im.grpc.server.controller.update.UpdateEntityAPI;
import com.lanjiu.im.grpc.util.ConstantsContent;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.ConstantsSelectKind;
import com.lanjiu.im.grpc.util.DBTools;
import io.grpc.stub.StreamObserver;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class InformationStorageServiceGrpcImpl extends InformationStorageServiceGrpc.InformationStorageServiceImplBase {

    private static final Logger logger = Logger.getLogger(InformationStorageServiceGrpcImpl.class.getName());

    /**
     * 创建群备注接口
     */
    @Override
    public void insertGroupRemark(TransmissionRequest request, StreamObserver<GroupRemarkResponse> responseObserver) {
        CreateEntityAPI createEntityAPI = new CreateEntityAPI();
        GroupRemarkResponse groupRemarkResponse = createEntityAPI.createGroupRemark(request);
        if(null == groupRemarkResponse){
            RpcGroupRemark rpcGroupRemark = request.getGroupRemark();
            groupRemarkResponse = GroupRemarkResponse.newBuilder()
                    .addResponseData(rpcGroupRemark)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.CREATE_REGISTERED_USER_FRIEND_FAIL);
        }else {
            logger.info(ConstantsPrompt.CREATE_REGISTERED_USER_FRIEND_SUCCESS);
        }
        responseObserver.onNext(groupRemarkResponse);
        responseObserver.onCompleted();
    }

    /**
     * 创建注册好友接口
     */
    @Override
    public void insertRegisteredUserFriend(TransmissionRequest request, StreamObserver<RegisteredUserFriendResponse> responseObserver) {
        CreateEntityAPI createEntityAPI = new CreateEntityAPI();
        RegisteredUserFriendResponse registeredUserFriendResponse = createEntityAPI.createRegisteredUserFriend(request);
        if("repeated".equals(registeredUserFriendResponse.getStatusDetail())){
            logger.info("添加好友重复");
            responseObserver.onNext(registeredUserFriendResponse);
            responseObserver.onCompleted();
        }else {
            if(null == registeredUserFriendResponse){
                RpcRegisteredUserFriend rpcRegisteredUserFriend = request.getRegisteredUserFriend();
                registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                        .addResponseData(rpcRegisteredUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.CREATE_REGISTERED_USER_FRIEND_FAIL);
            }else {
                logger.info(ConstantsPrompt.CREATE_REGISTERED_USER_FRIEND_SUCCESS);
            }
            responseObserver.onNext(registeredUserFriendResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 创建游客好友接口
     */
    @Override
    public void insertGuestUserFriend(TransmissionRequest request, StreamObserver<GuestUserFriendResponse> responseObserver) {
        CreateEntityAPI createEntityAPI = new CreateEntityAPI();
        GuestUserFriendResponse guestUserFriendResponse = createEntityAPI.createGuestUserFriend(request);
        if("repeated".equals(guestUserFriendResponse.getStatusDetail())){
            logger.info("添加好友重复");
            logger.info(ConstantsPrompt.CREATE_REGISTERED_USER_FRIEND_FAIL);
            responseObserver.onNext(guestUserFriendResponse);
            responseObserver.onCompleted();
        }else {
            if(null == guestUserFriendResponse){
                RpcGuestUserFriend rpcGuestUserFriend = request.getGuestUserFriend();
                guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                        .addResponseData(rpcGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.CREATE_GUEST_USER_FRIEND_FAIL);
            }else {
                logger.info(ConstantsPrompt.CREATE_GUEST_USER_FRIEND_SUCCESS);
            }
            responseObserver.onNext(guestUserFriendResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 创建注册群成员接口
     */
    @Override
    public void insertRegisteredGroupMember(TransmissionRequest request, StreamObserver<RegisteredGroupMemberResponse> responseObserver) {
        CreateEntityAPI createEntityAPI = new CreateEntityAPI();
        try {
            RegisteredGroupMemberResponse registeredGroupResponse = createEntityAPI.createRegisteredGroupMember(request);
            if(null == registeredGroupResponse){
                RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
                RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
                RpcRegisteredGroupMember rpcRegisteredGroupMember = request.getRegisteredGroupMember();
                registeredGroupResponse = RegisteredGroupMemberResponse.newBuilder()
                        .addGuestGroupData(rpcGuestGroup)
                        .addRegisteredGroupData(rpcRegisteredGroup)
                        .addResponseData(rpcRegisteredGroupMember)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.CREATE_REGISTERED_GROUP_MEMBER_FAIL);
            }else {
                logger.info(ConstantsPrompt.CREATE_REGISTERED_GROUP_MEMBER_SUCCESS);
            }
            responseObserver.onNext(registeredGroupResponse);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("创建注册群成员接口错误，"+request.toString());
            logger.error("创建注册群成员接口错误",e);
        }
    }

    /**
     * 创建游客群成员接口
     */
    @Override
    public void insertGuestGroupMember(TransmissionRequest request, StreamObserver<GuestGroupMemberResponse> responseObserver) {
        CreateEntityAPI createEntityAPI = new CreateEntityAPI();
        GuestGroupMemberResponse guestGroupResponse = createEntityAPI.createGuestGroupMember(request);
        if(null == guestGroupResponse){
            RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
            RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
            RpcGuestGroupMember rpcGuestGroupMember = request.getGuestGroupMember();
            guestGroupResponse = GuestGroupMemberResponse.newBuilder()
                    .addGuestGroupData(rpcGuestGroup)
                    .addRegisteredGroupData(rpcRegisteredGroup)
                    .addResponseData(rpcGuestGroupMember)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.CREATE_GUEST_GROUP_MEMBER_FAIL);
        }else {
            logger.info(ConstantsPrompt.CREATE_GUEST_GROUP_MEMBER_SUCCESS);
        }
        responseObserver.onNext(guestGroupResponse);
        responseObserver.onCompleted();
    }

    /**
     * 创建游客群接口
     */
    @Override
    public void insertGuestGroup(TransmissionRequest request, StreamObserver<GuestGroupResponse> responseObserver) {
        CreateEntityAPI createEntityAPI = new CreateEntityAPI();
        try {
            GuestGroupResponse guestGroupResponse = createEntityAPI.createGuestGroup(request);
            if(null == guestGroupResponse){
                RpcGuestGroup rpcGuestGroup = request.getGuestGroup();
                guestGroupResponse = GuestGroupResponse.newBuilder()
                        .addResponseGuestGroup(rpcGuestGroup)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.CREATE_GUEST_GROUP_FAIL);
            }else {
                logger.info(ConstantsPrompt.CREATE_GUEST_GROUP_SUCCESS);
            }
            responseObserver.onNext(guestGroupResponse);
            responseObserver.onCompleted();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 创建注册群接口
     */
    @Override
    public void insertRegisteredGroup(TransmissionRequest request, StreamObserver<RegisteredGroupResponse> responseObserver)  {
        CreateEntityAPI createEntityAPI = new CreateEntityAPI();
        try {
            RegisteredGroupResponse registeredGroupResponse = createEntityAPI.createRegisteredGroup(request);
            if(null == registeredGroupResponse.getResponseGroupMemberVoList()){
                RpcRegisteredGroup rpcRegisteredGroup = request.getRegisteredGroup();
                registeredGroupResponse = RegisteredGroupResponse.newBuilder()
                        .addResponseRegisteredGroup(rpcRegisteredGroup)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.CREATE_REGISTERED_GROUP_FAIL);
            }else {
                logger.info(ConstantsPrompt.CREATE_REGISTERED_GROUP_SUCCESS);
            }
            responseObserver.onNext(registeredGroupResponse);
            responseObserver.onCompleted();
        }catch (Exception e){
            logger.error("创建注册群接口错误，",e);
            e.printStackTrace();
        }
    }

    /**
     * 查询某注册用户的群列表接口----》一个注册绑定多个注册群成员----->一个注册群成员绑定一个群(可能是注册群也可能是游客群)
     * 1.某个注册用户关联的注册群成员列表和群列表（包含注册群和游客群）(GROUP_SELECT_TYPE_BY_GUEST_USER_ID)
     */
    @Override
    public void selectRegisteredGroup(TransmissionRequest request, StreamObserver<RegisteredGroupResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        String kind = request.getRequestKind();
        if(ConstantsSelectKind.GROUP_SELECT_TYPE_BY_REGISTERED_USER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupResponse guestGroupResponse = queryEntityAPI.selectRegisteredGroupByRegisteredUserId(request, session);
            if(null == guestGroupResponse){
                RpcRegisteredGroup registeredGroup = request.getRegisteredGroup();
                guestGroupResponse = RegisteredGroupResponse.newBuilder()
                        .addResponseRegisteredGroup(registeredGroup)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            session.close();
            responseObserver.onNext(guestGroupResponse);
            responseObserver.onCompleted();
        }else if(ConstantsSelectKind.REGISTERED_GROUP_AND_GROUP_MEMBER_SELECT_BY_GROUP_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupResponse guestGroupResponse = queryEntityAPI.selectRegisteredGroupByGroupIdAndRegisteredUserId(request, session);
            if(null == guestGroupResponse){
                RpcRegisteredGroup registeredGroup = request.getRegisteredGroup();
                guestGroupResponse = RegisteredGroupResponse.newBuilder()
                        .addResponseRegisteredGroup(registeredGroup)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            session.close();
            responseObserver.onNext(guestGroupResponse);
            responseObserver.onCompleted();
        }else if (ConstantsSelectKind.GROUP_SELECT_TYPE_BY_GUEST_NAME.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupResponse guestGroupResponse = queryEntityAPI.selectRegisteredGroupByGroupName(request, session);
            if(null == guestGroupResponse){
                RpcRegisteredGroup registeredGroup = request.getRegisteredGroup();
                guestGroupResponse = RegisteredGroupResponse.newBuilder()
                        .addResponseRegisteredGroup(registeredGroup)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            session.close();
            responseObserver.onNext(guestGroupResponse);
            responseObserver.onCompleted();
        }else if (ConstantsSelectKind.GROUP_SELECT_TYPE_BY_REGISTERED_GROUP_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupResponse guestGroupResponse = queryEntityAPI.selectRegisteredGroupByGroupId(request, session);
            if(null == guestGroupResponse){
                RpcRegisteredGroup registeredGroup = request.getRegisteredGroup();
                guestGroupResponse = RegisteredGroupResponse.newBuilder()
                        .addResponseRegisteredGroup(registeredGroup)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            session.close();
            responseObserver.onNext(guestGroupResponse);
            responseObserver.onCompleted();
        }else if (ConstantsSelectKind.GROUP_SELECT_TYPE_BY_REGISTERED_GROUP_ID_LIKE.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupResponse guestGroupResponse = queryEntityAPI.selectRegisteredGroupByGroupIdLike(request, session);
            if(null == guestGroupResponse){
                RpcRegisteredGroup registeredGroup = request.getRegisteredGroup();
                guestGroupResponse = RegisteredGroupResponse.newBuilder()
                        .addResponseRegisteredGroup(registeredGroup)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            session.close();
            responseObserver.onNext(guestGroupResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 查询某游客用户的群列表接口----》一个游客绑定多个游客群成员----->一个游客群成员绑定一个群(可能是注册群也可能是游客群)
     * 1.某个游客用户关联的游客群成员列表和群列表（包含注册群和游客群）(GROUP_SELECT_TYPE_BY_GUEST_USER_ID)
     */
    @Override
    public void selectGuestGroup(TransmissionRequest request, StreamObserver<GuestGroupResponse> responseObserver) {
        String groupId = request.getRequestKind();
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        GuestGroupResponse guestGroupResponse = queryEntityAPI.searchGroupById(groupId);
        if(null == guestGroupResponse){
            guestGroupResponse = GuestGroupResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(guestGroupResponse);
        responseObserver.onCompleted();
    }

    /**
     * 查询某游客的游客群成员列表接口----》一个游客绑定多个游客群成员
     */
    @Override
    public void selectRegisteredGroupMember(TransmissionRequest request, StreamObserver<RegisteredGroupMemberResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        String kind = request.getRequestKind();
        if(ConstantsSelectKind.REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_USER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupMemberResponse guestGroupMemberResponse = queryEntityAPI.selectRegisteredGroupMemberByRegisteredUserId(request, session);
            if(null == guestGroupMemberResponse){
                RpcRegisteredGroupMember guestRegisteredGroupMember = request.getRegisteredGroupMember();
                guestGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                        .addResponseData(guestRegisteredGroupMember)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestGroupMemberResponse);
            responseObserver.onCompleted();
        }else if (ConstantsSelectKind.REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_MEMBER_ID_LIKE.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupMemberResponse guestGroupMemberResponse = queryEntityAPI.selectRegisteredGroupMemberByRegisteredMemberIdLike(request, session);
            if(null == guestGroupMemberResponse){
                RpcRegisteredGroupMember guestRegisteredGroupMember = request.getRegisteredGroupMember();
                guestGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                        .addResponseData(guestRegisteredGroupMember)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestGroupMemberResponse);
            responseObserver.onCompleted();
        }else if (ConstantsSelectKind.REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_MEMBER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredGroupMemberResponse guestGroupMemberResponse = queryEntityAPI.selectRegisteredGroupMemberByRegisteredMemberId(request, session);
            if(null == guestGroupMemberResponse){
                RpcRegisteredGroupMember guestRegisteredGroupMember = request.getRegisteredGroupMember();
                guestGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                        .addResponseData(guestRegisteredGroupMember)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestGroupMemberResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 查询某游客的游客群成员列表接口----》一个游客绑定多个游客群成员
     */
    @Override
    public void selectGuestGroupMember(TransmissionRequest request, StreamObserver<GuestGroupMemberResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        String kind = request.getRequestKind();
        if(ConstantsSelectKind.GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_USER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            GuestGroupMemberResponse guestGroupMemberResponse = queryEntityAPI.selectGuestGroupMemberByGuestUserId(request, session);
            if(null == guestGroupMemberResponse){
                RpcGuestGroupMember guestGuestGroupMember = request.getGuestGroupMember();
                guestGroupMemberResponse = GuestGroupMemberResponse.newBuilder()
                        .addResponseData(guestGuestGroupMember)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestGroupMemberResponse);
            responseObserver.onCompleted();
        }else if (ConstantsSelectKind.GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_MEMBER_ID_LIKE.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            GuestGroupMemberResponse guestGroupMemberResponse = queryEntityAPI.selectGuestGroupMemberByGuestMemberIdLike(request, session);
            if(null == guestGroupMemberResponse){
                RpcGuestGroupMember guestGuestGroupMember = request.getGuestGroupMember();
                guestGroupMemberResponse = GuestGroupMemberResponse.newBuilder()
                        .addResponseData(guestGuestGroupMember)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestGroupMemberResponse);
            responseObserver.onCompleted();
        }else if (ConstantsSelectKind.GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_MEMBER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            GuestGroupMemberResponse guestGroupMemberResponse = queryEntityAPI.selectGuestGroupMemberByGuestMemberId(request, session);
            if(null == guestGroupMemberResponse){
                RpcGuestGroupMember guestGuestGroupMember = request.getGuestGroupMember();
                guestGroupMemberResponse = GuestGroupMemberResponse.newBuilder()
                        .addResponseData(guestGuestGroupMember)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestGroupMemberResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 查询某游客好友列表接口
     */
    @Override
    public void selectGuestUserFriend(TransmissionRequest request, StreamObserver<GuestUserFriendResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        String kind = request.getRequestKind();
        if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_GUEST_USER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            GuestUserFriendResponse guestUserFriendResponse = queryEntityAPI.selectGuestUserFriendByGuestUserId(request, session);
            if(null == guestUserFriendResponse){
                RpcGuestUserFriend guestGuestUserFriend = request.getGuestUserFriend();
                guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestUserFriendResponse);
            responseObserver.onCompleted();
        }else if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_GUEST_FRIEND_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            GuestUserFriendResponse guestUserFriendResponse = queryEntityAPI.selectGuestUserFriendByFriendId(request, session);
            if(null == guestUserFriendResponse){
                RpcGuestUserFriend guestGuestUserFriend = request.getGuestUserFriend();
                guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestUserFriendResponse);
            responseObserver.onCompleted();
        }else if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_GUEST_FRIEND_ID_LIKE.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            GuestUserFriendResponse guestUserFriendResponse = queryEntityAPI.selectGuestUserFriendByFriendIdLike(request, session);
            if(null == guestUserFriendResponse){
                RpcGuestUserFriend guestGuestUserFriend = request.getGuestUserFriend();
                guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestUserFriendResponse);
            responseObserver.onCompleted();
        }else if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            GuestUserFriendResponse guestUserFriendResponse = queryEntityAPI.selectGuestUserFriendByFriendUserId(request, session);
            if(null == guestUserFriendResponse){
                RpcGuestUserFriend guestGuestUserFriend = request.getGuestUserFriend();
                guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(guestUserFriendResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 查询某注册好友列表接口
     */
    @Override
    public void selectRegisteredUserFriend(TransmissionRequest request, StreamObserver<RegisteredUserFriendResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        String kind = request.getRequestKind();
        if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_REGISTERED_USER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredUserFriendResponse registeredUserFriendResponse =queryEntityAPI.selectRegisteredUserFriendByRegisteredUserId(request, session);
            if(null == registeredUserFriendResponse){
                RpcRegisteredUserFriend guestGuestUserFriend = request.getRegisteredUserFriend();
                registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(registeredUserFriendResponse);
            responseObserver.onCompleted();
        }else if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_REGISTERED_FRIEND_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredUserFriendResponse registeredUserFriendResponse =queryEntityAPI.selectRegisteredUserFriendByFriendId(request, session);
            if(null == registeredUserFriendResponse){
                RpcRegisteredUserFriend guestGuestUserFriend = request.getRegisteredUserFriend();
                registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(registeredUserFriendResponse);
            responseObserver.onCompleted();
        }else if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_REGISTERED_FRIEND_ID_LIKE.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredUserFriendResponse registeredUserFriendResponse =queryEntityAPI.selectRegisteredUserFriendByFriendIdLike(request, session);
            if(null == registeredUserFriendResponse){
                RpcRegisteredUserFriend guestGuestUserFriend = request.getRegisteredUserFriend();
                registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(registeredUserFriendResponse);
            responseObserver.onCompleted();
        }else if(ConstantsSelectKind.FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID.equals(kind)){
            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
            RegisteredUserFriendResponse registeredUserFriendResponse =queryEntityAPI.selectRegisteredUserFriendByFriendUserId(request, session);
            if(null == registeredUserFriendResponse){
                RpcRegisteredUserFriend guestGuestUserFriend = request.getRegisteredUserFriend();
                registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                        .addResponseData(guestGuestUserFriend)
                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                        .build();
                logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
            }else {
                logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
            }
            responseObserver.onNext(registeredUserFriendResponse);
            responseObserver.onCompleted();
        }
    }

    /**
     * 查询阅后即焚优先级列表
     */
    @Override
    public void selectBurnAfterReadingPriority(TransmissionRequest request, StreamObserver<BurnAfterReadingPriorityResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        BurnAfterReadingPriorityResponse burnAfterReadingPriorityResponse = queryEntityAPI.selectBurnAfterReadingPriority(session);
        if(null == burnAfterReadingPriorityResponse){
            RpcBurnAfterReadingPriority guestGuestUserFriend = request.getBurnAfterReadingPriority();
            burnAfterReadingPriorityResponse = BurnAfterReadingPriorityResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(burnAfterReadingPriorityResponse);
        responseObserver.onCompleted();

    }

    /**
     * 查询离线消息优先级列表
     */
    @Override
    public void selectOfflineMessagePriority(TransmissionRequest request, StreamObserver<OfflineMessagePriorityResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        OfflineMessagePriorityResponse offlineMessagePriorityResponse = queryEntityAPI.selectOfflineMessagePriority(session);
        if(null == offlineMessagePriorityResponse){
            RpcOfflineMessagePriority guestGuestUserFriend = request.getOfflineMessagePriority();
            offlineMessagePriorityResponse = OfflineMessagePriorityResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(offlineMessagePriorityResponse);
        responseObserver.onCompleted();

    }

    /**
     * 查询群公告信息
     */
    @Override
    public void selectGroupAnnouncements(TransmissionRequest request, StreamObserver<GroupAnnouncementsResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        GroupAnnouncementsResponse groupAnnouncementsResponse = queryEntityAPI.selectGroupAnnouncements(request, session);
        if(null == groupAnnouncementsResponse){
            RpcGroupAnnouncements guestGuestUserFriend = request.getGroupAnnouncements();
            groupAnnouncementsResponse = GroupAnnouncementsResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(groupAnnouncementsResponse);
        responseObserver.onCompleted();

    }

    /**
     * 查询群备注信息
     */
    @Override
    public void selectGroupRemark(TransmissionRequest request, StreamObserver<GroupRemarkResponse> responseObserver) {
        SqlSession session = DBTools.getSession();
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        GroupRemarkResponse groupRemarkResponse = queryEntityAPI.selectGroupRemark(request, session);
        if(null == groupRemarkResponse){
            RpcGroupRemark guestGuestUserFriend = request.getGroupRemark();
            groupRemarkResponse = GroupRemarkResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(groupRemarkResponse);
        responseObserver.onCompleted();

    }

    /**
     * 更新群备注信息
     */
    @Override
    public void updateGroupRemark(TransmissionRequest request, StreamObserver<GroupRemarkResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        GroupRemarkResponse groupRemarkResponse = updateEntityAPI.updateGroupRemark(request);
        if(null == groupRemarkResponse){
            RpcGroupRemark guestGuestUserFriend = request.getGroupRemark();
            groupRemarkResponse = GroupRemarkResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(groupRemarkResponse);
        responseObserver.onCompleted();
    }

    /**
     * 更新群公共信息
     */
    @Override
    public void updateGroupAnnouncements(TransmissionRequest request, StreamObserver<GroupAnnouncementsResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        GroupAnnouncementsResponse groupAnnouncementsResponse = updateEntityAPI.updateGroupAnnouncements(request);
        if(null == groupAnnouncementsResponse){
            RpcGroupAnnouncements guestGuestUserFriend = request.getGroupAnnouncements();
            groupAnnouncementsResponse = GroupAnnouncementsResponse.newBuilder()
                                        .addResponseData(guestGuestUserFriend)
                                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                                        .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(groupAnnouncementsResponse);
        responseObserver.onCompleted();

    }

    /**
     * 更新游客好友信息
     */
    @Override
    public void updateGuestUserFriend(TransmissionRequest request, StreamObserver<GuestUserFriendResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        GuestUserFriendResponse guestUserFriendResponse = updateEntityAPI.updateGuestUserFriend(request);
        if(null == guestUserFriendResponse){
            RpcGuestUserFriend guestGuestUserFriend = request.getGuestUserFriend();
            guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(guestUserFriendResponse);
        responseObserver.onCompleted();
    }

    /**
     * 更新注册好友信息
     */
    @Override
    public void updateRegisteredUserFriend(TransmissionRequest request, StreamObserver<RegisteredUserFriendResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        RegisteredUserFriendResponse registeredUserFriendResponse = updateEntityAPI.updateRegisteredUserFriend(request);
        if(null == registeredUserFriendResponse){
            RpcRegisteredUserFriend guestGuestUserFriend = request.getRegisteredUserFriend();
            registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredUserFriendResponse);
        responseObserver.onCompleted();
    }

    /**
     * 更新游客群信息
     */
    @Override
    public void updateGuestGroup(TransmissionRequest request, StreamObserver<GuestGroupResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        GuestGroupResponse guestGroupResponse = updateEntityAPI.updateGuestGroup(request);
        if(null == guestGroupResponse){
            RpcGuestGroup guestGuestUserFriend = request.getGuestGroup();
            guestGroupResponse = GuestGroupResponse.newBuilder()
                    .addResponseGuestGroup(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(guestGroupResponse);
        responseObserver.onCompleted();
    }

    /**
     * 更新注册群信息
     */
    @Override
    public void updateRegisteredGroup(TransmissionRequest request, StreamObserver<RegisteredGroupResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        RegisteredGroupResponse registeredGroupResponse = updateEntityAPI.updateRegisteredGroup(request);
        if(null == registeredGroupResponse){
            RpcRegisteredGroup registeredGuestUserFriend = request.getRegisteredGroup();
            registeredGroupResponse = RegisteredGroupResponse.newBuilder()
                    .addResponseRegisteredGroup(registeredGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredGroupResponse);
        responseObserver.onCompleted();
    }

    /**
     * 更新游客群成员信息
     */
    @Override
    public void updateGuestGroupMember(TransmissionRequest request, StreamObserver<GuestGroupMemberResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        GuestGroupMemberResponse guestGroupMemberResponse = updateEntityAPI.updateGuestGroupMember(request);
        if(null == guestGroupMemberResponse){
            RpcGuestGroupMember guestGuestUserFriend = request.getGuestGroupMember();
            guestGroupMemberResponse = GuestGroupMemberResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(guestGroupMemberResponse);
        responseObserver.onCompleted();
    }

    /**
     * 更新注册群成员信息
     */
    @Override
    public void updateRegisteredGroupMember(TransmissionRequest request, StreamObserver<RegisteredGroupMemberResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = updateEntityAPI.updateRegisteredGroupMember(request);
        if(null == registeredGroupMemberResponse){
            RpcRegisteredGroupMember guestGuestUserFriend = request.getRegisteredGroupMember();
            registeredGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.UPDATE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.UPDATE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredGroupMemberResponse);
        responseObserver.onCompleted();
    }

    /**
     * 删除群备注信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    @Override
    public void deleteGroupRemark(TransmissionRequest request, StreamObserver<GroupRemarkResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        GroupRemarkResponse groupRemarkResponse = deleteEntityAPI.deleteGroupRemark(request);
        if(null == groupRemarkResponse){
            RpcGroupRemark guestGuestUserFriend = request.getGroupRemark();
            groupRemarkResponse = GroupRemarkResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(groupRemarkResponse);
        responseObserver.onCompleted();

    }

    /**
     * 删除游客好友信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    @Override
    public void deleteGuestUserFriend(TransmissionRequest request, StreamObserver<GuestUserFriendResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        GuestUserFriendResponse guestUserFriendResponse = deleteEntityAPI.deleteGuestUserFriend(request);
        if(null == guestUserFriendResponse){
            RpcGuestUserFriend guestGuestUserFriend = request.getGuestUserFriend();
            guestUserFriendResponse = GuestUserFriendResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(guestUserFriendResponse);
        responseObserver.onCompleted();
    }

    /**
     * 删除注册好友信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    @Override
    public void deleteRegisteredUserFriend(TransmissionRequest request, StreamObserver<RegisteredUserFriendResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        RegisteredUserFriendResponse registeredUserFriendResponse = deleteEntityAPI.deleteRegisteredUserFriend(request);
        if(null == registeredUserFriendResponse){
            RpcRegisteredUserFriend guestGuestUserFriend = request.getRegisteredUserFriend();
            registeredUserFriendResponse = RegisteredUserFriendResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredUserFriendResponse);
        responseObserver.onCompleted();
    }

    /**
     * 删除游客群信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    @Override
    public void deleteGuestGroup(TransmissionRequest request, StreamObserver<GuestGroupResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        GuestGroupResponse guestGroupResponse = deleteEntityAPI.deleteGuestGroup(request);
        if(null == guestGroupResponse){
            RpcGuestGroup guestGuestUserFriend = request.getGuestGroup();
            guestGroupResponse = GuestGroupResponse.newBuilder()
                    .addResponseGuestGroup(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(guestGroupResponse);
        responseObserver.onCompleted();
    }

    /**
     * 删除注册群信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    @Override
    public void deleteRegisteredGroup(TransmissionRequest request, StreamObserver<RegisteredGroupResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        RegisteredGroupResponse registeredGroupResponse = deleteEntityAPI.deleteRegisteredGroup(request);
        if(null == registeredGroupResponse){
            RpcRegisteredGroup guestGuestUserFriend = request.getRegisteredGroup();
            registeredGroupResponse = RegisteredGroupResponse.newBuilder()
                    .addResponseRegisteredGroup(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredGroupResponse);
        responseObserver.onCompleted();
    }

    /**
     * 删除游客群成员信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    @Override
    public void deleteGuestGroupMember(TransmissionRequest request, StreamObserver<GuestGroupMemberResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        GuestGroupMemberResponse guestGroupMemberResponse = deleteEntityAPI.deleteGuestGroupMember(request);
        if(null == guestGroupMemberResponse){
            RpcGuestGroupMember guestGuestUserFriend = request.getGuestGroupMember();
            guestGroupMemberResponse = GuestGroupMemberResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(guestGroupMemberResponse);
        responseObserver.onCompleted();
    }

    /**
     * 删除注册群成员信息
     * 关注：必须传输删除的种类，参考类ConstantsSelectKind中的定义
     */
    @Override
    public void deleteRegisteredGroupMember(TransmissionRequest request, StreamObserver<RegisteredGroupMemberResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = deleteEntityAPI.deleteRegisteredGroupMember(request);
        if(null == registeredGroupMemberResponse){
            RpcRegisteredGroupMember guestGuestUserFriend = request.getRegisteredGroupMember();
            registeredGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder()
                    .addResponseData(guestGuestUserFriend)
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredGroupMemberResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void insertInviteUsersJoinGroup(TransmissionRequest request, StreamObserver<AllGroupsMemberResponse> responseObserver) {
        InsertEntityAPI insertEntityAPI = new InsertEntityAPI();
        AllGroupsMemberResponse allGroupsMemberResponse = insertEntityAPI.insertInviteUsersJoinGroup(request);
        if(null == allGroupsMemberResponse){
            allGroupsMemberResponse = AllGroupsMemberResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
            logger.info("邀请用户入群的返回数据："+allGroupsMemberResponse.getResponseGroupMemberVoList());
        }
        responseObserver.onNext(allGroupsMemberResponse);
        responseObserver.onCompleted();
//        String groupId = request.getRequestKind();
//        if(null != groupId && !"".equals(groupId)){
//            QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
//            logger.info("查询所有群成员的群ID："+groupId);
//            AllGroupsMemberResponse allGroupsMemberResponse = queryEntityAPI.selectGroupMembers(groupId);
//            if(null == allGroupsMemberResponse){
//                allGroupsMemberResponse = AllGroupsMemberResponse.newBuilder()
//                        .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
//                        .build();
//                logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
//            }else {
//                logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
//                logger.info("返回群所有群成员列表："+allGroupsMemberResponse.getResponseGroupMemberVoList());
//            }
//            responseObserver.onNext(allGroupsMemberResponse);
//            responseObserver.onCompleted();
//        }else {

//        }
    }

    @Override
    public void queryGroupMembersInfoList(SelectGroupMemberRequest request,StreamObserver<AllGroupsMemberResponse> responseObserver) {
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        String groupId = request.getGroupId();
        logger.info("查询所有群成员的群ID："+groupId);
        AllGroupsMemberResponse allGroupsMemberResponse = queryEntityAPI.selectGroupMembers(groupId);
        if(null == allGroupsMemberResponse){
            allGroupsMemberResponse = AllGroupsMemberResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
            logger.info("返回群所有群成员列表："+allGroupsMemberResponse.getResponseGroupMemberVoList().size());
        }
        responseObserver.onNext(allGroupsMemberResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteGuestRelatedAllInfo(TransmissionRequest request, StreamObserver<AllGroupsMemberResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        AllGroupsMemberResponse response = deleteEntityAPI.deleteGuestRelatedAllInfo(request);
        if(null == response){
            response = AllGroupsMemberResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void searchAllGroupByUserId(TransmissionRequest request, StreamObserver<AllGroupsMemberResponse> responseObserver) {
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        AllGroupsMemberResponse allGroupsResponse = queryEntityAPI.searchAllGroupByUserId(request);
        if(null == allGroupsResponse){
            allGroupsResponse = AllGroupsMemberResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(allGroupsResponse);
        responseObserver.onCompleted();
    }

    /**
     *  群主移除群成员(可以是一个或者多个)
     */
    @Override
    public void deleteMembersByGroupOwner(TransmissionRequest request, StreamObserver<AllGroupsMemberResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        AllGroupsMemberResponse allGroupsMemberResponse = deleteEntityAPI.deleteMembersByGroupOwner(request);
        if(null == allGroupsMemberResponse){
            allGroupsMemberResponse = AllGroupsMemberResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(allGroupsMemberResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void groupMemberExitGroupChat(TransmissionRequest request, StreamObserver<AllGroupsMemberResponse> responseObserver) {
        DeleteEntityAPI deleteEntityAPI = new DeleteEntityAPI();
        AllGroupsMemberResponse allGroupsMemberResponse = deleteEntityAPI.groupMemberExitGroupChat(request);
        if(null == allGroupsMemberResponse){
            allGroupsMemberResponse = AllGroupsMemberResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.DELETE_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.DELETE_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(allGroupsMemberResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void queryGroupInfoByListId(TransmissionRequest request,StreamObserver<RegisteredGroupResponse> responseObserver) {
        long startTime=System.currentTimeMillis();
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        RegisteredGroupResponse registeredGroupResponse = queryEntityAPI.queryGroupInfoByListId(request);
        if(null == registeredGroupResponse){
            registeredGroupResponse = RegisteredGroupResponse.newBuilder()
                    .setStatusDetail(ConstantsContent.RESPONSE_FAILURE)
                    .build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info("查询所有群信息返回数据："+registeredGroupResponse.getResponseRegisteredGroupList().toString());
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredGroupResponse);
        responseObserver.onCompleted();
        long endTime=System.currentTimeMillis();
        logger.info("查询所有群信息RPC接口耗时："+(endTime - startTime));
    }

    @Override
    public void queryUserFriendRelation(TransmissionRequest request,StreamObserver<RpcRegisteredUserFriend> responseObserver) {
        long startTime=System.currentTimeMillis();
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        RpcRegisteredUserFriend friendRelation = queryEntityAPI.queryFriendRelation(request);
        if(null == friendRelation){
            friendRelation = RpcRegisteredUserFriend.newBuilder().build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info("好友关系返回数据："+friendRelation.toString());
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(friendRelation);
        responseObserver.onCompleted();
        long endTime=System.currentTimeMillis();
        logger.info("查询好友关系接口耗时："+(endTime - startTime));
    }

    @Override
    public void updateRegGroupMemberRemark(TransmissionRequest request, StreamObserver<RegisteredGroupMemberResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        RegisteredGroupMemberResponse registeredGroupMemberResponse = updateEntityAPI.updateRegtGroupMemberRemark(request);
        if(null == registeredGroupMemberResponse){
            registeredGroupMemberResponse = RegisteredGroupMemberResponse.newBuilder().build();
            logger.info(ConstantsPrompt.SELECT_RESPONSE_FAILURE);
        }else {
            logger.info(ConstantsPrompt.SELECT_RESPONSE__SUCCESS);
        }
        responseObserver.onNext(registeredGroupMemberResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void selectGroupMemberNickname(TransmissionRequest request, StreamObserver<GroupMemberNicknameResponse> responseObserver) {
        QueryEntityAPI queryEntityAPI = new QueryEntityAPI();
        GroupMemberNicknameResponse nicknameResponse = queryEntityAPI.selectGroupMemberNickname(request);
        responseObserver.onNext(nicknameResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void insertGroupPhotoUrl(TransmissionRequest request,StreamObserver<AllGroupsMemberResponse> responseObserver) {
        UpdateEntityAPI updateEntityAPI = new UpdateEntityAPI();
        AllGroupsMemberResponse allGroupsMemberResponse = updateEntityAPI.updateRegisteredGroupServcie(request);
        responseObserver.onNext(allGroupsMemberResponse);
        responseObserver.onCompleted();
    }
}
