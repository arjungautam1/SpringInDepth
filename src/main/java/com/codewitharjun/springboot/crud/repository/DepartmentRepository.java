package com.codewitharjun.springboot.crud.repository;

import com.codewitharjun.springboot.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Student,Long> {

}
