package com.example.student.repo;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


//public interface StudentRepository extends JpaRepository<Student s>{}

public interface StudentRepository extends JpaRepository<Student, Long>{

}
