package com.example.demo;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentService extends JpaRepository<StudentEntity, Integer> {
}
