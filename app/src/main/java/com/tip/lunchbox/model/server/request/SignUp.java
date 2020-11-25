package com.tip.lunchbox.model.server.request;


/**
 * This class represents a request made to the SignUp endpoint of the api
 * Username represents username of the user
 * password represents password of the user
 * phone represents phone number of the user.
 **/
// Required for Moshi
@SuppressWarnings("unused")
public class SignUp {
    private String username;
    private String password;
    private long phone;

    public SignUp(String username, String password, long phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
}
