package com.example.HealthCheckwithDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HealthStatus {

    @Id
    private int id = 1;
    private String status;

    public HealthStatus() {}

    public HealthStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
