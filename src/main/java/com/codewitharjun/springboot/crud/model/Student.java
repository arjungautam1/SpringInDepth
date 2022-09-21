package com.codewitharjun.springboot.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/* Created by Arjun Gautam */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stuId;
    @NotNull(message = "User name shouldn't be null. ")
    private String stuName;
    @NotNull(message = "Student address shouldn't be null.")
    private String stuAddress;
    private String stuClass;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public Student(Long stuId, String stuName, String stuAddress, String stuClass) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAddress = stuAddress;
        this.stuClass = stuClass;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuClass='" + stuClass + '\'' +
                '}';
    }
}
