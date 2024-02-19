package com.example.demo_validate3.repository.department;

import com.example.demo_validate3.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
}
