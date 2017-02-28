/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;
/**
 * 
 */

/**
 * @author Dylan
 *
 */
public class DeckCreator {
static char[] card = new char[15];
static char[][] fullDeck=new char[4][52];

public DeckCreator(char[] cards, char[][] deck){
	cards= card;
	deck=fullDeck;
}
public void cardSetter(){
    card[0] = '2';
     card[1] = '3';
      card[2] = '4'; 
       card[3] = '5';
        card[4] = '6';
         card[5] = '7';
          card[6] = '8';
           card[7] = '9';
            card[8] = '1';
             card[0] = 'J';
              card[0] = 'Q';
               card[0] = 'K';
                 card[0] = 'A';
        
      
      
}
public void cardGen(){
	for(int x =0; x<13; x++){
		fullDeck[0][x]=card[x];
		fullDeck[1][x]=card[x];
		fullDeck[2][x]=card[x];
		fullDeck[3][x]=card[x];
		System.out.println(x);
	}
}
}
