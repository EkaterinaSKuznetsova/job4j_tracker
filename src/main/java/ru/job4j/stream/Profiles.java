package ru.job4j.stream;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Adress> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(new Comparator<Adress>() {
                    @Override
                    public int compare(Adress o1, Adress o2) {
                        return o1.getCity().compareTo(o2.getCity());
                    }
                })
                .distinct()
                .collect(Collectors.toList());
    }
}

