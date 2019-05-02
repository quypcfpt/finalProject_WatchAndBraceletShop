package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiWireTypeModel {
    @Expose
    private List<WireTypeModel> listWireType;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiWireTypeModel() {
    }

    public List<WireTypeModel> getListWireType() {
        return listWireType;
    }

    public void setListWireType(List<WireTypeModel> listWireType) {
        this.listWireType = listWireType;
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
