package com.example.ManyToMany.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "s_id")
    private int id;
    private String name;


    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "student_enrolled_courses",
        joinColumns = {@JoinColumn(name = "s_id")},
        inverseJoinColumns = {@JoinColumn(name = "c_id")}
    )
    List<Course> courses = new ArrayList();

}
