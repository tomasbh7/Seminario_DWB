package com.product.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.product.config.jwt.JwtAuthFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfig corsConfig) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)

        .authorizeHttpRequests(auth -> auth

            .requestMatchers("/error", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

            .requestMatchers(HttpMethod.GET, "/category/**")
                .hasAnyRole("CUSTOMER", "ADMIN")

            .requestMatchers(HttpMethod.GET, "/product/**")
                .hasAnyRole("CUSTOMER", "ADMIN")

            .anyRequest().hasRole("ADMIN")
        )

        .cors(cors -> cors.configurationSource(corsConfig))

        .formLogin(form -> form.disable())

        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )

        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}