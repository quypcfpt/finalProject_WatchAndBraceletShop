package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class LabelModel {
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String description;
    @Expose
    private String image;
    @Expose
    private int status;
    @Expose
    private  boolean active;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LabelModel)) return false;
        LabelModel label = (LabelModel) o;
        return status == label.status &&
                active == label.active &&
                Objects.equals(id, label.id) &&
                Objects.equals(name, label.name) &&
                Objects.equals(description, label.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, active);
    }
}
