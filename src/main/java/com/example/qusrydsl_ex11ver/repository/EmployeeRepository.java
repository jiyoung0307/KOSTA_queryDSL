package com.example.qusrydsl_ex11ver.repository;


import com.example.qusrydsl_ex11ver.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> ,
        EmployeeRepositoryQuery   {
    public List<Employee> findByEmpName(String empName);
    public List<Employee> findBySalaryGreaterThanEqual(Integer salary);

}