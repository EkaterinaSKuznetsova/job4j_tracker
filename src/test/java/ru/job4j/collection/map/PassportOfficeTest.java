package ru.job4j.collection.map;

import org.junit.Test;
import ru.job4j.collection.UniqueText;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDublicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizenNext = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizenNext));
    }

}