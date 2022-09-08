package com.teamhub.admincomejen.controllers;

import com.teamhub.admincomejen.entities.Enterprise;
import com.teamhub.admincomejen.services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnterpriseController {
    EnterpriseService service;

    public EnterpriseController(EnterpriseService service){

        this.service  = service;
    }

    @GetMapping("/enterprises")
    public List<Enterprise> getEnterpriseAll(){
        return service.getEnterpriseAll();
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise getEnterpriseOne(@PathVariable Long id){
        return service.getEnterpriseOne(id);
    }

    @PostMapping("/enterprises")
    public void postEnterprise(@RequestBody Enterprise enterprise){
        this.service.insertEnterprise(enterprise);
    }

    @PutMapping("/enterprises")
    public void putEnterprise(@RequestBody Enterprise enterprise){
        this.service.updateEnterprise(enterprise);
    }

    @DeleteMapping(value = "/enterprises/{id}")
    public String deleteEnterprise(@PathVariable("id") Long id){
        return this.service.deleteEnterprise(id);
    }


}
