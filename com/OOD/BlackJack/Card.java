package com.OOD.BlackJack;

public class Card {
    private int faceValue;
    private Suit suit;

    Card(int val, Suit suit) {
        this.faceValue = val;
        this.suit = suit;
    }

    public int value() {
        return this.faceValue;
    }

    public Suit suit() {
        return this.suit;
    }
}
