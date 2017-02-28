/*
 * Poker game project for AP Computer Science.
 * Written by:
 * Dylan Poole and
 * Alex Kneipp
 */
package poker;

import java.util.Random;

public class Deck
{
	/**
	 * Uses the Fisher-Yates shuffle algorithm to shuffle the deck
	 */
	private void shuffle()//TODO test.
	{
		Card[] tempArr = new Card[52];
		System.arraycopy(this.cards, 0, tempArr, 0, 52);
		for(int i = 0; i < 52; i++)
		{
			int k = shuffler.nextInt(52-i);
			for(int j = 0; j < 52-i-k; j++)
			{
				if(tempArr[k + j] != null)
				{
					this.cards[i] = tempArr[k+j];
					tempArr[k + j] = null;
					break;
				}
			}
		}
	}
    private Card[] cards= new Card[52];
    private Random shuffler = new Random();
}
