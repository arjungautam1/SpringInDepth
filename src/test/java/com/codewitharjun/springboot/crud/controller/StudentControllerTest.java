package com.codewitharjun.springboot.crud.controller;

import com.codewitharjun.springboot.crud.model.Student;
import com.codewitharjun.springboot.crud.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = Student.builder()
                .stuAddress("Kathmandu")
                .stuClass("10")
                .stuName("Arjun Gautam")
                .stuId(1L)
                .build();
    }

    @Test
    void saveStudent() throws Exception {
        Student inputStudent = Student.builder()
                .stuAddress("Kathmandu")
                .stuClass("10")
                .stuName("Arjun Gautam")
                .build();
        Mockito.when(studentService.saveStudent(inputStudent))
                .thenReturn(student);

        mockMvc.perform(post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \t  \"stuName\": \"Arjun Gautam\",\n" +
                                "   \t \"stuAddress\": \"Kathmandu\",\n" +
                                "   \t \"stuClass\": \"10\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getStudentById() throws Exception {
        Mockito.when(studentService.getStudentById(1L))
                .thenReturn(student);
        mockMvc.perform(get("/students/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stuName").value(student.getStuName()));

    }
}