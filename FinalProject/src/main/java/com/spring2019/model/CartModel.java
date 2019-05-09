package com.spring2019.model;

import com.google.gson.annotations.Expose;

public class CartModel {
    @Expose
    private String name;
    @Expose
    private String address;
    @Expose
    private String email;
    @Expose
    private String phone;
    @Expose
    private String cartString;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCartString() {
        return cartString;
    }

    public void setCartString(String cartString) {
        this.cartString = cartString;
    }
}
