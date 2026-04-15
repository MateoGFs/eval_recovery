package com.tech.courses.service.impl;

import java.util.List;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.tech.courses.dto.CreateEmployRequest;
import com.tech.courses.dto.EmployResponse;
import com.tech.courses.entity.Departament;
import com.tech.courses.entity.Employ;
import com.tech.courses.exception.ResourceNotFoundException;
import com.tech.courses.repository.DepartamentRepository;
import com.tech.courses.repository.EmployRepository;
import com.tech.courses.service.EmployService;
 
@Service
@Transactional
public class EmployServiceImpl implements EmployService {
 
    private final EmployRepository employRepository;
    private final DepartamentRepository departamentRepository;
 
    public EmployServiceImpl(EmployRepository employRepository,
                             DepartamentRepository departamentRepository) {
        this.employRepository = employRepository;
        this.departamentRepository = departamentRepository;
    }
 
    @Override
    public EmployResponse create(CreateEmployRequest request) {
        Employ employ = new Employ();
        employ.setName(request.getName());
        employ.setEmail(request.getEmail());
        employ.setPosition(request.getPosition());
        employ.setSalary(request.getSalary());
 
        if (request.getDepartamentId() != null) {
            Departament departament = departamentRepository.findById(request.getDepartamentId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Departament " + request.getDepartamentId() + " not found"));
            employ.setDepartament(departament);
        }
 
        Employ saved = employRepository.save(employ);
        return toResponse(saved);
    }
 
    @Override
    @Transactional(readOnly = true)
    public List<EmployResponse> list() {
        return employRepository.findAll().stream().map(this::toResponse).toList();
    }
 
    @Override
    @Transactional(readOnly = true)
    public EmployResponse getById(Long id) {
        Employ employ = employRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employ " + id + " not found"));
        return toResponse(employ);
    }
 
    private EmployResponse toResponse(Employ employ) {
        EmployResponse response = new EmployResponse();
        response.setId(employ.getId());
        response.setName(employ.getName());
        response.setEmail(employ.getEmail());
        response.setPosition(employ.getPosition());
        response.setSalary(employ.getSalary());
        if (employ.getDepartament() != null) {
            response.setDepartamentId(employ.getDepartament().getId());
            response.setDepartamentName(employ.getDepartament().getName());
        }
        response.setCreatedAt(employ.getCreatedAt());
        response.setUpdatedAt(employ.getUpdatedAt());
        return response;
    }
}
