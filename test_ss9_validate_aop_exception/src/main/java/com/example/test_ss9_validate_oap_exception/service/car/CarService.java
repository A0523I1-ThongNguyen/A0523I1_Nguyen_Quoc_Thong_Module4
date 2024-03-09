package com.example.test_ss9_validate_oap_exception.service.car;

import com.example.test_ss9_validate_oap_exception.model.Car;
import com.example.test_ss9_validate_oap_exception.repository.car.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CarService implements ICarService {
    @Autowired
    private ICarRepository iCarRepository;

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return iCarRepository.findAll(pageable);
    }

    @Override
    public void update(Car car) {
        iCarRepository.save(car);
    }

    @Override
    public Car findById(int id) {
        return iCarRepository.findById(id).orElse(null);
    }

    @Override
    public int randomIdCar() {
        int count;
        String convertSTI;
        do {
            int[] idNumbers = new int[5];
            for (int i = 0; i < idNumbers.length; i++) {
                idNumbers[i] = (int) (Math.random() * 10);
            }
            convertSTI = "";
            for (int num : idNumbers) {
                convertSTI += Integer.toString(num);
            }
            count = iCarRepository.idRandom(Integer.parseInt(convertSTI));
        } while (count != 0);
        return Integer.parseInt(convertSTI);
    }

    public  String getRandomCode() {
        String[] carBrands = { "Ford", "Toyota", "Hyundai" };
        Random random = new Random();
        int randomIndex = random.nextInt(carBrands.length);
        return carBrands[randomIndex];
    }

    @Override
    public void delete(int idCar) {
        iCarRepository.deleteById(idCar);
    }
}
