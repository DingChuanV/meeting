package com.uin.controller;

import com.uin.pojo.Department;
import com.uin.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.WebParam;


/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/7:37 PM
 */
@Controller
@RequestMapping("/admin")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 根据ID查询部门-测试
     *
     * @param
     * @author wanglufei
     * @date 2022/4/4 12:43 PM
     */
    @GetMapping("/dep/{id}")
    public void getDepByID(@PathVariable("id") Integer id) {
        Department depByID = departmentService.getDepByID(id);
        System.out.println(depByID);
    }

    /**
     * 跳转页面
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 8:23 PM
     */
    @RequestMapping("/departments")
    public String departments(Model model) {
        //展示数据
        model.addAttribute("deps", departmentService.getAllDeps());
        return "departments";
    }

    /**
     * 增加部门，并做了重复判断
     *
     * @param departmentname
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 9:42 PM
     */
    @RequestMapping("/addDepartment")
    public String addDepartment(String departmentname, Model model) {
        Integer integer = departmentService.addDepartment(departmentname);
        if (integer == -1) {
            model.addAttribute("error", "该部门已存在");
            return "forward:/admin/departments";
        }
        return "redirect:/admin/departments";
    }

    /**
     * 删除部门
     *
     * @param departmentid
     * @param model
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 12:11 AM
     */
    @RequestMapping("/deleteDep")
    public String deleteDep(Integer departmentid, Model model) {
        Integer flag = departmentService.deleteDep(departmentid);
        if (flag == 1) {
            model.addAttribute("message", "删除部门成功");
            return "redirect:/admin/departments";
        }
        return "redirect:/admin/departments";
    }

    /**
     * 编辑部门
     *
     * @param id
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/5 12:18 AM
     */
    @RequestMapping("/updateDep")
    @ResponseBody
    public String updateDep(Integer id, String name) {
        Integer integer = departmentService.updateDep(id, name);
        if (integer == 1) {
            return "success";
        }
        return "error";
    }

}
