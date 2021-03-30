package com.lanjiu.im.storage.test;

import com.lanjiu.im.grpc.server.create.StorageFriendMessageAPI;
import com.lanjiu.im.storage.pojo.*;
import com.lanjiu.im.storage.service.MsgFriendOffService;
import com.lanjiu.im.storage.service.MsgFriendOnService;
import com.lanjiu.im.storage.utils.ConstantKind;
import com.lanjiu.pro.friend_msg.NotifyDelMsg;
import com.lanjiu.pro.friend_msg.RequestFriendMessage;


import javax.imageio.stream.FileImageOutputStream;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestMsgFriendOffService {



    public static void main(String[] args) throws ParseException, SQLException, UnsupportedEncodingException {
        MsgFriendOffService msgFriendOffService = new MsgFriendOffService();
        StorageFriendMessageAPI api = new StorageFriendMessageAPI();
//        NotifyDelMsg notify =NotifyDelMsg.newBuilder().setDelfromId(10010261).setDeltoId(10010265).setMsgId("yyyyyyyy").setArgs("23").setTimestap(String.valueOf(System.currentTimeMillis())).build();
//        List<NotifyDelMsg> list = new ArrayList<>();
//        list.add(notify);
//        RequestFriendMessage requestFriendMessage = RequestFriendMessage.newBuilder().setRet(ConstantKind.TIME_CLEAR_ARG).addNotifyDelMsg(notify).build();

//        api.storageFriendMessageOff(requestFriendMessage);
//        List<DelFriendOffMsg> list = msgFriendOffService.getTimeClearLastMsg(10010356);
//        System.out.println(list.get(0).getDelToId());
//        System.out.println(list.get(0).getTimer());
//        msgFriendOffService1.deleteTimeClearMsg(10010356,"1585031690");
//        msgFriendOffService.commit();
//        msgFriendOffService.close();

//        TimeClearMsgPO po = new TimeClearMsgPO();
//        po.setClsFromId(10010260);
//        po.setClsToId(10010262);
//        po.setMsgType(23);
//        po.setMsgUid("agkjhdghigdigdaegh");
//        po.setNewtime(System.currentTimeMillis());
//        int i = msgFriendOffService.insertTimeClearMsg(po);
//        msgFriendOffService.commit();
//        msgFriendOffService.close();
//        System.out.println(i);

//        int j = msgFriendOffService.updateTimeClearMsg(po);
//        msgFriendOffService.commit();
//        msgFriendOffService.close();
//        System.out.println(j);

//        TimeClearMsgPO po = msgFriendOffService.getOneTimeClearLastMsg(10010267, 10010260);
//        System.out.println(po);
//        System.out.println(po.getNewtime());
//        System.out.println(po.getMsgUid());

//        List<TimeClearMsgPO> lists = msgFriendOffService.getTimeClearLastMsg(10010266);
//        for (TimeClearMsgPO po : lists){
//            System.out.println(po.getClsToId());
//            System.out.println(po.getNewtime());
//            System.out.println(po.getMsgUid());
//
//        }
//        msgFriendOffService.commit();
//        msgFriendOffService.close();

//        int i = msgFriendOffService.deleteMsgFriendOffByToId(10010606);
//        System.out.println(i);
//        String str = new String("中还".getBytes("utf-8"));
//        String str ="总共";
//        System.out.println("length:"+str.getBytes("utf-8").length);
//        System.out.println("bytes:"+str.codePointCount(0,str.length()));
//        System.out.println("kb:"+str.codePointCount(0,str.length())/1024);


//        TestMsgFriendOffService.saveImage2DB();
//        TestMsgFriendOffService.readDB2Image();
      /*  List<MsgFriendOffPO> msgFriendOffList = msgFriendOffService.selectMsgFriendOffByToId(521);
        byte[] bytes = msgFriendOffList.get(0).getContent().getBytes();
        String path ="F:\\zc.wav";
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));//打开输入流
            imageOutput.write(bytes, 0, bytes.length);//将byte写入硬盘
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }*/
//        UserStatusNow po = new UserStatusNow();
//        po.setUserId(525);
//        po.setUserStatus("on");
//        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
//        po.setTime(time);
//        int i = msgFriendOffService.onlineUserChangeStatus(po);
//        msgFriendOffService.commit();
//        System.out.println(i);


//        DelFriendOffMsg del= new DelFriendOffMsg();
//        del.setDelFromId(177);
//        del.setDelToId(202);
//        del.setFromId(177);
//        del.setMsgId("safageega132156saf");
//        del.setTimer(new Date().getTime());
//        del.setMsgType(1);
//        DelFriendOffMsg dels= new DelFriendOffMsg();
//        dels.setDelFromId(177);
//        dels.setDelToId(202);
//        dels.setFromId(911);
//        dels.setMsgId("515134164");
//        dels.setTimer(new Date().getTime());
//        dels.setMsgType(1);
//        List<DelFriendOffMsg> delFriendMsgOff = msgFriendOffService.getDelFriendMsgOff(202);
//        System.out.println(delFriendMsgOff.get(0).getTimer());
//        int i = msgFriendOffService.insertDelFriendMsgOff(del);
//
//        int j = msgFriendOffService.insertDelFriendMsgOff(dels);
//        msgFriendOffService.commit();
//        System.out.println(i);
//        System.out.println(j);
//        int list = msgFriendOffService.deleteMsgFriendOff(del.getMsgId());
//        System.out.println(list);
//        int j = msgFriendOffService.deleteDelFriendMsgOff("456");
//        msgFriendOffService.commit();
//        System.out.println(j);

//        for (int i = 0; i <350 ; i++) {
//            MsgFriendOffPO msgPO = new MsgFriendOffPO();
//            msgPO.setMsgId("asffaggaregea2344"+i+"#"+System.currentTimeMillis());
//            msgPO.setMsgType(0);
//            msgPO.setFromId(10010260);
//            msgPO.setToId(88888888);
//            msgPO.setContent("至尊vipvius电费hi凤凰国际欧艾斯东莞交管局水电费"+i);
//            msgPO.setEntityUrl("");
//            msgPO.setCreateTime(System.currentTimeMillis());
//            msgPO.setMessageOfflineStatus(true);
//            msgPO.setBurnAfterReadingLength(0);
//            msgPO.setBurnAfterReadingStatus(true);
//            msgPO.setFromNickname("vip");
//            msgPO.setFromAvatar("D:\\file_server\\avatar\\10010260784326a9416e465c887c584d7b024383.jpg");
//            msgPO.setVideoTime(0);
//            int j = msgFriendOffService.storageMsgFriendOff(msgPO);
//            msgFriendOffService.commit();
//            System.out.println(j);
//        }

//        List<MsgFriendOffPO> list = msgFriendOffService.selectMsgFriendOffByToId(88888888);
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i).getContent());
//        }
//        System.out.println(new Date());
//        int j = msgFriendOffService.deleteMsgFriendOff(1);
//        System.out.println(j);
//        List<MsgFriendOffPO> mlist = msgFriendOffService.selectMsgFriendOffByToId(66559988);
//        msgFriendOffService.commit();
//        System.out.println(mlist.get(0).getVideoTime());
//        System.out.println(mlist.get(0).getFromNickname());

//            int i = msgFriendOffService.deleteMsgFriendOffByFromId(101010222);
//        System.out.println(i);

//        MsgFriendOnService service = new MsgFriendOnService();
//        service.storageMsgFriendOn(msgPO);
//        List<MsgFriendOnPO> list = service.selectMsgFriendOnByToId(911);
//        System.out.println(list);

//        System.out.println(Math.round(Math.random()*1000000));



    }

    public static void saveImage2DB() {
        String sql = "insert into msg_friend_off values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String fileUrl = "E:\\IM\\zz.wav";
        Connection connection = null;
        PreparedStatement pst = null;
        FileInputStream in =null;
        try {
            in = new FileInputStream(new File(fileUrl));
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/janissary_friend_message?characterEncoding=utf8&serverTimezone=Asia/Shanghai","root","123456");
            pst = connection.prepareStatement(sql);
            pst.setString(1, "007");
            pst.setInt(2, 1);
            pst.setInt(3,521);
            pst.setInt(4,521);
            //SerialBlob是Blob的实现类 ;IOUtil是org.apache提供的工具类包
            // SerialBlob serialBlob = new SerialBlob(IOUtils.toByteArray(new FileInputStream(fileUrl)));
            //存储大文本信息使用的方法setBlob
            // pst.setBlob(3, serialBlob);

            byte[] bytes = new byte[in.available()];


            String content = bytes.toString();
            pst.setString(5,content);
            pst.setString(6,"url");
            pst.setDate(7,new Date( 1557728379));
            pst.setBoolean(8,true);
            pst.setBoolean(9,true);
            pst.setInt(10,007);
            pst.setString(11,"nick");
            pst.setString(12,"nick");
//            pst.setBinaryStream(3, in, in.available())
            pst.executeUpdate();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static  void readDB2Image() throws SQLException {
        String targetPath = "F:\\zc.wav";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/janissary_friend_message","root","123456");
        String sql = "select * from msg_friend_off where id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,"007");
        rs =ps.executeQuery();
        FileOutputStream fos = null;
        while (rs.next()){
            try {
                InputStream in = new FileInputStream(rs.getString(5));
                File file = new File(targetPath);
                String  path =  targetPath.substring(0,targetPath.lastIndexOf("/"));
                if(!file.exists()){
                    new File(path).mkdir();
                }

                 fos = new FileOutputStream(file);
                 int len =0;
                 byte[] buf = new byte[1024];
                 while ((len=in.read(buf)) != -1){
                     fos.write(buf,0,len);
                 }
                 fos.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(null!= fos){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }

    public static char  binstrToChar(String binStr){
        int[]  temp = binstrToIntArray(binStr);
        int sum=0;
        for (int i=0;i<temp.length;i++){
            sum += temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }

    private static int[] binstrToIntArray(String binStr) {
        char[] temp = binStr.toCharArray();
        int[] result = new  int[temp.length];
        for (int i=0;i<temp.length;i++){
            result[i] =temp[i]-48;
        }
        return result;

    }

}
