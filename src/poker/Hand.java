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
	}
	//Viewing the hand
	for (int x = 0; x<5; x++)
System.out.println(x+1+") "+five[x]);
	//rejectCards will choose which cards you want to reject
rejectCards();	
}
//Gets cards for your hand
public void dealHand(){
	Deck deck = new Deck();
	five =deck.dealTheCards();
	pointer = deck.returnPointer();	
}
//Takes cards out of your hand
public void rejectCards(){
	System.out.println("Would you like to reject some cards?");
	Scanner scan = new Scanner(System.in);
	String awnser = scan.nextLine();
	if (awnser.equals("No")){
		//IF no calculate their score
	}
	else{
		System.out.println("Which card would you like to reject (Type the number of the card).");
		//This is just a simple awnser var
		int awn = scan.nextInt();
		awn = awn - 1;
		//not sure why this is here don't delete it
		Deck deck = new Deck();
		//This deletes cards
		deck.deleteCards(pointer, awn);
		pointer++;
		viewHand();
		
	}
}

}
