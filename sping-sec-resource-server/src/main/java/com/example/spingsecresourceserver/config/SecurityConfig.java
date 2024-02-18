package com.example.spingsecresourceserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${jwks.issuer.uri}")
    private String jwksIssuerUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults());
        http.oauth2ResourceServer(configurer -> configurer.jwt(
                jwtConfigurer -> jwtConfigurer.jwkSetUri(jwksIssuerUri).jwtAuthenticationConverter(new CustomJwtAuthenticationConverter())));

        return http.build();
    }
}
