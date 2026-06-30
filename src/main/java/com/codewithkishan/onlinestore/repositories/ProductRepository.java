package com.codewithkishan.onlinestore.repositories;

import com.codewithkishan.onlinestore.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}