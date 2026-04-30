package com.faraz.expenseTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/test")
    public String test() {
        return "HELLO " + System.currentTimeMillis();
    }

    @GetMapping("/api/secure")
    public String secureTest() {
        return "Hello, this is a secure endpoissadasaadsaas!";
    }

}