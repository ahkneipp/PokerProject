/* 
 * Poker game project for AP Computer Science.
 * Written by:
 * Dylan Poole and
 * Alex Kneipp
 */
package poker;

import java.util.Scanner;

public class Hand {
	//controlStatement will keep the dealing of cards out of the algorthim.
	public static int controlStatement =0;
	public static Card[] five = new Card[5];
	
	//int pointer is from the Deck class to tell where I am in array
	int pointer = 0;
public Hand (){
	
}
//first i need a handViewer
public void viewHand(){
	//controlStatement will keep the dealing of cards out of the algorthim.
	if(controlStatement == 0){
		//dealHand creates a new hand
		dealHand();
		//Just to keep this from
		controlStatement++;
	for (int x = 0; x<5; x++)
System.out.println(x+1+") "+five[x]);
	//rejectCards will choose which cards you want to rejectln()
	rejectCards();
	}
	else{
		for (int x = 0; x<5; x++)
		System.out.println(x+1+") "+five[x]);
	}
	//Viewing the hand
	
}
//Gets cards for your hand
public void dealHand(){
	
	Deck deck = new Deck();
	five =deck.dealTheCards();
	pointer = deck.getPointer();	
	HandScorer.sortHand(five);
}
//Takes cards out of your hand
public void rejectCards(){
	System.out.println("Would you like to reject some cards? (yes/no)");
	Scanner scan = new Scanner(System.in);
	String awnser = scan.nextLine();
	if (awnser.equals("No")){
		//IF no calculate their score
		HandScorer hand = new HandScorer();
		hand.sortHand(five);		
		//After you get the score add the pay out to the users balance
	}
	else{
		System.out.println("How many cards would you like to reject?");
		int forLoop = scan.nextInt();
		int[] arrayOfNumbers= new int [5];
		for(int x =0; x<forLoop; x++){
	
		
		System.out.println("Which card would you like to reject (Type the number a single card you would like to reject).");
		//This is just a simple awnser var
		
		 arrayOfNumbers[x] = scan.nextInt();
		}
		//not sure why this is here don't delete it
		Deck deck = new Deck();
		//This deletes cards
		for(int x =0; x<forLoop; x++){
			
			deck.deleteCards(pointer, arrayOfNumbers[x]-1);
			pointer++;
		}		
	}
}
/**
 * @return
 *      The array which holds the player's cards.
 */
public Card[] getHand()
{
    return this.five;
}

}
