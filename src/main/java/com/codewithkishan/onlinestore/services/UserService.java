package com.codewithkishan.onlinestore.services;

import com.codewithkishan.onlinestore.entities.Category;
import com.codewithkishan.onlinestore.entities.Product;
import com.codewithkishan.onlinestore.entities.User;
import com.codewithkishan.onlinestore.repositories.AddressRepository;
import com.codewithkishan.onlinestore.repositories.ProductRepository;
import com.codewithkishan.onlinestore.repositories.ProfileRepository;
import com.codewithkishan.onlinestore.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLOutput;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;


    @Transactional
    public void showEntityStates(){
        var user = User.builder()
                .name("Kishan")
                .email("kishan@gmail.com")
                .password("password")
                .build();

        if(entityManager.contains(user)){
            System.out.println("Persistant");
        } else {
            System.out.println("Transient/Detached");
        }

        userRepository.save(user);

        if(entityManager.contains(user)){
            System.out.println("Persistant");
        } else {
            System.out.println("Transient/Detached");
        }
    }

    @Transactional
    public void showRelatedEntity(){
        var profile = profileRepository.findById(3L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }


    @Transactional
    public void fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getAddress());
    }


    @Transactional
    public void manageProducts(){

        var category = new Category((byte) 1);

        var product = Product.builder()
                .description("Desc")
                .name("product 1")
                .price(BigDecimal.valueOf(10.99))
                .category(category)
                .build();

        productRepository.save(product);


    }

    @Transactional
    public void findProducts(){
        productRepository.findProducts(BigDecimal.valueOf(10), BigDecimal.valueOf(11));
    }


    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)1);
    }

    public void fetchProducts(){
        var product = new Product();
        product.setName("product");
        var example = Example.of(product);
    }

    @Transactional
    public void fetchUsers(){
        var users = userRepository.fingAllWithTags();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }



}
