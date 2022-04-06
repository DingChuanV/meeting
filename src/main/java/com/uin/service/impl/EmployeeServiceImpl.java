package com.uin.service.impl;

import com.uin.mapper.EmployeeMapper;
import com.uin.pojo.Employee;
import com.uin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/3/3:38 PM
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @return com.uin.pojo.Employee
     * @author wanglufei
     * @date 2022/4/4 11:54 AM
     */
    public Employee doLogin(String username, String password) {
        Employee employee = employeeMapper.loadByUsername(username);
        if (employee == null || !employee.getPassword().equals(password)) {
            return null;
        }
        return employee;
    }

    /**
     * 注册
     *
     * @param employee
     * @return int
     * @author wanglufei
     * @date 2022/4/4 11:54 AM
     */
    public int doRegister(Employee employee) {
        //查询注册的用户名是否重复
        Employee emp = employeeMapper.loadByUsername(employee.getUsername());
        if (emp != null) {
            return -1;
        }
        employee.setStatus(0);
        employee.setRole(1);
        return employeeMapper.doRegister(employee);
    }

    /**
     * 查询用户待审批
     *
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/4 8:17 PM
     */
    public List<Employee> getAllEmp_status(int status) {
        return employeeMapper.getAllEmp_status(status);
    }

    /**
     * 通过审批
     *
     * @param employeeid
     * @param status
     * @return int
     * @author wanglufei
     * @date 2022/4/4 8:46 PM
     */
    public Integer updateStatus(Integer employeeid, Integer status) {
        return employeeMapper.approveaccount(employeeid, status);
    }

    /**
     * 获取全部员工 并分页
     *
     * @param employee
     * @param page
     * @param pageSize
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/5 5:14 PM
     */
    public List<Employee> getAllEmp(Employee employee, Integer page, Integer pageSize) {
        page = (page - 1) * pageSize;
        return employeeMapper.getAllEmp(employee, page, pageSize);
    }

    /**
     * 获取员工总数
     *
     * @param employee
     * @return java.lang.Long
     * @author wanglufei
     * @date 2022/4/5 5:14 PM
     */
    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    /**
     * 根据部门id查询员工
     *
     * @param depId
     * @return java.util.List<com.uin.pojo.Employee>
     * @author wanglufei
     * @date 2022/4/6 1:28 PM
     */
    public List<Employee> getAllEmpById(int depId) {
        return employeeMapper.getAllEmpById(depId);
    }

}
