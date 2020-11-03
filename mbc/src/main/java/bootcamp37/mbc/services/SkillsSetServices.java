/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.SkillsSet;
import bootcamp37.mbc.repositories.SkillsSetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deo Lahara
 */

@Service
public class SkillsSetServices {
    
    SkillsSetRepository skillssetRepository;

    @Autowired
    public SkillsSetServices(SkillsSetRepository skillssetRepository) {
        this.skillssetRepository = skillssetRepository;
    }
    
    public List<SkillsSet> getAllSkillsSet() {
        return skillssetRepository.findAll();
    }
    
    public Optional<SkillsSet> getByIdSkillsSet(String idskillsset) {
        Optional<SkillsSet> skillsset = skillssetRepository.findById(idskillsset);
        return skillsset;
    }
    
    public boolean updateSkillsSet(SkillsSet skillsset) {
        Optional<SkillsSet> skillssetOptional = getByIdSkillsSet(skillsset.getId());
        if (skillssetOptional.isPresent()) {
            SkillsSet update = skillssetOptional.get();
            update.setName(skillsset.getName());
            skillssetRepository.save(update);
            return true;
        }
        return false;
    }
    
    public SkillsSet save(SkillsSet skillsset) {
        boolean skillssetCheck = getByIdSkillsSet(skillsset.getId()).isPresent();
        SkillsSet ss = null;
        try {
            return ss = skillssetRepository.save(skillsset);
        } catch (Exception e) {
            System.out.println(e);
            return ss;
        }
    }
    
    public boolean deleteMapping(String idskillsset) {
        try {
            SkillsSet ss = getByIdSkillsSet(idskillsset).get();
            System.out.println(ss.toString());
            skillssetRepository.delete(ss);
            System.out.println(getByIdSkillsSet(idskillsset).get().toString() + " ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String deleteNetbeans(String idskillsset) {
        try {
            skillssetRepository.deleteById(idskillsset);
            return "delete succes id:" + idskillsset;
        } catch (Exception e) {
            return "detele failed";
        }
    }

}
