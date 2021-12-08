package ru.job4j.collection.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name =  p -> key.contains(p.getName());
        Predicate<Person> surName = p -> key.contains(p.getSurname());
        Predicate<Person> phone = p ->  key.contains(p.getPhone());
        Predicate<Person> address = p -> key.contains(p.getAddress());
        Predicate<Person> combine = name.or(surName.or(phone.or(address)));

        var result = new ArrayList<Person>();
        for (Person persone : persons) {
            if (combine.test(persone)) {
                result.add(persone);
            }
        }
        return result;
    }
}
