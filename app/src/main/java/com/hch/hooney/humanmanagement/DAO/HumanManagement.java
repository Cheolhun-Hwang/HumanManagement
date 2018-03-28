package com.hch.hooney.humanmanagement.DAO;

/**
 * Created by hch on 2018-03-24.
 */

public class HumanManagement {
    private int hm_id;          //*
    private String hm_name;     //*
    private String hm_part;
    private String hm_date;     //*
    private String hm_phone;
    private String hm_address;  //*
    private String hm_spotName; //*
    private double hm_mapX;     //*
    private double hm_mapY;     //*
    private String hm_comment;
    private String hm_mainPhoto;
    private String hm_subPhotos;    //Json Type To String
    private int isNew;              //type 0 : no   type 1 : yes

    public HumanManagement( ) {
        this.hm_id = -1;
        this.hm_name = "";
        this.hm_part = "";
        this.hm_date = "";
        this.hm_phone = "";
        this.hm_address = "";
        this.hm_spotName = "";
        this.hm_mapX = 0.0;
        this.hm_mapY = 0.0;
        this.hm_comment = "";
        this.hm_mainPhoto = "";
        this.hm_subPhotos = "";
        this.isNew = 0;
    }

    public HumanManagement(int hm_id, String hm_name, String hm_part, String hm_date,
                           String hm_phone, String hm_address, String hm_spotName,
                           double hm_mapX, double hm_mapY, String hm_comment,
                           String hm_mainPhoto, String hm_subPhotos, int isNew) {
        this.hm_id = hm_id;
        this.hm_name = hm_name;
        this.hm_part = hm_part;
        this.hm_date = hm_date;
        this.hm_phone = hm_phone;
        this.hm_address = hm_address;
        this.hm_spotName = hm_spotName;
        this.hm_mapX = hm_mapX;
        this.hm_mapY = hm_mapY;
        this.hm_comment = hm_comment;
        this.hm_mainPhoto = hm_mainPhoto;
        this.hm_subPhotos = hm_subPhotos;
        this.isNew = isNew;
    }

    public int getHm_id() {
        return hm_id;
    }

    public void setHm_id(int hm_id) {
        this.hm_id = hm_id;
    }

    public String getHm_name() {
        return hm_name;
    }

    public void setHm_name(String hm_name) {
        this.hm_name = hm_name;
    }

    public String getHm_part() {
        return hm_part;
    }

    public void setHm_part(String hm_part) {
        this.hm_part = hm_part;
    }

    public String getHm_date() {
        return hm_date;
    }

    public void setHm_date(String hm_date) {
        this.hm_date = hm_date;
    }

    public String getHm_phone() {
        return hm_phone;
    }

    public void setHm_phone(String hm_phone) {
        this.hm_phone = hm_phone;
    }

    public String getHm_address() {
        return hm_address;
    }

    public void setHm_address(String hm_address) {
        this.hm_address = hm_address;
    }

    public String getHm_spotName() {
        return hm_spotName;
    }

    public void setHm_spotName(String hm_spotName) {
        this.hm_spotName = hm_spotName;
    }

    public double getHm_mapX() {
        return hm_mapX;
    }

    public void setHm_mapX(double hm_mapX) {
        this.hm_mapX = hm_mapX;
    }

    public double getHm_mapY() {
        return hm_mapY;
    }

    public void setHm_mapY(double hm_mapY) {
        this.hm_mapY = hm_mapY;
    }

    public String getHm_comment() {
        return hm_comment;
    }

    public void setHm_comment(String hm_comment) {
        this.hm_comment = hm_comment;
    }

    public String getHm_mainPhoto() {
        return hm_mainPhoto;
    }

    public void setHm_mainPhoto(String hm_mainPhoto) {
        this.hm_mainPhoto = hm_mainPhoto;
    }

    public String getHm_subPhotos() {
        return hm_subPhotos;
    }

    public void setHm_subPhotos(String hm_subPhotos) {
        this.hm_subPhotos = hm_subPhotos;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }
}
