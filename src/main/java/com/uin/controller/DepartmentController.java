package com.uin.controller;

import com.uin.pojo.Department;
import com.uin.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/7:37 PM
 */
@RestController
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @GetMapping("/dep/{id}")
    public void getDepByID(@PathVariable("id") Integer id) {
        Department depByID = departmentService.getDepByID(id);
        System.out.println(depByID);
    }

}
