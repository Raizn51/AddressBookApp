package com.spring.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class AddressDTO {
    @NotEmpty(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name is Invalid")
    public String fullName;

    @NotEmpty(message = "Address cannot be null")
    public String address;

    @NotEmpty(message = "City cannot be null")
    public String city;

    @NotEmpty(message = "State cannot be null")
    public String state;

    @NotEmpty(message = "Zip Code cannot be null")
    public String zipCode;

    @NotEmpty(message = "Phone Number cannot be null")
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
