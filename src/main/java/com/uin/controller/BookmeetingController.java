package com.uin.controller;

import com.uin.pojo.Department;
import com.uin.pojo.Employee;
import com.uin.pojo.Meeting;
import com.uin.service.DepartmentService;
import com.uin.service.EmployeeService;
import com.uin.service.MeetingRoomService;
import com.uin.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/5/9:00 PM
 */
@Controller
public class BookmeetingController {
    @Autowired
    MeetingRoomService meetingRoomService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MeetingService meetingService;



    /**
     * 跳转页面
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/6 3:21 PM
     */
    @RequestMapping("/mybookings")
    public String mybookings() {
        return "mybookings";
    }

    @RequestMapping("/mymeetings")
    public String mymeetings() {
        return "mymeetings";
    }

    /**
     * 查询会议室
     *
     * @param model
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 9:09 PM
     */
    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model) {
        model.addAttribute("mrs", meetingRoomService.getAllMeetingRoom());
        return "bookmeeting";
    }

    /**
     * 主要是用来返回json数据
     *
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/5 9:13 PM
     */
    @RequestMapping("/getAllDeps")
    @ResponseBody
    public List<Department> getAllDeps() {
        List<Department> allDeps = departmentService.getAllDeps();
        return allDeps;
    }

    /**
     * 根据部门id查询员工 返回json数据
     *
     * @param depId
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/6 1:25 PM
     */
    @RequestMapping("/getAllEmpById")
    @ResponseBody
    public List<Employee> getAllEmpById(int depId) {
        return employeeService.getAllEmpById(depId);
    }

    /**
     * 预定会议
     *
     * @param meeting 会议
     * @param mps     参加会议的员工
     * @param session
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/6 1:59 PM
     */
    @RequestMapping("/doAddMeeting")
    public String addMeeting(Meeting meeting, Integer[] mps, HttpSession session) {
        Employee currentUser = (Employee) session.getAttribute("currentUser");
        //会议发起人
        meeting.setReservationistid(currentUser.getEmployeeid());
        Integer result = meetingService.addMeeting(meeting, mps);
        if (result == 1) {
            return "redirect:/searchmeetings";
        } else {
            return "forward:/bookmeeting";
        }
    }

    /**
     * 跳转页面
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/6 2:06 PM
     */
    @RequestMapping("/searchmeetings")
    public String searchmeetings(Model model) {
        model.addAttribute("meetings",meetingService.getAllMeetings());
        return "searchmeetings";
    }
    /**
     * 根据会议的id查询员工
     * @author wanglufei
     * @date 2022/4/6 3:48 PM
     * @param meetingid
     * @param model
     * @return java.lang.String
     */
//    @RequestMapping("/meetingdetails")
//    public String meetingdetails(int meetingid,Model model){
//       Employee employee= meetingService.getMeetingById(meetingid);
//       model.addAttribute("meeting_details",meeting);
//       return "meetingdetails";
//    }


}
