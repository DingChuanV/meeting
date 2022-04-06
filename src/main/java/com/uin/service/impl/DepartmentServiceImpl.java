package com.uin.service.impl;

import com.uin.mapper.DepartmentMapper;
import com.uin.pojo.Department;
import com.uin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/7:37 PM
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 根据id获取部门信息
     *
     * @param id
     * @return com.uin.pojo.Department
     * @author wanglufei
     * @date 2022/4/4 9:30 PM
     */
    public Department getDepByID(Integer id) {
        return departmentMapper.getDepByID(id);
    }

    /**
     * 获取部门信息
     *
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/4 9:30 PM
     */
    public List<Department> getAllDepId() {
        return departmentMapper.getAllDepId();
    }

    /**
     * 获取所有部门信息
     *
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/4 9:31 PM
     */
    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    /**
     * 增加部门
     *
     * @param departmentname
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/4 9:43 PM
     */
    public Integer addDepartment(String departmentname) {
        //通过用户输入的部门名称去数据库查询，是否有重复的
        Department depByUsername = departmentMapper.getDepByUsername(departmentname);
        if (depByUsername != null) {//意识就是数据库中存在
            return -1;
        } else {
            return departmentMapper.addDepartment(departmentname);
        }
    }

    /**
     * 删除部门
     *
     * @param departmentid
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/5 12:13 AM
     */
    public Integer deleteDep(Integer departmentid) {
        return departmentMapper.deleteDep(departmentid);
    }

    /**
     * 编辑部门
     *
     * @param name
     * @param id
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/5 12:20 AM
     */
    public Integer updateDep(Integer id, String name) {
        return departmentMapper.updateDep(id, name);
    }
}
