package ru.job4j.poly;

public class Bus implements  Transport {
    @Override
    public void drive() {
        System.out.println("Drive, drive, drive.");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Number of passengers = " + number);
    }

    @Override
    public float fill(float number) {
        float price = 39.50f;
        return number * price;
    }
}
