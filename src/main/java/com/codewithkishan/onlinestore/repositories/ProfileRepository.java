package com.codewithkishan.onlinestore.repositories;

import com.codewithkishan.onlinestore.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
