package com.example.test_ss7_car_springdata_vadilate.service.car;

import com.example.test_ss7_car_springdata_vadilate.model.Car;
import com.example.test_ss7_car_springdata_vadilate.repository.car.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Car> listSearchcar(String nameCar) {
        return iCarRepository.listSearchcar(nameCar);
    }

    @Override
    public Page<Car> listSearchcar2(Pageable pageable, String nameCar) {
        return iCarRepository.listSearchcar2(pageable,nameCar);
    }
}
