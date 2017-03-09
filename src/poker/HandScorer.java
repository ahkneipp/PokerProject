package poker;

public class HandScorer 
{
    public static int scoreHand(Hand hand)
    {
        return 0;
    }
    //use this url to finish your quicksort.
    //https://www.khanacademy.org/computing/computer-science/algorithms/quick-sort/a/overview-of-quicksort
    public static void sortHand(Card[] cards)
    {     
    	for(int j = 0; j < cards.length - 1; j++)
    	{
	        for(int i = 0;i < cards.length -j-2; i++)
	        {
	        	if(CardTranslate.getCardVal(cards[i]) < CardTranslate.getCardVal(cards[i+1]))
	        	{
	        		swap(cards, i , i+1);
	        		
	        	}
	        }
    	}
   
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
