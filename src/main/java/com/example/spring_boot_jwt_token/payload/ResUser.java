package com.example.spring_boot_jwt_token.payload;

import com.example.spring_boot_jwt_token.entitys.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResUser {
    public ResUser(User user) {
        this.id=user.getId();
        this.username=user.getUsername();
        this.phoneNumber=user.getPhoneNumber();
    }

    private Long id;
    private String username;
    private String phoneNumber;
}
