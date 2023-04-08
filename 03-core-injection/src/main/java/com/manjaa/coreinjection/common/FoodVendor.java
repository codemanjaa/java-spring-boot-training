package com.manjaa.coreinjection.common;

import org.springframework.stereotype.Component;

@Component
public class FoodVendor implements Vendor {

    @Override
    public String getQuote() {
        return "Please submit your Certificates!!!"; 
    }
}