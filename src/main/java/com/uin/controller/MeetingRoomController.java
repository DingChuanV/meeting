package com.uin.controller;

import com.uin.pojo.MeetingRoom;
import com.uin.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/5/7:27 PM
 */
@Controller
public class MeetingRoomController {
    @Autowired
    MeetingRoomService meetingRoomService;

    /**
     * 查询所有会议房间
     *
     * @param model
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 7:53 PM
     */
    @RequestMapping("/meetingrooms")
    public String getAllMeetingRoom(Model model) {
        List<MeetingRoom> meetingRooms = meetingRoomService.getAllMeetingRoom();
        model.addAttribute("mrs", meetingRooms);
        return "meetingrooms";
    }

    /**
     * 查询房间信息根据id
     *
     * @param roomid
     * @param model
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 8:37 PM
     */
    @RequestMapping("/roomdetails")
    public String roomdetails(int roomid, Model model) {
        MeetingRoom meetingRoom = meetingRoomService.getMeetingRoomById(roomid);
        model.addAttribute("details", meetingRoom);
        return "roomdetails";
    }

    /**
     * 更新房间信息
     *
     * @param meetingRoom
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 8:37 PM
     */
    @RequestMapping("/updateRoom")
    public String updateRoom(MeetingRoom meetingRoom) {
        int result = meetingRoomService.updateRoom(meetingRoom);
        if (result == 1) {
            return "redirect:/meetingrooms";
        }
        return "forward:/roomdetails";
    }

    /**
     * 跳转页面
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 8:37 PM
     */
    @RequestMapping("/admin/addmeetingroom")
    public String addmeetingroom() {
        return "addmeetingroom";
    }

    /**
     * 增加会议室
     *
     * @param meetingRoom
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 8:42 PM
     */
    @RequestMapping("/admin/addRoom")
    public String addRoom(MeetingRoom meetingRoom) {
        int result = meetingRoomService.addRoom(meetingRoom);
        if (result==1){
            return "redirect:/meetingrooms";
        }
        return "forward:/admin/addmeetingroom";
    }
}
