package ru.job4j.oop;

import ru.job4j.ex.UserInputException;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport tp = car;
        Object obj = car;
        Object ocar = new Car();
        Car carFromObject = (Car) ocar;
        Object bicycle = new Bicycle();
        Car cb = (Car) bicycle;
        System.out.println(new Car());
        System.out.println(new Bicycle());
        System.out.println(new Object());
    }
}
