package poker;

public class HandScorer 
{
	/*
	 * Scoring information
	 * Royal Flush: 250 - X
	 * Straight Flush: 50 - X
	 * Four of a kind: 25
	 * Full house: 6
	 * Flush: 5
	 * Straight: 4 - X
	 * 3 of a kind: 3
	 * 2 pair: 2
	 * Pair of Jacks or better: 1 X
	 */
    public static int scoreHand(Hand hand)
    {
    	for(Card c:hand.getHand())
    	{
    		c.setSuitId('S');
    	}
    	hand.getHand()[0].setFaceId('A');
    	hand.getHand()[1].setFaceId('2');
    	hand.getHand()[2].setFaceId('2');
    	hand.getHand()[3].setFaceId('5');
    	hand.getHand()[4].setFaceId('5');    	
    	sortHand(hand.getHand());
    	int[] matchInfo = getMatchInfo(hand.getHand());
    	hand.viewHand();
    	System.out.print("Match info: " );
    	for(int i = 0; i < 5; i ++)
    	{
    		System.out.print(matchInfo[i] + ", ");
    	}
    	System.out.println();
    	System.out.println("Flush: " + checkFlush(hand.getHand()));
    	System.out.println("Straight: " + checkStraight(hand.getHand()));
    	System.out.println("Royal: " + checkRoyal(hand.getHand()));
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
    		else
    		{
    			if(checkHandMatches(hand.getHand()).matchNumbers[0] > 0)//there's at least one match
    			{
    				if(checkHandMatches(hand.getHand()).matchNumbers[0] == 1)//1 or 2 pair
    				{
    					if(checkHandMatches(hand.getHand()).matchNumbers[1] == 0)//1 pair
    					{
    						if(CardTranslate.getCardVal(new Card('S',checkHandMatches(hand.getHand()).matchCards[0])) >= 11 || CardTranslate.getCardVal(new Card('S',checkHandMatches(hand.getHand()).matchCards[0])) == 1)
    						{
    							return 1;//pair of jacks or better
    						}
    						else
    						{
    							return 0;
    						}
    					}
    					else
    					{
    						
    					}
    				}
    			}
    		}
    	}
        return 0;
    }

    public static void sortHand(Card[] cards)
    {     
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
    
    private static boolean checkStraight(Card[] cards)
    {
    	boolean specialCase = false;
    	int prevCardVal = 0;
    	if(cards[0].getFaceId() == 'A')
    	{
    		specialCase = true;
    	}
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
    
    private static boolean checkRoyal(Card[] cards)
    {
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
    
    public static class MatchType
    {
    	public MatchType()
    	{
    		this.matchCards = new char[2];
    		this.matchNumbers = new int[2];
    	}
    	@Override
    	public String toString()
    	{
    		int numberOfMatches = 0;
    		String retval = "";
    		if(matchNumbers[0] > 0)
    		{
    			if(matchNumbers[1] > 0)
    			{
    				retval += "Two matches.";
    				numberOfMatches = 2;
    			}
    			else
    			{
    				retval += "One match.";
    				numberOfMatches = 1;
    			}
    		}
    		else
    		{
    			retval +="No Matches";
       		}
    		return retval;
    	}
    	public char[] matchCards = null;
    	public int[] matchNumbers = null;
    }
    
    private static void swap(Card[] cards, int i, int j)
    {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }
    private static boolean insertCard(Card[] cards, int currentPos, int newPos)
    {
        Card temp = cards[currentPos];
        boolean retVal = false;
        //if we're moving forwards
        if(currentPos < newPos)
        {
            for(int i = currentPos; i< newPos; i++)
            {
                cards[i] = cards [i+1];
            }
        }
        else//we're moving backwards
        {
            for(int i = currentPos; i > newPos; i--)
            {
                cards[i] = cards[i-1];
            }
        }
        cards[newPos] = temp;
        return false;
    }
}
