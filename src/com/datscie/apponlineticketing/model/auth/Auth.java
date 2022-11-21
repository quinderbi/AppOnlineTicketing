package com.datscie.apponlineticketing.model.auth;

import com.datscie.apponlineticketing.utils.Encryption;

public class Auth {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private final Encryption encryption;

    public Auth() {
        encryption = Encryption.getInstance();
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

    public void login(String email, String password) {
        try {
            if (email.equals(this.email) && password.equals(encryption.decrypt(this.password))) {
                System.out.println("Login Success");
            } else {
                System.out.println("Login Failed");
            }
        } catch (Exception e) {
            System.out.println("Login Failed " + e.getMessage());
        }
    }

    public void register(String name, String email, String phone, String password) {
        try {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.password = encryption.encrypt(password);
        } catch (Exception e) {
            System.out.println("Failed to encrypt password " + e.getMessage());
        }
    }
}
