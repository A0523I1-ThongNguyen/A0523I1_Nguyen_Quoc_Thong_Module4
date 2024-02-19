package com.example.one_to_many.repository;

import com.example.one_to_many.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

}
