package com.uin.service;

import com.uin.pojo.Meeting;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/6/2:02 PM
 */
public interface MeetingService {
    /**
     * 新增预定会议
     *
     * @param meeting
     * @param mps
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/6 2:06 PM
     */
    Integer addMeeting(Meeting meeting, Integer[] mps);

    /**
     * 查询全部会议
     *
     * @return java.util.List<com.uin.pojo.Meeting>
     * @author wanglufei
     * @date 2022/4/6 3:32 PM
     */
    List<Meeting> getAllMeetings();
}
