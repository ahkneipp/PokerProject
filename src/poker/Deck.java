/*
 * Poker game project for AP Computer Science. Written by: Dylan Poole and Alex
 * Kneipp
 */
package poker;

import java.util.Random;

public class Deck
{
    /**
     * Uses the Fisher-Yates shuffle algorithm to shuffle the deck
     */
    private void shuffle()
    {
        Card[] tempArr = new Card[52];
        System.arraycopy(this.cards, 0, tempArr, 0, 52);
        for (int i = 0; i < 52; i++)
        {
            int k = shuffler.nextInt(52 - i);
            for (int j = 0; j < 52 - i - k; j++)
            {
                if (tempArr[k + j] != null)
                {
                    this.cards[i] = tempArr[k + j];
                    tempArr[k + j] = null;
                    break;
                }
            }
        }
    }
    public Card[] dealTheCards()
    {    	
    	initDeck();
    	this.shuffle();
    	int tempPoint =0;
    	//this loop will adds the top five cards into the top
		for(int x =0; x<5; x++)
		{
			
			fiveCards[x] = cards[x];
			tempPoint = x;
		}
		pointer = tempPoint;
		
		return fiveCards;
	}
    public Card[] deleteCards(int point, int index){
    	fiveCards[index] = cards[point+1];
    	return fiveCards;
    }
    
    public int getPointer(){
    	return pointer;
    }
    
    public void initDeck()
    {
        char suitId =0;
        char faceId = 0;
        for (int i = 0; i < 4; i++)
        {
            switch (i)
            {
            case 0:
                suitId = 'S';
                break;
            case 1:
                suitId = 'C';
                break;
            case 2:
                suitId = 'H';
                break;
            case 3:
                suitId = 'D';
                break;
            }
            for (int j = 0; j < 13; j++)
            {
                switch(j)
                {
                case 0:
                    faceId = 'A';
                    break;
                case 1:
                    faceId = '2';
                    break;
                case 2:
                    faceId = '3';
                    break;
                case 3:
                    faceId = '4';
                    break;
                case 4:
                    faceId = '5';
                    break;
                case 5:
                    faceId = '6';
                    break;
                case 6:
                    faceId = '7';
                    break;
                case 7:
                    faceId = '8';
                    break;
                case 8:
                    faceId = '9';
                    break;
                case 9:
                    faceId = 'T';
                    break;
                case 10:
                    faceId = 'J';
                    break;
                case 11:
                    faceId = 'Q';
                    break;
                case 12:
                    faceId = 'K';
                    break;
                }
                cards[(i * 13) + j] = new Card(suitId, faceId);
            }
        }
    }
  private static  Card[] fiveCards = new Card[5];
    private static Card[] cards = new Card[52];
    private Random shuffler = new Random();
    private static int pointer = 0;
    private static Card[] topFive = new Card[5];
}
