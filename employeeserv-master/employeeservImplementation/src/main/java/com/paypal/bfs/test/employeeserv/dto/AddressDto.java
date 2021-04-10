package com.paypal.bfs.test.employeeserv.dto;

public class AddressDto {
    String line1;
    String line2;
    String city;
    String state;
    String country;
    String zipCode;

    public AddressDto(String line1, String line2, String city, String state, String country, String zipCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
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
        private String line1;
        private String line2;
        private String city;
        private String state;
        private String country;
        private String zipCode;

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

        public AddressDto build() {
            return new AddressDto(this.line1, this.line2, this.city, this.state, this.country, this.zipCode);
        }
    }

}
