package com.example.student.Service;

import com.example.student.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    List<Student> findAll();
}
