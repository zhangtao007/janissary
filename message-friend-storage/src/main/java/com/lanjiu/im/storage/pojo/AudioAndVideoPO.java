package com.lanjiu.im.storage.pojo;

/**
 * @author zha_gtao
 * @data 2020/8/28 12:41
 */
public class AudioAndVideoPO {

    private String server; //音视频服务地址
    private String roomId;
    private String roomPwd;
    private Boolean onlyAudio; //纯音频
    private String fromUserId;
    private String userName;
    private String userAvatar;
    private String toUser;
    private String type; //拨打
    private long time;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomPwd() {
        return roomPwd;
    }

    public void setRoomPwd(String roomPwd) {
        this.roomPwd = roomPwd;
    }

    public Boolean getOnlyAudio() {
        return onlyAudio;
    }

    public void setOnlyAudio(Boolean onlyAudio) {
        this.onlyAudio = onlyAudio;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AudioAndVideoPO{" +
                "server='" + server + '\'' +
                ", roomId='" + roomId + '\'' +
                ", roomPwd='" + roomPwd + '\'' +
                ", onlyAudio=" + onlyAudio +
                ", fromUserId='" + fromUserId + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", toUser='" + toUser + '\'' +
                ", type='" + type + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
