package com.manjaa.spring.demospring.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    public FootballCoach(){
        System.out.println("Constructor "+ getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {
        return "Keep running towards your goal";
     }
    
}
