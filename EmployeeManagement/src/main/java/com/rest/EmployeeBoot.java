package com.rest;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
public class EmployeeBoot {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBoot.class, args);
	}
}
