package com.nagarro.curd.service;

import com.nagarro.curd.entities.Employee;

import java.util.List;

public interface EmployeeService
{

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    Employee updateEmployeeById(Employee employee, Long id);

    void deleteEmployeeById(Long id);
}
