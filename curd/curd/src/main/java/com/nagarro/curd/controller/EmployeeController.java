package com.nagarro.curd.controller;

import com.nagarro.curd.entities.Employee;
import com.nagarro.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/Employee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> list = employeeService.getAllEmployee();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }
    @GetMapping("/Employee/{Id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long Id) {
        Employee employee = employeeService.getEmployeeById(Id);
        {
            if (employee == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.of(Optional.of(employee));
        }
    }

    @PostMapping("/Employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = null;
        try {
            emp = this.employeeService.addEmployee(employee);
            return ResponseEntity.of(Optional.of(emp));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/Employee/{id}")
    public ResponseEntity<Employee> upadteEmployeeById(@RequestBody Employee employee,
                                                       @PathVariable Long id) {
        try {
            this.employeeService.updateEmployeeById(employee, id);
            return ResponseEntity.ok().body(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/Employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
        try {
            this.employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
