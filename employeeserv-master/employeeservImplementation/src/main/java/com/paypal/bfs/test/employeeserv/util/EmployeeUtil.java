package com.paypal.bfs.test.employeeserv.util;


import com.paypal.bfs.test.employeeserv.domain.Address;
import com.paypal.bfs.test.employeeserv.domain.Employee;
import com.paypal.bfs.test.employeeserv.dto.AddressDto;
import com.paypal.bfs.test.employeeserv.dto.EmployeeDto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EmployeeUtil {
    public static EmployeeDto getEmployeeDto(com.paypal.bfs.test.employeeserv.api.model.Employee employee) {
        return EmployeeDto.builder().setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setDateOfBirth(formatDate(employee.getBirthday()))
                .setAddress(getAddressDto(employee.getAddress()))
                .build();
    }

    public static Date formatDate(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return new Date();
        }

    }

    public static AddressDto getAddressDto(com.paypal.bfs.test.employeeserv.api.model.Address address) {
        return AddressDto.builder()
                .setLine1(address.getLine1())
                .setLine2(address.getLine2())
                .setCity(address.getCity())
                .setCountry(address.getCountry())
                .setState(address.getState())
                .setZipCode(address.getZipcode())
                .build();
    }

    public static EmployeeDto getEmployeeDtoFromDao(Employee employee) {
        return EmployeeDto.builder().setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setDateOfBirth(employee.getDateOfBirth())
                .setAddress(getAddressDtoFromDao(employee.getAddress()))
                .build();
    }

    public static AddressDto getAddressDtoFromDao(Address address) {
        return AddressDto.builder()
                .setLine1(address.getLine1())
                .setLine2(address.getLine2())
                .setCity(address.getCity())
                .setCountry(address.getCountry())
                .setState(address.getState())
                .setZipCode(address.getZipCode())
                .build();
    }

    public static com.paypal.bfs.test.employeeserv.api.model.Employee getEmployee(EmployeeDto employeeDto) {
        com.paypal.bfs.test.employeeserv.api.model.Employee employee = new com.paypal.bfs.test.employeeserv.api.model.Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setBirthday(employeeDto.getDateOfBirth().toString());
        employee.setAddress(getEmployeeAddress(employeeDto.getAddress()));
        return employee;
    }

    public static com.paypal.bfs.test.employeeserv.api.model.Address getEmployeeAddress(AddressDto addressDto) {
        com.paypal.bfs.test.employeeserv.api.model.Address address = new com.paypal.bfs.test.employeeserv.api.model.Address();
        address.setLine1(addressDto.getLine1());
        address.setLine2(addressDto.getLine2());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCountry(addressDto.getCountry());
        address.setZipcode(addressDto.getZipCode());
        return address;
    }

    public static Employee getEmployeeDao(EmployeeDto employeeDto) {
        return Employee.builder().setId(employeeDto.getId())
                .setFirstName(employeeDto.getFirstName())
                .setLastName(employeeDto.getLastName())
                .setDateOfBirth(employeeDto.getDateOfBirth())
                .setAddress(getAddressDao(employeeDto.getAddress()))
                .build();
    }

    public static Address getAddressDao(AddressDto addressDto) {
        return Address.builder()
                .setLine1(addressDto.getLine1())
                .setLine2(addressDto.getLine2())
                .setCity(addressDto.getCity())
                .setCountry(addressDto.getCountry())
                .setState(addressDto.getState())
                .setZipCode(addressDto.getZipCode())
                .build();
    }
}
