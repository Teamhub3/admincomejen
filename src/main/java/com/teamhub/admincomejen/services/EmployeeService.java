package com.teamhub.admincomejen.services;


import com.teamhub.admincomejen.entities.Employee;
import com.teamhub.admincomejen.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    private EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository){

        this.repository = repository;
    }

    public List<Employee> getEmployeeAll(){
        return this.repository.findAll();
    }

    public Employee getEmployeeOne(Long id){
        return this.repository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    public void insertEmployee(Employee employee){
        this.repository.save(employee);
    }
    public void updateEmployee(Employee employee){
        this.repository.save(employee);
    }

    public String deleteEmployee(Long id){
        try {
            this.repository.deleteById(id);

        }catch (Exception exception){
            return "The enterprise with id = "+ id +" could not be eliminated.";
        }
        return null;
    }

}
