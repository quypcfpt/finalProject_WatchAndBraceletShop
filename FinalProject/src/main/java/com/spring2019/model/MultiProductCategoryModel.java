package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiProductCategoryModel {
    @Expose
    private List<ProductCategoryModel> listProductCategory;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiProductCategoryModel() {
    }

    public List<ProductCategoryModel> getListProductCategory() {
        return listProductCategory;
    }

    public void setListProductCategory(List<ProductCategoryModel> listProductCategory) {
        this.listProductCategory = listProductCategory;
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
