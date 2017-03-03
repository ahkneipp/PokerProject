package poker;

import java.util.Scanner;

public class Hand {
	
	public static Card[] five = new Card[5];
	Deck deck = new Deck();
	int pointer = 0;
public Hand (){
	
}
//first i need a handViewer
public void viewHand(){
	dealHand();
	for (int x = 0; x<5; x++)
System.out.println(five[x]);
	
}
public void dealHand(){
	Deck deck = new Deck();
	five =deck.dealTheCards();
	
	
}
public void rejectCards(){
	System.out.println("Would you like to reject some cards?");
	Scanner scan = new Scanner(System.in);
	String awnser = scan.nextLine();
	if (awnser.equals("No")){
		//IF no calculate their score
	}
	else{
		
	}
}

}
