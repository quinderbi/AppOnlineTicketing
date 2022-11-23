package com.datscie.apponlineticketing.model.auth;

public abstract class Auth {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public Auth() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public boolean login() {
        return false;
    }

    public boolean register() {
        return false;
    }
}
