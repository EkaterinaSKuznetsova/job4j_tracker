package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStudent {
    public Map<String, Student> creatMap(List<Student> students) {
        return students.stream()
               .collect(Collectors.toMap(
                       Student::getSurname,
                       student -> student,
                       (student1, student2) -> student2));
    }
}

