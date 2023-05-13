package com.example.spring_boot_jwt_token.component;

import com.example.spring_boot_jwt_token.entitys.Role;
import com.example.spring_boot_jwt_token.entitys.User;
import com.example.spring_boot_jwt_token.entitys.enums.RoleEnum;
import com.example.spring_boot_jwt_token.repositorys.RoleRepository;
import com.example.spring_boot_jwt_token.repositorys.UserRepository;
import com.example.spring_boot_jwt_token.securitys.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            Role admin = roleRepository.save(new Role(RoleEnum.ADMIN));
            Role user = roleRepository.save(new Role(RoleEnum.USER));
            userRepository.save(new User("admin1","admin1", passwordEncoder.encode("99651"),  Collections.singletonList(admin)));
            userRepository.save(new User("admin2","admin2", passwordEncoder.encode("99652"),  Collections.singletonList(admin)));
            userRepository.save(new User("admin3","admin3", passwordEncoder.encode("99653"),  Collections.singletonList(admin)));
            userRepository.save(new User("user",  "user",   passwordEncoder.encode("99653"),  Collections.singletonList(user)));
        }
    }
}
