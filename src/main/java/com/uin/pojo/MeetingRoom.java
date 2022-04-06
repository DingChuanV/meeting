package com.uin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanglufei
 * @description: 会议室
 * @date 2022/4/3/3:18 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingRoom {
    private int roomid;
    private int roomnum;
    private String roomname;
    private int capacity;
    private int status;
    private String description;
}
