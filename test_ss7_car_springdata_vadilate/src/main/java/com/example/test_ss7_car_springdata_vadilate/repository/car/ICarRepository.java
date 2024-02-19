package com.example.test_ss7_car_springdata_vadilate.repository.car;

import com.example.test_ss7_car_springdata_vadilate.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICarRepository extends JpaRepository<Car,Long> {
     Page<Car> findAll(Pageable pageable);
     @Query(value = "SELECT * FROM car where name_car like %:name_car%",nativeQuery = true)
     List<Car> listSearchcar(@Param("name_car") String nameCar);

     @Query(value = "SELECT * FROM car where name_car like %:name_car%",nativeQuery = true)
     Page<Car> listSearchcar2(Pageable pageable,@Param("name_car") String nameCar);

}
