package com.spring.addressbookapp.service;


import com.spring.addressbookapp.dto.AddressDTO;
import com.spring.addressbookapp.model.Address;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService implements IAddressService {
    private List<Address> addressList = new ArrayList<>();

    @Override
    public List<Address> getAllAddresses() {
        return addressList;
    }

    @Override
    public Address getAddressById(int id) {
        return addressList.stream()
                .filter(address -> address.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public Address addAddress(AddressDTO addressDTO) {
        int newId = addressList.size() + 1;
        Address address = new Address(newId, addressDTO);
        addressList.add(address);
        return address;
    }

    @Override
    public Address updateAddress(int id, AddressDTO addressDTO) {
        for (Address address : addressList) {
            if (address.getId() == id) {
                address.setName(addressDTO.name);
                address.setPhone(addressDTO.phone);
                address.setCity(addressDTO.city);
                address.setState(addressDTO.state);
                return address;
            }
        }
        return null;
    }

    @Override
    public void deleteAddress(int id) {
        addressList.removeIf(address -> address.getId() == id);
    }
}

