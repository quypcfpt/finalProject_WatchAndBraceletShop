package com.spring2019.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Objects;


public class RoleModel {
    @Expose
    private Integer id;
    @Expose
    private String name;

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

    public RoleModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleModel() {
    }
}
