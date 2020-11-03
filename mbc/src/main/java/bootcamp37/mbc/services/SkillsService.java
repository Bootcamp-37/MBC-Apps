/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Skills;
import bootcamp37.mbc.repositories.SkillsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deo Lahara
 */

@Service
public class SkillsService {
    SkillsRepository skillsRepository;

    @Autowired
    public SkillsService(SkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }
    
    public List<Skills> getAll(){
        return skillsRepository.findAll();
    }
    
    public Optional<Skills> getById(String id){
        Optional<Skills> skills = skillsRepository.findById(id);
        return skills;
    }
    
    public boolean updateSkills (Skills skills){
        Optional<Skills> skillsOptional = getById(skills.getId());
        if(skillsOptional.isPresent()){
            Skills update = skillsOptional.get();
            update.setEmployee(skills.getEmployee());
            update.setSkillsSet(skills.getSkillsSet());
            skillsRepository.save(update);
            return true;
        }
        return false;
    }
    
    public Skills save(Skills skills){
        boolean skillsCheck = getById(skills.getId()).isPresent();
        Skills skl = null;
        try {
            return skl = skillsRepository.save(skills);
        } catch (Exception e) {
            System.out.println(e);
            return skl;
        }
    }
    
        public boolean delete(String id){
        try {
            Skills skl = getById(id).get();
            System.out.println(skl.toString());
            skillsRepository.delete(skl);
            System.out.println(getById(id).get().toString()+" ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
