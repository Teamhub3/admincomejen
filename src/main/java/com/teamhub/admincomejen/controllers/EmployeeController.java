package com.teamhub.admincomejen.controllers;

import com.teamhub.admincomejen.entities.Employee;
import com.teamhub.admincomejen.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService service;

    public EmployeeController(EmployeeService service){

        this.service  = service;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployeeAll(){
        return service.getEmployeeAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeOne(@PathVariable Long id){
        return service.getEmployeeOne(id);
    }

    @PostMapping("/employees")
    public void postEmployee(@RequestBody Employee employee){
        this.service.insertEmployee(employee);
    }

    @PutMapping("/employees")
    public void putEmployee(@RequestBody Employee employee){
        this.service.updateEmployee(employee);
    }

    @DeleteMapping(value = "/employees/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        return this.service.deleteEmployee(id);
    }


}
