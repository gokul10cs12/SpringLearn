package com.learn.java.controller;

import com.learn.java.model.User;
import com.learn.java.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User createUser(@RequestBody User user) {
        return userService.creatUser(user);
    }

    @GetMapping()
    User getUserbyCriteria(@RequestParam(name = "criteria") String criteria) {
        return  userService.findUserByName(criteria);
    }

    @GetMapping("/{name}")
    User getUserbyName(@PathVariable String name) {
        return userService.findUserByName(name);
    }


    //path variable requestparam
}
