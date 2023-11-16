package com.example.qusrydsl_ex11ver.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private int salary;

    @QueryProjection
    public EmployeeDTO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
