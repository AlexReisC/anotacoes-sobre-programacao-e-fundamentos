package com.example.Comportamentos.test;

import java.util.ArrayList;
import java.util.List;

import com.example.Comportamentos.dominio.Car;
import com.example.Comportamentos.interfaces.CarPredicate;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("red", 2020), new Car("black", 2008));

    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        // Lambda
        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));

        System.out.println(greenCars);
        System.out.println(redCars);
    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate){
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
