package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.RpcGuestUserFriend;
import com.lanjiu.im.grpc.TransmissionRequest;
import com.lanjiu.im.grpc.dao.mapper.impl.*;
import com.lanjiu.im.grpc.pojo.*;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.ConstantsSelectKind;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class DeleteGuestUserFriendServiceAPI {

    private static final Logger logger = Logger.getLogger(DeleteGuestUserFriendServiceAPI.class.getName());

    public GuestUserFriend deleteGuestUserFriend(RpcGuestUserFriend rpcGuestUserFriend, String kind){
        SqlSession session = DBTools.getSession();
        int friendId = rpcGuestUserFriend.getFriendId();
        if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_FRIEND_ID.equals(kind)){
            if(friendId == 0){
                logger.info(ConstantsPrompt.FRIEND_ID_UNDEFAULT_DELETE);
                return null;
            }
        }
        Integer guestUserId = rpcGuestUserFriend.getGuestUserId();
        Integer friendUserId = rpcGuestUserFriend.getFriendUserId();
        String friendComment = rpcGuestUserFriend.getFriendComment();
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String burnAfterReadingSettings = rpcGuestUserFriend.getBurnAfterReadingSetting();
        String burnAfterReadingTimeUnit = rpcGuestUserFriend.getBurnAfterReadingTimeUnit();
        float length = rpcGuestUserFriend.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        String offlineMessageSetting = rpcGuestUserFriend.getOfflineMessageSetting();
        String friendNickName = rpcGuestUserFriend.getFriendNickName();
        GuestUserFriend guestUserFriend = new GuestUserFriend();
        guestUserFriend.setGuestUserId(guestUserId);
        guestUserFriend.setFriendId(friendId);
        guestUserFriend.setFriendUserId(friendUserId);
        guestUserFriend.setFriendComment(friendComment);
        guestUserFriend.setCreationTime(creationTime);
        guestUserFriend.setModificationTime(modificationTime);
        guestUserFriend.setOfflineMessageSetting(offlineMessageSetting);
        guestUserFriend.setBurnAfterReadingSetting(burnAfterReadingSettings);
        guestUserFriend.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
        guestUserFriend.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        guestUserFriend.setFriendNickName(friendNickName);

        boolean bResult = deleteGuestUserFriendService(session, guestUserFriend, kind);
        if(bResult){
            return guestUserFriend;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean deleteGuestUserFriendService(SqlSession session, GuestUserFriend guestUserFriend, String kind){
        GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
        int result = 0;
        List<GuestUserFriend> guestUserFriendList = null;
        try {
            if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_FRIEND_ID.equals(kind)){
                result = deleteGuestUserFriendByFriendIdService(session, guestUserFriend);
            }else if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_FRIEND_USER_ID.equals(kind)){
                guestUserFriendList = guestUserFriendMapper.selectGuestUserFriendByFriendUserId(guestUserFriend.getFriendUserId());
                for (GuestUserFriend guestUserFriend1 : guestUserFriendList){
                    result = deleteGuestUserFriendByFriendIdService(session, guestUserFriend1);
                }
            }else if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_GUEST_USER_ID_AND_FRIEND_USER_ID.equals(kind)){
                guestUserFriendList = guestUserFriendMapper.selectGuestUserFriendByGuestUserIdAndFriendUserId(guestUserFriend.getGuestUserId(), guestUserFriend.getFriendUserId());
                for (GuestUserFriend guestUserFriend1 : guestUserFriendList){
                    result = deleteGuestUserFriendByFriendIdService(session, guestUserFriend1);
                }
            }else if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_GUEST_USER_ID.equals(kind)){
                guestUserFriendList = guestUserFriendMapper.selectGuestUserFriendByGuestUserId(guestUserFriend.getGuestUserId());
                if(null == guestUserFriendList || guestUserFriendList.size()==0){
                    result = 1;
                }
                for (GuestUserFriend guestUserFriend1 : guestUserFriendList){
                    result = deleteGuestUserFriendByFriendIdService(session, guestUserFriend1);
                }
            }
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

    //需要释放Friend id
    public int deleteGuestUserFriendByFriendIdService(SqlSession session, GuestUserFriend guestUserFriend){
        GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
        FriendUsedBeautifulNumberMapper groupUsedBeautifulNumberMapper = session.getMapper(FriendUsedBeautifulNumberMapper.class);
        FriendUnusedBeautifulNumberMapper mapperbFriendUnusedBeautifulNumberMapper = session.getMapper(FriendUnusedBeautifulNumberMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumber = turnIntToObject(guestUserFriend.getFriendId());
        int result = 0;
        try {
            result = guestUserFriendMapper.deleteGuestUserFriendByFriendId(guestUserFriend.getFriendId());
            result = groupUsedBeautifulNumberMapper.deleteFriendUsedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = mapperbFriendUnusedBeautifulNumberMapper.insertFriendUnusedBeautifulNumber(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public BeautifulNumberAuto turnIntToObject(int number){
        BeautifulNumberAuto beautifulNumberAuto = new BeautifulNumberAuto();
        String nConfig = String.valueOf(number);

        String tenMillion = nConfig.substring(0, 1);
        beautifulNumberAuto.setTenMillion(Integer.valueOf(tenMillion));

        String oneMillion = nConfig.substring(1, 2);
        beautifulNumberAuto.setOneMillion(Integer.valueOf(oneMillion));

        String oneHundredThousand = nConfig.substring(2, 3);
        beautifulNumberAuto.setOneHundredThousand(Integer.valueOf(oneHundredThousand));

        String tenThousand = nConfig.substring(3, 4);
        beautifulNumberAuto.setTenThousand(Integer.valueOf(tenThousand));

        String oneThousand = nConfig.substring(4, 5);
        beautifulNumberAuto.setOneThousand(Integer.valueOf(oneThousand));

        String oneHundred = nConfig.substring(5, 6);
        beautifulNumberAuto.setOneHundred(Integer.valueOf(oneHundred));

        String ten = nConfig.substring(6, 7);
        beautifulNumberAuto.setTen(Integer.valueOf(ten));

        String one = nConfig.substring(7, 8);
        beautifulNumberAuto.setOne(Integer.valueOf(one));

        return beautifulNumberAuto;
    }

    public void deleteGuestRelatedAllInfo(TransmissionRequest request){
        SqlSession session = DBTools.getSession();
        int guestUserId = request.getGuestUserFriend().getGuestUserId();
        GuestGroupMapper guestGroupMapper = session.getMapper(GuestGroupMapper.class);
        GuestGroupGuestUserMemberRelationMapper mapper = session.getMapper(GuestGroupGuestUserMemberRelationMapper.class);
        GuestGroupMemberMapper groupMemberMapper = session.getMapper(GuestGroupMemberMapper.class);
        GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
        RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        try {
            //删除游客所有游客群
            guestGroupMapper.deleteGuestGroupByGuestUserId(guestUserId);
            //查询游客所有相关游客群信息
            List<GuestGroupMember> guestGroupMemberList = groupMemberMapper.selectGuestGroupMemberByGuestUserId(guestUserId);
            if(null != guestGroupMemberList && guestGroupMemberList.size()>0){
                for (GuestGroupMember member : guestGroupMemberList) {
                    mapper.deleteGuestGroupUserMemberRelationByGuestUserMemberId(member.getGroupMemberId());
                }
            }
            groupMemberMapper.deleteGuestGroupMemberByGuestUserId(guestUserId);
            guestUserFriendMapper.deleteGuestUserFriendByGuestUserId(guestUserId);
            registeredUserFriendMapper.deleteRegisteredUserFriendByFriendUserId(guestUserId);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }
    }
}
