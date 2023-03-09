package com.toffee.nuts.bulletinboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


/*
*
* .authorizeRequests() → .authorizeHttpRequests()
.antMatchers() → .requestMatchers()
.access("hasAnyRole('ROLE_A','ROLE_B')") → .hasAnyRole("A", "B")
* */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    /*    return http.authorizeHttpRequests()
                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN") //매니저, 관리자 사용가능
                .requestMatchers("/admin/**").hasRole("ADMIN");
    */
        return null;
    }
}
