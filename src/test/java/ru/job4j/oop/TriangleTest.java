package ru.job4j.oop;

import org.hamcrest.Matcher;
import org.junit.Assert;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;

public class TriangleTest {

    @Test
    public void area() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertThat(rsl, closeTo(8, 0.001));
    }
}