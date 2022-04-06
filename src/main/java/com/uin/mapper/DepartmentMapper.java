package com.uin.mapper;

import com.uin.pojo.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/7:35 PM
 */
public interface DepartmentMapper {
    /**
     * 根据id获取部门
     *
     * @param id
     * @return com.uin.pojo.Department
     * @author wanglufei
     * @date 2022/4/4 11:19 AM
     */
    Department getDepByID(@Param("id") Integer id);

    /**
     * 获取所有员工的id-测试
     *
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/4 11:20 AM
     */
    List<Department> getAllDepId();

    /**
     * 获取所有部门
     *
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/4 9:31 PM
     */
    List<Department> getAllDeps();

    /**
     * 增加部门
     *
     * @param departmentname
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/4 9:43 PM
     */
    Integer addDepartment(String departmentname);

    /**
     * 通过名字查询部门
     *
     * @param departmentname
     * @return java.util.List<com.uin.pojo.Department>
     * @author wanglufei
     * @date 2022/4/4 11:49 PM
     */
    Department getDepByUsername(String departmentname);

    /**
     * 删除部门
     *
     * @param departmentid
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/5 12:14 AM
     */
    Integer deleteDep(Integer departmentid);

    /**
     * 编辑部门
     *
     * @param name
     * @param id
     * @return java.lang.Integer
     * @author wanglufei
     * @date 2022/4/5 12:20 AM
     */
    Integer updateDep(@Param("id") Integer id,
                      @Param("name") String name);
}
