package com.example.qusrydsl_ex11ver.repository;

import com.example.qusrydsl_ex11ver.dto.DynamicSearchCond;
import com.example.qusrydsl_ex11ver.dto.EmployeeDTO;
import com.example.qusrydsl_ex11ver.dto.EmployeeDepartmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface EmployeeRepositoryQuery {
    List<EmployeeDTO> dynamicSearch(DynamicSearchCond searchCond);
    Page<EmployeeDepartmentDTO> dynamicSearchPagination(DynamicSearchCond searchCond, Pageable pageable);
}