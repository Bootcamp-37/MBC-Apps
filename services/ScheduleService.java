/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Schedule;
import bootcamp37.mbc.repositories.ScheduleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class ScheduleService {
ScheduleRepository scheduleRep;

@Autowired
    public ScheduleService(ScheduleRepository repo) {
        this.scheduleRep = repo;
    }
public List<Schedule> getAll(){
        return scheduleRep.findAll();
    }

 public Optional<Schedule> getById(String id){
        Optional<Schedule> schedule = scheduleRep.findById(id);
        return schedule;
    }    
    
    public boolean updateContract(Schedule schedule){
        Optional<Schedule> ScheduleOptional = getById(schedule.getId());
        if (ScheduleOptional.isPresent()) {
            Schedule update = ScheduleOptional.get();
            update.setDate(schedule.getDate());
            update.setInterviewer(schedule.getInterviewer());
            scheduleRep.save(update);
            return true;
        }
        return false;
    }
    
     public Schedule save(Schedule schedule){
        boolean scheduleCheck = getById(schedule.getId()).isPresent();
        Schedule sch = null;
         try {
            return sch = scheduleRep.save(schedule);
        } catch (Exception e) {
            System.out.println(e);
            return sch;
        }
    }
}
