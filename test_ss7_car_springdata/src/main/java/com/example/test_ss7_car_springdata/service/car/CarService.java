package com.example.test_ss7_car_springdata.service.car;

import com.example.test_ss7_car_springdata.model.Car;
import com.example.test_ss7_car_springdata.repository.car.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService{
    @Autowired
    private ICarRepository iCarRepository;
    @Override
    public Page<Car> findAll2(Pageable pageable) {
        return iCarRepository.findAll(pageable);
    }

    @Override
    public void add(Car car) {
//        car = null;
        iCarRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        iCarRepository.deleteById(id);
    }

    @Override
    public Car findById(Long id) {
        return iCarRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Car car) {
        iCarRepository.save(car);
    }
}
