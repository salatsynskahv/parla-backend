package com.parla.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class User {

    @Id
    private String id;

    private String username;
    private String firstName;
    private String password;

    private String email;

    private List<String> roles = new ArrayList<>();

    public User(String username, String password, String email, List<String> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "username: " + username + " email " + email +" roles "+ String.join(" ", roles);
    }
}
