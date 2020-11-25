package com.tip.lunchbox.model.server.response;

// Required for Moshi
@SuppressWarnings("unused")
//Response for both signup and login endpoints
public class Tokens {
    private String auth_token;
    private String refresh_token;

    public String getAuthToken() {
        return auth_token;
    }

    public String getRefreshToken() {
        return refresh_token;
    }
}
