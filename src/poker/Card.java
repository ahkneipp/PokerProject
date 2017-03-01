/*
 * Poker game project for AP Computer Science.
 * Written by:
 * Dylan Poole and
 * Alex Kneipp
 */
package poker;

public class Card
{
    public Card(String cardname)
    {
        
    }
    public Card(char suitId, char faceId)
    {
        this.suitId = suitId;
        this.faceId = faceId;
    }
    private String cardName = null;
    private char suitId = 0;
    private char faceId = 0;
}
