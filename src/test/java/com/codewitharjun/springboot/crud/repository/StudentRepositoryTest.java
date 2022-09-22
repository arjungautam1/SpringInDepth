package com.codewitharjun.springboot.crud.repository;

import com.codewitharjun.springboot.crud.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Student student=
                Student.builder()
                        .stuName("Arjun Gautam")
                        .stuClass("10")
                        .stuAddress("Kathmandu")
                        .build();
        entityManager.persist(student);
    }
    @Test
    public void whenGetById_thenReturnDepartment(){
        Student student=
                studentRepository.findById(1L).get();
        assertEquals(student.getStuName(),"Arjun Gautam");
    }
}