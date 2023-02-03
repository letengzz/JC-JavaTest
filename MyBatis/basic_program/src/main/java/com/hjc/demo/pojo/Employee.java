package com.hjc.demo.pojo;

/**
 *  和数据库表 t_emp 对应的实体类:
 *  emp_id INT AUTO_INCREMENT
 *  emp_name CHAR(100)
 *  emp_salary DOUBLE(10,5)
 *
 * @author hjc
 */
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;

    /**
     * 无参构造
     */
    public Employee() {
    }

    /**
     * 有参构造
     * @param empId
     * @param empName
     * @param empSalary
     */
    public Employee(Integer empId, String empName, Double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    /**
     * getter和setter方法
     */
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    /**
     * toString()方法
     * @return
     */
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}