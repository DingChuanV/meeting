package com.uin.controller;

import com.uin.pojo.Employee;
import com.uin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/5/4:46 PM
 */
@Controller
@RequestMapping("/admin")
public class EmployeeController {
    public static final Integer PAGE_SIZE = 10;

    @Autowired
    EmployeeService employeeService;

    /**
     * 获取全部员工 并分页
     *
     * @param employee
     * @param page
     * @param model
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 5:12 PM
     */
    @RequestMapping("/searchemployees")
    public String getAllEmp(Employee employee, @RequestParam(defaultValue = "1",required = false) Integer page,
                            Model model) {
        List<Employee> employees = employeeService.getAllEmp(employee, page, PAGE_SIZE);
        Long total = employeeService.getTotal(employee);
        model.addAttribute("emps", employees);
        //总记录数
        model.addAttribute("total", total);
        //第几页
        model.addAttribute("page", page);
        //每页展示多少员工
        model.addAttribute("pagenum", total % PAGE_SIZE == 0 ? total / PAGE_SIZE :
                total / PAGE_SIZE + 1);
        return "searchemployees";
    }
    @RequestMapping("/updateEmpStatus")
    public String updateEmpStatus(int id){
        Integer integer = employeeService.updateStatus(id,2);
        return "redirect:/admin/searchemployees?status=1";
    }

}
