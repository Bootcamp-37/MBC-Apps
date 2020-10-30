/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deo Lahara
 */

@Service
public class EmployeeServices {
     
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }
    
    public Optional<Employee> getById(String id){
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }
    
    public boolean updateEmployee (Employee employee){
        Optional<Employee> employeeOptional = getById(employee.getId());
        if(employeeOptional.isPresent()){
            Employee update = employeeOptional.get();
            update.setName(employee.getName());
            update.setBirthDate(employee.getBirthDate());
            update.setGender(employee.getGender());
            update.setEmail(employee.getEmail());
            update.setHireDate(employee.getHireDate());
            update.setEndDate(employee.getEndDate());
            update.setPhoneNumber(employee.getPhoneNumber());
            update.setAddress(employee.getAddress());
            employeeRepository.save(update);
            return true;
        }
        return false;
    }
    
    public Employee save(Employee employee){
        boolean employeeCheck = getById(employee.getId()).isPresent();
        Employee emp = null;
        try {
            return emp = employeeRepository.save(employee);
        } catch (Exception e) {
            System.out.println(e);
            return emp;
        }
    }
    
        public boolean delete(String id){
        try {
            Employee emp = getById(id).get();
            System.out.println(emp.toString());
            employeeRepository.delete(emp);
            System.out.println(getById(id).get().toString()+" ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
