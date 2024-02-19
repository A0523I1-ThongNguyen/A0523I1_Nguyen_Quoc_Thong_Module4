package com.example.test_ss7_car_springdata.repository.car;

import com.example.test_ss7_car_springdata.model.Brand;
import com.example.test_ss7_car_springdata.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarRepository extends JpaRepository<Car,Long> {
     Page<Car> findAll(Pageable pageable);

}
