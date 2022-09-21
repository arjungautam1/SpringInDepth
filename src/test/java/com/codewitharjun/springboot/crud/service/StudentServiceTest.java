package com.codewitharjun.springboot.crud.service;

import com.codewitharjun.springboot.crud.model.Student;
import com.codewitharjun.springboot.crud.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student =
                Student.builder()
                        .stuName("Arjun")
                        .stuAddress("Kathmandu")
                        .stuClass("10")
                        .stuId(1L)
                        .build();
        Mockito.when(studentRepository.findByStuNameIgnoreCase("Arjun"))
                .thenReturn(student);
    }

    @Test
    @DisplayName("Get data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String studentName = "Arjun";
        Student found =
                studentService.getStudentByName(studentName);
        assertEquals(studentName, found.getStuName());
    }
}