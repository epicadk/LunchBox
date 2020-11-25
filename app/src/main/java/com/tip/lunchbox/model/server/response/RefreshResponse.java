package com.tip.lunchbox.model.server.response;

// Required for Moshi
@SuppressWarnings("unused")
public class RefreshResponse {
    String auth_token;

    public String getAuthToken() {
        return auth_token;
    }
}
