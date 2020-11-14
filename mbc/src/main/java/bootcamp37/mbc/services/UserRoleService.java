/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.UserRole;
import bootcamp37.mbc.repositories.UserRoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class UserRoleService {
UserRoleRepository userRoleRep;

@Autowired
public UserRoleService(UserRoleRepository repo) {
        this.userRoleRep = repo;
    }
public List<UserRole> getAll(){
        return userRoleRep.findAll();
    }

 public Optional<UserRole> getById(String id){
        Optional<UserRole> userRole = userRoleRep.findById(id);
        return userRole;
    }    
    
    public boolean updateUserRole(UserRole userRole){
        Optional<UserRole> UserRoleOptional = getById(userRole.getId());
        if (UserRoleOptional.isPresent()) {
            UserRole update = UserRoleOptional.get();
            update.setRole(userRole.getRole());
            update.setUser(userRole.getUser());
            userRoleRep.save(update);
            return true;
        }
        return false;
    }
    
     public UserRole save(UserRole userRole){
        boolean userRoleCheck = getById(userRole.getId()).isPresent();
        UserRole usr = null;
         try {
            return usr = userRoleRep.save(userRole);
        } catch (Exception e) {
            System.out.println(e);
            return usr;
        }
    }    
}
