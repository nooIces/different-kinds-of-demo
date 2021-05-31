package com.example.spring.bean;


public class User {

    private String username;

    private String password;

    public User(){
        System.out.println("create user" + System.currentTimeMillis());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
