package com.photoleague.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/health").permitAll();
                    auth.anyRequest().authenticated(); // Secure all other endpoints
                });
//                .oauth2Login(oath2 -> {
//                    oath2.loginPage("/health").permitAll();
//                });
        return http.build();
    }
}
