package com.paypal.bfs.test.employeeserv.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {

    @GeneratedValue
    @Id
    int id;

    @NotNull
    @Size(min = 3, max = 255)
    String line1;

    @Size(min = 3, max = 255)
    String line2;

    @NotNull
    @Size(min = 2, max = 15)
    String city;

    @NotNull
    @Size(min = 2, max = 15)
    String state;

    @NotNull
    @Size(min = 2, max = 15)
    String country;

    @NotNull
    @Size(min = 6, max = 6)
    String zipCode;

    public Address() {
    }

    public Address(int id, String line1, String line2, String city, String state, String country, String zipCode) {
        this.id = id;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }



    public int getId() {
        return id;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public static AddressBuilder builder() {
        return new AddressBuilder();
    }

    public static class AddressBuilder {
        private int id;
        private String line1;
        private String line2;
        private String city;
        private String state;
        private String country;
        private String zipCode;

        public AddressBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public AddressBuilder setLine1(String line1) {
            this.line1 = line1;
            return this;
        }

        public AddressBuilder setLine2(String line2) {
            this.line2 = line2;
            return this;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setState(String state) {
            this.state = state;
            return this;
        }

        public AddressBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressBuilder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Address build() {
            return new Address(this.id, this.line1, this.line2, this.city, this.state, this.country, this.zipCode);
        }
    }
}
