/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

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
        switch (this.number) {
            case 13:
                return "A" + this.suit;
            case 12:
                return "K" + this.suit;
            case 11:
                return "Q" + this.suit;
            case 10:
                return "J" + this.suit;
            case 9:
                return "10" + this.suit;
            case 8:
                return "9" + this.suit;
            case 7:
                return "8" + this.suit;
            case 6:
                return "7" + this.suit;
            case 5:
                return "6" + this.suit;
            case 4:
                return "5" + this.suit;
            case 3:
                return "4" + this.suit;
            case 2:
                return "3" + this.suit;
            case 1:
                return "2" + this.suit;
            default:
                return this.number + this.suit;
        }
    }
}
