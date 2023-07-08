package com.sachet.AuthService.models;

public class ExtractedToken {
    private final String userName;
    private final String email;

    public ExtractedToken(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
