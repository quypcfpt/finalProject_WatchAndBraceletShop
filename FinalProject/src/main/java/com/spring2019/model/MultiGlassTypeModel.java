package com.spring2019.model;

import com.google.gson.annotations.Expose;
import com.spring2019.entity.GlassType;

import java.util.List;

public class MultiGlassTypeModel {
    @Expose
    private List<GlassTypeModel> listGlassType;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiGlassTypeModel() {
    }

    public List<GlassTypeModel> getListGlassType() {
        return listGlassType;
    }

    public void setListGlassType(List<GlassTypeModel> listGlassType) {
        this.listGlassType = listGlassType;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
