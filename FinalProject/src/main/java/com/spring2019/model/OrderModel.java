package com.spring2019.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class OrderModel {
    @Expose
    private Integer id;
    @Expose
    private String customerName;
    @Expose
    private String address;
    @Expose
    private String phone;
    @Expose
    private String email;
    @Expose
    private int status;
    @Expose
    private Float totalPrice;
    @Expose
    private String note;
    @Expose
    private String createDateTime;
    @Expose
    private String paidDateTime;
    @Expose
    private String code;
    @Expose
    private List<OrderDetailModel> list;
    public OrderModel() {
    }

    public OrderModel(Integer id, String customerName, String address, String phone, String email, int status, Float totalPrice, String note, String createDateTime, String paidDateTime) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.totalPrice = totalPrice;
        this.note = note;
        this.createDateTime = createDateTime;
        this.paidDateTime = paidDateTime;
    }

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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
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

    public List<OrderDetailModel> getList() {
        return list;
    }

    public void setList(List<OrderDetailModel> list) {
        this.list = list;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
