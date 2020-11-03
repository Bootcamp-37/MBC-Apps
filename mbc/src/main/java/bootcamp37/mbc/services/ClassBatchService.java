/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Batch;
import bootcamp37.mbc.entities.ClassBatch;
import bootcamp37.mbc.repositories.ClassBatchRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deo Lahara
 */

@Service
public class ClassBatchService {
    ClassBatchRepository classBatchRepository;

    @Autowired
    public ClassBatchService(ClassBatchRepository classBatchRepository) {
        this.classBatchRepository = classBatchRepository;
    }
    
    public List<ClassBatch> getAll(){
        return classBatchRepository.findAll();
    }
    
    public Optional<ClassBatch> getById(String id){
        Optional<ClassBatch> classbatch = classBatchRepository.findById(id);
        return classbatch;
    }
    
    public boolean updateClassBatch (ClassBatch classbatch){
        Optional<ClassBatch> classbatchOptional = getById(classbatch.getId());
        if(classbatchOptional.isPresent()){
            ClassBatch update = classbatchOptional.get();
            update.setBatch(classbatch.getBatch());
            update.setEmployee(classbatch.getEmployee());
            classBatchRepository.save(update);
            return true;
        }
        return false;
    }
    
    public ClassBatch save(ClassBatch classbatch){
        boolean classbatchCheck = getById(classbatch.getId()).isPresent();
        ClassBatch cs = null;
        try {
            return cs = classBatchRepository.save(classbatch);
        } catch (Exception e) {
            System.out.println(e);
            return cs;
        }
    }
    
        public boolean delete(String id){
        try {
            ClassBatch cs = getById(id).get();
            System.out.println(cs.toString());
            classBatchRepository.delete(cs);
            System.out.println(getById(id).get().toString()+" ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
   
}
