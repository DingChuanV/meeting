package com.uin.service;

import com.uin.pojo.Department;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/7:36 PM
 */
public interface DepartmentService {
    /**
     * 根据id查询部门-测试
     *
     * @param id
     * @return com.uin.pojo.Department
     * @author wanglufei
     * @date 2022/4/4 8:19 PM
     */
    Department getDepByID(Integer id);

    /**
     * 获取所有的部门id
     *
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/4 8:20 PM
     */
    List<Department> getAllDepId();

    /**
     * 获取所有部门的信息
     *
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/4 9:29 PM
     */
    List<Department> getAllDeps();

    /**
     * 增加部门
     *
     * @param departmentname
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/4 9:42 PM
     */
    Integer addDepartment(String departmentname);

    /**
     * 删除部门
     *
     * @param departmentid
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/5 12:13 AM
     */
    Integer deleteDep(Integer departmentid);

    /**
     * 编辑部门
     *
     * @param name
     * @param id
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/5 12:19 AM
     */
    Integer updateDep(Integer id, String name);
}
