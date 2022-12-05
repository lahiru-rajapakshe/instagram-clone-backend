package com.instagram.instagram;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/1.0/users")
    public void createUser(){

    }
}
