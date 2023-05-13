package com.example.spring_boot_jwt_token.services;


import com.example.spring_boot_jwt_token.payload.ApiResponse;
import com.example.spring_boot_jwt_token.payload.ApiResponseModel;
import com.example.spring_boot_jwt_token.payload.ReqUser;
import com.example.spring_boot_jwt_token.payload.ResUser;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {
    public List<ResUser> getAllUsers();
    public ResUser getOne(Long id);
    public ApiResponseModel editAndCreateUser(ReqUser reqUser);
    public ApiResponse deleteUser(Long id);
}
