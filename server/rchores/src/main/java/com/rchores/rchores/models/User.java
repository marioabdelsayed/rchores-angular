package com.rchores.rchores.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usersTable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    
    @Column(unique = true)
    private String email;
    private String password;

    public User (String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId(){
        return this.id;
    }
    
    public String getUsername(){
        return this.firstName;
    }

    public String getName (){
        return (this.firstName + this.lastName);
    }

    public String getEmail(){
        return this.email;
    }
    public void setPassword(String newPass){
        this.password = newPass;
    }

    public String getPassword(){
        return this.password;
    }
}
