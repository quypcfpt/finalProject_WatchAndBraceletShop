package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiAccountModel {
    @Expose
    private List<AccountModel> listAccount;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiAccountModel() {
    }

    public List<AccountModel> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<AccountModel> listAccount) {
        this.listAccount = listAccount;
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
