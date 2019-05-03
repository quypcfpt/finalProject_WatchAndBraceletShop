package com.spring2019.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class GlassType {
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
    @Column(name = "Status", nullable = false, length = 255)
    private int status;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GlassType)) return false;
        GlassType glassType = (GlassType) o;
        return active == glassType.active &&
                Objects.equals(id, glassType.id) &&
                Objects.equals(name, glassType.name) &&
                Objects.equals(description, glassType.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, active);
    }
}
