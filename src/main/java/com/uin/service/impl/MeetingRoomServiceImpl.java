package com.uin.service.impl;

import com.uin.mapper.MeetingRoomMapper;
import com.uin.pojo.MeetingRoom;
import com.uin.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/5/7:31 PM
 */
@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    /**
     * 获取所有会议房间
     *
     * @return java.util.List<com.uin.pojo.MeetingRoom>
     * @author wanglufei
     * @date 2022/4/5 7:42 PM
     */
    public List<MeetingRoom> getAllMeetingRoom() {
        return meetingRoomMapper.getAllMeetingRoom();
    }

    public MeetingRoom getMeetingRoomById(int roomid) {
        return meetingRoomMapper.getMeetingRoomById(roomid);
    }

    /**
     * 更新房间信息
     *
     * @param meetingRoom
     * @return int
     * @author wanglufei
     * @date 2022/4/5 8:22 PM
     */
    public int updateRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateRoom(meetingRoom);
    }

    /**
     * 新增会议室
     *
     * @param meetingRoom
     * @return int
     * @author wanglufei
     * @date 2022/4/5 8:45 PM
     */
    public int addRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.addRoom(meetingRoom);
    }
}
