package com.manjaa.spring.demospring.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Keep running towards your goal";
     }
    
}
