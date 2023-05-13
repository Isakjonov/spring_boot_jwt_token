package com.example.spring_boot_jwt_token.services;

import com.example.spring_boot_jwt_token.entitys.User;
import com.example.spring_boot_jwt_token.payload.ApiResponse;
import com.example.spring_boot_jwt_token.payload.ApiResponseModel;
import com.example.spring_boot_jwt_token.payload.ReqUser;
import com.example.spring_boot_jwt_token.payload.ResUser;
import com.example.spring_boot_jwt_token.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<ResUser> getAllUsers() {
        List<User> allByOrderByFullNameDesc = userRepository.findAllByOrderByUsernameDesc();
        List<ResUser> collect = allByOrderByFullNameDesc.stream().map(ResUser::new).collect(Collectors.toList());
        return collect;
    }

    @Override
    public ResUser getOne(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()){
            User user = byId.get();
            return new ResUser(user);
        }else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'id' when calling updateUser");
        }
    }

    @Override
    public ApiResponseModel editAndCreateUser(ReqUser reqUser) {
        Optional<User> byId =Optional.empty();
        if (reqUser.getId()!=null){
            byId=userRepository.findById(reqUser.getId());
        }
        User user;
        if (byId.isPresent()){
            user = byId.get();
        }else {
            if (reqUser.getId()!=null){
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Id topilmadi");
            }
            user=new User();
        }
        user.setUsername(reqUser.getUsername());
        user.setPhoneNumber(reqUser.getPhoneNumber());
        User save = userRepository.save(user);

        return new ApiResponseModel(true,byId.isPresent()?"O`zgartrildi!!!":"Saqlandi",new ResUser(save));
    }

    @Override
    public ApiResponse deleteUser(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()){
            userRepository.deleteById(id);
            return new ApiResponse(true,"User o`chirildi");
        }else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'id' when calling updateUser");
        }
    }
}
