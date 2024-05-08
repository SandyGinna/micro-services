package com.example.employeeservice.repository;

import com.example.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();
    public void add(Employee employee) {
        employees.add(employee);
    }

    public Employee findById(long id) {
        return employees.stream()
                .filter(e->e.getEmployeeId()==id)
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findByDepartmentId(long departmentId) {
        return employees.stream()
                .filter(e->e.getDepartmentId()==departmentId)
                .toList();
    }

}
