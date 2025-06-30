package com.example.HealthCheck;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    private boolean isUp = true;

    @GetMapping("/health")

    public String CheckHealth() {
        if (isUp) {
            return "Health is UP";
        } else {
            return "DOWN";
        }
    }

    @GetMapping("/toggle")

    public String toggleHealth() {
        if (isUp) {
            isUp = false;
            return "Health is DOWN";
        } else {
            isUp = true;
            return "Health is UP";
        }
    }

}


