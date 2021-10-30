package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] arrayO1 = o1.split("/");
        String[] arrayO2 = o2.split("/");
        int length = Math.min(arrayO1.length, arrayO2.length);
        int rsl = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                rsl = arrayO2[i].compareTo(arrayO1[i]);
                if (rsl != 0) {
                    return rsl;
                }
                continue;
            }
            rsl = arrayO1[i].compareTo(arrayO2[i]);
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(arrayO1.length, arrayO2.length);
    }
}
