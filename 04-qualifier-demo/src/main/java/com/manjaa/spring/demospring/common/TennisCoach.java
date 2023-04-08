package com.manjaa.spring.demospring.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "This is a tennis never punish";
    }
        
}
