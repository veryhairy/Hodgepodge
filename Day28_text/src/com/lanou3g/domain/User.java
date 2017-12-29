package com.lanou3g.domain;

public class User {
    private String username;
    private String gender;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
