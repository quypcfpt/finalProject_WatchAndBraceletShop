package com.spring2019.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "[Order]")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "CustomerName", nullable = false, length = 255)
    private String customerName;
    @Basic
    @Column(name = "Address", nullable = false, length = 255)
    private String  address;
    @Basic
    @Column(name = "Phone", nullable = false, length = 255)
    private String  phone;
    @Basic
    @Column(name = "Email", nullable = false, length = 255)
    private String  email;
    @Basic
    @Column(name = "Status", nullable = false, length = 255)
    private int  status;
    @Basic
    @Column(name = "Note", nullable = false, length = 255)
    private String  note;
    @Basic
    @Column(name = "CreateDateTime", nullable = false)
    private String createDateTime;
    @Basic
    @Column(name = "PaidDateTime", nullable = false)
    private String  paidDateTime;
    @Basic
    @Column(name = "Code", nullable = false)
    private String  code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getPaidDateTime() {
        return paidDateTime;
    }

    public void setPaidDateTime(String paidDateTime) {
        this.paidDateTime = paidDateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) &&
                Objects.equals(customerName, orders.customerName) &&
                Objects.equals(address, orders.address) &&
                Objects.equals(phone, orders.phone) &&
                Objects.equals(email, orders.email) &&
                Objects.equals(status, orders.status) &&
                Objects.equals(note, orders.note) &&
                Objects.equals(createDateTime, orders.createDateTime) &&
                Objects.equals(paidDateTime, orders.paidDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, address, phone, email, status, note, createDateTime, paidDateTime);
    }
}
