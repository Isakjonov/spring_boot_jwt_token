package com.example.spring_boot_jwt_token.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestController {
    @GetMapping("/getA")
    public String helloA(){
        return "Hello test get ADMIN";
    }
    @GetMapping("/getU")
    public String helloU(){
        return "Hello test get User";
    }
    @GetMapping("/getAU")
    public String helloAU(){
        return "Hello test get Admin User";
    }
}
