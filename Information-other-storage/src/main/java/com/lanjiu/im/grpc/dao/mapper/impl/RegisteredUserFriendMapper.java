package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.RegisteredUserFriend;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface RegisteredUserFriendMapper {
    List<RegisteredUserFriend> selectAllRegisteredUserFriend() throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriend(@Param("friendId") int friendId,
                                                          @Param("registeredUserId") int registeredUserId,
                                                          @Param("friendUserId") int friendUserId,
                                                          @Param("friendComment") String friendComment,
                                                          @Param("creationTime") Timestamp creationTime,
                                                          @Param("modificationTime") Timestamp modificationTime,
                                                          @Param("offlineMessageSetting") String offlineMessageSetting,
                                                          @Param("burnAfterReadingSetting") String burnAfterReadingSetting,
                                                          @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                                          @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                                          @Param("friendNickName") String friendNickName) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByRegisteredUserId(@Param("registeredUserId") int registeredUserId) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByFriendId(@Param("friendId") int friendId) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByFriendIdLike(@Param("friendId") int friendId) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByFriendUserId(@Param("friendUserId") int friendUserId) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByRegisteredUserIdAndFriendUserId(@Param("registeredUserId") int registeredUserId, @Param("friendUserId") int friendUserId) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByRegisteredUserIdAndFriendId(@Param("registeredUserId") int registeredUserId, @Param("friendId") int friendId) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByOfflineMessageSetting(@Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;

    List<RegisteredUserFriend> selectRegisteredUserFriendByBurnAfterReadingSetting(@Param("burnAfterReadingSetting") String burnAfterReadingSetting) throws Exception;

    int insertRegisteredUserFriend(@Param("registeredUserId") int registeredUserId,
                                   @Param("friendUserId") int friendUserId,
                                   @Param("friendComment") String friendComment,
                                   @Param("creationTime") Timestamp creationTime,
                                   @Param("modificationTime") Timestamp modificationTime,
                                   @Param("offlineMessageSetting") String offlineMessageSetting,
                                   @Param("burnAfterReadingSetting") String burnAfterReadingSetting,
                                   @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                   @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                   @Param("friendNickName") String friendNickName) throws Exception;

    int updateRegisteredUserFriend(@Param("friendId") int friendId,
                                   @Param("registeredUserId") int registeredUserId,
                                   @Param("friendUserId") int friendUserId,
                                   @Param("friendComment") String friendComment,
                                   @Param("modificationTime") Timestamp modificationTime,
                                   @Param("offlineMessageSetting") String offlineMessageSetting,
                                   @Param("burnAfterReadingSetting") String burnAfterReadingSetting,
                                   @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                   @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                   @Param("friendNickName") String friendNickName) throws Exception;

    int updateRegisteredUserFriendByRidAndFid(@Param("registeredUserId") int registeredUserId,
                                   @Param("friendUserId") int friendUserId,
                                   @Param("friendComment") String friendComment,
                                   @Param("modificationTime") Timestamp modificationTime,
                                   @Param("offlineMessageSetting") String offlineMessageSetting,
                                   @Param("burnAfterReadingSetting") String burnAfterReadingSetting,
                                   @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                   @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                   @Param("friendNickName") String friendNickName) throws Exception;

    int deleteRegisteredUserFriendByFriendId(@Param("friendId") int friendId) throws Exception;

    int deleteRegisteredUserFriendByRegisteredUserId(@Param("registeredUserId") int registeredUserId) throws Exception;

    int deleteRegisteredUserFriendByFriendUserId(@Param("friendUserId") int friendUserId) throws Exception;

    int deleteRegisteredUserFriendByRegisteredUserIdAndFriendUserId(@Param("registeredUserId") int registeredUserId,
                                                                    @Param("friendUserId") int friendUserId) throws Exception;

    RegisteredUserFriend getRelationByRegisteredUserIdAndFriendUserId(@Param("registeredUserId") int registeredUserId, @Param("friendUserId") int friendUserId) throws Exception;


    int updateFriendAlias(@Param("registeredUserId") Integer registeredUserId,
                          @Param("friendUserId") Integer friendUserId,
                          @Param("friendComment") String friendComment,
                          @Param("modificationTime") Timestamp modificationTime);

    int updateFriendOfflineSet(@Param("registeredUserId") Integer registeredUserId,
                               @Param("friendUserId") Integer friendUserId,
                               @Param("modificationTime") Timestamp modificationTime,
                               @Param("offlineMessageSetting") String offlineMessageSetting);
}
