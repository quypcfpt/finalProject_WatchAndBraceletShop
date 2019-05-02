package com.spring2019.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class MultiRoleModel {
    @Expose
    private List<RoleModel> listRole;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiRoleModel() {
    }

    public List<RoleModel> getListRole() {
        return listRole;
    }

    public void setListRole(List<RoleModel> listRole) {
        this.listRole = listRole;
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
