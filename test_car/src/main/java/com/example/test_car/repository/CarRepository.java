package com.example.test_car.repository;

import com.example.test_car.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository  implements ICarRepository{
    private static List<Car> listCar;

    static {
        listCar = new ArrayList<>();
        listCar.add(new Car(1, "Accent , Camry", new String[]{"Toyota,", "Huyndai"}, 520));
        listCar.add(new Car(2, "Vios", new String[]{"Toyota"}, 580));
        listCar.add(new Car(3, "Accent,Focus", new String[]{ "Huyndai,", "Ford"}, 600));
        listCar.add(new Car(4, "Santafe", new String[]{"Huyndai"}, 1420));
    }

    @Override
    public List<Car> findAll() {
        return listCar;
    }

    @Override
    public void add(Car car) {
        listCar.add(car);
    }

    @Override
    public void remove(Car car) {
        listCar.remove(car);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i <listCar.size();i++){
            if (id == listCar.get(i).getId()){
                listCar.remove(i);
            }
        }
    }



}
