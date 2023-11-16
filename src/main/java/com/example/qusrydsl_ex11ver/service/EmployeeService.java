package com.example.qusrydsl_ex11ver.service;

import com.example.qusrydsl_ex11ver.dto.DynamicSearchCond;
import com.example.qusrydsl_ex11ver.dto.EmployeeDTO;
import com.example.qusrydsl_ex11ver.repository.EmployeeRepositoryQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepositoryQuery employeeRepository;

    public List<EmployeeDTO> getEmployeesByDynamicCondition(
            DynamicSearchCond searchCond) {
        return employeeRepository.dynamicSearch(searchCond);
    }
}