package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(15);
        Battery second = new Battery(25);
        System.out.println("Load first battery = " + first.load);
        System.out.println("Load second battery = " + second.load);
        first.exchange(second);
        System.out.println("Load first battery = " + first.load);
        System.out.println("Load second battery = " + second.load);

    }
}
