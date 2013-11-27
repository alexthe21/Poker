/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author alex
 */
public class HandPlayerTest {
    public static void main(String[] args){
        Player p1 = new Player(0);
        Card[] c = {new Card(1, "♣"), new Card(1, "❤"), new Card(1, "♦"), 
            new Card(1, "♠"), new Card(3, "♣")};
        p1.takeCard(c);
        p1.setScore();
        System.out.println(p1.toString());
    }
}
