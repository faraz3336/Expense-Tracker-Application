package com.faraz.expenseTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "HELLO " + System.currentTimeMillis();
    }

    @GetMapping("/admin")
    public String adminTest() {
        return "Hello, this is a Admin endpoint!";
    }

    @GetMapping("/user")
    public String userTest() {
        return "Hello, this is a User endpoint!";
    }

}