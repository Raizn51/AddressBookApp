package com.spring.addressbookapp.service;





import com.spring.addressbookapp.dto.AddressDTO;
import com.spring.addressbookapp.model.Address;

import java.util.List;

public interface IAddressService {
    List<Address> getAllAddresses();
    Address getAddressById(int id);
    Address addAddress(AddressDTO addressDTO);
    Address updateAddress(int id, AddressDTO addressDTO);
    void deleteAddress(int id);
    public List<Address> addMultipleAddresses(List<AddressDTO> addressDTOList);
}
