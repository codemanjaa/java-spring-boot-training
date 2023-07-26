package com.springmanja.rest.spring.entity;

public class Vendor {
    private int id;
    private String vendorName;

    public Vendor(){
    }

    public Vendor(int id, String vendorName){
        this.id = id;
        this.vendorName = vendorName;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setVendorName(String vendorName){
        this.vendorName = vendorName;
    }

    public int getId(){
        return this.id;
    }

    public String getVendorName(){
        return this.vendorName;
    }
}
