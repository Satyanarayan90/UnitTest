package com.unit.service;


import com.unit.model.Employee;
import com.unit.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployee() {
        List<Employee> employees = repository.findAll();
        System.out.println("Getting data from DB : " + employees);
        return employees;
    }

    public List<Employee> getEmployeebyId(String empId) {
        return repository.findByEmpId(empId);
    }

    public void deleteEmployee(Employee user) {
        repository.delete(user);
    }
}
