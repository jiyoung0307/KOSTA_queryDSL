package com.example.qusrydsl_ex11ver.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDepartmentDTO {
    private String name;
    private int salary;
    private String deptName;

    @QueryProjection
    public EmployeeDepartmentDTO(String name, int salary, String deptName) {
        this.name = name;
        this.salary = salary;
        this.deptName = deptName;
    }
}