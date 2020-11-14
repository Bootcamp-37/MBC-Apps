/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ZFH
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    
    @GetMapping("/index")
    public String index() {
        return "index.html";
    }
    
    @GetMapping("/register")
    public String register(){
        return "register.html";
    }
    
    @GetMapping("/table_employee")
    public String employee(){
        return "table_employee";
    }
    @GetMapping("/basic_table")
    public String basic_table(){
        return "basic_table";
    }
    @GetMapping("/table_request")
    public String request(){
        return "table_request";
    }
    @GetMapping("/table_appointment")
    public String appointment(){
        return "table_appointment";
    }
    @GetMapping("/table_result")
    public String result(){
        return "table_result";
    }
}
