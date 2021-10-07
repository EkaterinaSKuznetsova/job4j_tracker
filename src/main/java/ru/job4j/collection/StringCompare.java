package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        int index = 0;
        int length = Math.min(right.length(), left.length());
        int rsl = 0;
        while (index < length && rsl == 0) {
            rsl = Character.compare(left.charAt(index), right.charAt(index));
            index++;

        }
        if (rsl == 0) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}

