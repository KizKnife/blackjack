package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // create deck
        Deck deck = new Deck();

        // shuffle
        deck.shuffle();

        // create player list
        ArrayList<Player> playerArrayList = new ArrayList<>();

        System.out.println("Welcome to Blackjack!");
        System.out.println();

        // player enter
        while (true) {
            System.out.print("How many players: ");
            int players = input.nextInt();

            if (players > 0) {
                for (int i = 1; i <= players; i++) {
                    playerArrayList.add(new Player("Player " + i));
                }
                break;
            } else {
                System.out.println("Invalid input!");
            }
        }

        System.out.println(playerArrayList.size() + " player(s) have joined the game!");

        // player names
        input.nextLine();
        for (Player player : playerArrayList) {
            System.out.print("Enter player name: ");
            String name = input.nextLine();
            player.setName(name);
        }

        // deal 2 cards to each player
        for (Player player : playerArrayList) {
            player.getHand().deal(deck.deal());
            player.getHand().deal(deck.deal());

            int handValue = player.getHand().getValue();

            System.out.println(
                    player.getName() + "'s hand is worth " + handValue + "!"
            );
        }

        // dealer first deal
        Player dealer = new Player("Dealer");
        dealer.getHand().deal(deck.deal());
        int dealerHandValue = dealer.getHand().getValue();
        System.out.println(
                dealer.getName() + "'s hand is worth " + dealerHandValue + "!"
        );

        System.out.println();

        // deal cards to each player
        for (Player player : playerArrayList) {
            int handValue = player.getHand().getValue();

            System.out.println(
                    player.getName() + "'s hand is worth " + handValue + "!"
            );

            while (true) {
                if (handValue > 21) {
                    System.out.println(
                            player.getName() + " has lost the game!"
                    );
                    return;
                }

                System.out.print("Hit (Y/N): ");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    player.getHand().deal(deck.deal());

                    handValue = player.getHand().getValue();

                    System.out.println(
                            player.getName() + "'s hand is worth " + handValue + "!"
                    );
                } else if (choice.equalsIgnoreCase("n")) {
                    System.out.println(player.getName() + " stays!");
                    break;
                } else {
                    System.out.println("Invalid input!");
                }
            }
        }

        // dealer final deal
        dealer.getHand().deal(deck.deal());
        dealerHandValue = dealer.getHand().getValue();
        System.out.println(
                "Dealer's hand is worth " + dealer.getHand().getValue() + "!"
        );

        for (Player player : playerArrayList) {
            int handValue = player.getHand().getValue();

            if (!player.isBust()) {
                while (dealer.getHand().getValue() < 21) {
                    dealer.getHand().deal(deck.deal());
                }
            }
            dealer.getHand().getValue();

            System.out.println(
                    "Dealer's hand is worth " + dealerHandValue + "!"
            );
        }
    }
}