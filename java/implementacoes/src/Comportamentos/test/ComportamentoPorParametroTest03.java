package Comportamentos.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Comportamentos.dominio.Car;

public class ComportamentoPorParametroTest03 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("red", 2020), new Car("black", 2008));

    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
        List<Car> redCars = filter(cars, car -> car.getColor().equals("red"));
        List<Car> yearBeforeCars = filter(cars, car -> car.getYear() < 2015);
        
        System.out.println(greenCars);
        System.out.println(redCars);
        System.out.println(yearBeforeCars);

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filter(nums, num -> num % 2 == 0));
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)){
                filteredList.add(t);
            }
        }
        return filteredList;
    }
}
