package com.spring2019.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;

public class MachineTypeModel {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private boolean active;

    public MachineTypeModel() {
    }

    public MachineTypeModel(Integer id, String name, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
