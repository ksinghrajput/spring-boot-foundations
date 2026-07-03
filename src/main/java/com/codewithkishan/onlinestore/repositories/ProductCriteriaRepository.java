package com.codewithkishan.onlinestore.repositories;

import com.codewithkishan.onlinestore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository imp {

    List<Product> findProductByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
