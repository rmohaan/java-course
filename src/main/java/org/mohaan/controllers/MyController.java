package org.mohaan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/")
    public String helloFunction() {
        System.out.println("Yeah, I'm the controller...");
        return "Hello from Function...";
    }

    @PostMapping("/")
    public String helloFunction(@RequestBody User user) {
        System.out.println("Yeah, I'm the controller...");
        return "Hello from Function..." + user.toString();
    }
}


package com.example.firestore.model;

public class User {
    private String id;
    private String name;
    private String email;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
