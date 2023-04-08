package com.manjaa.coredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjaa.util.Vendor;

@RestController
public class DemoController {

    // define the private field for the dependency
    private Vendor myVendor;

    @Autowired
    public DemoController(Vendor theVendor){
        myVendor = theVendor;
    }
    @GetMapping("/quote")
    public String getQuote(){
        return myVendor.getQuote();
    }
    
}
