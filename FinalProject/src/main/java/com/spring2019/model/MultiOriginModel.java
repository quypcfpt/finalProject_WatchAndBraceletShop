package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiOriginModel {
    @Expose
    private List<OriginModel> listOrigin;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiOriginModel() {
    }

    public List<OriginModel> getListOrigin() {
        return listOrigin;
    }

    public void setListOrigin(List<OriginModel> listOrigin) {
        this.listOrigin = listOrigin;
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
