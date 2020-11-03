/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tcs late file, choose Tools | Tcs lates
 * and open the tcs late in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Kelas;
import bootcamp37.mbc.entities.Kelas;
import bootcamp37.mbc.repositories.KelasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Deo Lahara
 */
@Service
public class KelasServices {

    KelasRepository kelasRepository;

    @Autowired
    public KelasServices(KelasRepository kelasRepository) {
        this.kelasRepository = kelasRepository;
    }

    public List<Kelas> getAllKelas() {
        return kelasRepository.findAll();
    }
    
    public Optional<Kelas> getByIdKelas(String idkelas) {
        Optional<Kelas> kelas = kelasRepository.findById(idkelas);
        return kelas;
    }
    
    public boolean updateKelas (Kelas kelas){
        Optional<Kelas> kelasOptional = getByIdKelas(kelas.getId());
        if(kelasOptional.isPresent()){
            Kelas update = kelasOptional.get();
            update.setStatus(kelas.getStatus());
            update.setBatch(kelas.getBatch());
            update.setEmployee(kelas.getEmployee());
            kelasRepository.save(update);
            return true;
        }
        return false;
    }
    
    public Kelas save(Kelas kelas){
        boolean kelasCheck = getByIdKelas(kelas.getId()).isPresent();
        Kelas cs = null;
        try {
            return cs = kelasRepository.save(kelas);
        } catch (Exception e) {
            System.out.println(e);
            return cs ;
        }
    }
    
    public boolean deleteMapping (String idkelas) {
        try {
            Kelas cs = getByIdKelas(idkelas).get();
            System.out.println(cs.toString());
            kelasRepository.delete(cs);
            System.out.println(getByIdKelas(idkelas).get().toString() + " ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String deleteNetbeans(String idkelas) {
        try {
            kelasRepository.deleteById(idkelas);
            return "delete succes id:" + idkelas;
        } catch (Exception e) {
            return "detele failed";
        }
    }
        

}
