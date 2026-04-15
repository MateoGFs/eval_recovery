package com.tech.courses.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tech.courses.dto.CreateEmployRequest;
import com.tech.courses.dto.EmployResponse;
import com.tech.courses.service.EmployService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emploies")
public class EmployController {

    private final EmployService employService;

    public EmployController(EmployService employService) {
        this.employService = employService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployResponse create(@Valid @RequestBody CreateEmployRequest request) {
        return employService.create(request);
    }

    @GetMapping
    public List<EmployResponse> list() {
        return employService.list();
    }

    @GetMapping("/{id}")
    public EmployResponse getById(@PathVariable Long id) {
        return employService.getById(id);
    }
}
