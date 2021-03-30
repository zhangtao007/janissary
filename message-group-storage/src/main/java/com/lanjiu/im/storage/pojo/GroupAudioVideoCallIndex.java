package com.lanjiu.im.storage.pojo;

/**
 * @author zha_gtao
 * @data 2020/8/31 17:42
 */
public class GroupAudioVideoCallIndex {

    private Integer id;
    //群id
    private String groupId;
    //群成员ID
    private String memberId;
    //是否参与音视频通话
    private  Boolean isJoin;
    //音视频消息id
    private Integer gavcId;
    private long time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Boolean getJoin() {
        return isJoin;
    }

    public void setJoin(Boolean join) {
        isJoin = join;
    }

    public Integer getGavcId() {
        return gavcId;
    }

    public void setGavcId(Integer gavcId) {
        this.gavcId = gavcId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "GroupAudioVideoCallIndex{" +
                "id=" + id +
                ", groupId='" + groupId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", isJoin='" + isJoin + '\'' +
                ", gavcId='" + gavcId + '\'' +
                ", time=" + time +
                '}';
    }
}
