package com.springmanja.dbdemo.dbcruddemo.rest;

import com.springmanja.dbdemo.dbcruddemo.entity.Employee;
import com.springmanja.dbdemo.dbcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/employees")
public class EmployeeRestController {
   
    private EmployeeService employeeService;
   
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
 
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees = employeeService.findAll();
        //add to the spring model
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }   

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theEid, Model theModel){
        Employee theEmployee = employeeService.findById(theEid);
        theModel.addAttribute("employee", theEmployee);
        return "employees/employee-form";

    }

    @GetMapping("/showFormForRemove")
    public String showFormForRemove(@RequestParam("employeeId") int theEid, Model theModel){
        employeeService.deleteById(theEid);
        //theModel.addAttribute("employee", theEmployee);
        return "redirect:/employees/list";

    }



}
