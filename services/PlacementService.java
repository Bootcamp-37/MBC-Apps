/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Placement;
import bootcamp37.mbc.repositories.PlacementRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class PlacementService {
PlacementRepository placementRep;

@Autowired
public PlacementService(PlacementRepository repo) {
this.placementRep = repo;
}

 public List<Placement> getAll(){
        return placementRep.findAll();
    }
  public Optional<Placement> getById(String id){
        Optional<Placement> placement = placementRep.findById(id);
        return placement;
    }    
    
    public boolean updateContract(Placement placement){
        Optional<Placement> PlacementOptional = getById(placement.getId());
        if (PlacementOptional.isPresent()) {
            Placement update = PlacementOptional.get();
            update.setStatus(placement.getStatus());
            update.setContract(placement.getContract());
            update.setRequest(placement.getRequest());
            placementRep.save(update);
            return true;
        }
        return false;
    }
    
     public Placement save(Placement placement){
        boolean placementCheck = getById(placement.getId()).isPresent();
        Placement p = null;
         try {
            return p = placementRep.save(placement);
        } catch (Exception e) {
            System.out.println(e);
            return p;
        }
    }
}
