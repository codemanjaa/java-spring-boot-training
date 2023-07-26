package com.springmanja.mvc.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping({
        "/showMyLoginPage"

    })
    public String showMyLoginPage(){
        return "modern-login";
    }

    @GetMapping("/access-denied")
    public String showAcceesDeniedPage(){
        return "access-denied";
    }
    /*
    @PostMapping("/my/logout")
    public String performLogout() {
    // .. perform logout
   return "redirect:/showMyLoginPage";
}
*/
  }
