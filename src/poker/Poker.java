/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Random;

/**
 *
 * @author alex
 */
public class Poker {

    Deck deck;
    Player[] players = new Player[4];
    Player turn;
    int stage;

    public Poker() {
        for (int i = 0; i < 4; i++) {
            this.players[i] = new Player(i);
        }
        Random ran = new Random();
        int rnd = ran.nextInt(4);
        this.turn = this.players[rnd];
    }

    public void play() {
        for (int i = 0; i < 5; i++) {
            //Instance a new deck.
            this.deck = new Deck();
            this.resetScores();

            //Shuffle the cards.
            this.shuffle();

            //First stage of the game.
            this.stage = 0;

            //Deal 5 cards to each player.
            for (int j = 0; j < this.players.length; j++) {
                this.deal(5);
            }
            System.out.println(this.toString());

            //Next game stage.
            this.stage++;
            
            //Discard and take X cards.
            for (int j = 0; j < this.players.length; j++) {
                this.discard();
            }

            //Check the winner.
            this.setScores();
            this.getWinner().win();
            System.out.println(this.toString());

            //Discard all cards.
            this.discardAll();

            //Next player will start new hand.
            this.passTurn();
        }
    }

    private void shuffle() {
        this.deck.shuffle();
    }

    private void resetScores() {
        for (int i = 0; i < this.players.length; i++) {
            this.turn.resetScore();
            this.passTurn();
        }
    }

    private void setScores() {
        for (int i = 0; i < this.players.length; i++) {
            this.players[i].setScore();
        }
    }

    private void deal(int num) {
        this.turn.takeCard(this.deck.deal(num));
        this.passTurn();
    }

    private void discard() {
        this.deal(this.turn.discard().length);
    }

    private void passTurn() {
        int currentTurn = this.turn.getId();
        currentTurn++;
        if (currentTurn == this.players.length) {
            currentTurn = 0;
        }
        this.turn = this.players[currentTurn];
    }

    private Player getWinner() {
        Player winner = this.players[0];
        for (int i = 1; i < this.players.length; i++) {
            if (this.players[i].getScore() > winner.getScore()) {
                winner = this.players[i];
            }
        }
        return winner;
    }

    private void discardAll() {
        for (int i = 0; i < players.length; i++) {
            this.turn.discardAll();
            this.passTurn();
        }
    }

    @Override
    public String toString() {
        String str = "";
        str = str + this.deck.toString() + "\n";
        for (int i = 0; i < this.players.length; i++) {
            str = str + this.players[i].toString() + "\n";
        }
        str = str + "Stage: " + this.stage + "\n";
        return str;
    }
}
