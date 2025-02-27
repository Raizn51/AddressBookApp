package com.spring.addressbookapp.model;


import com.spring.addressbookapp.dto.AddressDTO;

public class Address {
    private int id;
    private String name;
    private String phone;
    private String city;
    private String state;

    public Address(int id, AddressDTO addressDTO) {
        this.id = id;
        this.name = addressDTO.name;
        this.phone = addressDTO.phone;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
