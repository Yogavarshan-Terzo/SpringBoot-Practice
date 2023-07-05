package com.springdemo.practice;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Do batting practice for 15 minutes now!!!";
    }
}
