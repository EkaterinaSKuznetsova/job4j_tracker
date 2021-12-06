package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", value=" + value + '}';
    }

    public static void main(String[] args) {
        Suit[] suits = {Suit.Diamods, Suit.Clubs, Suit.Spades, Suit.Hearts};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        List<Card> cards = Stream.of(suits)
                .flatMap(s -> Stream.of(values)
                        .map(t -> new Card(s, t)))
                .collect(Collectors.toList());
        cards.forEach(System.out::println);
    }
}

