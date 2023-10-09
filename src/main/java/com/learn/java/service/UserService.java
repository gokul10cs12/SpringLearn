package com.learn.java.service;


import com.learn.java.model.User;
import com.learn.java.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User creatUser(User user) {
        return repository.save(user);
    }

    public User findUserByName(String name) {
        String location = "blr";
        return repository.findByName(name,location);
    }

    public User updateUser(User user) {

        return repository.updateUser(user);
    }
}
