package com.codewithkishan.onlinestore.repositories;

import com.codewithkishan.onlinestore.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}