package com.example.labb2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)

public class SecurityConfig {


    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails linda = User.builder()
                .username("linda")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("password"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin, linda);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeRequests(
                        auth -> auth
                                .requestMatchers(HttpMethod.GET, "/error").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/geo").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/categories").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/categories/*").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/categories").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/places").authenticated()
                                .requestMatchers(HttpMethod.GET, "/api/places").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/places/search").authenticated()
                                .requestMatchers(HttpMethod.GET, "/api/places/*").authenticated()
                                .requestMatchers(HttpMethod.PATCH, "/api/places/*").authenticated()
                                .requestMatchers(HttpMethod.DELETE, "/api/places/*").authenticated()
                )
                .build();
    }


}