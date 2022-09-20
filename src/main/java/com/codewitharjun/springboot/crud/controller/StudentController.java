package com.codewitharjun.springboot.crud.controller;
/* Created by Arjun Gautam */

import com.codewitharjun.springboot.crud.model.Student;
import com.codewitharjun.springboot.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {

        return studentService.saveStudent(student);
    }


}
