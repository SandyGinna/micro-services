package com.example.departmentservice.repository;

import com.example.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepo {

    private List<Department> departments = new ArrayList<>();

    public void add(Department department) {
        departments.add(department);
    }

    public Department findById(long id) {
        return departments.stream()
                .filter(d->d.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }
}
