package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Car car1 = new Car("BMW", "M5");
        Car car2 = new Car("Honda", "Accord");
        Car car3 = new Car("Toyota", "Camry");
        Car car4 = new Car("Toyota", "Corolla");

        // List<Car> cars = Arrays.asList(car1, car2, car3, car4);

        // carRepository.saveAll(cars);

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);

    }


}
