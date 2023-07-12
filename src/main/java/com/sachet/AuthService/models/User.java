package com.sachet.AuthService.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @Id
    private String id;
    private String name;
    @NotBlank(message = "UserName cannot be blank!")
    @Size(min = 5, max = 255, message = "UserName cannot be less than 5 and more than 10 characters!")
    private String userName;
    @NotBlank(message = "Email cannot be blank!")
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Please Enter a valid email!")
    private String email;
    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 5, max = 10, message = "Password cannot be less than 5 and more than 10 characters")
    private String password;
    List<String> roles;

    public User() {
    }

    public User(String name, String userName, String email, String password, List<String> roles) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", userName='" + userName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", roles=" + roles +
            '}';
    }
}
