package com.uin.mapper;

import com.uin.pojo.Department;
import com.uin.service.DepartmentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/3/11:36 AM
 */
public class mapperTest {
    @Autowired
    private DepartmentService departmentService;


    @Test
    public void test01(){

        Department depByID = departmentService.getDepByID(1);
        System.out.println(depByID);
    }
}
