package com.codewitharjun.springboot.crud.service;

import com.codewitharjun.springboot.crud.exception.UserNotFoundException;
import com.codewitharjun.springboot.crud.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getStudents();

    public Student getStudentById(Long studentId) throws UserNotFoundException;

    public void deleteStudentById(Long studentId) throws UserNotFoundException;

    public Student updateStudent(Long studentId, Student student);

    public Student getStudentByName(String studentName);
}
