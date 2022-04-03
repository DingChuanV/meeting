package com.uin.mapper;

import com.uin.pojo.Department;
import org.apache.ibatis.annotations.Param;


/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/3/31/7:35 PM
 */
public interface DepartmentMapper {

    Department getDepByID(@Param("id") Integer id);
}
