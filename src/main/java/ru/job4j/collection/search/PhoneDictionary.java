package ru.job4j.collection.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person value : persons) {
            if (key.contains(value.getName()) || key.contains(value.getSurname())
                    || key.contains(value.getPhone()) || key.contains(value.getAddress())) {
                result.add(value);

            }
        }
        return result;
    }
}
