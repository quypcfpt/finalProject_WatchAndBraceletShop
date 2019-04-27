package com.spring2019.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "ProductId", nullable = false)
    private Integer productId;
    @Basic
    @Column(name = "OrderId", nullable = false)
    private Integer orderId;
    @Basic
    @Column(name = "Price", nullable = false)
    private float price;
    @Basic
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "TotalPrice", nullable = false)
    private float totalPrice;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return Float.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                Float.compare(that.totalPrice, totalPrice) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, orderId, price, quantity, totalPrice);
    }
}
