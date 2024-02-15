package com.practice.springsecauthserver.repository;

import com.practice.springsecauthserver.model.AuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthClientRepository extends JpaRepository<AuthClient, Integer> {

    Optional<AuthClient> findByClientId(String clientId);
}
