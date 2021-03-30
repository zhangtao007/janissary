package com.lanjiu.im.communication.client;

import com.lanjiu.pro.business.BusinessProtocolMessageStandard;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

public class InformationClientHandler extends SimpleChannelInboundHandler<BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage> {

    private int count;
    private final Logger log = Logger.getLogger(InformationClientHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage msg) throws Exception {
     /*   //数据包完整性校验
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = msg.getUnifiedEntranceMessage();
        JCRC32 jcrc32 = new JCRC32();
        CheckSumResult checkSumResult = jcrc32.checkSumValidateProtocol(msg,unifiedEntranceMessage);
        if(checkSumResult.b_result){
            log.info("Client端数据包校验成功!");
            BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = unifiedEntranceMessage.getDataType();
            if(dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
            {
                System.out.println("客户端接收到的RegisteredUserProtocol消息时间：" + unifiedEntranceMessage.getRegisteredUserProtocol().getRegisteredUser().getNickname());
//                System.out.println("客户端接收到的RegisteredUserProtocol消息时间：" + unifiedEntranceMessage.getRegisteredUserProtocol().getRegisteredUser().getIpAddress());
//                System.out.println("客户端接收到的RegisteredUserProtocol消息时间：" + unifiedEntranceMessage.getRegisteredUserProtocol().getRegisteredUser().getUserPhone());
                System.out.println("客户端接收到的RegisteredUserProtocol消息时间：" + unifiedEntranceMessage.getHead().getTimestamp());
            } else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.LoginProtocol)
            {
//                System.out.println("客户端接收到的TouristsProtocol消息内容：" + unifiedEntranceMessage.getLoginProtocol().getTourists().getTemporaryId());
//                System.out.println("客户端接收到的TouristsProtocol消息内容：" + unifiedEntranceMessage.getLoginProtocol().getTourists().getIpAddress());
            }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol)
            {
                boolean b_file = originalPictureFriendsTransmissionFileWrite(unifiedEntranceMessage);
                System.out.println(b_file);

                System.out.println("客户端接收Picture文件 use OriginalPictureFriendsTransmissionProtocol");
            }
            System.out.println("客户端收到的消息数量：" + (++this.count));
        }else {
            log.info("Client端数据包校验失败... ...");
            //BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = jcrc32.packageCheckSum(checkSumResult.getMsg());
            //ctx.writeAndFlush(checkSumResult.getMsg());
        }
*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

      /*  //建立功能模块相关的连接
        //第二个参数为功能类型
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = null;
        unifiedEntranceMessage = interactiveProtocolSelection(ctx,BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol);

        //加校验码信息
        JCRC32 jcrc32 = new JCRC32();
        BusinessProtocolMessageStandard.CheckUnifiedEntranceMessage checkUnified = jcrc32.packageCheckSum(unifiedEntranceMessage);
        ctx.writeAndFlush(checkUnified);*/
    }

    /*
    * 参数为需要交互的功能模块类型，具体类型可以参考常量类
    * ConstantContent中的定义
    * */
  /*  public BusinessProtocolMessageStandard.UnifiedEntranceMessage interactiveProtocolSelection(ChannelHandlerContext ctx,BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType)
    {
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = null;
        if(dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
        {
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
                    .setRegisteredUserProtocol(BusinessProtocolMessages.RegisteredUserProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setTimestamp(LocalDateTime.now().getSecond())
                            .build())
                    .build();
        } else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.LoginProtocol) {
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.RegisteredUserProtocol)
                    .setRegisteredUserProtocol(BusinessProtocolMessages.RegisteredUserProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setTimestamp(LocalDateTime.now().getSecond())
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindUserRequestProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindUserRequestProtocol)
                    .setFindUserRequestProtocol(FindUserRequestProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindGroupRequestProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FindGroupRequestProtocol)
                    .setFindGroupRequestProtocol(BusinessProtocolMessageStandard.FindGroupRequestProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsListMaintenanceProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsListMaintenanceProtocol)
                    .setFriendsListMaintenanceProtocol(FriendsListMaintenanceProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolEntities.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMemberManagementProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMemberManagementProtocol)
                    .setGroupMemberManagementProtocol(BusinessProtocolMessageStandard.GroupMemberManagementProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.PersonalSettingsProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.PersonalSettingsProtocol)
                    .setPersonalSettingsProtocol(BusinessProtocolMessageStandard.PersonalSettingsProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOfflineMessageProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOfflineMessageProtocol)
                    .setFriendsOfflineMessageProtocol(BusinessProtocolMessageStandard.FriendsOfflineMessageProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsBurnAfterReadingProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsBurnAfterReadingProtocol)
                    .setFriendsBurnAfterReadingProtocol(BusinessProtocolMessageStandard.FriendsBurnAfterReadingProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOnlineStatusProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.FriendsOnlineStatusProtocol)
                    .setFriendsOnlineStatusProtocol(BusinessProtocolMessageStandard.FriendsOnlineStatusProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupAnnouncementManagementProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupAnnouncementManagementProtocol)
                    .setGroupAnnouncementManagementProtocol(BusinessProtocolMessageStandard.GroupAnnouncementManagementProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupBurnAfterReadingProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupBurnAfterReadingProtocol)
                    .setGroupBurnAfterReadingProtocol(BusinessProtocolMessageStandard.GroupBurnAfterReadingProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatSendingMessageProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatSendingMessageProtocol)
                    .setOneVOneChatSendingMessageProtocol(BusinessProtocolMessageStandard.OneVOneChatSendingMessageProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatReceptionProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OneVOneChatReceptionProtocol)
                    .setOneVOneChatReceptionProtocol(BusinessProtocolMessageStandard.OneVOneChatReceptionProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessagingProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessagingProtocol)
                    .setGroupMessagingProtocol(BusinessProtocolMessageStandard.GroupMessagingProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessageReceptionProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.GroupMessageReceptionProtocol)
                    .setGroupMessageReceptionProtocol(BusinessProtocolMessageStandard.GroupMessageReceptionProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol)
                    .setOriginalPictureVideoFriendsTransmissionProtocol(BusinessProtocolMessageStandard.OriginalPictureVideoFriendsTransmissionProtocol.newBuilder()
                            .setTourists(BusinessProtocolMessageStandard.Tourists.newBuilder()
                                    .setTemporaryId("client login module test")
                                    .setIpAddress(ctx.channel().localAddress().toString())
                                    .setMacAddress(ctx.channel().localAddress().toString())
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setMsgId(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_FRIENDS_MSG_ID)
                            .setTimestamp(LocalDateTime.now().getSecond())
                            .build())
                    .build();
        }else if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoGroupTransmissionProtocol){
            unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                    .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoGroupTransmissionProtocol)
                    .setOriginalPictureVideoGroupTransmissionProtocol(BusinessProtocolMessageStandard.OriginalPictureVideoGroupTransmissionProtocol.newBuilder()
                            .setRegisteredUser(BusinessProtocolMessageStandard.RegisteredUser.newBuilder()
                                    .build())
                            .build())
                    .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                            .setStatusReport(ConstantsContent.RESPONSE_CHECK_FAILURE)
                            .build())
                    .build();
        }
        return unifiedEntranceMessage;
    }*/
    /*
    参数的消息类型 SERVICE_MODULE_ACTIVE_REQUEST_MSG_ID
    string msgId = 1;// 消息id  服务类型编码+服务编码+模块编码+功能(动作)编码  10101010
    int32 msgType = 2;// 消息类型   长连接，短连接
    int32 msgContentType = 3;// 消息内容类型
    string fromId = 4;// 消息发送者id
    string toId = 5;// 消息接收者id
    int64 timestamp = 6;// 消息时间戳
    int32 statusReport = 7;// 状态报告   00，01,02（状态报告）
    * */

    /*
    public BusinessProtocolMessageStandard.UnifiedEntranceMessage originalVideoGroupTransmissionRead() throws Exception{
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = null;

        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getTestConfig();
        String fileName = properties.getProperty("file_name");
        System.out.println(fileName);
        //文件读取
        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(fileName,"r");
        FileChannel fileChannel = inputRandomAccessFile.getChannel();
        //做一个内存映射的byteBuffer
        long inputLength = new File(fileName).length();
        MappedByteBuffer inputData = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,inputLength);

        Charset charset = Charset.forName("utf-8");//

        CharsetDecoder decoder = charset.newDecoder(); //字节数组转字符串
        CharsetEncoder encoder = charset.newEncoder(); //字符串转字节数组

        CharBuffer charBuffer = decoder.decode(inputData);
        ByteBuffer outputData = encoder.encode(charBuffer);
        inputRandomAccessFile.close();

        //构建传输结构体
        unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoGroupTransmissionProtocol)
                .setOriginalPictureVideoGroupTransmissionProtocol(BusinessProtocolMessageStandard.OriginalPictureVideoGroupTransmissionProtocol.newBuilder()
                        .setVideo(BusinessProtocolMessageStandard.Video.newBuilder()
                                .setUrl(fileName)
                                .setOriginVideo(ByteString.copyFrom(outputData))
                                .build())
                        .build())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .setMsgId(ConstantsContent.ORIGINAL_PICTURE_VIDEO_TRANSMISSION_GROUP_MSG_ID)
                        .build())
                .build();

        return unifiedEntranceMessage;
    }*/
/*
    public BusinessProtocolMessageStandard.UnifiedEntranceMessage originalPictureFriendsTransmissionRead() throws Exception{
        BusinessProtocolMessageStandard.UnifiedEntranceMessage unifiedEntranceMessage = null;

        ConfigFileOperation configFileOperation = new ConfigFileOperation();
        Properties properties = configFileOperation.getTestConfig();
        String fileName = properties.getProperty("file_name");
        System.out.println(fileName);
        //文件读取
        RandomAccessFile inputRandomAccessFile = new RandomAccessFile(fileName,"r");
        FileChannel fileChannel = inputRandomAccessFile.getChannel();
        //做一个内存映射的byteBuffer
        long inputLength = new File(fileName).length();
        MappedByteBuffer inputData = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,inputLength);

        Charset charset = Charset.forName("utf-8");//

        CharsetDecoder decoder = charset.newDecoder(); //字节数组转字符串
        CharsetEncoder encoder = charset.newEncoder(); //字符串转字节数组

        CharBuffer charBuffer = decoder.decode(inputData);
        ByteBuffer outputData = encoder.encode(charBuffer);
        inputRandomAccessFile.close();

        //构建传输结构体
        unifiedEntranceMessage = BusinessProtocolMessageStandard.UnifiedEntranceMessage.newBuilder()
                .setDataType(BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol)
                .setOriginalPictureVideoFriendsTransmissionProtocol(BusinessProtocolMessageStandard.OriginalPictureVideoFriendsTransmissionProtocol.newBuilder()
                        .setPicture(BusinessProtocolMessageStandard.Picture.newBuilder()
                                .setUrl(fileName)
                                .setOriginPicture(ByteString.copyFrom(outputData))
                                .build())
                        .build())
                .setHead(BusinessProtocolMessageStandard.Head.newBuilder()
                        .build())
                .build();

        return unifiedEntranceMessage;
    }
*/
    public boolean originalVideoGroupTransmissionFileWrite(BusinessProtocolMessageStandard.UnifiedEntranceMessage msg) throws Exception{
      /*  BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = msg.getDataType();
        if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoGroupTransmissionProtocol)
        {
            BusinessProtocolMessageStandard.Video video= msg.getOriginalPictureVideoGroupTransmissionProtocol().getVideo();
            //视频文件保存
            String fileName = video.getUrl();
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            video.getOriginVideo().copyTo(writeBuffer);
            fileName = "E:\\Client_" + fileName;
            RandomAccessFile outputRandomAccessFile = new RandomAccessFile(fileName,"rw");
            FileChannel fileChannel = outputRandomAccessFile.getChannel();
            writeBuffer.flip();
            fileChannel.write(writeBuffer);
            outputRandomAccessFile.close();
        }*/

        return true;
    }

    public boolean originalPictureFriendsTransmissionFileWrite(BusinessProtocolMessageStandard.UnifiedEntranceMessage msg) throws Exception{
       /* BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType dataType = msg.getDataType();
        if (dataType == BusinessProtocolMessageStandard.UnifiedEntranceMessage.DataType.OriginalPictureVideoFriendsTransmissionProtocol)
        {
            BusinessProtocolMessageStandard.Picture picture= msg.getOriginalPictureVideoFriendsTransmissionProtocol().getPicture();
            //图片文件保存
            String fileName = picture.getUrl();
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            picture.getOriginPicture().copyTo(writeBuffer);
            fileName = "E:\\Client_" + fileName;
            RandomAccessFile outputRandomAccessFile = new RandomAccessFile(fileName,"rw");
            FileChannel fileChannel = outputRandomAccessFile.getChannel();
            writeBuffer.flip();
            fileChannel.write(writeBuffer);
            outputRandomAccessFile.close();
        }
*/
        return true;
    }
}
