public class Greet {
	private static String richard(){
		String setHelloMsg = ("Word up");
		return(setHelloMsg);
	}
	public static void main(String[] args) {
		String greeting;

		BigSib richard = new BigSib();

		System.out.print(richard());
		greeting = richard.greet("freshman");
		System.out.println(greeting);

	} //end main()
} //end Greet
