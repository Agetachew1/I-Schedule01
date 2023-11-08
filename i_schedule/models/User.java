package com.example.i_schedule.models;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and setters...
    public String getEmail(){
        return this.email;
    }
}
