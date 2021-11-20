package ru.job4j.stream;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixListTest {

    @Test
    public void matrixNoDubl() {
        Integer[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> result = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        MatrixList ml = new MatrixList();
        List<Integer> expected = ml.matrixToList(matrix);
        assertThat(result, is(expected));
    }

    @Test
    public void matrixWithDubl() {
        Integer[][] matrix = {{1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4}
        };
        List<Integer> result = List.of(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4);
        MatrixList ml = new MatrixList();
        List<Integer> expected = ml.matrixToList(matrix);
        assertThat(result, is(expected));
    }
}