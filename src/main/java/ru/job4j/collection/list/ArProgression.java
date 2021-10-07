package ru.job4j.collection.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        int summa = 0;
        for (int i = 0; i < data.size() - 2; i++) {
            if (data.get(i + 1) == (data.get(i) + data.get(i + 2)) / 2) {
                summa = summa + data.get(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> data = List.of(
                1, 6, 11, 16, 21,
                26, 31, 36, 41, 46
        );
        int rsl = ArProgression.checkData(data);
        System.out.println(rsl);
    }
}