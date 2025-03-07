package com.spring.addressbookapp.repository;

import com.spring.addressbookapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<Address , Integer> {
}
