package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.domain.Address;
import com.paypal.bfs.test.employeeserv.domain.Employee;
import com.paypal.bfs.test.employeeserv.dto.EmployeeDto;
import com.paypal.bfs.test.employeeserv.repository.AddressRepository;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

/*    @Autowired
    AddressRepository addressRepository;*/

    @Override
    public Optional<EmployeeDto> employeeGetById(String id) {
        return Optional.of(EmployeeUtil.getEmployeeDtoFromDao(employeeRepository.findById(Integer.parseInt(id)).get()));
    }

    @Override
    public Optional<EmployeeDto> createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.save(EmployeeUtil.getEmployeeDao(employeeDto));
        return Optional.of(EmployeeUtil.getEmployeeDtoFromDao(employee));
    }

    @Override
    public Iterable<EmployeeDto> fetchEmployee() {
        return StreamSupport.stream(employeeRepository.findAll().spliterator(), false)
                .map(employee -> EmployeeUtil.getEmployeeDtoFromDao(employee))
                .collect(Collectors.toList());

    }

}
