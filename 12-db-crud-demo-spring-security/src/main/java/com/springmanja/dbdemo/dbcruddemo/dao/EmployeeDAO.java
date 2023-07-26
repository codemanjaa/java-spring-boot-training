package com.springmanja.dbdemo.dbcruddemo.dao;

import java.util.List;
import com.springmanja.dbdemo.dbcruddemo.entity.Employee;


public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);

}
