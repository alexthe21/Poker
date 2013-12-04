/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.StartingView;
/**
 *
 * @author alex
 */
public class Start {

    public static void main(String[] args) {
        StartingView strvw = new StartingView();
        strvw.setNames();
        strvw.setHands();
        
        Poker poker = new Poker(strvw.getNames(), strvw.getHands());
        poker.play();
    }
}