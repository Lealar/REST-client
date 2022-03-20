package com.epam.rd.izh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private String login;
    private String password;
    private String role;

    public User(String firstName, String lastName, String login, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
