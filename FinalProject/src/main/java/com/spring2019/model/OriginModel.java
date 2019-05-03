package com.spring2019.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;


public class OriginModel {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private int status;
    @Expose
    private boolean active;
    public OriginModel() {
    }

    public OriginModel(Integer id, String name) {
        this.id = id;
        this.name = name;
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

}
