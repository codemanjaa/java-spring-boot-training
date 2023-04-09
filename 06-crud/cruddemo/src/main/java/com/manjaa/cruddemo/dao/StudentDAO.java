package com.manjaa.cruddemo.dao;

import com.manjaa.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
}
