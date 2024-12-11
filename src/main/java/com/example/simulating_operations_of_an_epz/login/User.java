package com.example.simulating_operations_of_an_epz.login;

import java.io.Serializable;

public class User implements Serializable {
    private String email;
    private String password;
    private String usertype;

    public User(String email, String password, String usertype) {
        this.email = email;
        this.password = password;
        this.usertype = usertype;
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

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    public boolean isEmail(String a) {
        return a.equalsIgnoreCase(this.email);
    }
    public boolean isPassword(String a) {
        return a.equals(this.password);
    }
    public boolean isUserType(String a) {
        return a.equals(this.usertype);
    }
}
