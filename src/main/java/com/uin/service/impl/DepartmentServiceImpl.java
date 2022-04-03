package com.uin.service.impl;

import com.uin.mapper.DepartmentMapper;
import com.uin.pojo.Department;
import com.uin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/7:37 PM
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDepByID(Integer id) {
        return departmentMapper.getDepByID(id);
    }
}
