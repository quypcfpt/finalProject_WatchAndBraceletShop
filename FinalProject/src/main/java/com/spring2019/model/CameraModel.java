package com.spring2019.model;

import com.google.gson.annotations.Expose;

public class CameraModel {

    @Expose
    private int id;
    @Expose
    private String description;
    @Expose
    private String position;
    @Expose
    private Integer observerStatus;
    @Expose
    private Integer order;
    @Expose
    private String resource;
//    @Expose
////    private StreetModel street;
    @Expose
    private boolean isActive;
    @Expose
    private String imgUrl;
    @Expose
    private String time;

    public CameraModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getObserverStatus() {
        return observerStatus;
    }

    public void setObserverStatus(Integer observerStatus) {
        this.observerStatus = observerStatus;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
//
//    public StreetModel getStreet() {
//        return street;
//    }
//
//    public void setStreet(StreetModel street) {
//        this.street = street;
//    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}