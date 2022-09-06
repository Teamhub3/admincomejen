package com.teamhub.admincomejen;

import com.teamhub.admincomejen.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
@RestController
@SpringBootApplication
public class AdmincomejenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmincomejenApplication.class, args);
	}

}
