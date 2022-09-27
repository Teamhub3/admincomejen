package com.teamhub.admincomejen.controllers;

import com.teamhub.admincomejen.entities.Employee;
import com.teamhub.admincomejen.entities.EmployeeResponse;
import com.teamhub.admincomejen.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<List<Employee>>(this.employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable Long id){
        try {
            Employee employee = employeeService.getEmployee(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> postEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(
                new EmployeeResponse("Empresa creada exitosamente", employeeService.postEmployee(employee)),
                HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<EmployeeResponse> putEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(
                new EmployeeResponse("Empresa actualizada exitosamente", employeeService.putEmployee(employee)),
                HttpStatus.OK
        );
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> patchEmployee(@RequestBody Employee employee, @PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new EmployeeResponse("Actulizacion exitosa", employeeService.patchEmployee(employee, id)),
                    HttpStatus.OK
            );

        }catch (Exception e) {
            return new ResponseEntity<>(
                    new EmployeeResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @DeleteMapping("employees/{id}")
    public ResponseEntity<EmployeeResponse> deleteEnterprise(@PathVariable Long id){
        return new ResponseEntity<>(
                new EmployeeResponse(employeeService.deleteEmployee(id),null ),
                HttpStatus.OK
        );
    }
}
