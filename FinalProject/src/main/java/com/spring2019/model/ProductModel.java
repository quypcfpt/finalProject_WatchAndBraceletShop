package com.spring2019.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;

public class ProductModel {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private long price;
    @Expose
    private String image;
    @Expose
    private int wireTypeId;
    @Expose
    private int glassTypeId;
    @Expose
    private int machineTypeId;
    @Expose
    private Integer labelId;
    @Expose
    private int originId;
    @Expose
    private int status;
    @Expose
    private String productCode;
    @Expose
    private int stockAmount;
    @Expose
    private int stockIn;
    @Expose
    private int stockOut;
    @Expose
    private int categoryId;
    @Expose
    private boolean active;

    @Expose
    private String wireType;

    @Expose
    private String glassType;

    @Expose
    private String machineType;

    @Expose
    private String label;

    @Expose
    private String origin;

    public ProductModel() {

    }

    public ProductModel(Integer id, String name, String description, long price, String image, int wireTypeId, int glassTypeId, int machineTypeId, int labelId, int originId, int status, String productCode, int stockAmount, int stockIn, int stockOut, int categoryId, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.wireTypeId = wireTypeId;
        this.glassTypeId = glassTypeId;
        this.machineTypeId = machineTypeId;
        this.labelId = labelId;
        this.originId = originId;
        this.status = status;
        this.productCode = productCode;
        this.stockAmount = stockAmount;
        this.stockIn = stockIn;
        this.stockOut = stockOut;
        this.categoryId = categoryId;
        this.active = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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

    public void setLabelId(Integer labelId) {
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
}
