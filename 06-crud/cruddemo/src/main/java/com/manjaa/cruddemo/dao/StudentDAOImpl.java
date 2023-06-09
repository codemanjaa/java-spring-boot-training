package com.manjaa.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manjaa.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // Deine the field for entity manager

    private EntityManager entityManager;

    // inject the entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implements save method


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
       
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

}