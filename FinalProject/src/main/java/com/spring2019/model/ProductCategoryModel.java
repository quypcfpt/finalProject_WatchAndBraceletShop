package com.spring2019.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;


public class ProductCategoryModel {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private int status;
    @Expose
    private boolean active;

    public ProductCategoryModel(Integer id, String name, String description, int status, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.active = active;
    }

    public ProductCategoryModel() {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
