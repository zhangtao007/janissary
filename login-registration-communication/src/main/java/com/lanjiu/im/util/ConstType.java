package com.lanjiu.im.util;

public class ConstType {


    //协议包校验情况
    public static final String RESPONSE_CHECK_FAILURE = "package check failure";

    //注册登录模块消息请求(登录—存储)
    public static final String REGISTERUSER ="100";
    public static final String GUESTUSER = "101";

    //消息响应
    public static final String SUCCESS ="SUCCESS";
    public static final String FAILURE ="FAILURE";
    public static final String EXCEPTION ="网络异常";
    public static final String REGIST_SUCCESS ="注册成功！";
    public static final String REGIST_FAILURE ="注册失败！";
    public static final String REGIST_LOGIN_SUCCESS = "登录成功！";
    public static final String REGIST_LOGIN_FAILURE = "登录失败！";
    public static final String REGIST_LOGOUT_FAILURE = "退出失败！";
    public static final String REGIST_LOGOUT_SUCCESS = "退出成功！";
    public static final String PERSON_SETTING_FAILURE = "个人设置失败！";
    public static final String PERSON_SETTING_SUCCESS = "个人设置成功！";
    public static final String QUERY_USERINFO_SUCCESS = "用户搜索成功！";
    public static final String QUERY_USERINFO_FAILURE = "用户搜索失败！";
    public static final String PHONE_ERROR = "手机号码错误！";
    public static final String PASSWORD_ERROR = "密码错误！";
    public static final String VCODE_ID_ERROR = "请输入正确ID和有效验证码！";
    public static final String USER_ID_ERROR = "请输入正确ID号码！";
    public static final String VCODE_ERROR = "请输入正确有效的验证码！";
    public static final String NET_BUSINISS = "网络繁忙，请稍后重试";
    public static final String PHONE_VCODE_OK = "手机号和验证码验证成功！";




    //用户个人设置类型
    public static final String OFF_LINE_SERTTING = "0";
    public static final String BURN_AFTER_READING = "1";
    public static final String ONLINE_STATUS = "2";
    public static final String ON = "ON";
    public static final String OFF = "OFF";
    public static final String OUT = "OUT";
    public static final String TIME_UTIL = "SECOND";
    public static final boolean TRUE = true;
    public static final boolean FALSE = false;
    public static final String QUERY_ALL_USER= "QUERY_ALL_USER";
    public static final String SEARCH_USER = "SEARCH_USER";
    public static final String USER_SET = "USER_SET";
    public static final String PERSON_SETTING_EXIT_CLEAN = "PERSON_SETTING_EXIT_CLEAN";
    public static final String PERSONAL_SETTING_TIMER_CLEAN = "PERSONAL_SETTING_TIMER_CLEAN";



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





}
