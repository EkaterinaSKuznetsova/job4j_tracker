package ru.job4j.stream;

import java.util.Objects;

public class Profile {
    private Address address;
    private String name;

    public Profile(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address getAddress() {
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
