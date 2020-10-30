/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Site;
import bootcamp37.mbc.repositories.SiteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZFH
 */
@Service
public class SiteService {
    SiteRepository siteRep;

@Autowired
    public SiteService(SiteRepository repo) {
        this.siteRep = repo;
    }
public List<Site> getAll(){
        return siteRep.findAll();
    }

 public Optional<Site> getById(String id){
        Optional<Site> site = siteRep.findById(id);
        return site;
    }    
    
    public boolean updateContract(Site site){
        Optional<Site> SiteOptional = getById(site.getId());
        if (SiteOptional.isPresent()) {
            Site update = SiteOptional.get();
            update.setName(site.getName());
            update.setDivision(site.getDivision());
            update.setPhoneSite(site.getPhoneSite());
            update.setAddress(site.getAddress());
            update.setClient(site.getClient());
            update.setInterview(site.getInterview());
            siteRep.save(update);
            return true;
        }
        return false;
    }
    
     public Site save(Site site){
        boolean siteCheck = getById(site.getId()).isPresent();
        Site s = null;
         try {
            return s = siteRep.save(site);
        } catch (Exception e) {
            System.out.println(e);
            return s;
        }
    }
}
