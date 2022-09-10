package com.teamhub.admincomejen.services;

import com.teamhub.admincomejen.entities.Enterprise;
import com.teamhub.admincomejen.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnterpriseService {

    private EnterpriseRepository repository;
    public EnterpriseService(EnterpriseRepository repository){

        this.repository = repository;
    }

    public List<Enterprise> getEnterpriseAll(){
        return this.repository.findAll();
    }

    public Enterprise getEnterpriseOne(Long id){
        return this.repository.findById(id).orElseThrow(()->new EnterpriseNotFoundException(id));
    }

    public void insertEnterprise(Enterprise enterprise){
        this.repository.save(enterprise);
    }
    public void updateEnterprise(Enterprise enterprise){
        this.repository.save(enterprise);
    }

    public String deleteEnterprise(Long id){
        try {
            this.repository.deleteById(id);

        }catch (Exception exception){
               return "The enterprise with id = "+ id +" could not be eliminated.";
        }
        return null;
    }

}
