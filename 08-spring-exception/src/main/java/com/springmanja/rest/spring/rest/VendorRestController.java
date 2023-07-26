package com.springmanja.rest.spring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmanja.rest.spring.entity.Vendor;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class VendorRestController {
private List<Vendor> theVendors;

@PostConstruct
public void loadData(){
    theVendors = new ArrayList<>();
    theVendors.add(new Vendor(1, "DataZentist"));
    theVendors.add(new Vendor(2, "JYU"));
    }

@GetMapping("/vendors")
public List<Vendor> getVendors(){
    return theVendors;
}

// Path variables retrieve a single entity {vendorId}
@GetMapping("/vendors/{vendorId}")
public Vendor getVendor(@PathVariable int vendorId){
    if((vendorId >= theVendors.size()) || (vendorId < 0)){
        throw new VendorNotFoundException("Vendor Id not found - "+ vendorId);
    }
    return theVendors.get(vendorId);
    }   

    // Add an exception handler using @ExceptionHandler

  
}
