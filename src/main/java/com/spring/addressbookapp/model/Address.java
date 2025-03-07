package com.spring.addressbookapp.model;

import com.spring.addressbookapp.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address_book")
@Data
@NoArgsConstructor // Ensures JPA can create instances
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use IDENTITY for MySQL
    @Column(name = "address_book_id")
    private int addressBookId;

    @Column
    private String fullName;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;

    @Column
    private String phoneNumber;

    @Version // Handles concurrent updates
    private Integer version;

    // Constructor for creating Address from AddressDTO
    public Address(AddressDTO addressDTO) {
        this.fullName = addressDTO.fullName;
        this.address = addressDTO.address;
        this.city = addressDTO.city;
        this.state = addressDTO.state;
        this.zipCode = addressDTO.zipCode;
        this.phoneNumber = addressDTO.phoneNumber;
    }
}
