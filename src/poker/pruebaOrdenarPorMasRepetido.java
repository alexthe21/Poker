/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.*;

/**
 *
 * @author alex
 */
public class pruebaOrdenarPorMasRepetido {

    public static void main(String[] args) {
        ArrayList<Card> hand = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int ran = r.nextInt(13) + 1;
            int ran2 = r.nextInt(4);
            String suit;
            switch (ran2) {
                case 0:
                    suit = "♣";
                    break;
                case 1:
                    suit = "♦";
                    break;
                case 2:
                    suit = "♠";
                    break;
                case 3:
                    suit = "❤";
                    break;
                default:
                    suit = "❤";
                    break;
            }
            hand.add(new Card(ran, suit));
        }
        Collections.sort(hand, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.getNumber() - c2.getNumber();
            }
        });
        for (int i = 0; i < hand.size(); i++) {
            if (i < hand.size() - 1) {
                if (hand.get(0).getNumber() != hand.get(1).getNumber()) {
                    hand.add(hand.remove(0));
                }
            }
        }
    }
}
