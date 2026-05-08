package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    public Hand(){
        cards = new ArrayList<>();
    }

    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void deal(Card card){
        cards.add(card);
    }
    public int getSize(){
        return cards.size();
    }

    // The Hand uses the methods of each card to determine
    // the value of each card - and adds up all values
    public int getValue(){
        int value = 0;
        for(Card card: cards){
            card.flip(); // turn the card over to see the value
            value += card.getPointValue();
            //System.out.println(card.getPointValue());
            showCard(card);
            System.out.println(showCard(card));
            card.flip(); // hide the card again
        }
        return value;
    }

    public String showCard(Card card) {
        return switch (card.getValue()) {
            case "A" ->
                    "  ___\n" +
                    " |A  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "2" ->
                    "  ___\n" +
                    " |2  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "3" ->
                    "  ___\n" +
                    " |3  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "4" ->
                    "  ___\n" +
                    " |4  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "5" ->
                    "  ___\n" +
                    " |5  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "6" ->
                    "  ___\n" +
                    " |6  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "7" ->
                    "  ___\n" +
                    " |7  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "8" ->
                    "  ___\n" +
                    " |8  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "9" ->
                    "  ___\n" +
                    " |9  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "10" ->
                    "  ___\n" +
                    " |10 |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "J" ->
                    "  ___\n" +
                    " |J  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "Q" ->
                    "  ___\n" +
                    " |Q  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            case "K" ->
                    "  ___\n" +
                    " |K  |\n" +
                    " |(`)|\n" +
                    " |_\\_|";
            default -> "\uD83C\uDCA0";
        };
    }
}