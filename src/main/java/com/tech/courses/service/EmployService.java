package com.tech.courses.service;

import java.util.List;
 
import com.tech.courses.dto.CreateEmployRequest;
import com.tech.courses.dto.EmployResponse;
 
public interface EmployService {
 
    EmployResponse create(CreateEmployRequest request);
 
    List<EmployResponse> list();
 
    EmployResponse getById(Long id);
}