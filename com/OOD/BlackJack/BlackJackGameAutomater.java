package com.OOD.BlackJack;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGameAutomater {
    private Deck deck;
    private BlackJackHand[] hands;
    private static final int HIT_UTIL = 16;

    public BlackJackGameAutomater(int numOfPlayers) {
        hands = new BlackJackHand[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            hands[i] = new BlackJackHand();
        }
    }
    
    void initializeDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    boolean dealInitial() {
        for (BlackJackHand hand : hands) {
            Card[] cards = deck.dealHand(2);
            if (cards == null) {
                return false;
            }
            hand.addCards(cards);
        }
        return true;
    }

    List<Integer> getBlackJacks() {
        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].isBlackJack()) {
                winners.add(i);
            }
        }
        return winners;
    }

    boolean playHand(BlackJackHand hand) {
        while (hand.score() < HIT_UTIL) {
            Card card = deck.dealCard();
            if (card == null) {
                return false;
            }
            hand.addCards(new Card[]{card});
        }
        return true;
    }

    boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            if (!playHand(hand)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> getWinners() {
        List<Integer> winners = new ArrayList<>();
        int winningScore = 0;
        for (int i = 0; i < hands.length; i++) {
            BlackJackHand hand = hands[i];
            if (!hand.busted()) {
                if (hand.score() > winningScore) {
                    winningScore = hand.score();
                    winners.clear();
                    winners.add(i);
                } else if (hand.score() == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }

    void printHandsAndScore() {
        for (int i = 0; i < hands.length; i++) {
            System.out.println("Hand" + i + "(" + hands[i].score() + ")");
            // hands[i].print();
            System.out.println();
        }
    }

    public void simulate() {
        initializeDeck();

        boolean success = dealInitial();
        if (!success) {
            System.out.println("Error. Out of cards");
        } else {
            System.out.println("-- Initial -- ");
            printHandsAndScore();
            List<Integer> blackJacks = getBlackJacks();
            if (blackJacks.size() > 0) {
                System.out.print("Blackjacks at");
                for (Integer i :blackJacks) {
                    System.out.print(i + " ");
                }
                System.out.println("done");
            } else {
                success = playAllHands();
                if (!success) {
                    System.out.println("Out of cards");
                } else {
                    System.out.println("\n -- Completed Game -- ");
                    printHandsAndScore();
                    List<Integer> winners = getWinners();
                    if (winners.size() > 0) {
                        System.out.print("Winners: ");
                        for (Integer i : winners) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("Draw, all palyers have busted");
                    }
                }
            }
        }
    }
    
    // test case
    public static void main(String[] args) {
        BlackJackGameAutomater automator = new BlackJackGameAutomater(5);
        automator.simulate();
    }
}
