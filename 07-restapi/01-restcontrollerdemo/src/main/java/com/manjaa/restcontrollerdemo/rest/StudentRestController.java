package com.manjaa.restcontrollerdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manjaa.restcontrollerdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mayura", "Selvarajah"));
        students.add(new Student("Mikko", "Docker"));
        students.add(new Student("Mario", "Kuber"));
        return students;
    }
    
}
