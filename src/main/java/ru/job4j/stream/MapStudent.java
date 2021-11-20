package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStudent {
    public Map<String, Student> creatMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(student -> student.getSurname(), student -> student));
    }
}
