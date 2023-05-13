
package com.example.spring_boot_jwt_token.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqSignUp {
    private String username;
    private String phoneNumber;
    private String password;

}
