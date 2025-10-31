package com.example.student;

import com.example.student.Service.StudentServiceImpl;
import com.example.student.model.Student;
import com.example.student.repo.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplMockitoTest {

    private static final String NAME = "Radhika";
    private static final String CONTACT = "7887927102";
    private static final String EMAIL = "radhika@gmail.com";
    private static final String LOCATION = "Pune";

    @Mock
    private StudentRepository repository;
    @InjectMocks
    private StudentServiceImpl service;

    private Student input;

    @BeforeEach
    void setUp() {
        input = student(null, NAME, CONTACT, EMAIL, LOCATION);
    }

    @Test
    void create_success() {
        // arrange
        when(repository.save(any(Student.class)))
                .thenReturn(student(1L, NAME, CONTACT, EMAIL, LOCATION));

        // act
        Student result = service.create(input);

        // assert
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getEmail()).isEqualTo(EMAIL);

        // verify repository call with captured arg (single capture utility)
        ArgumentCaptor<Student> cap = ArgumentCaptor.forClass(Student.class);
        verify(repository).save(cap.capture());
        assertThat(cap.getValue().getEmail()).isEqualTo(EMAIL);
        verifyNoMoreInteractions(repository);
    }
    private static Student student(Long id, String name, String contact, String email, String location) {
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setContactNumber(contact);
        s.setEmail(email);
        s.setLocation(location);
        return s;
    }
}
