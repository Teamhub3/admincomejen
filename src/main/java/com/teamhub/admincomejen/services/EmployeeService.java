package com.teamhub.admincomejen.services;

import com.teamhub.admincomejen.entities.Employee;
import com.teamhub.admincomejen.entities.Enterprise;
import com.teamhub.admincomejen.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) throws Exception{
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else {
            throw new Exception("El empleado no exite");
        }
    }
    public Employee getEmployeeByEmail(String email) throws Exception{
        Optional<Employee> optionalEmployee = Optional.ofNullable(employeeRepository.findByEmail(email));
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else {
            throw new Exception("El empleado no exite");
        }
    }

    public Long getUltimoId(){
        List<Employee> employees = this.employeeRepository.findAll();
        if(employees.size()>0){
            return employees.get(employees.size()-1).getId();
        }else{
            return 0L;
        }
    }


    public List<Employee> getEmployeeByEnterpriseId(Long id){
        return this.employeeRepository.findByEnterprise_Id(id);
    }

    public Employee postEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public Employee putEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee patchEmployee(Employee employee_param, Long id) throws Exception{
        try {
            Employee employeeDB = getEmployee(id);

            if (employee_param.getEmail() != null){
                employeeDB.setEmail(employee_param.getEmail());
            }
            if (employee_param.getPassword() != null){
                employeeDB.setPassword(employee_param.getPassword());
            }
            if (employee_param.getRoles() != null){
                employeeDB.setRoles(employee_param.getRoles());
            }
            if (employee_param.getProfile() != null){
                employeeDB.setProfile(employee_param.getProfile());
            }
            employeeDB.setUpdateAt(LocalDate.now());
            return postEmployee(employeeDB);
        }catch (Exception e){
            throw new Exception("El empleado no se actulizo");
        }
    }

    public String deleteEmployee(Long id){
        try {
            this.employeeRepository.deleteById(id);
            return "Empleado eliminado exitosamente!";
        }catch (Exception e){
            return "El empleado con id = " + id + " no se pudo eliminar o no existe en la base de datos!";
        }
    }
}
