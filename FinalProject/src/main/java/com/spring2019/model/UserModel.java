package com.spring2019.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;

public class UserModel {
    @Expose
    private Integer id;
    @Expose
    private String username;
    @Expose
    private String password;
    @Expose
    private String lastName;
    @Expose
    private String middleName;
    @Expose
    private String firstName;
    @Expose
    private String phone;
    @Expose
    private String email;
    @Expose
    private int status;
    @Expose
    private int roleId;
    @Expose
    private String confirmPassword;
    @Expose
    private String oldPassword;

    public UserModel() {
    }

    public UserModel(Integer id, String username, String password, String lastName, String middleName, String firstName, String phone, String email, int status, int roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.roleId = roleId;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
