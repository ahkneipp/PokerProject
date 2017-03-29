package poker;

public class JavaDollar {
	private static int currentDollar = 5;
JavaDollar(){
	
}
public static int currentMoney(){
	return currentDollar;
}
static void startGameFee(){
	currentDollar = currentDollar - 1;
}
}
