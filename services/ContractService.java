/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Contract;
import bootcamp37.mbc.repositories.ContractRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class ContractService {
    ContractRepository contractRep;
    
@Autowired
public ContractService(ContractRepository repo) {
        this.contractRep = repo;
    }
    
    public List<Contract> getAll(){
        return contractRep.findAll();
    }
    
    public Optional<Contract> getById(String id){
        Optional<Contract> contract = contractRep.findById(id);
        return contract;
    }    
    
    public boolean updateContract(Contract contract){
        Optional<Contract> contractOptional = getById(contract.getId());
        if (contractOptional.isPresent()) {
            Contract update = contractOptional.get();
            update.setName(contract.getName());
            update.setStartDate(contract.getStartDate());
            update.setEndDate(contract.getEndDate());
            contractRep.save(update);
            return true;
        }
        return false;
    }
    
     public Contract save(Contract contract){
        boolean contractCheck = getById(contract.getId()).isPresent();
        Contract c = null;
         try {
            return c = contractRep.save(contract);
        } catch (Exception e) {
            System.out.println(e);
            return c;
        }
    }
}
