package com.lanjiu.im.communication.client.login_regist.login_storageAPI;

public class ConstType {

    //协议包校验情况
    public static final String RESPONSE_CHECK_FAILURE = "package check failure";

    //注册登录模块消息请求(登录—存储)
    public static final String REGISTERUSER ="0";
    public static final String GUESTUSER = "1";
    public static final String USERINFOMATION = "2";

    //消息响应
    public static final String SUCCESS ="SUCCESS";
    public static final String FAILURE ="FAILURE";
    public static final String REGIST_SUCCESS ="registed  success";
    public static final String REGIST_FAILURE ="registed  failure";
    public static final String REGIST_LOGIN_SUCCESS = "registUser login success";
    public static final String GUEST_LOGIN_SUCCESS = "guestUser login success";
    public static final String REGIST_LOGIN_FAILURE = "registUser login failure";
    public static final String GUEST_LOGIN_FAILURE = "guestUser login failure";
    public static final String PERSON_SETTING_FAILURE = "person setting  failure";
    public static final String PERSON_SETTING_SUCCESS = "person setting success";
    public static final String OFF_MSG_SETTING = "OFF_MESSAGE_FRIEND_SETTING  false ,";



    //用户个人设置类型
    public static final String OFF_LINE_SERTTING = "0";
    public static final String BURN_AFTER_READING = "1";
    public static final String ONLINE_STATUS = "2";
    public static final String ON = "ON";
    public static final String OFF = "OFF";
    public static final String TIME_UTIL = "SECOND";
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;
    public static final String QUERY_ALL_USER= "QUERY_ALL_USER";
    public static final String SEARCH_USER = "SEARCH_USER";



    //发号机制
    public static final String AUTO_REGIST = "AUTO_REGIST";
    public static final String AUTO_GUEST = "AUTO_GUEST";

    public final static int BEAUTIFUL_NUMBER_TEN_MILLION = 10000000;
    public final static int BEAUTIFUL_NUMBER_ONE_MILLION = 1000000;
    public final static int BEAUTIFUL_NUMBER_ONE_HUNDRED_THOUSAND = 100000;
    public final static int BEAUTIFUL_NUMBER_TEN_THOUSAND = 10000;
    public final static int BEAUTIFUL_NUMBER_ONE_THOUSAND = 1000;
    public final static int BEAUTIFUL_NUMBER_ONE_HUNDRED = 100;
    public final static int BEAUTIFUL_NUMBER_TEN = 10;
    public final static int BEAUTIFUL_NUMBER_ONE = 1;
    public final static int BEAUTIFUL_NUMBER_ONCE_GET = 1;
    public final static int BEAUTIFUL_NUMBER_MIN_LIMIT = 10;

    //null
    public  final  static  String EMPTY = "";



}
