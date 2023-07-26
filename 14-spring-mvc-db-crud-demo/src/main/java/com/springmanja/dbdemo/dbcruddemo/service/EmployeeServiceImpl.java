package com.springmanja.dbdemo.dbcruddemo.service;

import com.springmanja.dbdemo.dbcruddemo.entity.Employee;
import com.springmanja.dbdemo.dbcruddemo.rest.EmployeeNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmanja.dbdemo.dbcruddemo.dao.EmployeeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;

    }

    public List<Employee> findAll(){
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id){
        
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if(result.isPresent()){
            employee= result.get();
        }
        else {
            throw new EmployeeNotFoundException("Employee not found "+id);
        }
        return employee;
        
        
      //  return  employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }






}
