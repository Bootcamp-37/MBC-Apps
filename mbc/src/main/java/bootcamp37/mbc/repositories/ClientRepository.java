/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.repositories;

import bootcamp37.mbc.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Deo Lahara
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, String>{
    
}
