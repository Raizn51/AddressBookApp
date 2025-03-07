package com.spring.addressbookapp.service;

import com.spring.addressbookapp.dto.AddressDTO;
import com.spring.addressbookapp.model.Address;
import com.spring.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
public class AddressService implements IAddressService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<Address> getAllAddresses() {
        return addressBookRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return addressBookRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Address addAddress(AddressDTO addressDTO) {
        Address address = new Address(addressDTO);
        log.debug("Address Book Data: " + address.toString());
        return addressBookRepository.save(address);
    }

    @Override
    @Transactional
    public List<Address> addMultipleAddresses(List<AddressDTO> addressDTOList) {
        List<Address> newAddressList = addressDTOList.stream()
                .map(Address::new)
                .toList();
        return addressBookRepository.saveAll(newAddressList);
    }

    @Override
    @Transactional
    public Address updateAddress(int id, AddressDTO addressDTO) {
        return addressBookRepository.findById(id)
                .map(existingAddress -> {
                    existingAddress.setFullName(addressDTO.fullName);
                    existingAddress.setAddress(addressDTO.address);
                    existingAddress.setCity(addressDTO.city);
                    existingAddress.setState(addressDTO.state);
                    existingAddress.setZipCode(addressDTO.zipCode);
                    existingAddress.setPhoneNumber(addressDTO.phoneNumber);
                    return addressBookRepository.save(existingAddress);
                })
                .orElse(null);
    }

    @Override
    @Transactional
    public void deleteAddress(int id) {
        addressBookRepository.deleteById(id);
    }
}
