/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Role;
import bootcamp37.mbc.repositories.RoleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class RoleService {
RoleRepository roleRep;

@Autowired
    public RoleService(RoleRepository repo) {
        this.roleRep = repo;
    }
public List<Role> getAll(){
        return roleRep.findAll();
    }

 public Optional<Role> getById(String id){
        Optional<Role> role = roleRep.findById(id);
        return role;
    }    
    
    public boolean updateRole(Role role){
        Optional<Role> RoleOptional = getById(role.getId());
        if (RoleOptional.isPresent()) {
            Role update = RoleOptional.get();
            update.setName(role.getName());
            roleRep.save(update);
            return true;
        }
        return false;
    }
    
     public Role save(Role role){
        boolean roleCheck = getById(role.getId()).isPresent();
        Role r = null;
         try {
            return r = roleRep.save(role);
        } catch (Exception e) {
            System.out.println(e);
            return r;
        }
    }
}
