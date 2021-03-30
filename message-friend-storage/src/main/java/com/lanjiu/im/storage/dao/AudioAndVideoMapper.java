package com.lanjiu.im.storage.dao;

import com.lanjiu.im.storage.pojo.AudioAndVideoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zha_gtao
 * @data 2020/8/28 12:39
 */
public interface AudioAndVideoMapper {
    int insertVideoMessage(AudioAndVideoPO po);

    List<AudioAndVideoPO> selectAudioAndVideoMessage(@Param("to_user") String to_user);

    int removeAudioAndVideo(@Param("receiveUser") String receiveUser, @Param("roomId") String roomId);

    int closeRoomByRoomId(@Param("roomId") String roomId);
}
