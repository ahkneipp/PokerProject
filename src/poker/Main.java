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
	//These arrays will now just be unidealized
	static char [][] fullDeck = new char[3][12];
	static char[] cards= new char[12];

	
    public static void main(String args[])
    {
	//pass the arrays to the DeckCreator class
	//DeckCreator deckGen = new DeckCreator(cards, fullDeck);
	Hand test = new Hand();
	test.viewHand();
	System.out.println("Your score was: " + HandScorer.scoreHand(test));		
	}
	
	
}

