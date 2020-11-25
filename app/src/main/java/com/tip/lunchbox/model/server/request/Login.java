package com.tip.lunchbox.model.server.request;

// Required for Moshi
@SuppressWarnings("unused")
public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
