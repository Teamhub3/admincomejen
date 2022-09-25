package com.teamhub.admincomejen.repositories;

import com.teamhub.admincomejen.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmail(String email);
}
