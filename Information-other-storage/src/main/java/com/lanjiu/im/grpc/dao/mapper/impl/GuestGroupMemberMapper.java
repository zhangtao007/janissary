package com.lanjiu.im.grpc.dao.mapper.impl;

import com.lanjiu.im.grpc.pojo.AllGroupMemberVO;
import com.lanjiu.im.grpc.pojo.GuestGroupMember;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface GuestGroupMemberMapper {
    public List<GuestGroupMember> selectAllGuestGroupMember() throws Exception;
    public List<GuestGroupMember> selectGuestGroupMember(@Param("groupMemberId") int groupMemberId,
                                                       @Param("guestUserId") int guestUserId,
                                                       @Param("groupRemarks") String groupRemarks,
                                                       @Param("groupOwner") String groupOwner,
                                                       @Param("burnAfterReadingSettings") String burnAfterReadingSettings,
                                                       @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                                       @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                                       @Param("groupEntryTime") Timestamp groupEntryTime,
                                                       @Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;

    public List<GuestGroupMember> selectGuestGroupMemberByGroupMemberId(@Param("groupMemberId") int groupMemberId) throws Exception;
    public List<GuestGroupMember> selectGuestGroupMemberByGroupMemberIdLike(@Param("groupMemberId") int groupMemberId) throws Exception;
    public List<GuestGroupMember> selectGuestGroupMemberByGuestUserId(@Param("guestUserId") int guestUserId) throws Exception;
    public List<GuestGroupMember> selectGuestGroupMemberByGroupMemberIdAndGuestUserId(@Param("groupMemberId") int groupMemberId, @Param("guestUserId") int guestUserId) throws Exception;
    public List<GuestGroupMember> selectGuestGroupMemberByOfflineMessageSetting(@Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;
    public List<GuestGroupMember> selectGuestGroupMemberByBurnAfterReadingSetting(@Param("burnAfterReadingSettings") String burnAfterReadingSettings) throws Exception;
    public int insertGuestGroupMember(@Param("groupMemberId") int groupMemberId,
                                      @Param("guestUserId") int guestUserId,
                                      @Param("groupRemarks") String groupRemarks,
                                      @Param("groupOwner") String groupOwner,
                                      @Param("burnAfterReadingSettings") String burnAfterReadingSettings,
                                      @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                      @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                      @Param("groupEntryTime") Timestamp groupEntryTime,
                                      @Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;

    public int updateGuestGroupMember(@Param("groupMemberId") int groupMemberId,
                                      @Param("guestUserId") int guestUserId,
                                      @Param("groupRemarks") String groupRemarks,
                                      @Param("groupOwner") String groupOwner,
                                      @Param("burnAfterReadingSettings") String burnAfterReadingSettings,
                                      @Param("burnAfterReadingTimeUnit") String burnAfterReadingTimeUnit,
                                      @Param("burnAfterReadingTimeLength") BigDecimal burnAfterReadingTimeLength,
                                      @Param("groupEntryTime") Timestamp groupEntryTime,
                                      @Param("offlineMessageSetting") String offlineMessageSetting) throws Exception;
    public int deleteGuestGroupMemberByGuestUserId(@Param("guestUserId") int guestUserId) throws Exception;
    public int deleteGuestGroupMemberByGroupMemberId(@Param("groupMemberId") int groupMemberId) throws Exception;

    GuestGroupMember getGuestByGroupMemberId(@Param("groupMemberId") int groupMemberId) throws Exception;

    List<AllGroupMemberVO> selectGroupTouristMembers(@Param("groupId")int groupId)throws Exception;

}
