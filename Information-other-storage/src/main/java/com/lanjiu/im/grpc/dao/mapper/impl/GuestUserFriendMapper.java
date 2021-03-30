package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.GuestUserFriend;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface GuestUserFriendMapper {
    List<GuestUserFriend> selectAllGuestUserFriend() throws Exception;

    List<GuestUserFriend> selectGuestUserFriend(@Param("friendId") int friendId,
                                                @Param("guestUserId") int guestUserId,
                                                @Param("friendUserId") int friendUserId,
                                                @Param("friendComment") String friendComment,
                                                @Param("creationTime") Date creationTime,
                                                @Param("modificationTime") Date modificationTime,
                                                @Param("offlineMessageSetting") String offlineMessageSetting,
                                                @Param("burnAfterReadingSetting") String burnAfterReadingSetting,
                                                @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                                @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength, @Param("friendNickName") String friendNickName) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByGuestUserId(@Param("guestUserId") int guestUserId) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByFriendId(@Param("friendId") int friendId) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByFriendIdLike(@Param("friendId") int friendId) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByFriendUserId(@Param("friendUserId") int friendUserId) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByGuestUserIdAndFriendUserId(@Param("guestUserId") int guestUserId, @Param("friendUserId") int friendUserId) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByGuestUserIdAndFriendId(@Param("guestUserId") int guestUserId, @Param("friendId") int friendId) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByOfflineMessageSetting(@Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;

    List<GuestUserFriend> selectGuestUserFriendByBurnAfterReadingSetting(@Param("burnAfterReadingSetting") String burnAfterReadingSetting) throws Exception;

    int insertGuestUserFriend(@Param("guestUserId") int guestUserId,
                              @Param("friendUserId") int friendUserId,
                              @Param("friendComment") String friendComment,
                              @Param("creationTime") Date creationTime,
                              @Param("modificationTime") Date modificationTime,
                              @Param("offlineMessageSetting") String offlineMessageSetting,
                              @Param("burnAfterReadingSetting") String burnAfterReadingSetting,
                              @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                              @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength, @Param("friendNickName") String friendNickName) throws Exception;

    int updateGuestUserFriend(@Param("guestUserId") int guestUserId,
                              @Param("friendId") int friendId,
                              @Param("friendUserId") int friendUserId,
                              @Param("friendComment") String friendComment,
                              @Param("creationTime") Date creationTime,
                              @Param("modificationTime") Date modificationTime,
                              @Param("offlineMessageSetting") String offlineMessageSetting,
                              @Param("burnAfterReadingSetting") String burnAfterReadingSetting,
                              @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                              @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength, @Param("friendNickName") String friendNickName) throws Exception;

    int deleteGuestUserFriendByFriendId(@Param("friendId") int friendId) throws Exception;

    int deleteGuestUserFriendByFriendUserId(@Param("friendUserId") int friendUserId) throws Exception;

    int deleteGuestUserFriendByGuestUserIdAndFriendUserId(@Param("guestUserId") int guestUserId,
                                                          @Param("friendUserId") int friendUserId) throws Exception;

    int deleteGuestUserFriendByGuestUserId(@Param("guestUserId") int guestUserId) throws Exception;
}
