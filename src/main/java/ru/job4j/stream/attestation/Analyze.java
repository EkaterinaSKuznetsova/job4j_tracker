package ru.job4j.stream.attestation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects().stream())
                .mapToInt(s -> s.getScore())
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(p -> new Tuple(p.getName(),
                                    p.getSubjects().stream()
                                     .mapToInt(s -> s.getScore())
                                     .average()
                                     .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {

        return stream.flatMap(p -> p.getSubjects().stream())
               .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                       Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
               .map(m -> new Tuple(m.getKey(), m.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
      return  stream.map(p -> new Tuple(p.getName(),
                p.getSubjects().stream()
                        .mapToInt(s -> s.getScore())
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
