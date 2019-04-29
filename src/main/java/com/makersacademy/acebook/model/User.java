package com.makersacademy.acebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    private User() {

    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = this.setPassword(password);
    }

    public String setPassword(String password) {
       return this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

}

