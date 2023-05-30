package com.lab3.mybatis.po;

import lombok.Data;

@Data
public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String phone;
    public User(int userID, String username, String password, String email, String phone) {
        this.userID = userID; this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
