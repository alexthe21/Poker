/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author alex
 */
public class Player {

    int id;
    Hand hand;
    int victories;

    public Player(int id) {
        this.id = id;
        this.hand = new Hand();
        this.victories = 0;
    }

    public int getId() {
        return this.id;
    }

    public Card[] discard(){
        return this.hand.discard();
    }
    
    public int askCards(){
        return 5 - this.hand.size();
    }
    public void takeCard(Card[] c) {
        this.hand.takeCard(c);
    }

    public void discardAll() {
        this.hand.discardAll();
    }

    public int getScore() {
        return this.hand.getScore();
    }

    public void resetScore(){
        this.hand.resetScore();
        this.hand.resetHandValue();
    }
    
    public void setScore(){
        this.hand.setScore();
    } 
    public void win() {
        this.victories++;
    }

    @Override
    public String toString() {
        return "Player: " + this.id + " Wins: " + this.victories + " Hand: " + 
                this.hand.toString();
    }
}
