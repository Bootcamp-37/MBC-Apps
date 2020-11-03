/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Request;
import bootcamp37.mbc.repositories.RequestRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deo Lahara
 */

@Service
public class RequestService {
    RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
    
    public List<Request> getAll(){
        return requestRepository.findAll();
    }
    
    public Optional<Request> getById(String id){
        Optional<Request> request = requestRepository.findById(id);
        return request;
    }
    
    public boolean updateRequest (Request request){
        Optional<Request> requestOptional = getById(request.getId());
        if(requestOptional.isPresent()){
            Request update = requestOptional.get();
            update.setSite(request.getSite());
            update.setSkills(request.getSkills());
            update.setSchedule(request.getSchedule());
            update.setWorkerDemand(request.getWorkerDemand());
            update.setStatus(request.getStatus());
            requestRepository.save(update);
            return true;
        }
        return false;
    }
    
    public Request save(Request request){
        boolean requestCheck = getById(request.getId()).isPresent();
        Request rq = null;
        try {
            return rq = requestRepository.save(request);
        } catch (Exception e) {
            System.out.println(e);
            return rq;
        }
    }
    
        public boolean delete(String id){
        try {
            Request rq = getById(id).get();
            System.out.println(rq.toString());
            requestRepository.delete(rq);
            System.out.println(getById(id).get().toString()+" ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
