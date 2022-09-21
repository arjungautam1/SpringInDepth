package com.codewitharjun.springboot.crud.repository;

import com.codewitharjun.springboot.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Student findByStuNameIgnoreCase(String stuName);

}
