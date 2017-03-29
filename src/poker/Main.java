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
	 

	
public static void main(String args[] ){
	//pass the arrays to the DeckCreator class
	DeckCreator deckGen = new DeckCreator(cards, fullDeck);
        //After this the deck will be created 
        //Have a translater class ready 
        //so that the user can read what card they got
//	deckGen.cardGen();
//	GamePlay game = new GamePlay();
//	game.test();
	JavaDollar dollar = new JavaDollar();
	System.out.println("Welcome to the game of poker. To play you must pay one Java Dollar.");
	System.out.println("Do you agree to our terms?");
	Scanner scan = new Scanner(System.in);
	String awn = scan.nextLine();
	if(awn.equals("Yes")){
		//minus a java dollar and play the game
		dollar.startGameFee();
		if (dollar.currentMoney() == -1){
			System.out.println("Sorry you are too broke to play this game");
		}
		else{
			Hand test = new Hand();
			test.viewHand();
		}
		
	}
	
}
}
