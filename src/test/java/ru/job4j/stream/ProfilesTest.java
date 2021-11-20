package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import ru.job4j.stream.Profiles;

public class ProfilesTest {
    @Test
    public void whenSpisokClientsDifferentAdress() {
        List<Profile> client = List.of(
                new Profile(new Adress("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                        "Vasiliy Petrov"),
                new Profile(new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Aleksey Gorshkov"),
                new Profile(new Adress("Saint - Peterburg", "Liteinui pr.", 45, 90),
                        "Anna Novikova")
        );
        List<Adress> rsl = List.of(
                new Adress("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                new Adress("Saint - Peterburg", "Liteinui pr.", 45, 90)
        );
        Profiles pr = new Profiles();
        List<Adress> expected = pr.collect(client);
        assertThat(rsl, is(expected));

    }

    @Test
    public void whenSpisokClientsWithSameAdress() {
        List<Profile> client = List.of(
                new Profile(new Adress("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                        "Artem Volkov"),
                new Profile(new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Irina Ivanova"),
                new Profile(new Adress("Saint - Peterburg", "Liteinui pr.", 45, 90),
                        "Alisa Selezneva"),
                new Profile(new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Vladimir Petrov"),
                new Profile(new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Dmitriy Sokolov")
        );
        List<Adress> rsl = List.of(
                new Adress("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                new Adress("Saint - Peterburg", "Liteinui pr.", 45, 90),
                new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                new Adress("Saint - Peterburg", "B. Morskay pr.", 76, 13)
        );
        Profiles pr = new Profiles();
        List<Adress> expected = pr.collect(client);
        assertThat(rsl, is(expected));

    }
}