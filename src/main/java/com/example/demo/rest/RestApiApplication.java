package com.example.demo.rest;

import com.example.demo.entity.StudentEntity;
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
        StudentEntity student = new StudentEntity(course, name, surName);
        studentService.saveAndFlush(student);
    }

    @GetMapping(value = "/byId")
    public Optional<StudentEntity> byId(Integer id) {
        return studentService.findById(id);
    }

    @GetMapping(value = "/findAll")
    public List<StudentEntity> findAll() {
        return studentService.findAll().stream()
                .sorted(Comparator.comparing(StudentEntity::getId))
                .collect(Collectors.toList());
    }

    @PutMapping(value = "/update")
    public void update(Integer id, Integer course, String firstName, String lastName) {
        StudentEntity student = new StudentEntity(course, firstName, lastName);
        student.setId(id);
        studentService.saveAndFlush(student);
    }

    @DeleteMapping(value = "/delete")
    public void delete(StudentEntity student) {
        studentService.delete(student);
    }

}
