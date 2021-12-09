package com.myapp.tremplist_update;

import java.util.List;

public class Ride {

    // private int id;
    private String src_city;
    private String src_details;
    private String dst_city;
    private String dst_details;
    private User Driver;
    private List<User> tremplists;


    private Date date;
    private Hour hour;

    private String car_type;
    private String car_color;
    private int sits;
    private int free_sits;
    private int ride_cost;

    static int counter_of_drives = 0;

    public Ride() {
    }

    public Ride(String src, String dst, Date date, Hour hour, int sits, int cost) {
        this.src_city = src;
        this.dst_city = dst;
        this.date = date;
        this.hour = hour;
        this.sits = sits;
        this.free_sits = sits;
        this.ride_cost = cost;
        //this.id = counter_of_drives++;
        this.src_details = "";
        this.dst_details = "";
        this.car_color = "";
        this.car_type = "";
    }

    public Ride(String src, String src_details, String dst, String dst_details, Date date, Hour hour, int sits, int cost, String car_color, String car_type) {
        this.src_city = src;
        this.dst_city = dst;
        this.date = date;
        this.hour = hour;
        this.sits = sits;
        this.free_sits = sits;
        this.ride_cost = cost;
        //this.id = counter_of_drives++;
        this.src_details = src_details;
        this.dst_details = dst_details;
        this.car_color = car_color;
        this.car_type = car_type;
    }

//    public Ride(Date date, String dst, int free_sits, Hour hour,int id, int cost, int sits, String src_city) {
//        this.src_city = src;
//        this.dst_city = dst;
//        this.date = date;
//        this.hour = hour;
//        this.sits = sits;
//        this.free_sits=sits;
//        this.ride_cost = cost;
//        this.id = counter_of_drives++;
//    }

    public String getSrc_city() {
        return src_city;
    }

    public void setSrc_city(String src_city) {
        this.src_city = src_city;
    }

    public String getSrc_details() {
        return src_details;
    }

    public void setSrc_details(String src_details) {
        this.src_details = src_details;
    }

    public String getDst_city() {
        return dst_city;
    }

    public void setDst_city(String dst_city) {
        this.dst_city = dst_city;
    }

    public String getDst_details() {
        return dst_details;
    }

    public void setDst_details(String dst_details) {
        this.dst_details = dst_details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public int getSits() {
        return sits;
    }

    public void setSits(int sits) {
        this.sits = sits;
    }

    public int getFree_sits() {
        return free_sits;
    }

    public void setFree_sits(int free_sits) {
        this.free_sits = free_sits;
    }

    public int getRide_cost() {
        return ride_cost;
    }

    public void setRide_cost(int ride_cost) {
        this.ride_cost = ride_cost;
    }

//    public int getId(){
//        return id;
//    }


}
