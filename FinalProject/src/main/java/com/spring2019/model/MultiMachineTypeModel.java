package com.spring2019.model;

import com.google.gson.annotations.Expose;
import com.spring2019.entity.MachineType;

import java.util.List;

public class MultiMachineTypeModel {
    @Expose
    private List<MachineTypeModel> listMachineType;
    @Expose
    private int totalPage;
    @Expose
    private long totalRecord;
    @Expose
    private int currentPage;

    public MultiMachineTypeModel() {
    }

    public List<MachineTypeModel> getListMachineType() {
        return listMachineType;
    }

    public void setListMachineType(List<MachineTypeModel> listMachineType) {
        this.listMachineType = listMachineType;
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
