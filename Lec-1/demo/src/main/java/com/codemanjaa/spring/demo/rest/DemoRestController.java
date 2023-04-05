package com.codemanjaa.spring.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;;;

@RestController
public class DemoRestController {

    // Handling the properties value
    @Value("${team.name}")
    private String teamName;
    
    @Value("${dev.name}")
    private String devName;

    @GetMapping("/")
    public String sayHello(){
        return "Hello Spring World!";
        
    }   

    @GetMapping("/weather")
    public String getWeather(){
        return "Weather is sunny";
    }

    @GetMapping("/devinfo")
    public String getDevInfo(){
        return "Team is: " +teamName +" Developer is: "+devName;
    }
}
