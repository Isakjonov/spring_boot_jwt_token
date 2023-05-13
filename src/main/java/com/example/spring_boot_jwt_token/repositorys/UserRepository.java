package com.example.spring_boot_jwt_token.repositorys;

import com.example.spring_boot_jwt_token.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByOrderByUsernameDesc();
    Optional<User> findByPhoneNumber(String phoneNumber);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByPhoneNumber(String phoneNumber);
}
