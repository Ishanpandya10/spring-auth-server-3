package com.practice.springsecauthserver.repository;

import com.practice.springsecauthserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUserName(String username);
}
