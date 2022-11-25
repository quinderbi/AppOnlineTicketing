package com.datscie.apponlineticketing.model.auth;

public abstract class Auth {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public Auth() {}

    protected Auth(String id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
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

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String email, String password) {
        return false;
    }

    public void register(String name, String email, String phone, String password) {}
}
