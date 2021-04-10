package com.paypal.bfs.test.employeeserv.service;


import com.paypal.bfs.test.employeeserv.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmployeeService {

    public Optional<EmployeeDto> employeeGetById(String id);
    public Optional<EmployeeDto> createEmployee(EmployeeDto employee);
    public Iterable<EmployeeDto> fetchEmployee();
}
