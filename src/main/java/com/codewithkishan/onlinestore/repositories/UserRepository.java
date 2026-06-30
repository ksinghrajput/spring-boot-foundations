package com.codewithkishan.onlinestore.repositories;

import com.codewithkishan.onlinestore.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
