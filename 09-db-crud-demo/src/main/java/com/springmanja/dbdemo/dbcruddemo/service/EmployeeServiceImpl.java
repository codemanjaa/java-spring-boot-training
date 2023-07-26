package com.springmanja.dbdemo.dbcruddemo.service;

import com.springmanja.dbdemo.dbcruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.springmanja.dbdemo.dbcruddemo.dao.EmployeeDAO;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;

    }

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id){
        return  employeeDAO.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee){
        return employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id){
        employeeDAO.deleteById(id);
    }






}
