/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.Card;
import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>(52);
        int i = 0;
        int j = 1;
        while (i < 52) {
            this.cards.add(new Card(j, "♣"));
            i++;
            this.cards.add(new Card(j, "❤"));
            i++;
            this.cards.add(new Card(j, "♦"));
            i++;
            this.cards.add(new Card(j, "♠"));
            i++;
            j++;
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
    
    public Card[] deal(int num){
        Card[] card = new Card[num];
        for(int i = 0; i < num; i++){
            card[i] = this.cards.remove(i);
        }
        return card;
    }  
    
    @Override
    public String toString(){
        String deck = "Deck(";
        for(int i = 0; i < this.cards.size(); i++){
            if(i == 0){
                deck = deck + this.cards.get(i).toString();
            } else if(i % 20 == 0){
                deck += "\n\t";
            } else {
                deck += " " + this.cards.get(i).toString();
            }
        }
        return deck + ")";
    }
}
