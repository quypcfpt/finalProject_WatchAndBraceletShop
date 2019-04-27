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
    private float price;
    @Expose
    private int wireTypeId;
    @Expose
    private int glassTypeId;
    @Expose
    private int machineTypeId;
    @Expose
    private int labelId;
    @Expose
    private int originId;
    @Expose
    private int status;
    @Expose
    private String productCode;
    @Expose
    private int categoryId;
    @Expose
    private boolean active;

    public ProductModel() {

    }


    public ProductModel(Integer id, String name, String description, float price, int wireTypeId, int glassTypeId, int machineTypeId, int labelId, int originId, int status, String productCode, int categoryId, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.wireTypeId = wireTypeId;
        this.glassTypeId = glassTypeId;
        this.machineTypeId = machineTypeId;
        this.labelId = labelId;
        this.originId = originId;
        this.status = status;
        this.productCode = productCode;
        this.categoryId = categoryId;
        this.active = active;
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
}
