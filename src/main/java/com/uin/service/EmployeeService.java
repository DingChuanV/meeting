package com.uin.service;

import com.uin.pojo.Employee;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/3/3:38 PM
 */
public interface EmployeeService {
    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return com.uin.pojo.Employee
     * @author wanglufei
     * @date 2022/4/4 11:53 AM
     */
    Employee doLogin(String username, String password);

    /**
     * 注册
     *
     * @param employee
     * @return int
     * @author wanglufei
     * @date 2022/4/4 11:53 AM
     */
    int doRegister(Employee employee);

    /**
     * 查询用户待审批
     *
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/4 8:17 PM
     */
    List<Employee> getAllEmp_status(int status);

    /**
     * 通过审批
     *
     * @param employeeid
     * @param status
     * @return int
     * @author wanglufei
     * @date 2022/4/4 8:45 PM
     */
    Integer updateStatus(Integer employeeid, Integer status);


    /**
     * 获取全部用户 并分页
     *
     * @param employee
     * @param page
     * @param pageSize
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/5 5:10 PM
     */
    List<Employee> getAllEmp(Employee employee, Integer page, Integer pageSize);

    /**
     * 获取员工的总人数
     *
     * @param employee
     * @return java.lang.Long
     * @author wanglufei
     * @date 2022/4/5 5:11 PM
     */
    Long getTotal(Employee employee);

    /**
     * 根据部门id查询员工
     *
     * @param depId
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/6 1:28 PM
     */
    List<Employee> getAllEmpById(int depId);
}
