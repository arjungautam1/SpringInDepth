package com.codewitharjun.springboot.crud.controller;
/* Created by Arjun Gautam */

import com.codewitharjun.springboot.crud.exception.UserNotFoundException;
import com.codewitharjun.springboot.crud.model.Student;
import com.codewitharjun.springboot.crud.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    private final Logger LOGGER=
            LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/student")
    public Student saveStudent(@Valid @RequestBody Student student) {
        LOGGER.info("Inside save student of Student Controller. ");

        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getStudentList() {
        LOGGER.info("Inside get students of Student Controller. ");
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId) throws UserNotFoundException {
        return studentService.getStudentById(studentId);

    }

    @DeleteMapping("students/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId) throws UserNotFoundException{
        studentService.deleteStudentById(studentId);
        return "Student deleted successfully.";
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long studentId,@RequestBody Student student){

        return studentService.updateStudent(studentId,student);
    }
    @GetMapping("/students/name/{name}")
    public Student getStudentByName(@PathVariable("name") String studentName){

        return studentService.getStudentByName(studentName);
    }


}
