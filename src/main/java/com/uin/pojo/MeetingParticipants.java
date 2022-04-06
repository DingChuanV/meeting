package com.uin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanglufei
 * @description: 参会人员
 * @date 2022/4/3/3:17 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingParticipants {
    private int meetingid;
    private int employeeid;
}
