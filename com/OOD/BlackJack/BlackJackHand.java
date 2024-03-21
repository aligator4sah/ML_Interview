package com.OOD.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand {
    @Override
    public int score() {
        List<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for (Integer score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    public void print() {
        System.out.println("Current score: " + this.score());
    }

    public boolean busted() {
        return score() > 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        Card first = cards.get(0);
        Card second = cards.get(1);
        return (isAce(first) && isFaceCard(second)) || (isAce(second) && isFaceCard(first));
    }

    private boolean isAce(Card card) {
        return card.value() == 1;
    }

    private boolean isFaceCard(Card card) {
        return card.value() >= 11 && card.value() <= 13;
    }

    private List<Integer> possibleScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card card : this.cards) {
            updateScore(card, scores);
        }
        return scores;
    }

    

    private void updateScore(Card card, List<Integer> scores) {
        final int[] toAdd = getScores(card);
        if (scores.isEmpty()) {
            for (int num : toAdd) {
                scores.add(num);
            }
        } else {
            final int length = scores.size();
            for (int i = 0; i < length; i++) {
                int oldScore = scores.get(i);
                scores.set(i, oldScore + toAdd[0]);
                for (int j = 1; j < toAdd.length; j++) {
                    scores.add(oldScore + toAdd[j]);
                }
            }
        }
    }

    private int[] getScores(Card card) {
        if (card.value() > 1) {
            return new int[]{Math.min(card.value(), 10)};
        } else {
            return new int[]{1, 11};
        }
    }
    
}
