package com.codewitharjun.springboot.crud.service;
/* Created by Arjun Gautam */

import com.codewitharjun.springboot.crud.exception.UserNotFoundException;
import com.codewitharjun.springboot.crud.model.Student;
import com.codewitharjun.springboot.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        try {
            return studentRepository.findById(studentId).get();
        } catch (java.util.NoSuchElementException e) {
            throw new UserNotFoundException("Student with id  " + studentId + " does not exist");
        }
    }

    @Override
    public void deleteStudentById(Long studentId) {
        try{
            studentRepository.deleteById(studentId);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            throw new UserNotFoundException("Student with id  " + studentId + " does not exist");
        }
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {

        Student studentDB = studentRepository.findById(studentId).get();
        if (Objects.nonNull(student.getStuName()) && !"".equalsIgnoreCase(student.getStuName())) {
            studentDB.setStuName(student.getStuName());
        }

        if (Objects.nonNull(student.getStuAddress()) && !"".equalsIgnoreCase(student.getStuAddress())) {
            studentDB.setStuAddress(student.getStuAddress());
        }

        if (Objects.nonNull(student.getStuClass()) && !"".equalsIgnoreCase(student.getStuClass())) {
            studentDB.setStuClass(student.getStuClass());
        }
        return studentRepository.save(studentDB);
    }

    @Override
    public Student getStudentByName(String studentName) {
        return studentRepository.findByStuNameIgnoreCase(studentName);
    }
}
