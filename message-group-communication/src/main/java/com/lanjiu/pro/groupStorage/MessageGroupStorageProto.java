// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message_group_storage_grpc.proto

package com.lanjiu.pro.groupStorage;

public final class MessageGroupStorageProto {
  private MessageGroupStorageProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_DeleteGroupMembersMsgRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_DeleteGroupMembersMsgRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_SelectOffLineGroupMsgRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_SelectOffLineGroupMsgRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_ResponseResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_ResponseResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_ResponseCount_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_ResponseCount_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_GroupMsgList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_GroupMsgList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_GroupMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_GroupMsg_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_GroupMsgOffLineRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_GroupMsgOffLineRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n message_group_storage_grpc.proto\022\033com." +
      "lanjiu.pro.groupStorage\032\031google/protobuf" +
      "/any.proto\032#im_business_protocol_entitie" +
      "s.proto\"V\n\034DeleteGroupMembersMsgRequest\022" +
      "\017\n\007user_id\030\001 \001(\t\022\023\n\013member_type\030\002 \001(\t\022\020\n" +
      "\010group_id\030\003 \003(\t\"P\n\034SelectOffLineGroupMsg" +
      "Request\022\017\n\007user_id\030\001 \001(\t\022\014\n\004page\030\002 \001(\005\022\021" +
      "\n\tpage_size\030\003 \001(\005\"R\n\016ResponseResult\022\017\n\007s" +
      "uccess\030\001 \001(\010\022\013\n\003msg\030\002 \001(\t\022\"\n\004data\030\003 \001(\0132" +
      "\024.google.protobuf.Any\"\036\n\rResponseCount\022\r" +
      "\n\005count\030\001 \001(\005\"O\n\014GroupMsgList\022?\n\tgroup_m" +
      "sg\030\001 \003(\0132,.com.lanjiu.pro.business.Group" +
      "OfflineMessage\"\032\n\010GroupMsg\022\016\n\006msg_id\030\001 \001" +
      "(\005\"\247\003\n\026GroupMsgOffLineRequest\022\016\n\006msg_id\030" +
      "\001 \001(\t\022\020\n\010msg_type\030\002 \001(\005\022\017\n\007from_id\030\003 \001(\t" +
      "\022\020\n\010group_id\030\004 \001(\t\022\r\n\005to_id\030\005 \001(\t\022\017\n\007con" +
      "tent\030\006 \001(\t\022\022\n\nentity_url\030\007 \001(\t\022\027\n\017snapch" +
      "at_status\030\010 \001(\010\022\034\n\024snapchat_time_length\030" +
      "\t \001(\005\022\023\n\013create_time\030\n \001(\003\022\n\n\002id\030\013 \001(\005\022\014" +
      "\n\004isAt\030\014 \001(\005\022\020\n\010duration\030\r \001(\003\022\022\n\ngroupO" +
      "wner\030\016 \001(\t\022\026\n\016groupOwnerNick\030\017 \001(\t\022\025\n\rgr" +
      "oupOwnerUrl\030\020 \001(\t\022\021\n\tgroupName\030\021 \001(\t\022\024\n\014" +
      "fromMemberId\030\022 \001(\t\022\026\n\016fromMemberName\030\023 \001" +
      "(\t\022\030\n\020fromMemberAvatar\030\024 \001(\t\"\177\n\032GroupAud" +
      "ioVideoCallRequest\022S\n\026groupAudioVideoMes" +
      "sage\030\001 \001(\01323.com.lanjiu.pro.groupStorage" +
      ".GroupAudioVideoMessage\022\014\n\004args\030\002 \001(\t\"\202\001" +
      "\n\033GroupAudioVideoCallResponse\022S\n\026groupAu" +
      "dioVideoMessage\030\001 \003(\01323.com.lanjiu.pro.g" +
      "roupStorage.GroupAudioVideoMessage\022\016\n\006re" +
      "sult\030\002 \001(\t\"\330\001\n\026GroupAudioVideoMessage\022\017\n" +
      "\007room_id\030\001 \001(\t\022\022\n\nonly_audio\030\002 \001(\010\022\024\n\014fr" +
      "om_user_id\030\003 \001(\t\022\026\n\016from_user_name\030\004 \001(\t" +
      "\022\023\n\013user_avatar\030\005 \001(\t\022\020\n\010group_id\030\006 \001(\t\022" +
      "\027\n\017call_member_ids\030\007 \001(\t\022\014\n\004type\030\010 \001(\t\022\016" +
      "\n\006detail\030\t \001(\t\022\r\n\005other\030\n \001(\t2\263\t\n\032Messag" +
      "eGroupStorageService\022v\n\020saveGroupMassage" +
      "\0223.com.lanjiu.pro.groupStorage.GroupMsgO" +
      "ffLineRequest\032+.com.lanjiu.pro.groupStor" +
      "age.ResponseResult\"\000\022\200\001\n\032saveGroupMember" +
      "sOffLineMsg\0223.com.lanjiu.pro.groupStorag" +
      "e.GroupMsgOffLineRequest\032+.com.lanjiu.pr" +
      "o.groupStorage.ResponseResult\"\000\022\201\001\n\025sele" +
      "ctOffLineGroupMsg\0229.com.lanjiu.pro.group" +
      "Storage.SelectOffLineGroupMsgRequest\032+.c" +
      "om.lanjiu.pro.groupStorage.ResponseResul" +
      "t\"\000\022\205\001\n\032selectOffLineGroupMsgCount\0229.com" +
      ".lanjiu.pro.groupStorage.SelectOffLineGr" +
      "oupMsgRequest\032*.com.lanjiu.pro.groupStor" +
      "age.ResponseCount\"\000\022\210\001\n\034deleteGroupMembe" +
      "rsOffLineMsg\0229.com.lanjiu.pro.groupStora" +
      "ge.DeleteGroupMembersMsgRequest\032+.com.la" +
      "njiu.pro.groupStorage.ResponseResult\"\000\022\200" +
      "\001\n\024deleteSendOffLineMsg\0229.com.lanjiu.pro" +
      ".groupStorage.DeleteGroupMembersMsgReque" +
      "st\032+.com.lanjiu.pro.groupStorage.Respons" +
      "eResult\"\000\022t\n\016deleteGroupMsg\0223.com.lanjiu" +
      ".pro.groupStorage.GroupMsgOffLineRequest" +
      "\032+.com.lanjiu.pro.groupStorage.ResponseR" +
      "esult\"\000\022z\n\016groupOwnerExit\0229.com.lanjiu.p" +
      "ro.groupStorage.DeleteGroupMembersMsgReq" +
      "uest\032+.com.lanjiu.pro.groupStorage.Respo" +
      "nseResult\"\000\022\215\001\n\026groupAudioAndVideoCall\0227" +
      ".com.lanjiu.pro.groupStorage.GroupAudioV" +
      "ideoCallRequest\0328.com.lanjiu.pro.groupSt" +
      "orage.GroupAudioVideoCallResponse\"\000B;\n\033c" +
      "om.lanjiu.pro.groupStorageB\030MessageGroup" +
      "StorageProtoH\001P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.AnyProto.getDescriptor(),
          com.lanjiu.pro.business.BusinessProtocolEntities.getDescriptor(),
        });
    internal_static_com_lanjiu_pro_groupStorage_DeleteGroupMembersMsgRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_lanjiu_pro_groupStorage_DeleteGroupMembersMsgRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_DeleteGroupMembersMsgRequest_descriptor,
        new java.lang.String[] { "UserId", "MemberType", "GroupId", });
    internal_static_com_lanjiu_pro_groupStorage_SelectOffLineGroupMsgRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_lanjiu_pro_groupStorage_SelectOffLineGroupMsgRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_SelectOffLineGroupMsgRequest_descriptor,
        new java.lang.String[] { "UserId", "Page", "PageSize", });
    internal_static_com_lanjiu_pro_groupStorage_ResponseResult_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_lanjiu_pro_groupStorage_ResponseResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_ResponseResult_descriptor,
        new java.lang.String[] { "Success", "Msg", "Data", });
    internal_static_com_lanjiu_pro_groupStorage_ResponseCount_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_lanjiu_pro_groupStorage_ResponseCount_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_ResponseCount_descriptor,
        new java.lang.String[] { "Count", });
    internal_static_com_lanjiu_pro_groupStorage_GroupMsgList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_lanjiu_pro_groupStorage_GroupMsgList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_GroupMsgList_descriptor,
        new java.lang.String[] { "GroupMsg", });
    internal_static_com_lanjiu_pro_groupStorage_GroupMsg_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_lanjiu_pro_groupStorage_GroupMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_GroupMsg_descriptor,
        new java.lang.String[] { "MsgId", });
    internal_static_com_lanjiu_pro_groupStorage_GroupMsgOffLineRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_lanjiu_pro_groupStorage_GroupMsgOffLineRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_GroupMsgOffLineRequest_descriptor,
        new java.lang.String[] { "MsgId", "MsgType", "FromId", "GroupId", "ToId", "Content", "EntityUrl", "SnapchatStatus", "SnapchatTimeLength", "CreateTime", "Id", "IsAt", "Duration", "GroupOwner", "GroupOwnerNick", "GroupOwnerUrl", "GroupName", "FromMemberId", "FromMemberName", "FromMemberAvatar", });
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallRequest_descriptor,
        new java.lang.String[] { "GroupAudioVideoMessage", "Args", });
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoCallResponse_descriptor,
        new java.lang.String[] { "GroupAudioVideoMessage", "Result", });
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoMessage_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_lanjiu_pro_groupStorage_GroupAudioVideoMessage_descriptor,
        new java.lang.String[] { "RoomId", "OnlyAudio", "FromUserId", "FromUserName", "UserAvatar", "GroupId", "CallMemberIds", "Type", "Detail", "Other", });
    com.google.protobuf.AnyProto.getDescriptor();
    com.lanjiu.pro.business.BusinessProtocolEntities.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
