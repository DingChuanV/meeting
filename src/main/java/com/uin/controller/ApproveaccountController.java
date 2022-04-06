package com.uin.controller;

import com.uin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/4/8:11 PM
 */
@RequestMapping("/admin")
@Controller
public class ApproveaccountController {
    //用户未审批的状态
    public static final int STATUS = 0;
    @Autowired
    EmployeeService employeeService;

    /**
     * 跳转页面
     *
     * @param model
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 8:24 PM
     */
    @RequestMapping("/approveaccount")
    public String approveaccount(Model model) {
        model.addAttribute("emps", employeeService.getAllEmp_status(STATUS));
        return "approveaccount";
    }

    /**
     * 通过审批--更改用户的status
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 8:44 PM
     */
    @RequestMapping("/updateStatus")
    public String updateStatus(Integer employeeid, Integer status) {
        Integer i = employeeService.updateStatus(employeeid, status);
        return "redirect:/admin/approveaccount";
    }
}
