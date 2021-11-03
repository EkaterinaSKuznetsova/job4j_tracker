package ru.job4j.lamda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] numbers = {
                "f",
                "jhjhjkh",
                "ghghgglkgkgglg",
                "fhf",
                "jj"
        };
        System.out.println("Array before compare:");
        for (String number : numbers) {
            System.out.println(number);
        }
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(numbers, comparator);
        System.out.println("Array after compare:");
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
