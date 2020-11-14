/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import java.util.List;
import java.util.Optional;
import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class EmployeeService {

    EmployeeRepository employeeRep;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRep) {
        this.employeeRep = employeeRep;
    }

    public List<Employee> getAll() {
        return employeeRep.findAll();
    }

    public Optional<Employee> getbyId(String id) {
        return employeeRep.findById(id);
    }

    public Employee save(Employee e) {
        System.out.println(e.toString());
        return employeeRep.save(e);
    }

    public String delete(String id) {
        try {
            employeeRep.deleteById(id);
            return "delete succes id:" + id;
        } catch (Exception e) {
            return "detele failed";
        }
    }

}
