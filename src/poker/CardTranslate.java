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
    		retval ="Ace of ";
    		break;
    	case '2':
    		retval ="Two of ";    		
    		break;
    	case '3':
    		retval ="Three of ";    		
    		break;
    	case '4':
    		retval ="Four of ";	
    		break;
    	case '5':
    		retval ="Five of ";	
    		break;
    	case '6':
    		retval ="Six of ";	
    		break;
    	case '7':
    		retval ="Seven of ";	
    		break;
    	case '8':
    		retval ="Eight of ";	
    		break;
    	case '9':
    		retval ="Nine of ";
    		break;
    	case 'T':
    		retval ="Ten of ";
    		break;
    	case 'J':
    		retval ="Jack of ";
    		break;
    	case 'Q':
    		retval ="Queen of ";
    		break;
    	case 'K':
    		retval ="King of ";
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
    public static int getCardVal(Card card)
    {
        switch(card.getFaceId())
        {
        case 'A':
            return 1;
        case '2':
            return 2;          
        case '3':
            return 3;           
        case '4':
            return 4; 
        case '5':
            return 5;
        case '6':
            return 6; 
        case '7':
            return 7;    
        case '8':
            return 8;   
        case '9':
            return 9;
        case 'T':
            return 10;
        case 'J':
            return 11;
        case 'Q':
            return 12;
        case 'K':
            return 13;
        default:
            return -1;
        }
    }
}
