package com.learn.java.repository;

import com.learn.java.model.User;

public interface UserRepositoryAddon {

    User findByName(String name, String location);

    User updateUser(User user);
}
