package com.lanjiu.im.grpc.server.controller.update;

import com.lanjiu.im.grpc.RpcRegisteredGroupMember;
import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.dao.mapper.impl.GroupMemberNicknameMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredGroupMemberMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredUserFriendMapper;
import com.lanjiu.im.grpc.pojo.GroupMemberNickname;
import com.lanjiu.im.grpc.pojo.RegisteredGroupMember;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.ConstantsDefault;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UpdateRegisteredGroupMemberServiceAPI {

    private static final Logger logger = Logger.getLogger(UpdateRegisteredGroupMemberServiceAPI.class.getName());

    public RegisteredGroupMember updateRegisteredGroupMember(RpcRegisteredGroupMember rpcRegisteredGroupMember){
        SqlSession session = DBTools.getSession();
        int groupMemberId = rpcRegisteredGroupMember.getGroupMemberId();
        if((0 == groupMemberId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_ID_UNDEFAULT_UPDATE);
            return null;
        }
        //其他属性
        Integer registeredUserId = rpcRegisteredGroupMember.getRegisteredUserId();
        if((0 == registeredUserId)){
            logger.info(ConstantsDefault.GROUP_MEMBER_USER_ID_UNDEFAULT);
            return null;
        }
        String groupRemarks = rpcRegisteredGroupMember.getGroupRemarks();
        String groupOwner = rpcRegisteredGroupMember.getGroupOwner();
        if(("".equals(groupOwner))||(null == groupOwner)){
            groupOwner = ConstantsDefault.GROUP_MEMBER_MASTER_NO;
        }
        String burnAfterReadingSettings = rpcRegisteredGroupMember.getBurnAfterReadingSettings();
        if(("".equals(burnAfterReadingSettings))||(null == burnAfterReadingSettings)){
            burnAfterReadingSettings = ConstantsDefault.BURN_AFTER_READING_SETTING_OFF;
        }
        String burnAfterReadingTimeUnit = rpcRegisteredGroupMember.getBurnAfterReadingTimeUnit();
        if(("".equals(burnAfterReadingTimeUnit))||(null == burnAfterReadingTimeUnit)){
            burnAfterReadingTimeUnit = ConstantsDefault.TIME_UNIT_SECOND;
        }
        float length = rpcRegisteredGroupMember.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        Timestamp groupEntryTime = new Timestamp(rpcRegisteredGroupMember.getGroupEntryTime());
        String offlineMessageSetting = rpcRegisteredGroupMember.getOfflineMessageSetting();
        if(("".equals(offlineMessageSetting))||(null == offlineMessageSetting)){
            offlineMessageSetting = ConstantsDefault.OFFLINE_MESSAGE_SETTING_OFF;
        }
        //构建游客群成员对象
        RegisteredGroupMember registeredGroupMember = new RegisteredGroupMember();
        registeredGroupMember.setGroupMemberId(groupMemberId);
        registeredGroupMember.setRegisteredUserId(registeredUserId);
        registeredGroupMember.setGroupOwner(groupOwner);
        registeredGroupMember.setGroupRemarks(groupRemarks);
        registeredGroupMember.setBurnAfterReadingSettings(burnAfterReadingSettings);
        registeredGroupMember.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        registeredGroupMember.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        registeredGroupMember.setGroupEntryTime(groupEntryTime);
        registeredGroupMember.setOfflineMessageSetting(offlineMessageSetting);

        boolean bResult = updateRegisteredGroupMemberService(session, registeredGroupMember);
        if(bResult){
            return registeredGroupMember;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean updateRegisteredGroupMemberService(SqlSession session, RegisteredGroupMember registeredGroupMember){
        RegisteredGroupMemberMapper guestGroupMemberMapper = session.getMapper(RegisteredGroupMemberMapper.class);
        //
        int result = 0;
        try {
//            result = guestGroupMemberMapper.updateRegisteredGroupMember(registeredGroupMember.getGroupMemberId(), registeredGroupMember.getRegisteredUserId(),
//                    registeredGroupMember.getGroupRemarks(), registeredGroupMember.getGroupOwner(),
//                    registeredGroupMember.getBurnAfterReadingSettings(), registeredGroupMember.getBurnAfterReadingTimeUnit(),
//                    registeredGroupMember.getBurnAfterReadingTimeLength(), registeredGroupMember.getGroupEntryTime(), registeredGroupMember.getOfflineMessageSetting());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        System.out.println(result);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }

    public RpcRegisteredGroupMember updateRegtGroupMemberRemark(RpcRegisteredGroupMember registeredGroupMember, RpcRegisteredUserFriend registeredUserFriend){
        SqlSession session = DBTools.getSession();
        int groupId = registeredGroupMember.getGroupId();
        int registeredUserId = registeredUserFriend.getRegisteredUserId();//修改人ID
        int registeredUserId1 = registeredGroupMember.getRegisteredUserId();//被修改人ID
        int groupMemberId = registeredGroupMember.getGroupMemberId();//修改人成员ID
        String nickName = registeredGroupMember.getGroupRemarks();//修改的群备注
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        RegisteredGroupMemberMapper mapper = session.getMapper(RegisteredGroupMemberMapper.class);
        RegisteredUserFriendMapper userFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        try {
            //首先判断两人是否是好友
            RegisteredUserFriend relation = userFriendMapper.getRelationByRegisteredUserIdAndFriendUserId(registeredUserId, registeredUserId1);
            RegisteredUserFriend relation2 = userFriendMapper.getRelationByRegisteredUserIdAndFriendUserId(registeredUserId1, registeredUserId);
            if(null != relation && null != relation2){
                userFriendMapper.updateRegisteredUserFriend(relation.getFriendId(),relation.getRegisteredUserId(),relation.getFriendUserId(),
                        nickName,modificationTime,relation.getOfflineMessageSetting(),relation.getBurnAfterReadingSetting(),relation.getBurnAfterReadingTimeUnit(),
                        relation.getBurnAfterReadingTimeLength(),relation.getFriendNickName());
            }
            RegisteredGroupMember registeredByGroupMember = mapper.getRegisteredByGroupMemberId(groupMemberId);
            String userIdAndNames = registeredByGroupMember.getUserIdAndName();
            String[] users = userIdAndNames.split(",");
            List<String> userList = new ArrayList<>();
            for (String user : users) {
                userList.add(user);
            }
            userList.removeAll(userList);
            List<String> oldList = new ArrayList<>();
            for (String user : users) {
                String[] userIdAndName = user.split("-");
                List<String> list = new ArrayList<>();
                for (String s : userIdAndName) {
                    list.add(s);
                }
                if(String.valueOf(registeredUserId1).equals(list.get(0))){
                    String f = list.get(1);
                    f = nickName;
                    String newUser = list.get(0)+"-"+f;
                    oldList.add(list.get(0)+"-"+list.get(1));
                    userList.add(newUser);
                }else {
                    userList.add(user);
                }
            }
            String newUserIdAndName = "";
            for (String s : userList) {
                newUserIdAndName = s+","+newUserIdAndName;
            }
            mapper.updateRegisteredGroupMember(groupMemberId,registeredByGroupMember.getRegisteredUserId(),newUserIdAndName,registeredByGroupMember.getGroupRemarks(),
                    registeredByGroupMember.getGroupOwner(),registeredByGroupMember.getBurnAfterReadingSettings(),registeredByGroupMember.getBurnAfterReadingTimeUnit(),
                    registeredByGroupMember.getBurnAfterReadingTimeLength(),registeredByGroupMember.getGroupEntryTime(),registeredByGroupMember.getOfflineMessageSetting());

            GroupMemberNicknameMapper groupMemberNicknameMapper = session.getMapper(GroupMemberNicknameMapper.class);
            GroupMemberNickname groupMemberNickname = groupMemberNicknameMapper.selectGroupMemberNickname(groupId, registeredUserId, registeredUserId1);
            if (null == groupMemberNickname){
                groupMemberNickname = new GroupMemberNickname();
                groupMemberNickname.setGroupId(groupId);
                groupMemberNickname.setUserId(registeredUserId);
                groupMemberNickname.setGroupMemberId(registeredUserId1);
                groupMemberNickname.setNickRemark(nickName);
                groupMemberNickname.setCreateTime(registeredByGroupMember.getGroupEntryTime());
                groupMemberNicknameMapper.insert(groupMemberNickname);
            }else {
                groupMemberNickname.setNickRemark(nickName);
                groupMemberNickname.setCreateTime(registeredByGroupMember.getGroupEntryTime());
                groupMemberNicknameMapper.updateByPrimaryKey(groupMemberNickname);
            }
            RpcRegisteredGroupMember rpcRegisteredGroupMember = RpcRegisteredGroupMember.newBuilder()
                            .setGroupMemberId(groupMemberId)
                            .setRegisteredUserId(registeredUserId)
                            .setGroupId(groupId)
                            .build();
            session.commit();
            return rpcRegisteredGroupMember;
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
        return null;
    }
}
