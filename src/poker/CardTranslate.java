/*
 * Poker game project for AP Computer Science.
 * Written by:
 * Dylan Poole and
 * Alex Kneipp
 */
package poker;

/**
 *
 * @author Alex Kneipp
 */
public class CardTranslate 
{
    public static String getNameFromIDs(final char suitId, final char faceId)
    {
    	String retval = null;
    	switch(faceId)
    	{
    	case 'A':
    		retval +="Ace of ";
    		break;
    	case '2':
    		retval +="Two of ";    		
    		break;
    	case '3':
    		retval +="Three of ";    		
    		break;
    	case '4':
    		retval +="Four of ";	
    		break;
    	case '5':
    		retval +="Five of ";	
    		break;
    	case '6':
    		retval +="Six of ";	
    		break;
    	case '7':
    		retval +="Seven of ";	
    		break;
    	case '8':
    		retval +="Eight of ";	
    		break;
    	case '9':
    		retval +="Nine of ";
    		break;
    	case 'T':
    		retval +="Ten of ";
    		break;
    	case 'J':
    		retval +="Jack of ";
    		break;
    	case 'Q':
    		retval +="Queen of ";
    		break;
    	case 'K':
    		retval +="King of ";
    		break;
    	}
    	switch(suitId)
    	{
    	case 'S':
    		retval += "Spades";
    		break;
    	case 'C':
    		retval += "Clubs";
    		break;
    	case 'H':
    		retval += "Hearts";
    		break;
    	case 'D':
    		retval += "Diamonds";
    		break;
    	}
    	return retval;
    }
}
