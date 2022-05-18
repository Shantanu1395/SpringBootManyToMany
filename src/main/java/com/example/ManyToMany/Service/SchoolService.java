package com.example.ManyToMany.Service;

import com.example.ManyToMany.Models.Course;
import com.example.ManyToMany.Models.Student;
import com.example.ManyToMany.Repository.CourseRepository;
import com.example.ManyToMany.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void createTestData(){
        Student s1 = new Student(101, "Shantanu", null);
        Student s2 = new Student(102, "Ajay", null);

        Course c1 = new Course(1001, "Database", null);
        Course c2 = new Course(1002, "Networks", null);
        Course c3 = new Course(1003, "Algorithms", null);

        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);

        studentRepository.save(s1);
        studentRepository.save(s2);

        s1.setCourses(Arrays.asList(c1, c2));
        s2.setCourses(Arrays.asList(c2, c3));

//        c1.setStudents(Arrays.asList(s1));
//        c2.setStudents(Arrays.asList(s1, s2));
//        c3.setStudents(Arrays.asList(s2));

//        courseRepository.save(c1);
//        courseRepository.save(c2);
//        courseRepository.save(c3);

        studentRepository.save(s1);
        studentRepository.save(s2);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

}
