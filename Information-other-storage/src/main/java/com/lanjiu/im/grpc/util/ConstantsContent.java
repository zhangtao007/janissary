package com.lanjiu.im.grpc.util;

public class ConstantsContent {
    //消息响应类型  Success/Failure/Network Timeout Transmission
    public final static String RESPONSE_SUCCESS = "success";
    public final static String RESPONSE_SUCCESS_NULL = "select null";
    public final static String RESPONSE_FAILURE = "failure";
    public final static String RESPONSE_FAILURE_REQUEST_ERROR = "REQUEST_ERROR";
    public final static String RESPONSE_NETWORK_TIMEOUT = "timeout";
    public final static String RESPONSE_AGREE = "agree";
    public final static String RESPONSE_REFUSE = "refuse";
    public final static String RESPONSE_SET_UNRECIEVE = "Friend or you have set not to receive offline messages";

    //当前服务模块类型 RegisteredUser,Tourists  Current service module type
    public final static String CURRENT_SERVICE_MODULE_REGISTERED_USER_TYPE = "RegisteredUser";
    public final static String CURRENT_SERVICE_MODULE_TOURISTS_TYPE = "Tourists";
    //心跳监测
    public final static String MSGTYPE_HEARTBEAT_REQUEST = "heat beat";
    //协议包校验情况
    public final static String RESPONSE_CHECK_FAILURE = "package check failure";


    //好友信息修改类型
    public  final static String FRIEND_ALIAS = "FRIEND_ALIAS";
    public  final static String FRIEND_OFFLINE_SET = "FRIEND_OFFLINE_SET";

    //8位数的进制
    public final static int BEAUTIFUL_NUMBER_TEN_MILLION = 10000000;
    public final static int BEAUTIFUL_NUMBER_ONE_MILLION = 1000000;
    public final static int BEAUTIFUL_NUMBER_ONE_HUNDRED_THOUSAND = 100000;
    public final static int BEAUTIFUL_NUMBER_TEN_THOUSAND = 10000;
    public final static int BEAUTIFUL_NUMBER_ONE_THOUSAND = 1000;
    public final static int BEAUTIFUL_NUMBER_ONE_HUNDRED = 100;
    public final static int BEAUTIFUL_NUMBER_TEN = 10;
    public final static int BEAUTIFUL_NUMBER_ONE = 1;
    public final static int BEAUTIFUL_NUMBER_ONCE_GET = 1;
    //未少于最小量，不用从总表取记录
    public final static int BEAUTIFUL_NUMBER_MIN_LIMIT = 10;
    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP = "GUEST_GROUP";
    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_FRIEND = "GUEST_FRIEND";
    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_MEMBER = "GUEST_GROUP_MEMBER";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP = "REGISTERED_GROUP";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_FRIEND = "REGISTERED_FRIEND";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP_MEMBER = "REGISTERED_GROUP_MEMBER";

    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_REAL = "GUEST_GROUP_REAL";
    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_FRIEND_REAL = "GUEST_FRIEND_REAL";
    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_MEMBER_REAL = "GUEST_GROUP_MEMBER_REAL";

    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP_REAL = "REGISTERED_GROUP_REAL";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_FRIEND_REAL = "REGISTERED_FRIEND_REAL";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP_MEMBER_REAL = "REGISTERED_GROUP_MEMBER_REAL";
    //手动设置靓号机制的状态
    public final static String BEAUTIFUL_NUMBER_SET_COMMON_START = "1";
    public final static String BEAUTIFUL_NUMBER_SET_COMMON_CLOSE = "0";

    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_REAL_CONFIG = "/beautiful_number/guest_group_beautiful_number_config.properties";
    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_FRIEND_REAL_CONFIG = "/beautiful_number/guest_friend_beautiful_number_config.properties";
    public final static String BEAUTIFUL_NUMBER_TYPE_GUEST_GROUP_MEMBER_REAL_CONFIG = "/beautiful_number/guest_group_member_beautiful_number_config.properties";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP_REAL_CONFIG = "/beautiful_number/registered_group_beautiful_number_config.properties";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_FRIEND_REAL_CONFIG = "/beautiful_number/registered_friend_beautiful_number_config.properties";
    public final static String BEAUTIFUL_NUMBER_TYPE_REGISTERED_GROUP_MEMBER_REAL_CONFIG = "/beautiful_number/registered_group_member_beautiful_number_config.properties";

}
