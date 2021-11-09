package ru.job4j.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDiapason {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<Double>();
        for (int x = start; x < end; x++) {
            result.add(func.apply(Double.valueOf(x)));
        }
        return result;
    }
}
