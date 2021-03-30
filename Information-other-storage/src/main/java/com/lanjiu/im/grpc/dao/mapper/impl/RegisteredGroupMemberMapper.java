package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.AllGroupMemberVO;
import com.lanjiu.im.grpc.pojo.RegisteredGroupMember;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface RegisteredGroupMemberMapper {
    List<RegisteredGroupMember> selectAllRegisteredGroupMember() throws Exception;
    List<RegisteredGroupMember> selectRegisteredGroupMember(@Param("groupMemberId") int groupMemberId,
                                                         @Param("registeredUserId") int registeredUserId,
                                                         @Param("groupRemarks") String groupRemarks,
                                                         @Param("groupOwner") String groupOwner,
                                                         @Param("burnAfterReadingSettings") String burnAfterReadingSettings,
                                                         @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                                         @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                                         @Param("groupEntryTime") Timestamp groupEntryTime,
                                                         @Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;

    List<RegisteredGroupMember> selectRegisteredGroupMemberByGroupMemberId(@Param("groupMemberId") int groupMemberId) throws Exception;
    List<RegisteredGroupMember> selectRegisteredGroupMemberByGroupMemberIdLike(@Param("groupMemberId") int groupMemberId) throws Exception;
    List<RegisteredGroupMember> selectRegisteredGroupMemberByRegisteredUserId(@Param("registeredUserId") int registeredUserId) throws Exception;
    List<RegisteredGroupMember> selectRegisteredGroupMemberByGroupMemberIdAndRegisteredUserId(@Param("groupMemberId") int groupMemberId, @Param("registeredUserId") int registeredUserId) throws Exception;
    List<RegisteredGroupMember> selectRegisteredGroupMemberByOfflineMessageSetting(@Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;
    List<RegisteredGroupMember> selectRegisteredGroupMemberByBurnAfterReadingSetting(@Param("burnAfterReadingSettings") String burnAfterReadingSettings) throws Exception;
    int insertRegisteredGroupMember(@Param("groupMemberId") int groupMemberId,
                                      @Param("registeredUserId") int registeredUserId,
                                      @Param("userIdAndName") String userIdAndName,
                                      @Param("groupRemarks") String groupRemarks,
                                      @Param("groupOwner") String groupOwner,
                                      @Param("burnAfterReadingSettings") String burnAfterReadingSettings,
                                      @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                      @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                      @Param("groupEntryTime") Timestamp groupEntryTime,
                                      @Param("offlineMessageSetting") String offlineMessageSetting);

    int updateRegisteredGroupMember(@Param("groupMemberId") int groupMemberId,
                                      @Param("registeredUserId") int registeredUserId,
                                      @Param("userIdAndName") String userIdAndName,
                                      @Param("groupRemarks") String groupRemarks,
                                      @Param("groupOwner") String groupOwner,
                                      @Param("burnAfterReadingSettings") String burnAfterReadingSettings,
                                      @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                      @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                      @Param("groupEntryTime") Timestamp groupEntryTime,
                                      @Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;
    int deleteRegisteredGroupMemberByRegisteredUserId(@Param("registeredUserId") int registeredUserId) throws Exception;
    int deleteRegisteredGroupMemberByGroupMemberId(@Param("groupMemberId") int groupMemberId) throws Exception;

    RegisteredGroupMember getRegisteredByGroupMemberId(@Param("groupMemberId") int groupMemberId)throws Exception;

    List<AllGroupMemberVO> selectGroupRegisteredMembers(@Param("groupId")int groupId)throws Exception;

    List<AllGroupMemberVO> queryAllGroupByUserId(@Param("userId")int userId)throws Exception;

    int insertGroupMemberOfBatch(List<RegisteredGroupMember> memberList);
}
