package com.springmanja.dbdemo.dbcruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springmanja.dbdemo.dbcruddemo.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    public List<Employee> findAllByOrderByLastNameAsc();
    
}
