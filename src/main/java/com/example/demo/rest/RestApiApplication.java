package com.example.demo.rest;

import com.example.demo.entity.Student;
import com.example.demo.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class RestApiApplication {

    @Autowired
    StudentService studentService;


    @PostMapping(value = "/saveStudent")
    public void saveStudent(int course, String surName, String name) {
        Student student = new Student(course, name, surName);
        studentService.saveAndFlush(student);
    }

    @GetMapping(value = "/byId")
    public Optional<Student> byId(Integer id) {
        return studentService.findById(id);
    }

    @GetMapping(value = "/findAll")
    public List<Student> findAll() {
        return studentService.findAll().stream()
                .sorted(Comparator.comparing(Student::getId))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/update")
    public void update(Integer id, Integer course, String firstName, String lastName) {
        Student student = new Student(course, firstName, lastName);
        student.setId(id);
        studentService.saveAndFlush(student);
    }

    @DeleteMapping(value = "/delete")
    public void delete(Student student) {
        studentService.delete(student);
    }

}
