package com.springmanja.rest.spring.rest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    //Add code for the "/hello" endpoint

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Spider";
    }
    
}
