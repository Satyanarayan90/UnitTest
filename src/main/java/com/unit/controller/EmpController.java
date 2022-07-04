package com.unit.controller;

import com.unit.model.Employee;
import com.unit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmployeeService service;

    @PostMapping(value = "/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> findAllEmployees() {
        return service.getEmployee();
    }

    @GetMapping("/getEmployeeByempId/{empId}")
    public List<Employee> findEmployeeById(@PathVariable String empId) {
        return service.getEmployeebyId(empId);
    }

    @DeleteMapping(value="/remove")
    public Employee removeEmp(@RequestBody Employee employee) {
        service.deleteEmployee(employee);
        return employee;
    }
}
