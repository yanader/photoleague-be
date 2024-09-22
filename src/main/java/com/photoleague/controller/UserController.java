package com.photoleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    DataSource datasource;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/public/users")
    public String createUser(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String role) {
        JdbcUserDetailsManager userDetailsManager
                = new JdbcUserDetailsManager(datasource);

        if (userDetailsManager.userExists(username)) {
            return "User already exists!";
        }

        UserDetails user = User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles(role)
                .build();

        userDetailsManager.createUser(user);

        return "User created successfully";
    }

    @GetMapping("/user-info")
    public Map<String, Object> getUser(
            @AuthenticationPrincipal OAuth2User principal) {
        return principal.getAttributes();
    }
}
