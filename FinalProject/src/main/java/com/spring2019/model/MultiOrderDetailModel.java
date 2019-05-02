package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiOrderDetailModel {
    @Expose
    private List<OrderDetailModel> listOrderDetail;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiOrderDetailModel() {
    }

    public List<OrderDetailModel> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(List<OrderDetailModel> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
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
