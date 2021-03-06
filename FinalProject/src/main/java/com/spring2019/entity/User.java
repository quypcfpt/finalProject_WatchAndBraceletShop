package com.spring2019.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "[User]")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Username", nullable = false, length = 50)
    private String username;
    @Basic
    @Column(name = "Password", nullable = false, length = 16)
    private String password;
    @Basic
    @Column(name = "LastName", nullable = false,length = 50)
    private String lastName;
    @Basic
    @Column(name = "MiddleName", nullable = false,length = 50)
    private String middleName;
    @Basic
    @Column(name = "FirstName", nullable = false,length = 50)
    private String firstName;
    @Basic
    @Column(name = "Phone", nullable = false,length = 20)
    private String phone;
    @Basic
    @Column(name = "Email", nullable = false,length = 50)
    private String email;
    @Basic
    @Column(name = "Status", nullable = false)
    private int status;
    @Basic
    @Column(name = "RoleId", nullable = false)
    private int roleId;

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

    public void setMiddleName(String  middleName) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return status == user.status &&
                roleId == user.roleId &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(middleName, user.middleName) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, lastName, middleName, firstName, phone, email, status, roleId);
    }
}
