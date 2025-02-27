package com.spring.addressbookapp.controller;


import com.spring.addressbookapp.dto.*;
import com.spring.addressbookapp.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressController {

    private List<Address> addressList = new ArrayList<>();

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getAllAddresses() {
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", addressList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("id") int id) {
        for (Address address : addressList) {
            if (address.getId() == id) {
                ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", address);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ResponseDTO("Address Not Found", null), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddress(@RequestBody AddressDTO addressDTO) {
        int newId = addressList.size() + 1;
        Address address = new Address(newId, addressDTO);
        addressList.add(address);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Successfully", address);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@PathVariable("id") int id, @RequestBody AddressDTO addressDTO) {
        for (Address address : addressList) {
            if (address.getId() == id) {
                address.setName(addressDTO.name);
                address.setPhone(addressDTO.phone);
                address.setCity(addressDTO.city);
                address.setState(addressDTO.state);
                ResponseDTO responseDTO = new ResponseDTO("Updated Address Successfully", address);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ResponseDTO("Address Not Found", null), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable("id") int id) {
        for (Address address : addressList) {
            if (address.getId() == id) {
                addressList.remove(address);
                ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted ID: " + id);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ResponseDTO("Address Not Found", null), HttpStatus.NOT_FOUND);
    }
}
