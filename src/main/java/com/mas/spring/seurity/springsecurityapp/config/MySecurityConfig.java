package com.mas.spring.seurity.springsecurityapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(auth->auth
                .requestMatchers("/hello").authenticated());
        return httpSecurity.build();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*@Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("mukul")
                .password(passwordEncoder().encode("anand"))
                .authorities("read").build();
        userDetailsService.createUser(userDetails);
        return userDetailsService;
    }*/
}
