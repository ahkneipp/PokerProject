/* 
 * Poker game project for AP Computer Science.
 * Written by:
 * Dylan Poole and
 * Alex Kneipp
 */
package poker;
/**
 * A static class used to score hands for the poker game
 */
public class HandScorer 
{
	/**
	 * Scores the provided hand in accordance with the information below:
	 * Royal Flush: 250
	 * Straight Flush: 50 
	 * Four of a kind: 25
	 * Full house: 6
	 * Flush: 5
	 * Straight: 4
	 * 3 of a kind: 3
	 * 2 pair: 2
	 * Pair of Jacks or better: 1
	 * @param hand
	 *     The Hand object representing the player's hand
	 * @return
	 *     The in-game score of the provided hand
	 */
    public static int scoreHand(Hand hand)
    {
        //The hand must be sorted to effectively check for matches
    	sortHand(hand.getHand());
    	//Check the matches
    	int[] matchInfo = getMatchInfo(hand.getHand());
    	//Show the user their hand
    	hand.viewHand();
    	//Check if the player has any of the non-match scores
    	if(checkStraight(hand.getHand()))
    	{
    		if(checkStraight(hand.getHand()))
    		{
    			if(checkFlush(hand.getHand()))
    			{
    				if(checkRoyal(hand.getHand()))
    				{
    				return 250;//royal flush
    				}
    				else
    				{
    					return 50;//straight flush
    				}
    			}
    			else
    			{
    				return 4;//straight
    			}
    		}
    	}
		if(checkFlush(hand.getHand()))
		{
			return 5;//normal flush
		}
		//Check the matches in the hand to see if they earn any points
		MatchType match = checkHandMatches(hand.getHand());	
		if(match.matchNumbers[0] > 0)//there's at least one match
		{
			if(match.matchNumbers[0] == 2)//1 or 2 pair
			{
				if(match.matchNumbers[1] == 0)//1 pair
				{
					if(CardTranslate.getCardVal(new Card('S',match.matchCards[0])) 
							>= 11 || CardTranslate.getCardVal(new Card('S',match.matchCards[0])) == 1)
					{
						return 1;//pair of jacks or better
					}
					else
					{
						return 0;
					}
				}
				else if(match.matchNumbers[1] == 2)// 2 pair
				{
					return 2;//2 pair
				}
				else //full house (1,2 case, not 2,1 case);
				{
					return 6;
				}
			}
			else if(match.matchNumbers[0] == 3)//full house (2,1 case) or 3 of a kind
			{
				if(match.matchNumbers[1] == 2)
				{
					return 6; //full house (2,1 case)
				}
				else
				{
					return 3; //3 of a kind
				}
			}
			else if(match.matchNumbers[0] == 4)// 4 of a kind
			{
				return 25;
			}
		}	
		//If there aren't any matches or other scoring combinations, return 0
        return 0;
    }
    /**
     * Sorts the provided card array (presumed to be a poker hand, 
     * but not doesn't necessarily have to be one) by value of the 
     * cards (Ace acts as a 1 for this purpose)
     * @param cards
     *      An array of Card objects to be sorted
     */
    public static void sortHand(Card[] cards)
    {     
        //bubble sort algorithm because it's only 5 cards and most computers
        //will get this done more than fast enough.
    	for(int j = 0; j < cards.length - 1; j++)
    	{
	        for(int i = 0;i < cards.length -j-1; i++)
	        {
	        	if(CardTranslate.getCardVal(cards[i+1]) < CardTranslate.getCardVal(cards[i]))
	        	{
	        		swap(cards, i , i+1);	        		
	        	}
	        }
    	}   
    }
    /**
     * Checks to see if there is a straight in a poker hand
     * @param cards
     *      A sorted array of Card objects representing a poker hand.
     * @return
     *      True if the array contains a straight (where Ace can act 
     *      as either a 1 or "14" (to end a royal straight)), false otherwise
     */
    private static boolean checkStraight(Card[] cards)
    {
    	boolean specialCase = false;
    	int prevCardVal = 0;
    	/*
    	 * Since Ace can act as either a 1 or 14, we check if 
    	 * there's an ace in the hand.  If there is, we need
    	 * to check a special case for straights.  Aces ruin everything
    	 */
    	if(cards[0].getFaceId() == 'A')
    	{
    		specialCase = true;
    	}
    	//If there aren't any aces, just check to 
    	//make sure the hand is in sequential order
    	if(!specialCase)
    	{
    		for(Card c: cards)
    		{
    			if(prevCardVal != 0 && CardTranslate.getCardVal(c) != prevCardVal + 1)
    			{
    				return false;
    			}
    			prevCardVal = CardTranslate.getCardVal(c);
    		}
    		return true;
    	}
    	/*
    	 * If there is an ace, we need to check that the 
    	 * rest of the cards are sequential beyond it, 
    	 * then check that the second card is a 10 and 
    	 * the last is a king, or that the second is 
    	 * a 2 and the last a 5, since those are the 
    	 * only two instances of straights containing aces.
    	 */
    	else
    	{
    		for(Card c: cards)
    		{
    			int cardVal = CardTranslate.getCardVal(c);
    			if(cardVal != prevCardVal + 1)
    			{
    				if(cardVal == 10 && cards[0].getFaceId() == 'A')
    				{
    					prevCardVal = cardVal;
    					continue;
    				}
    				return false;
    			}
    			prevCardVal = cardVal;
    		}
    		return true;
    	}
    }
    /**
     * Checks to see if the array of cards provided as a parameter 
     * contians only royal cards (Ace, King, Queen, Jack, and Ten)
     * @param cards
     *      An array of card objects presumed to be 
     *      (but not necessarily) representing a hand in poker
     * @return
     *      True if every card is royal, false otherwise
     */
    private static boolean checkRoyal(Card[] cards)
    {
        //For each card, check if it's royal
    	for(Card c: cards)
    	{
    		if(c.getFaceId() != 'A' && c.getFaceId() != 'K' && c.getFaceId() != 'Q' &&
    				c.getFaceId() != 'J' && c.getFaceId() != 'T')
    		{
    			return false;
    		}
    	}
    	return true;
    }
    /**
     * Checks if the provided card array contains a poker flush
     * @param cards
     *      An array of cards representing a poker hand
     * @return
     *      True if the array represents a flush, false otherwise
     */
    private static boolean checkFlush (Card[] cards)
    {
    	char flushChar = cards[0].getSuitId();
    	for(Card c: cards)
    	{
    		if(c.getSuitId() != flushChar)
    		{
    			return false;
    		}
    	}
    	return true;
    }
    /**
     * Returns information pertaining to the matches between cards.
     * @param cards
     *      A sorted array of Card object representing a poker hand.
     * @return
     *      An array containing information about the matches in 
     *      the hand.  DO NOT try to parse this array directly, 
     *      use the object returned by check HandMatches(Card[]) 
     *      if individual match information MUST be parsed.
     */
    private static int[] getMatchInfo(Card[] cards)    
    {
    	int matchIndex = 0;
    	int[] matchInfo = {0,0,0,0,0};
    	for(int i = 0; i < cards.length-1; i++)
    	{
    		if(cards[i].getFaceId() == cards[i+1].getFaceId())
    		{
    			matchInfo[matchIndex]++;
    		}
    		else
    		{
    			matchIndex = i + 1;
    		}
    	}
    	return matchInfo;
    }
    /**
     * Checks that provided poker hand for matches, and then 
     * stores information about those matches in the returned 
     * object.  For more information on how the information 
     * is stored, see the documentation on MatchType.
     * @param hand
     *      An array of Cards representing a poker hand.
     * @return
     *      An object of type MatchType containing 
     *      information on the matches in the hand.  
     *      See the documentation for MatchType for more details.
     */
    private static MatchType checkHandMatches(Card[] hand)
    {
    	HandScorer.MatchType retVal = new HandScorer.MatchType();
    	int[] matchInfo = getMatchInfo(hand);
    	int matchIndex = 0;
    	for(int i = 0; i < matchInfo.length; i++)
    	{
    		if(matchInfo[i] > 0)
    		{
    			retVal.matchCards[matchIndex] = hand[i].getFaceId();
    			retVal.matchNumbers[matchIndex] = matchInfo[i] + 1;
    			matchIndex++;
    		}
    	}
    	return retVal;
    }
    /**
     * Class containing information pertaining to the matches
     * in a poker hand
     */
    public static class MatchType
    {
        /**
         * Creates a new MatchType object
         */
    	public MatchType()
    	{
    	    /*
    	     * Since in a hand of a five-card draw poker game can only have 
    	     * two unique matches (where the members of the match are not 
    	     * members of another match), we can have two two-element arrays 
    	     * to store information on both.
    	     */
    		this.matchCards = new char[2];
    		this.matchNumbers = new int[2];
    	}
    	/**
    	 * Returns a string representing the number of matches.
    	 */
    	@Override
    	public String toString()
    	{
    		String retval = "";
    		if(matchNumbers[0] > 0)
    		{
    			if(matchNumbers[1] > 0)
    			{
    				retval += "Two matches.";
    			}
    			else
    			{
    				retval += "One match.";
    			}
    		}
    		else
    		{
    			retval +="No Matches";
       		}
    		return retval;
    	}
        /**
         * The face of the cards involved in each match.  
         * [0] contains the information for the first match, 
         * and [1] contains the information for the second.  
         * If there are no matches, both [0] and [1] will 
         * contain the default char value. If there is only 
         * 1 match, [0] will contain its information and [1] 
         * will have the default char value.
         */
    	public char[] matchCards = null;
        /**
         * The number of cards contained in each match.  
         * matchCards[0] contains the number of cards in 
         * the first match and matchCards[1] contains the 
         * number of cards in the second.  If there are no 
         * matches, both [0] and [1] will contain 0.  
         * If there is only 1 match, [0] will contain 
         * the number of cards involved in the match, but [1]
         * will contain 0.
         */
    	public int[] matchNumbers = null;
    }
    /**
     * Swaps two elements in the provided Card array.  Both i and j 
     * must be less than cards.length, or the method will do nothing.
     * @param cards
     *      The array containing the Card objects
     * @param i
     *      The index of the first element to swap
     * @param j
     *      The index of the second element to swap.
     */
    private static void swap(Card[] cards, int i, int j)
    {
        if(i < cards.length && j < cards.length)
        {
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
}
