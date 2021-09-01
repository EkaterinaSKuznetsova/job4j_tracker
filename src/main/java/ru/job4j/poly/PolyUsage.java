package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle bus = new Autobus();
        Vehicle plane = new Airplane();
        Vehicle train = new Train();
        Vehicle[] transports = {bus, plane, train};
        for (Vehicle transport:transports) {
            transport.move();
        }

    }
}
