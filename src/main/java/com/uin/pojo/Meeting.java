package com.uin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wanglufei
 * @description: 会议
 * @date 2022/4/3/3:12 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meeting {
    private int meetingid;
    private String meetingname;
    private int roomid;
    private int reservationistid;
    private int numberofparticipants;
    private Date starttime;
    private Date endtime;
    private Date reservationtime;
    private Date canceledtime;
    private String description;
    private String status;
}
