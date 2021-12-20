package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int  sumAllOperation(int number) {
        return sum(number) + minus(number) + multiply(number) + divide(number);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(x + " + 10 = " + result);
        Calculator calc = new Calculator();
        result = calc.multiply(5);
        System.out.println(x + " * 5 = " + result);
        result = Calculator.minus(8);
        System.out.println("8 - " + x + " = " + result);
        result = calc.divide(5);
        System.out.println("5 / " + x + " = " + result);
        result = calc.sumAllOperation(5);
        System.out.println(result);
    }
}