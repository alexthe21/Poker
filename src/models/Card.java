/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author alex
 */
public class Card {

    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getNumber() {
        return this.number;
    }

    public Card copy() {
        return new Card(this.number, this.suit);
    }

    @Override
    public String toString() {
        if (this.number < 10) {
            return (this.number + 1) + this.suit;
        } else {
            switch (this.number) {
                case 13:
                    return "A" + this.suit;
                case 12:
                    return "K" + this.suit;
                case 11:
                    return "Q" + this.suit;
                case 10:
                    return "J" + this.suit;
                default: 
                    return this.number + this.suit;
            }
        }
    }
}
