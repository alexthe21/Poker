/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Scanner;

/**
 *
 * @author alex
 */
public class StartingView {

    private String[] playerNames;
    private int hands;

    public StartingView() {
        this.playerNames = new String[4];
    }

    public void setNames() {
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Player " + i + " name:");
            this.playerNames[i] = reader.nextLine();
        }
    }
    
    public String[] getNames(){
        return this.playerNames;
    }
    
    public void setHands() {
        Scanner reader = new Scanner(System.in);
   
            System.out.println("How many hands are they playing?:");
            this.hands = reader.nextInt();
        
    }
    
    public int getHands(){
        return this.hands;
    }
}
