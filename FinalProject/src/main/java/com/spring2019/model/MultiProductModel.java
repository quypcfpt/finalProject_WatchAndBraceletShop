package com.spring2019.model;

import com.google.gson.annotations.Expose;
import com.spring2019.entity.Product;

import java.util.List;

public class MultiProductModel {
    @Expose
    private List<ProductModel> listProduct;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiProductModel() {
    }

    public List<ProductModel> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductModel> listProduct) {
        this.listProduct = listProduct;
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
