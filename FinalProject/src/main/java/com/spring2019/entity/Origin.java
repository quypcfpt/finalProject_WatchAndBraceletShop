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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Origin)) return false;
        Origin origin = (Origin) o;
        return Objects.equals(id, origin.id) &&
                Objects.equals(name, origin.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
