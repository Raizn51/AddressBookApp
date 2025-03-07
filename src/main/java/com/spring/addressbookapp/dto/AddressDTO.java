package com.spring.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

@ToString
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
    @Pattern(regexp = "^[0-9]{5,6}$", message = "Zip Code must be 5 or 6 digits")
    public String zipCode;

    @NotEmpty(message = "Phone Number cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must be exactly 10 digits")
    public String phoneNumber;

    public AddressDTO(String fullName, String address, String city, String state, String zipCode, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }
}
