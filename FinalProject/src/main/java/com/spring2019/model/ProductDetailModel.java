package com.spring2019.model;

import com.google.gson.annotations.Expose;

public class ProductDetailModel {

    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private String description;

    @Expose
    private float price;

    @Expose
    private String image;

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

    @Expose
    private int status;

    @Expose
    private String productCode;

    @Expose
    private boolean active;

    public ProductDetailModel() {
    }

    public ProductDetailModel(Integer id, String name, String description, float price, String image, String wireType, String glassType, String machineType, String label, String origin, int status, String productCode, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.wireType = wireType;
        this.glassType = glassType;
        this.machineType = machineType;
        this.label = label;
        this.origin = origin;
        this.status = status;
        this.productCode = productCode;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWireType() {
        return wireType;
    }

    public void setWireType(String wireType) {
        this.wireType = wireType;
    }

    public String getGlassType() {
        return glassType;
    }

    public void setGlassType(String glassType) {
        this.glassType = glassType;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
