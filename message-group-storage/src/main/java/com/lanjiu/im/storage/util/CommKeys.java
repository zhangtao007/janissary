package com.lanjiu.im.storage.util;

import com.google.gson.Gson;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommKeys {

   public static Charset ISO_CHARSET = Charset.forName("ISO-8859-1");

   public static final String TOURISTS_USER_IDENTIFY = "7、8、9";

   public static final String SEARCH_USER = "SEARCH_USER";

   public static final String RESULT_SUCCESS_MSG = "执行成功";

   public static final String RESULT_FAIL_MSG = "执行失败";

   public static final String REGISTERED_USER = "100";

   public static final String TOURISTS_USER = "101";

   //音视频通话消息类型
   public static final String AVC_SAVE = "AVC_SAVE";
   public static final String AVC_SAVE_TO_OFF_USER ="AVC_SAVE_TO_OFF_USER";
   public static final String AVC_PUSH = "AVC_PUSH";
   public static final String AVC_DEL ="AVC_DEL";
   public static final String ROOM_CLOSED ="close"; //房间关闭
   public static final String ROOM_JOIN ="join";
   public static final String ROOM_LEAVE ="leave";
   public static final String ROOM_UNANSWERED ="unanswered";
   public static final String ROOM_INVITE ="invite";



   //0：内容为文本
   public static final int TEXT = 0;

   //1：内容为图片
   public static final int PICTURE = 1;

   //2：内容为视频
   public static final int VIDEO = 2;

   //3：内容为语音
   public static final int VOICE = 3;

   //4：内容为文件
   public static final int FILE = 4;

   //5：创建群
   public static final int CREATE = 42;

   //6：邀请入群（无同意、拒绝）
   public static final int INVITE_IN = 6;

   //10：申请入群
   public static final int REQ_JOIN_IN = 10;

   //8：申请拒绝
   public static final int REQ_REFUSE = 12;

   //9：申请同意
   public static final int REQ_CONSENT = 43;

   //10：群主踢出成员
   public static final int KICK_OUT = 44;

   //11: 退出群组
   public static final int EXIT_GROUP = 45;

   //12: 解散群组
   public static final int DISSOLVE_GROUP = 46;

   //47: 撤回消息
   public static final int DEL_GROUP_MSG = 47;

   // 定期清理用户发送的消息
   public static final List<Integer> REGULAR_CLEAR = new ArrayList<Integer>(5){
      {
         this.add(0);
         this.add(1);
         this.add(2);
         this.add(3);
         this.add(4);
      }
   };

   private static Gson gson = new Gson();

   public static String toJson(Object object){
      return gson.toJson(object);
   }

   private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   public static String getTime() {
      return df.format(new Date());
   }
}
