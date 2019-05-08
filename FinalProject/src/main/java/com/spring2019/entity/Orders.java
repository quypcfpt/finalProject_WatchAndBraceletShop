package com.spring2019.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "CustomerId", nullable = false)
    private Integer custimerId;
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
    private Date createDateTime;
    @Basic
    @Column(name = "PaidDateTime", nullable = false)
    private Date  paidDateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustimerId() {
        return custimerId;
    }

    public void setCustimerId(Integer custimerId) {
        this.custimerId = custimerId;
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

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getPaidDateTime() {
        return paidDateTime;
    }

    public void setPaidDateTime(Date paidDateTime) {
        this.paidDateTime = paidDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) &&
                Objects.equals(custimerId, orders.custimerId) &&
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
        return Objects.hash(id, custimerId, customerName, address, phone, email, status, note, createDateTime, paidDateTime);
    }
}
