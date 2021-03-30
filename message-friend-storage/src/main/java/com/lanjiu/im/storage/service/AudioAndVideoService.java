package com.lanjiu.im.storage.service;

import com.lanjiu.im.storage.dao.AudioAndVideoMapper;
import com.lanjiu.im.storage.pojo.AudioAndVideoPO;
import com.lanjiu.im.storage.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zha_gtao
 * @data 2020/8/28 12:38
 */
public class AudioAndVideoService {

    public static final Logger logger = LoggerFactory.getLogger(AudioAndVideoService.class);

    private SqlSession session;
    private AudioAndVideoMapper mapper;

    public AudioAndVideoService(){
        session = DBTools.getSession();
        mapper = session.getMapper(AudioAndVideoMapper.class);
    }

    public void close(){
        session.close();
    }
    public void commit(){session.commit();}
    public void rollback() {session.rollback();}


    public int storageVideoMessage(AudioAndVideoPO po) {
        int row = 0;
        try {
            row = mapper.insertVideoMessage(po);
        } catch (Exception e) {
            logger.error("插入音视频消息时失败",e);
        }
        return row;
    }

    public List<AudioAndVideoPO> selectAudioAndVideoMessage(String to_user) {
        List<AudioAndVideoPO>  list = new ArrayList<>();
        try {
            list = mapper.selectAudioAndVideoMessage(to_user);
        } catch (Exception e) {
            logger.error("查询音视频离线消息时失败",e);
        }
        return list;
    }

    public int removeAudioAndVideoMessge(String receiveUser, String roomId) {
        int i=0;
        try {
            i = mapper.removeAudioAndVideo(receiveUser,roomId);
        } catch (Exception e) {
           logger.error("删除推送后的消息",e);
        }
        return i;
    }

    public int closeRoomByRoomId(String roomId) {
        int i=0;
        try {
            i = mapper.closeRoomByRoomId(roomId);
        } catch (Exception e) {
            logger.error("房间关闭后的清除消息",e);
        }
        return i;
    }

    public static void main(String[] args) {
        AudioAndVideoService  service = new AudioAndVideoService();
        AudioAndVideoPO  po = new AudioAndVideoPO();
        po.setServer("http://");
        po.setRoomId("123333room");
        po.setFromUserId("10010781");
        po.setUserName("aibiying");
        po.setUserAvatar("//:ssafafaf.com");
        po.setOnlyAudio(false);
        po.setToUser("10010891");
        po.setType("create");
        po.setTime(1495028384);
//        int res = service.storageVideoMessage(po);
//        List<AudioAndVideoPO> list = service.selectAudioAndVideoMessage("10010891");
//        int i = service.removeAudioAndVideoMessge("10010891", "123456room");
        service.commit();
        service.close();

    }



}
