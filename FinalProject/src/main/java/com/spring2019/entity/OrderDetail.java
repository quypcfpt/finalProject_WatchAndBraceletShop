package com.spring2019.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ProductId", referencedColumnName = "id")
    private Product productById;
    @ManyToOne
    @JoinColumn(name = "OrderId", referencedColumnName = "id")
    private Orders orderById;
    @Basic
    @Column(name = "Price", nullable = false)
    private float price;
    @Basic
    @Column(name = "Quantity", nullable = false)
    private int quantity;

    public OrderDetail(Product productById, float price, int quantity) {
        this.productById = productById;
        this.price = price;
        this.quantity = quantity;
    }
    public OrderDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProductById() {
        return productById;
    }

    public void setProductById(Product productById) {
        this.productById = productById;
    }

    public Orders getOrderById() {
        return orderById;
    }

    public void setOrderById(Orders orderById) {
        this.orderById = orderById;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return Float.compare(that.price, price) == 0 &&
                quantity == that.quantity &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, quantity);
    }
}
