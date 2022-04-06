package com.uin.mapper;

import com.uin.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/3/3:37 PM
 */
public interface EmployeeMapper {
    /**
     * 登陆--简单版的登陆功能
     *
     * @param username
     * @return com.uin.pojo.Employee
     * @author wanglufei
     * @date 2022/4/4 12:51 AM
     */
    Employee loadByUsername(String username);

    /**
     * 注册
     *
     * @param employee
     * @return int
     * @author wanglufei
     * @date 2022/4/4 11:55 AM
     */
    int doRegister(Employee employee);

    /**
     * 查询用户待审批
     *
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/4 8:18 PM
     */
    List<Employee> getAllEmp_status(int status);

    /**
     * 通过审批
     *
     * @param employeeid
     * @param status
     * @return int
     * @author wanglufei
     * @date 2022/4/4 8:46 PM
     */
    Integer approveaccount(@Param("employeeid") Integer employeeid, @Param("status") Integer status);

    /**
     * 查询all用户 并分页
     *
     * @param employee
     * @param page
     * @param pageSize
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/5 5:16 PM
     */
    List<Employee> getAllEmp(@Param("emp") Employee employee, @Param("page") Integer page,
                             @Param("pagesize") Integer pageSize);

    /**
     * 获取总记录数
     *
     * @param employee
     * @return java.lang.Long
     * @author wanglufei
     * @date 2022/4/5 5:23 PM
     */
    Long getTotal(Employee employee);

    /**
     * 根据部门id查询员工
     *
     * @param depId
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/6 1:29 PM
     */
    List<Employee> getAllEmpById(int depId);
}
