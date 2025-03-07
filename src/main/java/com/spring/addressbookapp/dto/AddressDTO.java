package com.spring.addressbookapp.dto;

public class AddressDTO {
    public String fullName;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String phoneNumber;

    public AddressDTO(String fullName, String city, String state, String zipCode, String phoneNumber) {
        this.fullName = fullName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
