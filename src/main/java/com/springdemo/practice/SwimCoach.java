package com.springdemo.practice;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In constructor :"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {

        return "Do breathing exercise for 10 minutes";
    }
}
