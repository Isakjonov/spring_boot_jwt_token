package com.example.spring_boot_jwt_token.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseModel {
    private Boolean success;
    private String message;
    private Object data;
}
