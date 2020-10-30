/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Interviewer;
import bootcamp37.mbc.repositories.InterviewerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class InterviewerService {
    InterviewerRepository InterviewRep;
    
@Autowired
public InterviewerService(InterviewerRepository repo) {
        this.InterviewRep = repo;
    }
    
    public List<Interviewer> getAll(){
        return InterviewRep.findAll();
    }
    
    public Optional<Interviewer> getById(String id){
        Optional<Interviewer> interviewer = InterviewRep.findById(id);
        return interviewer;
    }    
    
    public boolean updateContract(Interviewer interviewer){
        Optional<Interviewer> InterviewerOptional = getById(interviewer.getId());
        if (InterviewerOptional.isPresent()) {
            Interviewer update = InterviewerOptional.get();
            update.setName(interviewer.getName());
            update.setPhoneNumber(interviewer.getPhoneNumber());
            update.setEmail(interviewer.getEmail());
            InterviewRep.save(update);
            return true;
        }
        return false;
    }
    
     public Interviewer save(Interviewer interviewer){
        boolean interviewerCheck = getById(interviewer.getId()).isPresent();
        Interviewer i = null;
         try {
            return i = InterviewRep.save(interviewer);
        } catch (Exception e) {
            System.out.println(e);
            return i;
        }
    }
}
