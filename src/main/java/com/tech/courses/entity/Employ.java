package com.tech.courses.entity;

import java.time.Instant;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "employ")
public class Employ {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, length = 150)
    private String name;
 
    @Column(nullable = false, unique = true, length = 200)
    private String email;
 
    @Column(length = 100)
    private String position;
 
    @Column(nullable = false)
    private Double salary;
 
    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament departament;
 
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
 
    @Column(nullable = false)
    private Instant updatedAt;
 
    @PrePersist
    void onCreate() {
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }
 
    @PreUpdate
    void onUpdate() {
        this.updatedAt = Instant.now();
    }
 
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
 
    public Departament getDepartament() { return departament; }
    public void setDepartament(Departament departament) { this.departament = departament; }
 
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
 
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
