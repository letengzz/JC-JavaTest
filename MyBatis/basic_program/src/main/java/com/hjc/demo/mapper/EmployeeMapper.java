package com.hjc.demo.mapper;

import com.hjc.demo.pojo.Employee;

/**
 * Mapper映射
 * @author hjc
 */
public interface EmployeeMapper {

    /**
     * 查询信息
     * @param empId id
     * @return 所需要的信息
     */
    Employee selectEmployee(Integer empId);
}