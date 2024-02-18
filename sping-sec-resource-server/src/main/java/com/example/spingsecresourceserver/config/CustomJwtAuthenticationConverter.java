package com.example.spingsecresourceserver.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, CustomJwtAuthenticationToken> {

    @Override
    public CustomJwtAuthenticationToken convert(Jwt source) {
        List<String> authorities = (List<String>) source.getClaims().get("authorities");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream().map(SimpleGrantedAuthority::new).toList();
        return new CustomJwtAuthenticationToken(source, simpleGrantedAuthorities);
    }

}
