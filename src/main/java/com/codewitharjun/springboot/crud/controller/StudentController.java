package com.codewitharjun.springboot.crud.controller;
/* Created by Arjun Gautam */

import com.codewitharjun.springboot.crud.model.Student;
import com.codewitharjun.springboot.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {

        return studentService.saveStudent(student);
    }
    @GetMapping("/students")
    public List<Student> getStudentList(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return studentService.getStudentById(studentId);
    }


}
