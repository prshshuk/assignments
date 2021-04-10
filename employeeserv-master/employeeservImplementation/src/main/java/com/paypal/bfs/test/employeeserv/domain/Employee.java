package com.paypal.bfs.test.employeeserv.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Employee {

    @GeneratedValue
    @Id
    int id;

    @NotNull
    @Size(min = 3, max = 15)
    String firstName;

    @NotNull
    @Size(min = 3, max = 15)
    String lastName;

    @Past
    Date dateOfBirth;

    @NotNull
    @OneToOne(cascade=CascadeType.ALL)
    Address address;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, Date dateOfBirth, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public void setAddress(Address address) {
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

    public Address getAddress() {
        return address;
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private Date dateOfBirth;
        private Address address;

        public EmployeeBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public EmployeeBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Employee build() {
            return new Employee(this.id,this.firstName,this.lastName,this.dateOfBirth,this.address);
        }
    }
}