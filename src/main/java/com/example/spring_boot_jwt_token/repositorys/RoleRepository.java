package com.example.spring_boot_jwt_token.repositorys;

import com.example.spring_boot_jwt_token.entitys.Role;
import com.example.spring_boot_jwt_token.entitys.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface RoleRepository extends JpaRepository<Role,Integer> {
    List<Role> findAllByName(RoleEnum name);
}
