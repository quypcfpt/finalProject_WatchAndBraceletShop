package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiOrderModel {
    @Expose
    private List<OrderModel> listOrder;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiOrderModel() {
    }

    public List<OrderModel> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<OrderModel> listOrder) {
        this.listOrder = listOrder;
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
