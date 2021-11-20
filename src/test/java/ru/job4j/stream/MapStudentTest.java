package ru.job4j.stream;


import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MapStudentTest {
    @Test
    public void whenListWithoutDublicate() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        MapStudent ms = new MapStudent();
        Map<String, Student> rsl = new HashMap<>(Map.of(
                "Surname1", new Student(10, "Surname1"),
                "Surname4", new Student(40, "Surname4"),
                "Surname5", new Student(50, "Surname5"),
                "Surname7", new Student(70, "Surname7"),
                "Surname9", new Student(90, "Surname9"))
        );
        Map<String, Student> expected = ms.creatMap(students);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenListWithDublicate() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        MapStudent ms = new MapStudent();
        Map<String, Student> rsl = new HashMap<>(Map.of(
                "Surname1", new Student(10, "Surname1"),
                "Surname4", new Student(40, "Surname4"),
                "Surname5", new Student(50, "Surname5"),
                "Surname7", new Student(70, "Surname7"),
                "Surname9", new Student(90, "Surname9"))
        );
        Map<String, Student> expected = ms.creatMap(students);
        assertThat(rsl, is(expected));
    }

}