package com.spring.addressbookapp.dto;

public class AddressDTO {
    public String name;
    public String phone;
    public String city;
    public String state;

    public AddressDTO(String name, String phone, String city, String state) {
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
