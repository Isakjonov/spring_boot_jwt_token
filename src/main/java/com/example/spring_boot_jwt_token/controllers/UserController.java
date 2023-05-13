package com.example.spring_boot_jwt_token.controllers;

import com.example.spring_boot_jwt_token.payload.ReqUser;
import com.example.spring_boot_jwt_token.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{id}")
    public HttpEntity<?> getOneUser(@PathVariable(name="id") Long id){

        return ResponseEntity.ok().body(userService.getOne(id));
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping
    public HttpEntity<?> createUser(@RequestBody ReqUser reqUser){
        return ResponseEntity.ok().body(userService.editAndCreateUser(reqUser));
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public HttpEntity<?> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }
}

