/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author alex
 */
public class Hand {

    private ArrayList hand;
    private int score;
    private String handValue;

    public Hand() {
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public void takeCard(Card[] c) {
        this.hand.addAll(Arrays.asList(c));
        this.sortHand();
    }

    public Card[] discard() {
        ArrayList<Card> discartedCards = new ArrayList<>();
        Card[] discartedCardsArray;
        this.sortHand();
        this.handValue = this.checkHand();
        int lastCard;
        switch (this.handValue) {
            case "Three of a kind":
                lastCard = 2;
                break;
            case "Two pairs":
                lastCard = 3;
                break;
            case "One pair":
                lastCard = 1;
                break;
            case "High card":
                lastCard = 0;
                Collections.sort(this.hand, new Comparator<Card>() {
                    @Override
                    public int compare(Card c1, Card c2) {
                        return c2.getNumber() - c1.getNumber();
                    }
                });
                break;
            default:
                lastCard = 4;
                break;
        }
        for (int i = 4; i > lastCard; i--) {
            Card x = (Card) this.hand.remove(i);
            discartedCards.add(x);
        }
        discartedCardsArray = new Card[discartedCards.size()];
        discartedCards.toArray(discartedCardsArray);
        return discartedCardsArray;
    }

    private void sortHand() {
        Card[] handArray;
        Collections.sort(this.hand, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c2.getNumber() - c1.getNumber();
            }
        });
        handArray = new Card[this.hand.size()];
        for (int i = 0; i < this.hand.size(); i++) {
            this.hand.toArray(handArray);
            if (handArray[0].getNumber() == handArray[1].getNumber()) {
                //It's a pair
                if (handArray[0].getNumber() != handArray[2].getNumber()) {
                    //It's not three of a kind.
                    if (handArray[2].getNumber() == handArray[3].getNumber()
                            && handArray[2].getNumber() == handArray[4].getNumber()) {
                        //It's an inverted full house.
                        Collections.reverse(this.hand);
                    } else if(handArray[2].getNumber() != handArray[1].getNumber() &&
                            handArray[2].getNumber() != handArray[3].getNumber()){
                        //The middle card may be placed between two pairs.
                        this.hand.add(this.hand.remove(2));
                    }
                }
                break;
            } else {
                //Lonely card in the first position. Moving it to the end.
                this.hand.add(this.hand.remove(0));
            }
        }
    }

    public int size() {
        return this.hand.size();
    }

    public void discardAll() {
        this.hand.clear();
        this.score = 0;
    }

    private String checkHand() {
        Card[] handArray = new Card[this.hand.size()];
        this.hand.toArray(handArray);
        if (handArray[0].getNumber() == handArray[1].getNumber()) {
            if (handArray[0].getNumber() == handArray[2].getNumber()) {
                if (handArray[0].getNumber() == handArray[3].getNumber()) {
                    //Player has four of a kind.
                    return "Four of a kind";
                } else if (handArray[3].getNumber() == handArray[4].getNumber()) {
                    //Player has a full house.
                    return "Full house";
                } else {
                    //Player has three of a kind.
                    return "Three of a kind";
                }
            } else if (handArray[2].getNumber() == handArray[3].getNumber()) {
                //Player has two pairs.
                return "Two pairs";
            } else {
                //Player has one pair.
                return "One pair";
            }
        } else {
            //Player has high card.
            return "High card";
        }
    }

    public void resetScore() {
        this.score = 0;
    }
    public void resetHandValue(){
        this.handValue = "";
    }
    public void setScore() {
        Card[] handArray = new Card[this.hand.size()];
        this.sortHand();
        this.hand.toArray(handArray);
        this.handValue = this.checkHand();
        switch (this.handValue) {
            case "Four of a kind":
                this.score = 7000;
                this.score += handArray[0].getNumber() + handArray[1].getNumber()
                        + handArray[2].getNumber() + handArray[3].getNumber()
                        + handArray[4].getNumber();
                break;
            case "Full house":
                this.score = 6000;
                this.score += handArray[0].getNumber() + handArray[1].getNumber()
                        + handArray[2].getNumber() + handArray[3].getNumber()
                        + handArray[4].getNumber();
                break;
            case "Three of a kind":
                this.score = 3000;
                this.score += handArray[0].getNumber() + handArray[1].getNumber()
                        + handArray[2].getNumber();
                break;
            case "Two pairs":
                this.score = 2000;
                this.score += handArray[0].getNumber() + handArray[1].getNumber()
                        + handArray[2].getNumber() + handArray[3].getNumber()
                        + handArray[4].getNumber();
                break;
            case "One pair":
                this.score = 1000;
                this.score += handArray[0].getNumber() + handArray[1].getNumber();
                break;
            case "High card":
                this.score = handArray[0].getNumber();
                break;
        }
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        String str = "Score:" + this.score + " ";
        for (int i = 0; i < this.hand.size(); i++) {
            str += this.hand.get(i).toString() + " ";
        }
        return str + this.handValue;
    }
}
