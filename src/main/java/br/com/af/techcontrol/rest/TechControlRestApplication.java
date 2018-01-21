package br.com.af.techcontrol.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TechControlRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechControlRestApplication.class, args);
	}
}
