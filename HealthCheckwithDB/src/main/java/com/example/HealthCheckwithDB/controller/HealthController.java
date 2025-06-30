package com.example.HealthCheckwithDB.controller;

import com.example.HealthCheckwithDB.model.HealthStatus;
import com.example.HealthCheckwithDB.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    @Autowired
    private HealthRepository repo;

    @GetMapping("/health")
    public String checkHealth() {
        HealthStatus hs = repo.findById(1).orElse(new HealthStatus("DOWN"));
        return hs.getStatus();
    }

    @PostMapping("/toggle")
    public String toggleHealth() {
        HealthStatus hs = repo.findById(1).orElse(new HealthStatus("DOWN"));

        String currentStatus = hs.getStatus();
        String newStatus;

        if (currentStatus.equals("UP")) {
            newStatus = "DOWN";
        } else {
            newStatus = "UP";
        }

        hs.setStatus(newStatus);
        repo.save(hs);
        return "Health status changed to: " + newStatus;
    }
}
