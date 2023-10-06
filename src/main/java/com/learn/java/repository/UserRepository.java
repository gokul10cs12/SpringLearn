package com.learn.java.repository;

import com.learn.java.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);
    User deleteUserByName(String name);
}
