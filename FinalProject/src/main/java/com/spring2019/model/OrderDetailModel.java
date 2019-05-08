package com.spring2019.model;

import com.google.gson.annotations.Expose;
import com.spring2019.entity.Product;

import javax.persistence.*;
import java.util.Objects;

public class OrderDetailModel {
    @Expose
    private Integer id;
    @Expose
    private Integer productId;
    @Expose
    private Integer orderId;
    @Expose
    private float price;
    @Expose
    private int quantity;
    @Expose
    private ProductModel product;
    @Expose
    private OrderModel orderModel;
    @Expose
    private float totalPrice;

    public OrderDetailModel(Integer id, Integer productId, Integer orderId, float price, int quantity) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetailModel() {

    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }
}
