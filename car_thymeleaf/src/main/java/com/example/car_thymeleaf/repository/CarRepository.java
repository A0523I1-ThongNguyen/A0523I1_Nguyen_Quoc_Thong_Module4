package com.example.car_thymeleaf.repository;

import com.example.car_thymeleaf.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository implements ICarRepository {
    static List<Car> listCar = new ArrayList<>();

    static {
        listCar.add(new Car(1, "Camry", 1550, new String[]{"2.5Q", "2.0"}, true));
        listCar.add(new Car(2, "Accent", 1550, new String[]{"AT", "MT", "ATH"}, true));
        listCar.add(new Car(3, "Civic", 1550, new String[]{"Turbo", "normal"}, false));
    }

    @Override
    public List<Car> findAll() {
        return listCar;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < listCar.size(); i++) {
            if (listCar.get(i).getId() == id) {
                listCar.remove(i);
            }
        }
    }
}
