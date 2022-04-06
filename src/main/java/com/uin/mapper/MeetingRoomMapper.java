package com.uin.mapper;

import com.uin.pojo.MeetingRoom;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/5/7:34 PM
 */
public interface MeetingRoomMapper {
    /**
     * 获取所有会议房间
     *
     * @return java.util.List<com.uin.pojo.MeetingRoom>
     * @author wanglufei
     * @date 2022/4/5 7:37 PM
     */
    List<MeetingRoom> getAllMeetingRoom();

    /**
     * 根据id查询
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
     * @param meetingRoom
     * @return int
     * @author wanglufei
     * @date 2022/4/5 8:23 PM
     */
    int updateRoom(MeetingRoom meetingRoom);

    /**
     * 新增会议室
     *
     * @param meetingRoom
     * @return int
     * @author wanglufei
     * @date 2022/4/5 8:45 PM
     */
    int addRoom(MeetingRoom meetingRoom);
}
