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
    /**
     * Constructs a new Card object with a face and suit
     * @param suitId
     *      a character representing the suit of the card. (S,C,H,D)
     * @param faceId
     *      a character representing the face of the card. (A,2,3,4,5,6,7,8,9,T,J,Q,K)
     */
    public Card(final char suitId,final char faceId)
    {
        this.suitId = suitId;
        this.faceId = faceId;
        this.cardName = CardTranslate.getNameFromIDs(suitId, faceId);
    }
    /**
     * 
     * @return
     *      A string representation of the card, of the form "<<face> of <<suit>"
     */
    public String getCardName()
    {
    	if(this.cardName != null)
    	{
    		return this.cardName;
    	}
    	this.cardName = CardTranslate.getNameFromIDs(this.suitId, this.faceId);
    	return this.cardName;
    }
    /**
     * @return
     *      The character representing the suit of the card
     */
    public char getSuitId()
    {
    	return this.suitId;
    }
    /**
     * @return
     *      The character representing the face of the card
     */
    public char getFaceId()
    {
    	return this.faceId;
    }
    /*
     * The next two methods should never actually be used in the game,
     *  they're just for testing purposes.
     */
    public void setSuitId(char newId)
    {
    	this.suitId = newId;
    	this.cardName = CardTranslate.getNameFromIDs(this.suitId, this.faceId);
    }
    public void setFaceId(char newId)
    {
    	this.faceId = newId;
    	this.cardName = CardTranslate.getNameFromIDs(this.suitId, this.faceId);
    }
    /**
     * See getCardName()
     */
    @Override
    public String toString()
    {
    	return this.getCardName();
    }
    private String cardName = null;
    private char suitId = 0;
    private char faceId = 0;
}
