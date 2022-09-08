package com.teamhub.admincomejen;

import com.teamhub.admincomejen.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AdmincomejenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmincomejenApplication.class, args);
	}

}
