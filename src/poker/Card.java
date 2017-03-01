/*
 * Poker game project for AP Computer Science.
 * Written by:
 * Dylan Poole and
 * Alex Kneipp
 */
package poker;
/**
 * @author Alex Kneipp
 *
 */
public class Card
{
    public Card(final char suitId,final char faceId)
    {
        this.suitId = suitId;
        this.faceId = faceId;
        this.cardName = CardTranslate.getNameFromIDs(suitId, faceId);
    }
    public String getCardName()
    {
    	if(this.cardName != null)
    	{
    		return this.cardName;
    	}
    	this.cardName = CardTranslate.getNameFromIDs(this.suitId, this.faceId);
    	return this.cardName;
    }
    public char getSuitId()
    {
    	return this.suitId;
    }
    public char getFaceId()
    {
    	return this.faceId;
    }
    @Override
    public String toString()
    {
    	return this.getCardName();
    }
    private String cardName = null;
    private char suitId = 0;
    private char faceId = 0;
}
