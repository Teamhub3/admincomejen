package com.teamhub.admincomejen.security;



import com.teamhub.admincomejen.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();

    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/enterprises/front/delete/**").hasRole("ADMIN")
                .antMatchers("/enterprises/front/transactions/**").hasAnyRole("ADMIN", "OPERATOR")
                .antMatchers("/enterprises/front/employees/**").hasRole("ADMIN")
                .antMatchers("/enterprises/front/add/transaction/**").hasAnyRole("ADMIN","OPERATOR")
                .antMatchers("/enterprises/front/add/employee/**").hasRole("ADMIN")
                .antMatchers("/enterprises/front/add/enterprise/**").hasRole("ADMIN")
                .antMatchers("/enterprises/front/enterprise/**").hasAnyRole("ADMIN","OPERATOR")
                .antMatchers("/home").hasAnyRole("ADMIN", "OPERATOR")
                .antMatchers("/").permitAll()
                .antMatchers("/login/**").permitAll()

                .and()

                .formLogin().loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }


}
