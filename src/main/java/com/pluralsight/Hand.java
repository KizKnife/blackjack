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
                    " |KIZ|\n" +
                    " |__A|";
            case "2" ->
                    "  ___\n" +
                    " |2  |\n" +
                    " |KIZ|\n" +
                    " |__2|";
            case "3" ->
                    "  ___\n" +
                    " |3  |\n" +
                    " |KIZ|\n" +
                    " |__3|";
            case "4" ->
                    "  ___\n" +
                    " |4  |\n" +
                    " |KIZ|\n" +
                    " |__4|";
            case "5" ->
                    "  ___\n" +
                    " |5  |\n" +
                    " |KIZ|\n" +
                    " |__5|";
            case "6" ->
                    "  ___\n" +
                    " |6  |\n" +
                    " |KIZ|\n" +
                    " |__6|";
            case "7" ->
                    "  ___\n" +
                    " |7  |\n" +
                    " |KIZ|\n" +
                    " |__7|";
            case "8" ->
                    "  ___\n" +
                    " |8  |\n" +
                    " |KIZ|\n" +
                    " |__8|";
            case "9" ->
                    "  ___\n" +
                    " |9  |\n" +
                    " |KIZ|\n" +
                    " |__9|";
            case "10" ->
                    "  ___\n" +
                    " |10 |\n" +
                    " |KIZ|\n" +
                    " |_10|";
            case "J" ->
                    "  ___\n" +
                    " |J  |\n" +
                    " |KIZ|\n" +
                    " |__J|";
            case "Q" ->
                    "  ___\n" +
                    " |Q  |\n" +
                    " |KIZ|\n" +
                    " |__Q|";
            case "K" ->
                    "  ___\n" +
                    " |K  |\n" +
                    " |KIZ|\n" +
                    " |__K|";
            default -> "\uD83C\uDCA0";
        };
    }
}