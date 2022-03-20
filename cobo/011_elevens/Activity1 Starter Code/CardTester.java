// Team FEORGE - Andrey Sokolov + Geese & Ziying Jian + Pinky, Lauren Lee + Ted
// APCS pd8
// L07 - But These Go Up To Eleven
// 2022-03-19
// time spent: 3 humorous hours

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */

	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card ziying = new Card("Ace" , "Spades", 999);
		System.out.println(ziying);
		System.out.println("rank:" + ziying.rank());
		System.out.println("suit:" + ziying.suit());
		System.out.println("point val:" + ziying.pointValue());

		System.out.println();
		Card lauren = new Card ("Jack", "Hearts", 100);
		System.out.println(lauren);
		System.out.println("rank:" + lauren.rank());
		System.out.println("suit:" + lauren.suit());
		System.out.println("point val:" + lauren.pointValue());

		Card ziggy = new Card("Ace" , "Spades", 999);

		System.out.println();
		System.out.println(lauren.matches(ziying));
		System.out.println(ziggy.matches(ziying));
	}
}
