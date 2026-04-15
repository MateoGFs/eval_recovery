package com.tech.courses.dto;

import java.time.Instant;
 
public class EmployResponse {
 
    private Long id;
    private String name;
    private String email;
    private String position;
    private Double salary;
    private Long departamentId;
    private String departamentName;
    private Instant createdAt;
    private Instant updatedAt;
 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
 
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
 
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
 
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
 
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
 
    public Long getDepartamentId() { return departamentId; }
    public void setDepartamentId(Long departamentId) { this.departamentId = departamentId; }
 
    public String getDepartamentName() { return departamentName; }
    public void setDepartamentName(String departamentName) { this.departamentName = departamentName; }
 
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
 
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}

