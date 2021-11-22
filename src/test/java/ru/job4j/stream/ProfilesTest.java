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
    public void whenSpisokClientsDifferentAddress() {
        List<Profile> client = List.of(
                new Profile(new Address("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                        "Vasiliy Petrov"),
                new Profile(new Address("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Aleksey Gorshkov"),
                new Profile(new Address("Saint - Peterburg", "Liteinui pr.", 45, 90),
                        "Anna Novikova")
        );
        List<Address> rsl = List.of(
                new Address("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                new Address("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                new Address("Saint - Peterburg", "Liteinui pr.", 45, 90)
        );
        Profiles pr = new Profiles();
        List<Address> expected = pr.collect(client);
        assertThat(rsl, is(expected));

    }

    @Test
    public void whenSpisokClientsWithSameAdress() {
        List<Profile> client = List.of(
                new Profile(new Address("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                        "Artem Volkov"),
                new Profile(new Address("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Irina Ivanova"),
                new Profile(new Address("Saint - Peterburg", "Liteinui pr.", 45, 90),
                        "Alisa Selezneva"),
                new Profile(new Address("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Vladimir Petrov"),
                new Profile(new Address("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                        "Dmitriy Sokolov")
        );
        List<Address> rsl = List.of(
                new Address("Saint - Peterburg", "Nevskiy pr.", 45, 54),
                new Address("Saint - Peterburg", "B. Morskay pr.", 76, 13),
                new Address("Saint - Peterburg", "Liteinui pr.", 45, 90)
                );
        Profiles pr = new Profiles();
        List<Address> expected = pr.collect(client);
        assertThat(rsl, is(expected));

    }

    @Test
    public void whenSpisokClientsWithDublicateAdress() {
        List<Profile> client = List.of(
                new Profile(new Address("Санкт - Петербург", "Невский проспект", 45, 54),
                        "Vasiliy Petrov"),
                new Profile(new Address("Волгоград", "Морская улица", 76, 13),
                        "Aleksey Gorshkov"),
                new Profile(new Address("Астрахань", "Советсткий проспект", 45, 90),
                        "Anna Novikova"),
                new Profile(new Address("Санкт - Петербург", "Невский проспект", 45, 54),
                        "Elmira Petrova"),
                new Profile(new Address("Волгоград", "Морская улица", 76, 13),
                        "Anna Gorshkova")

        );
        List<Address> rsl = List.of(
                new Address("Астрахань", "Советсткий проспект", 45, 90),
                new Address("Волгоград", "Морская улица", 76, 13),
                new Address("Санкт - Петербург", "Невский проспект", 45, 54)

        );
        Profiles pr = new Profiles();
        List<Address> expected = pr.collect(client);
        assertThat(rsl, is(expected));
    }
}