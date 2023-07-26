package com.springmanja.rest.spring.rest;

public class VendorErrorResponse {
    private int status;
    private String message;
    private long timeStamp;


    public VendorErrorResponse(){

    }

    public VendorErrorResponse(int status, String message, long timeStamp){
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public void setMessage(String message){
        this.message = message;
    }
    public void setTimeStamp(long timeStamp){
        this.timeStamp = timeStamp;
    }

    public int getstatus(){
        return this.status;
    }

    public String getMessage(){
        return this.message;
    }

    public long getTimeStamp(){
        return this.timeStamp;
    }



    
}
