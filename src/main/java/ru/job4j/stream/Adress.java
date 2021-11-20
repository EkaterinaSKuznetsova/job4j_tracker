package ru.job4j.stream;

import java.util.Objects;

public class Adress {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Adress(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Adress)) {
            return false;
        }
        Adress adress = (Adress) o;
        return getHome() == adress.getHome() && getApartment()
                == adress.getApartment() && getCity().equals(adress.getCity())
                && getStreet().equals(adress.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getHome(), getApartment());
    }
}

