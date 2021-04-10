package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dto.EmployeeDto;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import com.paypal.bfs.test.employeeserv.util.EmployeeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
        return new ResponseEntity<>(EmployeeUtil.getEmployee(employeeService.employeeGetById(id).get()), HttpStatus.OK);
    }


    public ResponseEntity<Employee> createEmployee(Employee employee){
/*        employeeService.createEmployee(EmployeeUtil.getEmployeeDto(employee));
        return new ResponseEntity<>(employee, HttpStatus.OK);*/
        return new ResponseEntity<>(EmployeeUtil.getEmployee(employeeService.createEmployee(EmployeeUtil.getEmployeeDto(employee)).get()), HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<Employee>> fetchEmployee(){
        return new ResponseEntity<>(StreamSupport.stream(employeeService.fetchEmployee().spliterator(), false)
                .map(employeeDto -> EmployeeUtil.getEmployee(employeeDto))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}
