package com.example.ManyToMany.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Course {
    @Id
    @Column(name = "c_id")
    private int id;
    private String name;

    @JsonManagedReference
    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList();

}
