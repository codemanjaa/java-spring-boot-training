package com.manjaa.cruddemo.dao;

import java.util.List;

import com.manjaa.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastname(String lastName);
    void update(Student student);
    void delete(Integer id);
}
