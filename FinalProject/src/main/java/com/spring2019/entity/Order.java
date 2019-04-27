package com.spring2019.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Order {
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
    private String  status;
    @Basic
    @Column(name = "TotalPrice", nullable = false)
    private Float  totalPrice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(custimerId, order.custimerId) &&
                Objects.equals(customerName, order.customerName) &&
                Objects.equals(address, order.address) &&
                Objects.equals(phone, order.phone) &&
                Objects.equals(email, order.email) &&
                Objects.equals(status, order.status) &&
                Objects.equals(totalPrice, order.totalPrice) &&
                Objects.equals(note, order.note) &&
                Objects.equals(createDateTime, order.createDateTime) &&
                Objects.equals(paidDateTime, order.paidDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, custimerId, customerName, address, phone, email, status, totalPrice, note, createDateTime, paidDateTime);
    }
}
