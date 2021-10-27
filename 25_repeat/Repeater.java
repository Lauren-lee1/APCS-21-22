/**
Clueless Cats: Lauren Lee, Bo, Diana Akhmedova, Ajax, Vansh Saboo, Tiffany
APCS
HW25: Do I repeat myself?
2021-10-26
time spent: 0.5 hrs
**/

/**
DISCO
-Another way to write the recursive function is:

-Recursive utilizes if statements as opposed to while. 
- in creating the functions we want x to be < numpost not <=
QCC
- in what situtation would each method be more practical?
- when we are working with larger numbers and longer cases, which one would be faster?
**/

public class Repeater {

	public static void main(String[]args) {
		System.out.println(fenceW(1) + " ...should be |");
		System.out.println(fenceW(2) + " ...should be |--|");
		System.out.println(fenceW(3) + "...should be |--|--|");

		System.out.println();

		System.out.println(fenceR(1) + " ...should be |");
		System.out.println(fenceR(2) + " ...should be |--|");
		System.out.println(fenceR(3) + " ...should be |--|--|");
  }

	public static String fenceW(int numPosts) {
		int x = 1;
		String output = "|";

		while ( x < numPosts ) {
			output = output + "--|";
			x++;
    		}
    		return output;
  	}

	public static String fenceR(int numPosts) {
		String output = "";
		if (numPosts == 1) {
			output = output + "|";
		}else {
			if (numPosts > 1) {
				output = fenceR(numPosts - 1) + "--|";
			}
		}
		return output;
	}
}
