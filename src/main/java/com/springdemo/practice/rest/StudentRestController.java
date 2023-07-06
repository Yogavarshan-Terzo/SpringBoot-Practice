package com.springdemo.practice.rest;

import com.springdemo.practice.entity.Student;
import com.springdemo.practice.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> studentList = new ArrayList<>();
    @PostConstruct
    public void addData(){
        studentList.add(new Student("Yogavarshan","Sundarraj"));
        studentList.add(new Student("Yusvanth","Subramanian"));
        studentList.add(new Student("Gokul","S"));
    }

    @GetMapping("/student/{studentId}")
    public Student findStudent(@PathVariable int studentId){

        //throw exception if student not found
        if(studentId > studentList.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return studentList.get(studentId);
    }

}
