package com.learn.java.repository;

import com.learn.java.model.User;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String>, UserRepositoryAddon {

    // User findByName(String name);

    User deleteUserByName(String name);

    @Query(value = "{$and :[{ \"name\" : ?0 }, { \"location\" : ?1 }]}", fields = "{name : 1, location: 1}")
    User getByName(String name, String location);

    @DeleteQuery(value = "{'name' : ?0}")
    void deleteUser(String name);

}
