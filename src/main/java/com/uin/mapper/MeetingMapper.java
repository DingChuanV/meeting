package com.uin.mapper;

import com.uin.pojo.Meeting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/6/2:02 PM
 */
public interface MeetingMapper {
    /**
     * 新增会议
     *
     * @param meeting
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/6 2:18 PM
     */
    Integer addMeeting(Meeting meeting);

    /**
     * 会议要参加的员工
     *
     * @param meetingid
     * @param mps
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/6 2:18 PM
     */
    Integer addParticipants(@Param("meetingid") int meetingid, @Param("mps") Integer[] mps);

    /**
     * 查询全部会议
     *
     * @return java.util.List<com.uin.pojo.Meeting>
     * @author wanglufei
     * @date 2022/4/6 3:33 PM
     */
    List<Meeting> getAllMeetings();
}
