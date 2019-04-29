package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiLabelModel {
    @Expose
    private List<LabelModel> listLabel;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiLabelModel() {
    }

    public List<LabelModel> getListLabel() {
        return listLabel;
    }

    public void setListLabel(List<LabelModel> listLabel) {
        this.listLabel = listLabel;
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
