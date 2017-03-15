package poker;

public class HandScorer 
{
    public static int scoreHand(Hand hand)
    {
    	sortHand(hand.getHand());
    	int[] matchInfo = checkMatches(hand.getHand());
    	hand.viewHand();
    	System.out.print("Match info: " );
    	for(int i = 0; i < 5; i ++)
    	{
    		System.out.print(matchInfo[i] + ", ");
    	}
    	System.out.println();
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
    
    private boolean checkStraight()
    {
    	
    	return false;
    }
    
    private boolean checkFlush (Card[] cards)
    {
    	char flushChar = cards[0].getSuitId();
    	for(Card c: cards)
    	{
    		if(c.getFaceId() != flushChar)
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
