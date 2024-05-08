package com.example.departmentservice.controller;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {


    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeClient employeeClient;
    @PostMapping
    public void addDepartment(@RequestBody Department department) {
        departmentRepo.add(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable long id) {
        log.info("Get department by id,{}",id);
        return departmentRepo.findById(id);
    }

    @GetMapping
    public List<Department> findAll() {
        return departmentRepo.findAll();
    }
    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployee() {
        List<Department> departments = departmentRepo.findAll();
        departments.forEach(department -> {
            department.setEmployee(employeeClient.getByDepartment(department.getId()));
        });
        return departments;
    }


}
