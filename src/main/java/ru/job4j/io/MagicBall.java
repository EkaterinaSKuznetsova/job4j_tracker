package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        System.out.println("Я великий оракул. Что ты хочешь узнать?");
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                System.out.println("ДА");
                break;
            case 1:
                System.out.println("НЕТ");
                break;
            default:
                System.out.println("Может быть");
                break;
        }
    }
}
