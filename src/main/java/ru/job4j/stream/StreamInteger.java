package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInteger {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(new Integer[]{0, -1, -2, 5, 7, 8, -10, 70});
        List<Integer> positive = numbers.stream().filter(number -> number > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);

    }
}

