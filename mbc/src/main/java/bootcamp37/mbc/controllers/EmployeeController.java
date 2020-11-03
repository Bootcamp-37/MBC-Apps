    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.controllers;

import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.services.EmployeeServices;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Deo Lahara
 */

@ResponseBody
@RequestMapping("/employee")
@Controller
public class EmployeeController {
    EmployeeServices employeeServices;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }
    
    @ResponseBody
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeServices.getAllEmployee();
    }

    @ResponseBody
    @GetMapping("/ID/{idemployee}")
    public Employee getByIdEmployee(@PathVariable String idemployee) {
        return employeeServices.getByIdEmployee(idemployee).get();
    }

    @ResponseBody
    @GetMapping("/InsertEmployee")
    public String employeeInsert() {
        Employee employee = null;
        try {
            String id = "E006";
            String name = "Nisa";
            String email = "nisa@email.com";
            String gender = "FEMALE";
            String phonenumber = "081111111111";
            String address = "Jl. Depan Upnormal";

            String birthDate = "1998-01-01 12:00:00";
            String hireDate = "2020-10-29 12:00:00";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date birth = formatter.parse(birthDate);
            Date hire = formatter.parse(hireDate);

            System.out.println(birth + " ini end");
            System.out.println(hire + " ini hire");
            employee = new Employee(id, name, birth, gender, email, hire, phonenumber, address);
            Employee emp = employeeServices.save(employee);
            return "employee: " + emp.toString();
        } catch (ParseException ex) {
            return "failed";
        }
    }
    
    
    @PostMapping("")
    public Employee insert(@RequestBody Employee employee) {
        Employee result = employeeServices.save(employee);
        return result;
    }
    
    @ResponseBody
    @PutMapping("")
    public boolean update(@RequestBody Employee employee){
        return employeeServices.updateEmployee(employee);
    }
    
    @ResponseBody
    @DeleteMapping("{idemployee}")
    public Map<String,String> deleteEmployee (@PathVariable String idemployee){
        boolean isSuccess = employeeServices.delete(idemployee);
        Map<String, String> status = new HashMap<>();
        if (isSuccess) {
            status.put("status", "200");
            return status;
        }else{
            return status;
        }
    }
    
    @ResponseBody
    @GetMapping("/delete/{idemployee}")
    public String employeeDelete(@PathVariable String idemployee) {
        return employeeServices.deleteNetbeans(idemployee);
    }
    
    
}
