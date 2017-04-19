/*
 * Poker game project for AP Computer Science.
 * Written by:
 * Dylan Poole and
 * Alex Kneipp
 */
package poker;

import java.util.Scanner;

/*
 * This is where the poker game will start
 * It will not be the actual game board
 */
public class Main {
	
    public static void main(String args[])
    {
    //Create the player's hand
	Hand playerHand = new Hand();
	//Show the player their hand and ask if they want to swap out any cards
	playerHand.viewHand();
	//Show the player their new hand and their score.
	System.out.println("Your score was: " + HandScorer.scoreHand(playerHand));		
	}
	
	
}

