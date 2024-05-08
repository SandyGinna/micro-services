package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping
    public void add(@RequestBody Employee employee) {
        employeeRepository.add(employee);
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employeeRepository.findById(id);
    }

    @GetMapping("department/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
}
