package com.codewitharjun.springboot.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/* Created by Arjun Gautam */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stuId;
    @NotNull(message = "User name shouldn't be null. ")
    private String stuName;
    @NotNull(message = "Student address shouldn't be null.")
    private String stuAddress;
    private String stuClass;

}
