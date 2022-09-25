package com.teamhub.admincomejen.services;

import com.teamhub.admincomejen.entities.Enterprise;
import com.teamhub.admincomejen.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService {

    private EnterpriseRepository enterpriseRepository;

    public EnterpriseService(EnterpriseRepository enterpriseRepository){
        this.enterpriseRepository = enterpriseRepository;
    }
    public List<Enterprise> getEnterprises(){
        return this.enterpriseRepository.findAll();
    }

    public Enterprise getEnterprise(Long id) throws Exception{
        Optional<Enterprise> optionalEnterprise = enterpriseRepository.findById(id);
        if (optionalEnterprise.isPresent()){
            return optionalEnterprise.get();
        }else {
            throw new Exception("La empresa no exite");
        }
    }
    public Long getUltimoId(){
        List<Enterprise> enterprises = this.enterpriseRepository.findAll();
        if(enterprises.size()>0){
            return enterprises.get(enterprises.size()-1).getId();
        }else{
            return 0L;
        }

    }

    public Enterprise postEnterprise(Enterprise enterprise){
        return this.enterpriseRepository.save(enterprise);
    }

    public Enterprise putEnterprise(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise patchEnterprise(Enterprise enterprise_param, Long id) throws Exception{
        try {
            Enterprise enterpriseDB = getEnterprise(id);

            if (enterprise_param.getAddress() != null){
                enterpriseDB.setAddress(enterprise_param.getAddress());
            }
            if ((enterprise_param.getDocument() != null)){
                enterpriseDB.setDocument(enterprise_param.getDocument());
            }
            if (enterprise_param.getName() != null){
                enterpriseDB.setName(enterprise_param.getName());
            }
            if (enterprise_param.getPhone() != null){
                enterpriseDB.setPhone(enterprise_param.getPhone());
            }
            enterpriseDB.setUpdatedAt(LocalDate.now());
            return  postEnterprise(enterpriseDB);
        }catch (Exception e){
            throw new Exception("La empresa no se actulizo");
        }
    }

    public String deleteEnterprise(Long id){
        try {
            this.enterpriseRepository.deleteById(id);
            return "Empresa eliminada exitosamente!";
        }catch (Exception e){
            return "La empresa con id = " + id + " no se pudo eliminar o no existe en la base de datos!";
        }
    }

}
