/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.model;

/**
 *
 * @author Quy
 */

public class Order {
    private int id;
    private String customerId;
    private String customerName;
    private String address;
    private String phone;
    private String email;
    private String Status;
    private double money;
    private String note;
    private String createDateTime;
    private String paiddateTime;

    public Order(int id, String customerId, String customerName, String address, String phone, String email, String Status, double money, String note, String createDateTime, String paiddateTime) {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.Status = Status;
        this.money = money;
        this.note = note;
        this.createDateTime = createDateTime;
        this.paiddateTime = paiddateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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

    public String getPaiddateTime() {
        return paiddateTime;
    }

    public void setPaiddateTime(String paiddateTime) {
        this.paiddateTime = paiddateTime;
    }
    
    
    
}
