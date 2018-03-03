package br.com.af.techcontrol.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TechControlRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechControlRestApplication.class, args);
	}
}
