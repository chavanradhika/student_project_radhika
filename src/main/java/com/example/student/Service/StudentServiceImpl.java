package com.example.student.Service;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository repository;


    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }


    @Override
    public Student create(Student student) {
      return repository.save(student);
    }


    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

}
