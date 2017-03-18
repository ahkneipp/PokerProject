package poker;

public class HandScorer 
{
    public static int scoreHand(Hand hand)
    {
    	for(Card c:hand.getHand())
    	{
    		c.setSuitId('S');
    	}
    	hand.getHand()[0].setFaceId('2');
    	hand.getHand()[1].setFaceId('3');
    	hand.getHand()[2].setFaceId('4');
    	hand.getHand()[3].setFaceId('5');
    	hand.getHand()[4].setFaceId('6');

    	
    	sortHand(hand.getHand());
    	int[] matchInfo = checkMatches(hand.getHand());
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
    
    private static int[] checkMatches(Card[] cards)    
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
    			matchIndex++;
    		}
    	}
    	return matchInfo;
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
