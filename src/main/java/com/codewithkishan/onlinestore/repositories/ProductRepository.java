package com.codewithkishan.onlinestore.repositories;

import com.codewithkishan.onlinestore.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    //String
    List<Product> findByNameIgnoreCase(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContains(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    //Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2);

    //null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    //multiple
    List<Product> findByDescriptionNullAndNameNull();


    //Order BY

    List<Product> findByNameOrderByPriceDesc(String name);

    //Limit
    List<Product> findTop10ByNameOrderByPrice(String name);





    
    

    

    
    
}