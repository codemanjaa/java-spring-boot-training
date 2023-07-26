package com.springmanja.dbdemo.dbcruddemo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class DemoController {

    @GetMapping({
        "/welcome",
        "/hello"
    })
    public String hello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }
    
    @GetMapping("/test")
    public String test(@RequestParam(value = "name",
    defaultValue = "World", required = true) String name, Model model) {
    model.addAttribute("name", name);
    return "hello";
    }
}
