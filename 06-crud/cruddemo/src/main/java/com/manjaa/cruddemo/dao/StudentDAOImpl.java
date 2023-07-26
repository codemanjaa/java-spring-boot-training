package com.manjaa.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manjaa.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public List<Student> findAll() {
        // create the query
        //TypedQuery<Student> theQuery = entityManager.createNamedQuery("FROM Student", Student.class);
        TypedQuery<Student> theQuery =entityManager.createQuery("FROM Student", Student.class);    
        // return the query result
        return theQuery.getResultList();
      }

    @Override
    public List<Student> findByLastname(String lastName) {
        
        // create the query
        TypedQuery<Student> lastNameQuery = entityManager.createQuery("FROM Student WHERE lastName=:theParam", Student.class); 

        // Set the query param
        lastNameQuery.setParameter("theParam", lastName);

        // display the result
        return lastNameQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        
        // retrieve the record
        Student student = entityManager.find(Student.class, id);
        // delete the record
       entityManager.remove(student);
    }

}