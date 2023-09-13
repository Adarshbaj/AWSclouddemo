package com.nagarro.curd.service;

import com.nagarro.curd.entities.Employee;
import com.nagarro.curd.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("emp_id is incorrect"));

    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployeeById(Employee employee, Long id) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }
}
