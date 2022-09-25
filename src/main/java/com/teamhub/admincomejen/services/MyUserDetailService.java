package com.teamhub.admincomejen.services;


import com.teamhub.admincomejen.entities.Employee;
import com.teamhub.admincomejen.entities.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private EmployeeService employeeService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = null;
        try {
            employee = this.employeeService.getEmployeeByEmail(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }

        return new MyUserDetails(employee);
    }

}
