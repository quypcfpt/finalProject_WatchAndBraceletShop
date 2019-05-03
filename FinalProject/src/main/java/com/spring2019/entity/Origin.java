package com.spring2019.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "Name", nullable = false , length = 255)
    private String name ;
    @Basic
    @Column(name = "Status", nullable = false , length = 255)
    private int status ;
    @Basic
    @Column(name = "Active", nullable = false , length = 255)
    private boolean active ;

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
        if (!(o instanceof Origin)) return false;
        Origin origin = (Origin) o;
        return active == origin.active &&
                Objects.equals(id, origin.id) &&
                Objects.equals(name, origin.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }
}
