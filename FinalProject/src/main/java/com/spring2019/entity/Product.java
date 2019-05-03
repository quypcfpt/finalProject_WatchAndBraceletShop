package com.spring2019.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "Description", nullable = false, length = 255)
    private String description;
    @Basic
    @Column(name = "Image", nullable = false)
    private String imge;
    @Basic
    @Column(name = "Price", nullable = false)
    private float price;
    @Basic
    @Column(name = "WireTypeId", nullable = false)
    private int wireTypeId;
    @Basic
    @Column(name = "GlassTypeId", nullable = false)
    private int glassTypeId;
    @Basic
    @Column(name = "MachineTypeId", nullable = false)
    private int machineTypeId;
    @Basic
    @Column(name = "LabelId", nullable = false)
    private int labelId;
    @Basic
    @Column(name = "OriginId", nullable = false)
    private int originId;
    @Basic
    @Column(name = "Status", nullable = false)
    private int status;
    @Basic
    @Column(name = "ProductCode", nullable = false, length = 255)
    private String productCode;
    @Basic
    @Column(name = "StockAmount", nullable = false, length = 255)
    private int stockAmount;
    @Basic
    @Column(name = "StockIn", nullable = false, length = 255)
    private int stockIn;
    @Basic
    @Column(name = "StockOut", nullable = false, length = 255)
    private int stockOut;
    @Basic
    @Column(name = "CategoryId", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "Active", nullable = false)
    private boolean active;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWireTypeId() {
        return wireTypeId;
    }

    public void setWireTypeId(int wireTypeId) {
        this.wireTypeId = wireTypeId;
    }

    public int getGlassTypeId() {
        return glassTypeId;
    }

    public void setGlassTypeId(int glassTypeId) {
        this.glassTypeId = glassTypeId;
    }

    public int getMachineTypeId() {
        return machineTypeId;
    }

    public void setMachineTypeId(int machineTypeId) {
        this.machineTypeId = machineTypeId;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public int getStockIn() {
        return stockIn;
    }

    public void setStockIn(int stockIn) {
        this.stockIn = stockIn;
    }

    public int getStockOut() {
        return stockOut;
    }

    public void setStockOut(int stockOut) {
        this.stockOut = stockOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 &&
                wireTypeId == product.wireTypeId &&
                glassTypeId == product.glassTypeId &&
                machineTypeId == product.machineTypeId &&
                labelId == product.labelId &&
                originId == product.originId &&
                status == product.status &&
                categoryId == product.categoryId &&
                active == product.active &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(imge, product.imge) &&
                Objects.equals(productCode, product.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imge, price, wireTypeId, glassTypeId, machineTypeId, labelId, originId, status, productCode, categoryId, active);
    }
}
