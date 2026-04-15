package com.tech.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.courses.entity.Employ;

public interface EmployRepository extends JpaRepository<Employ, Long> {
}