/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.repositories;

import bootcamp37.mbc.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Deo Lahara
 */
public interface BatchRepository extends JpaRepository<Batch, String> {
    
}
