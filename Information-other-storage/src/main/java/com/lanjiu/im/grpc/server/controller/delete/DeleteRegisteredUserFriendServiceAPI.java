package com.lanjiu.im.grpc.server.controller.delete;

import com.lanjiu.im.grpc.RpcRegisteredUserFriend;
import com.lanjiu.im.grpc.dao.mapper.impl.FriendUnusedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.FriendUsedBeautifulNumberRealMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.GuestUserFriendMapper;
import com.lanjiu.im.grpc.dao.mapper.impl.RegisteredUserFriendMapper;
import com.lanjiu.im.grpc.pojo.BeautifulNumberAuto;
import com.lanjiu.im.grpc.pojo.GuestUserFriend;
import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import com.lanjiu.im.grpc.util.ConstantsPrompt;
import com.lanjiu.im.grpc.util.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class DeleteRegisteredUserFriendServiceAPI {

    private static final Logger logger = Logger.getLogger(DeleteRegisteredUserFriendServiceAPI.class.getName());

    public RegisteredUserFriend deleteRegisteredUserFriend(RpcRegisteredUserFriend rpcRegisteredUserFriend){
        SqlSession session = DBTools.getSession();
//        int friendId = rpcRegisteredUserFriend.getFriendId();
//        if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_FRIEND_ID.equals(friendId)){
//            if(friendId == 0){
//                logger.info(ConstantsPrompt.FRIEND_ID_UNDEFAULT_DELETE);
//                return null;
//            }
//        }
        String friendComment = rpcRegisteredUserFriend.getFriendComment();
        Timestamp creationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        Timestamp modificationTime = Timestamp.valueOf(LocalDateTime.now().withNano(0));
        String burnAfterReadingSettings = rpcRegisteredUserFriend.getBurnAfterReadingSetting();
        String burnAfterReadingTimeUnit = rpcRegisteredUserFriend.getBurnAfterReadingTimeUnit();
        float length = rpcRegisteredUserFriend.getBurnAfterReadingTimeLength();
        BigDecimal burnAfterReadingTimeLength = new BigDecimal(length);
        String offlineMessageSetting = rpcRegisteredUserFriend.getOfflineMessageSetting();
        String friendNickName = rpcRegisteredUserFriend.getFriendNickName();
        RegisteredUserFriend registeredUserFriend = new RegisteredUserFriend();
        registeredUserFriend.setRegisteredUserId(rpcRegisteredUserFriend.getRegisteredUserId());
//        registeredUserFriend.setFriendId(friendId);
        registeredUserFriend.setFriendUserId(rpcRegisteredUserFriend.getFriendUserId());
//        registeredUserFriend.setFriendComment(friendComment);
        registeredUserFriend.setCreationTime(creationTime);
        registeredUserFriend.setModificationTime(modificationTime);
//        registeredUserFriend.setOfflineMessageSetting(offlineMessageSetting);
//        registeredUserFriend.setBurnAfterReadingSetting(burnAfterReadingSettings);
//        registeredUserFriend.setBurnAfterReadingTimeUnit(burnAfterReadingTimeUnit);
//        registeredUserFriend.setBurnAfterReadingTimeLength(burnAfterReadingTimeLength);
        registeredUserFriend.setFriendNickName(friendNickName);

        boolean bResult = deleteRegisteredUserFriendService(session, rpcRegisteredUserFriend);
        if(bResult){
            return registeredUserFriend;
        }else {
            logger.info(ConstantsPrompt.BEAUTIFUL_NUMBER_TYPE_DATABASE_LINK_EXCEPTION);
        }
        return null;
    }

    public boolean deleteRegisteredUserFriendService(SqlSession session, RpcRegisteredUserFriend rpcRegisteredUserFriend){
        int result = 0;
        try {
            Integer registeredUserId = rpcRegisteredUserFriend.getRegisteredUserId();
            Integer friendUserId = rpcRegisteredUserFriend.getFriendUserId();
            RegisteredUserFriendMapper registeredUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
            GuestUserFriendMapper guestUserFriendMapper = session.getMapper(GuestUserFriendMapper.class);
            List<RegisteredUserFriend> registeredUserFriends = registeredUserFriendMapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(registeredUserId, friendUserId);
            List<RegisteredUserFriend> registeredUserFriends1 = registeredUserFriendMapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(friendUserId, registeredUserId);
            List<GuestUserFriend> guestUserFriends = guestUserFriendMapper.selectGuestUserFriendByGuestUserIdAndFriendUserId(friendUserId, registeredUserId);
            List<GuestUserFriend> guestUserFriends1 = guestUserFriendMapper.selectGuestUserFriendByGuestUserIdAndFriendUserId(registeredUserId,friendUserId);

//            List<RegisteredUserFriend> guestUserFriendList = null;
            if((null != registeredUserFriends && registeredUserFriends.size()>0) && (null != registeredUserFriends1 && registeredUserFriends1.size()>0)){
                result = registeredUserFriendMapper.deleteRegisteredUserFriendByRegisteredUserIdAndFriendUserId(registeredUserId, friendUserId);
                result = registeredUserFriendMapper.deleteRegisteredUserFriendByRegisteredUserIdAndFriendUserId(friendUserId,registeredUserId);
            }

            if((null != registeredUserFriends && registeredUserFriends.size()>0) && (null != guestUserFriends && guestUserFriends.size()>0)){
                result = registeredUserFriendMapper.deleteRegisteredUserFriendByRegisteredUserIdAndFriendUserId(registeredUserId, friendUserId);
                result = guestUserFriendMapper.deleteGuestUserFriendByGuestUserIdAndFriendUserId(friendUserId,registeredUserId);
            }

            if((null != guestUserFriends && guestUserFriends.size()>0) && (null != guestUserFriends1 && guestUserFriends1.size()>0)){
                result = guestUserFriendMapper.deleteGuestUserFriendByGuestUserIdAndFriendUserId(friendUserId,registeredUserId);
                result = guestUserFriendMapper.deleteGuestUserFriendByGuestUserIdAndFriendUserId(registeredUserId,friendUserId);
            }
//                if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_FRIEND_ID.equals(kind)){
//                    result = deleteRegisteredUserFriendByFriendIdService(session, guestUserFriend);
//                }else if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_FRIEND_USER_ID.equals(kind)){
//                    guestUserFriendList = guestUserFriendMapper.selectRegisteredUserFriendByFriendUserId(guestUserFriend.getFriendUserId());
//                    for (RegisteredUserFriend guestUserFriend1 : guestUserFriendList){
//                        result = deleteRegisteredUserFriendByFriendIdService(session, guestUserFriend1);
//                    }
//                }else if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_REGISTERED_USER_ID_AND_FRIEND_USER_ID.equals(kind)){
//                    guestUserFriendList = guestUserFriendMapper.selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(guestUserFriend.getRegisteredUserId(), guestUserFriend.getFriendUserId());
//                    for (RegisteredUserFriend guestUserFriend1 : guestUserFriendList){
//                        result = deleteRegisteredUserFriendByFriendIdService(session, guestUserFriend1);
//                    }
//                }else if(ConstantsSelectKind.FRIEND_DELETE_TYPE_BY_REGISTERED_USER_ID.equals(kind)){
//                    guestUserFriendList = guestUserFriendMapper.selectRegisteredUserFriendByRegisteredUserId(guestUserFriend.getRegisteredUserId());
//                    for (RegisteredUserFriend guestUserFriend1 : guestUserFriendList){
//                        result = deleteRegisteredUserFriendByFriendIdService(session, guestUserFriend1);
//                    }
//                }
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }

    //需要释放Friend id
    public int deleteRegisteredUserFriendByFriendIdService(SqlSession session, RegisteredUserFriend guestUserFriend){
        FriendUsedBeautifulNumberRealMapper groupUsedBeautifulNumberMapper = session.getMapper(FriendUsedBeautifulNumberRealMapper.class);
        FriendUnusedBeautifulNumberRealMapper mapperbFriendUnusedBeautifulNumberMapper = session.getMapper(FriendUnusedBeautifulNumberRealMapper.class);
        RegisteredUserFriendMapper guestUserFriendMapper = session.getMapper(RegisteredUserFriendMapper.class);
        BeautifulNumberAuto friendUnusedBeautifulNumber = turnIntToObject(guestUserFriend.getFriendId());
        int result = 0;
        try {
            result = guestUserFriendMapper.deleteRegisteredUserFriendByFriendId(guestUserFriend.getFriendId());
            result = groupUsedBeautifulNumberMapper.deleteFriendUsedBeautifulNumberReal(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
                    friendUnusedBeautifulNumber.getOneHundredThousand(), friendUnusedBeautifulNumber.getTenThousand(),
                    friendUnusedBeautifulNumber.getOneThousand(), friendUnusedBeautifulNumber.getOneHundred(),
                    friendUnusedBeautifulNumber.getTen(), friendUnusedBeautifulNumber.getOne());
            result = mapperbFriendUnusedBeautifulNumberMapper.insertFriendUnusedBeautifulNumberReal(friendUnusedBeautifulNumber.getTenMillion(), friendUnusedBeautifulNumber.getOneMillion(),
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
}
