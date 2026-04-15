package com.tech.courses.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateEmployRequest {

    @NotBlank(message = "name is required")
    @Size(max = 150, message = "name must be <= 150 chars")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "email must be a valid address")
    @Size(max = 200, message = "email must be <= 200 chars")
    private String email;

    @Size(max = 100, message = "position must be <= 100 chars")
    private String position;

    @NotNull(message = "salary is required")
    @Min(value = 0, message = "salary must be >= 0")
    private Double salary;

    private Long departamentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Long departamentId) {
        this.departamentId = departamentId;
    }
}