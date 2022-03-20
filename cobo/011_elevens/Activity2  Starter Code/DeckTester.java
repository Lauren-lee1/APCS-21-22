/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] ranks1 = {"ace", "two", "four"};
		String[] ranks2 = {"five", "twenty", "idk"};
		String[] suits = {"blue", "red"};
		String[] suits1 = {"carrot", "potatoe"};
		String[] suits2 = {"polka-dot", "chicken wings"};
		int[] pointValues = {11, 12, 13};
		int[] pointValues1 = {1, 2, 3};
		int[] pointValues2 = {5, 20, 999};

		Deck d = new Deck(ranks, suits, pointValues);
		Deck d1 = new Deck(ranks1, suits1, pointValues1);
		Deck d2 = new Deck(ranks2, suits2, pointValues2);
		System.out.println("**** Original Deck Methods ****");
		System.out.println("** Deck 0 **");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("** Deck 1 **");
		System.out.println("  toString:\n" + d1.toString());
		System.out.println("  isEmpty: " + d1.isEmpty());
		System.out.println("  size: " + d1.size());
		System.out.println();
		System.out.println();

		System.out.println("** Deck 2 **");
		System.out.println("  toString:\n" + d2.toString());
		System.out.println("  isEmpty: " + d2.isEmpty());
		System.out.println("  size: " + d2.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

	}
}
