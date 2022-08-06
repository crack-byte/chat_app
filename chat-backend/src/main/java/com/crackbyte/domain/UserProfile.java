package com.crackbyte.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@Entity
public class UserProfile extends User {
    private String firstName;
    private String lastName;
    private short age;
    private String userName;

    public UserProfile() {
        super();
    }

    public UserProfile(String firstName, String lastName, short age, String userName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userName = userName;
    }
}
