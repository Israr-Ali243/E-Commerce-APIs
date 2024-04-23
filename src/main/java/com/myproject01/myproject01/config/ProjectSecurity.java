//package com.myproject01.myproject01.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class ProjectSecurity {
//
//    @Bean
//    public SecurityFilterChain FilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/user/id")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//        return httpSecurity.build();
//    }
//}
