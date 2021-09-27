package ru.job4j.collection.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person value:persons) {
            if (key.equals(value.getName()) || key.equals(value.getSurname()) ||
                    key.equals(value.getPhone()) || key.equals(value.getAddress())) {
                result.add(value);
            }

        }
        return result;
    }
}
