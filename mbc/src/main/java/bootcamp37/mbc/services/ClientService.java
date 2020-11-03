/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.services;

import bootcamp37.mbc.entities.Client;
import bootcamp37.mbc.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Deo Lahara
 */

@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    public List<Client> getAll(){
        return clientRepository.findAll();
    }
    
    public Optional<Client> getById(String id){
        Optional<Client> client = clientRepository.findById(id);
        return client;
    }
    
    public boolean updateClient (Client client){
        Optional<Client> clientOptional = getById(client.getId());
        if(clientOptional.isPresent()){
            Client update = clientOptional.get();
            update.setName(client.getName());
            clientRepository.save(update);
            return true;
        }
        return false;
    }
    
    public Client save(Client client){
        boolean clientCheck = getById(client.getId()).isPresent();
        Client cl = null;
        try {
            return cl = clientRepository.save(client);
        } catch (Exception e) {
            System.out.println(e);
            return cl;
        }
    }
    
        public boolean delete(String id){
        try {
            Client cl = getById(id).get();
            System.out.println(cl.toString());
            clientRepository.delete(cl);
            System.out.println(getById(id).get().toString()+" ini test");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
