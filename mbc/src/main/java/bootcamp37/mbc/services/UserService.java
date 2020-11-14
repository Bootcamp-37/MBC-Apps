/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.User;
import bootcamp37.mbc.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class UserService {
UserRepository userRep;

@Autowired
    public UserService(UserRepository repo) {
        this.userRep = repo;
    }

    public List<User> getAll(){
        return userRep.findAll();
    }

    public Optional<User> getById(String id){
        return userRep.findById(id);
    }
    
    public User getByUsername(String username){
        return userRep.findByUsername(username);
    }
    public boolean updateUser(User user){
        Optional<User> UserOptional = getById(user.getId());
        if (UserOptional.isPresent()) {
            User update = UserOptional.get();
            update.setUsername(user.getUsername());
            update.setPassword(user.getPassword());
            update.setEmployee(user.getEmployee());
            userRep.save(update);
            return true;
        }
        return false;
    }
    
     public User save(User user){
        boolean UserCheck = getById(user.getId()).isPresent();
        User us = null;
         try {
            return us = userRep.save(user);
        } catch (Exception e) {
            System.out.println(e);
            return us;
        }
    }
     
      public String delete(String id) {
        try {
            userRep.deleteById(id);
            return "delete succes id:" + id;
        } catch (Exception e) {
            return "detele failed";
        }
      }
}
