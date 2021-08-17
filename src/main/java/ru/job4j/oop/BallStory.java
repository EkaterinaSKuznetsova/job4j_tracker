package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        hare.tryEat(ball);
        ball.say();
        Wolf wolf = new Wolf();
        wolf.tryEat(ball);
        ball.say();
        Fox fox = new Fox();
        fox.tryEat(ball);
        ball.say();

    }
}
