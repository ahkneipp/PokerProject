package poker;

/*
 * This class is going to be the main game play
 */
public class GamePlay {
public GamePlay(){
	
}
public  void test(){
	Card[] displayCards = new Card[5];
	//just show the top five cards
	Deck deck = new Deck();
	displayCards = deck.dealTheCards();
	
//	for(int x =0; x<5; x++){
//		System.out.println(displayCards[x]);
//	}
}

}
