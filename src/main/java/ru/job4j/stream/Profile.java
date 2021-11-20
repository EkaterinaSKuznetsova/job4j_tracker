package ru.job4j.stream;

import java.util.Objects;

public class Profile {
    private Adress address;
    private String name;

    public Profile(Adress address, String name) {
        this.address = address;
        this.name = name;
    }

    public Adress getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(getAddress(), profile.getAddress())
                && Objects.equals(getName(), profile.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress(), getName());
    }
}

