package com.spring2019.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Label {
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
    @Column(name = "Status", nullable = false)
    private int status;
    @Basic
    @Column(name = "Active", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Label)) return false;
        Label label = (Label) o;
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
