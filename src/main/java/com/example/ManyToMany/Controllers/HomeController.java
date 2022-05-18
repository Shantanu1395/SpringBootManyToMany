package com.example.ManyToMany.Controllers;

import com.example.ManyToMany.Models.Course;
import com.example.ManyToMany.Models.Student;
import com.example.ManyToMany.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    SchoolService schoolService;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        return schoolService.createStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getStudents(){
        return schoolService.getAllStudents();
    }

    @GetMapping("/course")
    public List<Course> getCourses(){
        return schoolService.getAllCourses();
    }

    @PostMapping("/createTestData")
    public void createTestData(){
        schoolService.createTestData();
    }

}
