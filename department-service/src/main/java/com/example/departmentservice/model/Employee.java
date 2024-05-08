package com.example.departmentservice.model;

import com.netflix.discovery.provider.Serializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {

    private long employeeId;
    private String employeeName;
    private Integer age;

}
