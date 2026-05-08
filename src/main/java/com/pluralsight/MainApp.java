package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Deck deck = new Deck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        // shuffle
        deck.shuffle();

        // deal 2 cards to player 1
        for(int i = 0; i < 2; i++) {
            // get a card from the deck
            Card card = deck.deal();

            // deal that card to the hand
            hand1.deal(card);
        }

        int hand1Value = hand1.getValue();

        System.out.println("Player 1's hand is worth " + hand1Value);

        // deal 2 cards to player 2
        for(int i = 0; i < 2; i++) {
            // get a card from the deck
            Card card = deck.deal();

            // deal that card to the hand
            hand2.deal(card);
        }

        int hand2Value = hand2.getValue();

        System.out.println("Player 2's hand is worth " + hand2Value);

        System.out.println();

        if (hand1Value <= 21 && hand1Value > hand2Value) {
            System.out.println("Player 1 wins!");
        } else if (hand1Value == hand2Value) {
            System.out.println("Tie!");
        } else if (hand2Value <= 21) {
            System.out.println("Player 2 wins!");
        }

//        while (true) {
//            int handValue = hand1.getValue();
//            System.out.println("This hand is worth " + handValue);
//
//            if (handValue > 21) {
//                System.out.println("You lose!");
//                return;
//            } else if (handValue <= 21) {
//                System.out.printf("Hit (Y/N): ");
//                String choice = input.nextLine();
//
//                if (choice.equalsIgnoreCase("y")) {
//                    Card card = deck.deal();
//                    hand1.deal(card);
//                } else {
//                    return;
//                }
//            }
//        }
    }
}