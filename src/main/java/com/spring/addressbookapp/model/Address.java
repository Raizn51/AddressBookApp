package com.spring.addressbookapp.model;


import com.spring.addressbookapp.dto.AddressDTO;

public class Address {
    private int id;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

    public Address(int id, AddressDTO addressDTO) {
        this.id = id;
        this.fullName = addressDTO.fullName;
        this.address= addressDTO.address;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.zipCode=addressDTO.zipCode;
        this.phoneNumber=addressDTO.phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
