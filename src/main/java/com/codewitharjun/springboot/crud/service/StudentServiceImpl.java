package com.codewitharjun.springboot.crud.service;
/* Created by Arjun Gautam */

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
        return studentRepository.findById(studentId).get();
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student studentDB = studentRepository.findById(studentId).get();
        if (Objects.nonNull(student.getStuName()) &&
                !"".equalsIgnoreCase(student.getStuName())) {
            studentDB.setStuName(student.getStuName());
        }

        if (Objects.nonNull(student.getStuAddress()) &&
                !"".equalsIgnoreCase(student.getStuAddress())) {
            studentDB.setStuAddress(student.getStuAddress());
        }

        if (Objects.nonNull(student.getStuClass()) &&
                !"".equalsIgnoreCase(student.getStuClass())) {
            studentDB.setStuClass(student.getStuClass());
        }
        return studentRepository.save(studentDB);
    }

    @Override
    public Student getStudentByName(String studentName) {
        return studentRepository.findByStuNameIgnoreCase(studentName);
    }
}
