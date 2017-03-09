package poker;

public class HandScorer 
{
    public static int scoreHand(Hand hand)
    {
        return 0;
    }
    //use this url to finish your quicksort.
    //https://www.khanacademy.org/computing/computer-science/algorithms/quick-sort/a/overview-of-quicksort
    private static Card[] sortHand(Card[] cards)
    {        
        if (cards.length ==1)
            return cards;
        else
        {
            int pivot = cards.length -1;
            for(int i = 0; i < cards.length; i++)
            {
                if(CardTranslate.getCardVal(cards[i]) < CardTranslate.getCardVal(cards[pivot]))
                {
                    insertCard(cards, i, pivot - 1); 
                    if(i > pivot)
                    {
                        pivot++;
                    }
                }
                else
                {
                    insertCard(cards,i,pivot);
                    if(pivot > i)
                    {
                        pivot--;
                    }
                }
            }
            return new Card[10]; //TODO makes the code compile
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
