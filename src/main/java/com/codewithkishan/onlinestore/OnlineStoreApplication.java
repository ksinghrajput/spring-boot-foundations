package com.codewithkishan.onlinestore;

import com.codewithkishan.onlinestore.entities.User;
import com.codewithkishan.onlinestore.repositories.UserRepository;
import com.codewithkishan.onlinestore.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OnlineStoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OnlineStoreApplication.class, args);
        var service = context.getBean(UserService.class);
        service.fetchUsers();

    }

}
