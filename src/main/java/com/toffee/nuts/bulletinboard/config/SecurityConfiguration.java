package com.toffee.nuts.bulletinboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/*
*
* .authorizeRequests() → .authorizeHttpRequests()
.antMatchers() → .requestMatchers()
.access("hasAnyRole('ROLE_A','ROLE_B')") → .hasAnyRole("A", "B")
* */
@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().disable();// h2 콘솔 사용하기위해서 clickjaccking공격을 막는 건 disable.

        return http.authorizeHttpRequests()
                //.requestMatchers("/","/login").permitAll()
                .requestMatchers("/member/**").authenticated()
                .requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN") //매니저, 관리자 사용가능
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/h2-console/**","/home","/").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/", true)
                //.successHandler(new LoginSuccessHandler("/"))
                .failureUrl("/fail")
                .loginPage("/login")
                .loginProcessingUrl("/loginProc")
                .and().build();

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
