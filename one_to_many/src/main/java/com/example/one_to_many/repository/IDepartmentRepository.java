package com.example.one_to_many.repository;

import com.example.one_to_many.model.Department;
import com.example.one_to_many.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {

}
