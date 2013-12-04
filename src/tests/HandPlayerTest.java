/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import models.Player;
import models.Card;

/**
 *
 * @author alex
 */
public class HandPlayerTest {
    public static void main(String[] args){
        Player p1 = new Player(0, "John Doe");
        Card[] c = {new Card(1, "♣"), new Card(1, "❤"), new Card(1, "♦"), 
            new Card(1, "♠"), new Card(3, "♣")};
        p1.takeCard(c);
        p1.setScore();
        System.out.println(p1.toString());
    }
}
