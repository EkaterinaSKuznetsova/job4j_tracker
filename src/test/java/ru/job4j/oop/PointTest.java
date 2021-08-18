package ru.job4j.oop;

import org.junit.Test;

import org.junit.Assert;

public class PointTest {

    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when20to00then2() {
        double expected = 2;
        Point a = new Point(2, 0);
        Point b = new Point(0, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when13to20then3and16() {
        double expected = 3.16;
        Point a = new Point(1, 3);
        Point b = new Point(2, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when05to50then7and07() {
        double expected = 7.07;
        Point a = new Point(0, 5);
        Point b = new Point(5, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when58to00then9and43() {
        double expected = 9.43;
        Point a = new Point(5, 8);
        Point b = new Point(0, 0);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenDistance3D() {
        double expected = 9.49;
        Point a = new Point(5, 8, 0);
        Point b = new Point(0, 0, 1);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenDistance3DTest2() {
        double expected = 4.12;
        Point a = new Point(0, 8, 0);
        Point b = new Point(0, 4, 1);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}