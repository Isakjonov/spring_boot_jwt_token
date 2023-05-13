package com.example.spring_boot_jwt_token.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqUser {
    private Long id;
    private String username;
    private String phoneNumber;
}
