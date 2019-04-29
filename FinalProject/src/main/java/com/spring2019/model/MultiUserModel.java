package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiUserModel {
    @Expose
    private List<UserModel> listUser;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiUserModel() {
    }

    public List<UserModel> getListUser() {
        return listUser;
    }

    public void setListUser(List<UserModel> listUser) {
        this.listUser = listUser;
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
