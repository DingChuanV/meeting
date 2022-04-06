package com.uin.controller;

import com.uin.pojo.Department;
import com.uin.pojo.Employee;
import com.uin.service.DepartmentService;
import com.uin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/3/2:17 PM
 */
@Controller
public class LoginController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    /**
     * 映射登陆页面
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 11:16 AM
     */
    @RequestMapping("/")
    public String login() {
        return "login";
    }

    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @param model
     * @param session
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 11:16 AM
     */
    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession session) {
        Employee employee = employeeService.doLogin(username, password);
        if (employee == null) {
            model.addAttribute("error", "用户姓名或密码错误！");
            return "forward:/";
        } else {
            if (0 == employee.getStatus()) {
                model.addAttribute("error", "用户待审批！");
                return "forward:/";
            } else if (employee.getStatus() == 2) {
                model.addAttribute("error", "用户审批未通过！");
                return "forward:/";
            } else {
                //登陆成功之后将用户存到http session中去
                session.setAttribute("currentUser", employee);
                return "redirect:/notifications";
            }
        }
    }

    /**
     * 映射注册页面
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 11:16 AM
     */
    @RequestMapping("/register")
    public String register(Model model) {
        List<Department> deps = departmentService.getAllDepId();
        model.addAttribute("deps", deps);
        return "register";
    }

    /**
     * 注册
     * 成功-》回到登陆页面
     * 失败-》属性回填-》继续注册
     *
     * @param employee
     * @param model
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 12:01 PM
     */
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(Employee employee, Model model) {
        int flag = employeeService.doRegister(employee);
        if (flag == 1) {
            return "redirect:/";
        } else {
            model.addAttribute("error", "注册失败,用户已存在");
            //处理属性回填
            model.addAttribute("employee", employee);
            return "forward:register";
        }
    }
}
