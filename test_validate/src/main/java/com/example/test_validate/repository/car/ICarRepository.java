package com.example.test_validate.repository.car;

import com.example.test_validate.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car,Long> {
//    Page<Car> findAll(Pageable pageable);
}
