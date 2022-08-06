package com.crackbyte.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

import java.util.UUID;

import static javax.persistence.InheritanceType.JOINED;

@Getter
@Setter
@Entity(name = "users")
@Inheritance(strategy = JOINED)
public class User extends Base {
    private String uuid;
    private String email;
    private String encryptedPassword;

    public User() {
        this.uuid = UUID.randomUUID().toString();
    }
}
