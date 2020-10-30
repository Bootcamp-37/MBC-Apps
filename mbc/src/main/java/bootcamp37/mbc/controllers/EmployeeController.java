/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.controllers;

import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.services.EmployeeServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Deo Lahara
 */

@RequestMapping("employee")
@RestController
public class EmployeeController {
    EmployeeServices employeeServices;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }
    
    @GetMapping("")
    public List<Employee> getAll() {
        return employeeServices.getAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable String id) {
        return employeeServices.getById(id).get();
    }


    @PostMapping("")
    public Employee insert(@RequestBody Employee employee) {
        Employee result = employeeServices.save(employee);
        return result;
    }
    
    @PutMapping("")
    public boolean update(@RequestBody Employee employee){
        return employeeServices.updateEmployee(employee);
    }
    
    @DeleteMapping("{id}")
    public Map<String,String> delete(@PathVariable String id){
        boolean isSuccess = employeeServices.delete(id);
        Map<String, String> status = new HashMap<>();
        if (isSuccess) {
            status.put("status", "200");
            return status;
        }else{
            return status;
        }
    }
    
    
}
