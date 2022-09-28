package com.teamhub.admincomejen.controllers;




import com.teamhub.admincomejen.entities.Enterprise;
import com.teamhub.admincomejen.entities.EnterpriseResponse;
import com.teamhub.admincomejen.services.EnterpriseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnterpriseController {

    private EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService){
        this.enterpriseService = enterpriseService;
    }

    @GetMapping("/enterprises")
    public ResponseEntity<List<Enterprise>> getEnterprises(){
        return new ResponseEntity<List<Enterprise>>(this.enterpriseService.getEnterprises(), HttpStatus.OK);
    }

    @GetMapping("/enterprises/{id}")
    public ResponseEntity<Object> getEnterprise(@PathVariable Long id){
        try {
            Enterprise enterprise = enterpriseService.getEnterprise(id);
            return new ResponseEntity<>(enterprise, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/enterprises")
    public ResponseEntity<EnterpriseResponse> postEnterprise(@RequestBody Enterprise enterprise){
        return new ResponseEntity<>(
                new EnterpriseResponse("Empresa creada exitosamente", enterpriseService.postEnterprise(enterprise)),
                HttpStatus.OK);
    }

    @PutMapping("/enterprises")
    public ResponseEntity<EnterpriseResponse> putEnterprise(@RequestBody Enterprise enterprise){
        return new ResponseEntity<>(
                new EnterpriseResponse("Empresa actualizada exitosamente", enterpriseService.putEnterprise(enterprise)),
                HttpStatus.OK
        );
    }

    @PatchMapping("/enterprises/{id}")
    public ResponseEntity<EnterpriseResponse> patchEnterprise(@RequestBody Enterprise enterprise, @PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new EnterpriseResponse("Actulizacion exitosa", enterpriseService.patchEnterprise(enterprise, id)),
                    HttpStatus.OK
            );

        }catch (Exception e) {
            return new ResponseEntity<>(
                    new EnterpriseResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/enterprises/{id}")
    public ResponseEntity<EnterpriseResponse> deleteEnterprise(@PathVariable Long id){
        return new ResponseEntity<>(
                new EnterpriseResponse(enterpriseService.deleteEnterprise(id),null ),
                HttpStatus.OK
        );
    }



}
