package com.teamhub.admincomejen.repositories;

import com.teamhub.admincomejen.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.thymeleaf.spring5.processor.SpringUErrorsTagProcessor;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmail(String email);

    public List<Employee> findByEnterprise_Id(Long id);
}
