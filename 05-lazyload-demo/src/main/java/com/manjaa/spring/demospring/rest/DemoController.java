package com.manjaa.spring.demospring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjaa.spring.demospring.common.Coach;
import com.manjaa.spring.demospring.common.FootballCoach;

@RestController
public class DemoController {

    
    Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("footballCoach") Coach coach){
        myCoach = coach;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello Spory!!!";
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
