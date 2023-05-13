package com.example.spring_boot_jwt_token.controllers;

import com.example.spring_boot_jwt_token.entitys.User;
import com.example.spring_boot_jwt_token.payload.ReqSignUp;
import com.example.spring_boot_jwt_token.securitys.AuthService;
import com.example.spring_boot_jwt_token.securitys.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("register")
    public HttpEntity<?> register(@RequestBody ReqSignUp reqSignUp){
        return authService.register(reqSignUp);
    }
    @PostMapping("login")
    public HttpEntity<?> login(@RequestBody ReqSignUp reqSignUp){
        return ResponseEntity.ok(authService.login(reqSignUp.getPhoneNumber(),reqSignUp.getPassword()));
    }
    @GetMapping("me")
    public HttpEntity<?> userMe(@CurrentUser User user){
        return  ResponseEntity.ok(user);
    }
}
