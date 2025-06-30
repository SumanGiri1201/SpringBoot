package com.example.HealthCheckwithDB;

import com.example.HealthCheckwithDB.model.HealthStatus;
import com.example.HealthCheckwithDB.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class HealthCheckwithDbApplication {

	@Autowired
	HealthRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckwithDbApplication.class, args);
	}

	@PostConstruct
	public void setup() {
		if (repo.findById(1).isEmpty()) {
			repo.save(new HealthStatus("UP"));
		} else {
			repo.save(new HealthStatus("DOWN"));

		}
	}
}
