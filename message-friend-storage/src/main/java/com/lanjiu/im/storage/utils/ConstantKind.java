package com.lanjiu.im.storage.utils;

public class ConstantKind {

    //friend-message-type(好友离线消息和删除指令)
    public final static String MESSAGE_FRIEND_OFF = "MESSAGE_FRIEND_OFF";
    public final static String MESSAGE_FRIEND_DEL = "MESSAGE_FRIEND_DEL";


    //select
    public final static String MESSAGE_REQUEST_SELECT_ALL = "ALL";
    public final static String MESSAGE_REQUEST_SELECT_MSG_ID = "MSG_ID";
    public final static String MESSAGE_REQUEST_SELECT_FROM_ID = "FROM_ID";
    public final static String MESSAGE_REQUEST_SELECT_TO_ID = "TO_ID";
    public final static String TIME_CLEAR_REQUEST_SELECT_TO_ID = "TIME_CLEAR_TO_ID";

    //delete
    public final static String MESSAGE_REQUEST_DELETE_MSG_ID = "MSG_ID";
    public final static String MESSAGE_REQUEST_DELETE_FROM_ID = "FROM_ID";
    public final static String MESSAGE_REQUEST_DELETE_TO_ID = "TO_ID";
    public final static String MESSAGE_REQUEST_GUEST_USER_LOGOUT = "GUEST_USER_ID";
    public final static String TIME_CLEAR_ARG = "TIME_CLEAR_ARG";
}
