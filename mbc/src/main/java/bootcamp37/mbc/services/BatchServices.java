/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Batch;
import bootcamp37.mbc.repositories.BatchRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Batch> getAll() {
        return batchRepository.findAll();
    }

    public Optional<Batch> getById(String id) {
        Optional<Batch> batch = batchRepository.findById(id);
        return batch;
    }

    public boolean updateBatch(Batch batch) {
        Optional<Batch> batchOptional = getById(batch.getId());
        if (batchOptional.isPresent()) {
            Batch update = batchOptional.get();
            update.setName(batch.getName());
            batchRepository.save(update);
            return true;
        }
        return false;
    }

    public Batch save(Batch batch) {
        boolean batchCheck = getById(batch.getId()).isPresent();
        Batch bc = null;
        try {
            return bc = batchRepository.save(batch);
        } catch (Exception e) {
            System.out.println(e);
            return bc;
        }
    }

    public boolean delete(String id) {
        try {
            Batch bc = getById(id).get();
            System.out.println(bc.toString());
            batchRepository.delete(bc);
            System.out.println(getById(id).get().toString() + " ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
