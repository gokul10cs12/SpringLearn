package com.learn.java.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    String getTestMessage() {
        return "test";
    }

    @PostMapping
    String postMessage(@RequestBody String name) {
        return "captured" + name;
    }
}
