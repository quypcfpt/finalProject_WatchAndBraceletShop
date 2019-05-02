package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class DatatableModel {
    @Expose
    private List data;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
