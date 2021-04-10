package com.paypal.bfs.test.employeeserv.dto;


import java.util.Date;

public class EmployeeDto {

    int id;
    String firstName;
    String lastName;
    Date dateOfBirth;
    AddressDto address;

    public EmployeeDto(int id, String firstName, String lastName, Date dateOfBirth, AddressDto address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public AddressDto getAddress() {
        return address;
    }

    public static EmployeeDtoBuilder builder() {
        return new EmployeeDtoBuilder();
    }

    public static class EmployeeDtoBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private Date dateOfBirth;
        private AddressDto address;

        public EmployeeDtoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EmployeeDtoBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeDtoBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeDtoBuilder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public EmployeeDtoBuilder setAddress(AddressDto address) {
            this.address = address;
            return this;
        }

        public EmployeeDto build() {
            return new EmployeeDto(this.id,this.firstName,this.lastName,this.dateOfBirth,this.address);
        }
    }
}
