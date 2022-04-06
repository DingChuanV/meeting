package com.uin.service.impl;

import com.uin.mapper.MeetingMapper;
import com.uin.pojo.Meeting;
import com.uin.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/6/2:02 PM
 */
@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingMapper meetingMapper;

    /**
     * 新增预定会议
     *
     * @param meeting
     * @param mps
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/6 2:07 PM
     */
    public Integer addMeeting(Meeting meeting, Integer[] mps) {
        meeting.setReservationtime(new Date());
        Integer result = meetingMapper.addMeeting(meeting);
        meetingMapper.addParticipants(meeting.getMeetingid(), mps);
        return result;
    }

    /**
     * 查询全部会议
     *
     * @return java.util.List<com.uin.pojo.Meeting>
     * @author wanglufei
     * @date 2022/4/6 3:33 PM
     */
    public List<Meeting> getAllMeetings() {
        return meetingMapper.getAllMeetings();
    }
}
