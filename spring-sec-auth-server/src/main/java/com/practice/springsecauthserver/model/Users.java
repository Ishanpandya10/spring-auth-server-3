package com.practice.springsecauthserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class Users {

    @Id
    private Integer id;

    private String userName;
    private String password;
    private String authority;

}
