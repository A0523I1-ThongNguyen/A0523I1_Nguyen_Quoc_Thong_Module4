package com.example.test_ss9_validate_oap_exception.repository.car;

import com.example.test_ss9_validate_oap_exception.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarRepository extends JpaRepository<Car,Integer> {
    @Override
    Page<Car> findAll(Pageable pageable);
    @Query(value = "select count(*) from car where id_car = :idCar",nativeQuery = true)
        int idRandom(@Param("idCar") int idCar);
}
