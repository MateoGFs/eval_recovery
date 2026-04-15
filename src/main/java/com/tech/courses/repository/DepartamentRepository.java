package com.tech.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.tech.courses.entity.Departament;
 
public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
