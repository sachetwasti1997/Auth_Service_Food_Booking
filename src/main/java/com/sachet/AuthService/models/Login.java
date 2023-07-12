package com.sachet.AuthService.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Login {

    @NotBlank(message = "Email cannot be blank!")
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Please Enter a valid email!")
    private String userName;

    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 5, max = 10, message = "Password cannot be less than 5 and more than 10 characters")
    private String password;

    public Login() {
    }

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
