package com.example.student.web;
import com.example.student.Service.StudentService;
import com.example.student.model.Student;
import com.example.student.repo.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }


    // POST: create a student
    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
        Student saved = service.create(student);
        return ResponseEntity.created(URI.create("/api/students/" + saved.getId())).body(saved);
    }


    // GET: retrieve all students
    @GetMapping
    public List<Student> findAll() {
        return service.findAll();
    }

}
