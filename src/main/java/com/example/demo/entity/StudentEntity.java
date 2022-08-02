package com.example.demo.entity;

import javax.persistence.*;

@Entity(name = "Students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course")
    private int course;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public StudentEntity(){}

    public StudentEntity(int course, String firstName, String lastName) {
        this.course = course;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public int getCourse() {
        return course;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", course=" + course +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
