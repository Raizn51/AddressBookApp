package com.spring.addressbookapp.controller;


import com.spring.addressbookapp.dto.*;
import com.spring.addressbookapp.model.Address;
import com.spring.addressbookapp.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping(value ={"","/","/get"})
    public ResponseEntity<ResponseDTO> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", addresses);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressById(@PathVariable("id") int id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            ResponseDTO responseDTO = new ResponseDTO("Get Call For ID Successful", address);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseDTO("Address Not Found", null), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddress(@Valid @RequestBody AddressDTO addressDTO) {
        Address address = addressService.addAddress(addressDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Successfully", address);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/create/bulk")
    public ResponseEntity<ResponseDTO> addMultipleAddresses(@Valid @RequestBody List<AddressDTO> addressDTOList) {
        List<Address> addresses = addressService.addMultipleAddresses(addressDTOList);
        return new ResponseEntity<>(new ResponseDTO("Created Multiple Addresses Successfully", addresses), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@PathVariable("id") int id, @RequestBody AddressDTO addressDTO) {
        Address updatedAddress = addressService.updateAddress(id, addressDTO);
        if (updatedAddress != null) {
            ResponseDTO responseDTO = new ResponseDTO("Updated Address Successfully", updatedAddress);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseDTO("Address Not Found", null), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable("id") int id) {
        addressService.deleteAddress(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted ID: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
