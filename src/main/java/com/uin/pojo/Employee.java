package com.uin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wanglufei
 * @description: 员工
 * @date 2022/4/3/2:29 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int employeeid;
    private String employeename;
    private String username;
    private String phone;
    private String email;
    private int status;
    private int departmentid;
    private String password;
    private int role;
}
