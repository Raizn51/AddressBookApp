package com.spring.addressbookapp.controller;


import com.spring.addressbookapp.dto.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getAllAddresses() {
        return new ResponseEntity<>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getAddressById(@PathVariable("id") int id) {
        return new ResponseEntity<>("Get Call Success for id: " + id, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAddress(@RequestBody AddressDTO addressDTO) {
        return new ResponseEntity<>("Created Address Data for: " + addressDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddress(@RequestBody AddressDTO addressDTO) {
        return new ResponseEntity<>("Updated Address Data for: " + addressDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") int id) {
        return new ResponseEntity<>("Delete Call Success for id: " + id, HttpStatus.OK);
    }
}
