package com.rchores.rchores.models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User (String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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
