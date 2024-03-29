package com.OOD.BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    protected final List<Card> cards = new ArrayList<>();

    public int score() {
        int score = 0;
        for (Card c : cards) {
            score += c.value();
        }
        return score;
    }

    public void addCards(Card[] c) {
        Collections.addAll(cards, c);
    }

    public int size() {
        return cards.size();
    }
    
}
