package com.springmanja.dbdemo.dbcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springmanja.dbdemo.dbcruddemo.entity.Employee;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members", collectionResourceRel = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
