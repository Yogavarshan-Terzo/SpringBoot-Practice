package com.springdemo.practice;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice batting for 15 mins now";
    }
}
