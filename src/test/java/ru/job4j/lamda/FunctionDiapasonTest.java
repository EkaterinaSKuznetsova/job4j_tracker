package ru.job4j.lamda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FunctionDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinerResultat() {
        List<Double> result = FunctionDiapason.diapason(5, 8, (x) -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunction() {
        List<Double> result = FunctionDiapason.diapason(5, 8, (x) -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPowFunction() {
        List<Double> result = FunctionDiapason.diapason(5, 8, (x) -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(3125D, 15625D, 78125D);
        assertThat(result, is(expected));
    }

}