package com.codewithkishan.onlinestore.repositories;

import com.codewithkishan.onlinestore.dtos.ProductSummary;
import com.codewithkishan.onlinestore.dtos.ProductSummaryDto;
import com.codewithkishan.onlinestore.entities.Category;
import com.codewithkishan.onlinestore.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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



    @Query("Select p from Product p where p.price between :min and :max")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select p from Product p where p.name = :min")
    List<Product> findProductsRange(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    public void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    @Query("select p.id, p.name from Product p where p.category= :category")
    List<ProductSummaryDto> findByCategory(@Param("category") Category category);




    

    

    
    
}