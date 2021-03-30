package com.lanjiu.im.grpc.client.util;

public class ConstantsSelectKind {

    public final static String FRIEND_SELECT_TYPE_BY_FRIEND_USER_ID = "BY_FRIEND_USER_ID";
    public final static String FRIEND_SELECT_TYPE_BY_GUEST_USER_ID = "BY_GUEST_USER_ID";
    public final static String FRIEND_SELECT_TYPE_BY_GUEST_FRIEND_ID = "GUEST_FRIEND_ID";
    public final static String FRIEND_SELECT_TYPE_BY_GUEST_FRIEND_ID_LIKE = "GUEST_FRIEND_ID_LIKE";
    public final static String FRIEND_SELECT_TYPE_BY_REGISTERED_USER_ID = "BY_REGISTERED_USER_ID";
    public final static String FRIEND_SELECT_TYPE_BY_REGISTERED_FRIEND_ID = "REGISTERED_FRIEND_ID";
    public final static String FRIEND_SELECT_TYPE_BY_REGISTERED_FRIEND_ID_LIKE = "REGISTERED_FRIEND_ID_LIKE";

    public final static String GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_USER_ID = "GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_USER_ID";
    public final static String GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_MEMBER_ID_LIKE = "GUEST_MEMBER_ID_LIKE";
    public final static String GUEST_GROUP_MEMBER_SELECT_TYPE_BY_GUEST_MEMBER_ID = "GUEST_MEMBER_ID";
    public final static String REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_USER_ID = "REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_USER_ID";
    public final static String REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_MEMBER_ID_LIKE = "REGISTERED_MEMBER_ID_LIKE";
    public final static String REGISTERED_GROUP_MEMBER_SELECT_TYPE_BY_REGISTERED_MEMBER_ID = "REGISTERED_MEMBER_ID";

    public final static String GUEST_GROUP_AND_GROUP_MEMBER_SELECT_BY_GROUP_ID = "GUEST_GROUP_AND_GROUP_MEMBER_SELECT";
    public final static String GROUP_SELECT_TYPE_BY_GUEST_USER_ID = "GROUP_SELECT_TYPE_BY_GUEST_USER_ID";
    public final static String GROUP_SELECT_TYPE_BY_GUEST_GROUP_ID = "GUEST_GROUP_ID";
    public final static String GROUP_SELECT_TYPE_BY_GUEST_GROUP_ID_LIKE = "GUEST_GROUP_ID_LIKE";
    public final static String GROUP_SELECT_TYPE_BY_GUEST_NAME = "GROUP_SELECT_TYPE_BY_GUEST_NAME";
    public final static String GROUP_SELECT_TYPE_BY_REGISTERED_USER_ID = "GROUP_SELECT_TYPE_BY_REGISTERED_USER_ID";
    public final static String GROUP_SELECT_TYPE_BY_REGISTERED_GROUP_ID = "REGISTERED_GROUP_ID";
    public final static String GROUP_SELECT_TYPE_BY_REGISTERED_GROUP_ID_LIKE = "REGISTERED_GROUP_ID_LIKE";
    public final static String REGISTERED_GROUP_AND_GROUP_MEMBER_SELECT_BY_GROUP_ID = "REGISTERED_GROUP_AND_GROUP_MEMBER_SELECT";

    //delete类型------group remark
    public final static String GROUP_REMARK_DELETE_TYPE_BY_GROUP_ID = "GROUP_REMARK_DELETE_TYPE_BY_GROUP_ID";
    public final static String GROUP_REMARK_DELETE_TYPE_BY_MEMEBER_REMARKID_ID = "GROUP_REMARK_DELETE_TYPE_BY_MEMEBER_REMARKID_ID";
    public final static String GROUP_REMARK_DELETE_TYPE_BY_MEMBER_ID = "GROUP_REMARK_DELETE_TYPE_BY_MEMBER_ID";
    public final static String GROUP_REMARK_DELETE_TYPE_BY_GROUP_ID_AND_MEMBER_ID = "GROUP_REMARK_DELETE_TYPE_BY_GROUP_ID_AND_MEMBER_ID";

    //delete类型------  friend
    public final static String FRIEND_DELETE_TYPE_BY_FRIEND_ID = "FRIEND_DELETE_TYPE_BY_FRIEND_ID";
    public final static String FRIEND_DELETE_TYPE_BY_FRIEND_USER_ID = "FRIEND_DELETE_TYPE_BY_FRIEND_USER_ID";
    public final static String FRIEND_DELETE_TYPE_BY_GUEST_USER_ID_AND_FRIEND_USER_ID = "FRIEND_DELETE_TYPE_BY_GUEST_USER_ID_AND_FRIEND_USER_ID";
    public final static String FRIEND_DELETE_TYPE_BY_GUEST_USER_ID = "FRIEND_DELETE_TYPE_BY_GUEST_USER_ID";

    public final static String FRIEND_DELETE_TYPE_BY_REGISTERED_USER_ID_AND_FRIEND_USER_ID = "FRIEND_DELETE_TYPE_BY_REGISTERED_USER_ID_AND_FRIEND_USER_ID";
    public final static String FRIEND_DELETE_TYPE_BY_REGISTERED_USER_ID = "FRIEND_DELETE_TYPE_BY_REGISTERED_USER_ID";

    //delete类型------  group
    public final static String GROUP_DELETE_TYPE_BY_GROUP_ID = "GROUP_DELETE_TYPE_BY_GROUP_ID";

    //delete类型------  group member
    public final static String GROUP_MEMBER_DELETE_TYPE_BY_GROUP_MEMBER_ID = "GROUP_MEMBER_DELETE_TYPE_BY_GROUP_MEMBER_ID";

}
