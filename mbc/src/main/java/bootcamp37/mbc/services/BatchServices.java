/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tbclate file, choose Tools | Tbclates
 * and open the tbclate in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Batch;
import bootcamp37.mbc.entities.Batch;
import bootcamp37.mbc.entities.Batch;
import bootcamp37.mbc.entities.Course;
import bootcamp37.mbc.entities.Employee;
import bootcamp37.mbc.repositories.BatchRepository;
import bootcamp37.mbc.viewmodel.BatchVM;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Deo Lahara
 */

@Service
public class BatchServices {
    BatchRepository batchRepository;

    @Autowired
    public BatchServices(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public List<BatchVM> getAllBatch() {
        List<BatchVM> bvms = new ArrayList<>();
        List <Batch> batchs = batchRepository.findAll();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        for (Batch batch : batchs) {
            Date start = batch.getStartDate();
            Date end = batch.getEndDate();

            String startdate = dateFormat.format(start);
            String enddate = dateFormat.format(end);

            bvms.add(new BatchVM(batch.getId(), batch.getName(), startdate,enddate, batch.getCourse().getId(), batch.getEmployee().getId()));

        }
        for (BatchVM batchVM : bvms) {
            System.out.println(batchVM.getId());
            System.out.println(batchVM.getName());
            System.out.println(batchVM.getStartDate());
            System.out.println(batchVM.getCourse());
            System.out.println(batchVM.getEmployee());
        }
        return bvms;
    }

    public Optional<Batch> getByIdBatch(String idbatch) {
        return batchRepository.findById(idbatch);
    }
    
    public boolean updateBatch (Batch batch){
        Optional<Batch> batchOptional = getByIdBatch(batch.getId());
        if(batchOptional.isPresent()){
            Batch update = batchOptional.get();
            update.setName(batch.getName());
            update.setStartDate(batch.getStartDate());
            update.setEndDate(batch.getStartDate());
            update.setCourse(batch.getCourse());
            update.setEmployee(batch.getEmployee());
            batchRepository.save(update);
            return true;
        }
        return false;
    }

    public Batch save(Batch batch){
        boolean batchCheck = getByIdBatch(batch.getId()).isPresent();
        try {
            return batchRepository.save(batch);
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean deleteMapping(String idbatch) {
        try {
            Batch bc = getByIdBatch(idbatch).get();
            System.out.println(bc.toString());
            batchRepository.delete(bc);
            System.out.println(getByIdBatch(idbatch).get().toString() + " ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String deleteNetbeans(String idbatch) {
        try {
            batchRepository.deleteById(idbatch);
            return "delete succes id:" + idbatch;
        } catch (Exception e) {
            return "detele failed";
        }
    }
        
}
