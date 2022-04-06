package com.uin.service;

import com.uin.pojo.MeetingRoom;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/5/7:30 PM
 */
public interface MeetingRoomService {
    /**
     * 查询所有会议房间
     *
     * @return java.util.List<com.uin.pojo.MeetingRoom>
     * @author wanglufei
     * @date 2022/4/5 7:33 PM
     */
    List<MeetingRoom> getAllMeetingRoom();

    /**
     * 根据id查询房间
     *
     * @param roomid
     * @return com.uin.pojo.MeetingRoom
     * @author wanglufei
     * @date 2022/4/5 7:55 PM
     */
    MeetingRoom getMeetingRoomById(int roomid);

    /**
     * 更新房间信息
     *
     * @param roomid
     * @return int
     * @author wanglufei
     * @date 2022/4/5 8:20 PM
     */
    int updateRoom(MeetingRoom roomid);

    /**
     * 新增会议室
     *
     * @param meetingRoom
     * @return int
     * @author wanglufei
     * @date 2022/4/5 8:44 PM
     */
    int addRoom(MeetingRoom meetingRoom);
}
