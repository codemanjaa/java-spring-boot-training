package com.springmanja.dbdemo.dbcruddemo.rest;

import com.springmanja.dbdemo.dbcruddemo.entity.Employee;
import java.util.List;
//import com.springmanja.dbdemo.dbcruddemo.dao.EmployeeDAO;
import com.springmanja.dbdemo.dbcruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
   // private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;
    // inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        //this.employeeDAO = employeeDAO;
        this.employeeService = employeeService;
    }
    
    // expose all employee
    @GetMapping("/hello")
    public String hello(){
        return "Hello Mayura>>>";
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        
        Employee employee = employeeService.findById(id);
        if(employee == null ){
            throw new EmployeeNotFoundException("Employee not found "+ id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //just in case user pass an id in json that would be set to 0
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;

    }
   
    @DeleteMapping("/employees")
    public void delete(@PathVariable int id){
        Employee dbEmployee = employeeService.findById(id);
        if(dbEmployee == null){
            throw new EmployeeNotFoundException(" Employee Id "+id);
        }
        employeeService.deleteById(id);

    }

}
