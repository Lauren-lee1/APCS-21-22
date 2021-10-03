/*
Cool Computers: Lauren Lee, Bo, Gloria Lee, Flounder, Kevin Li, Kirby
APCS
HW09: What are BigSibs good for?
2021-10-1
*/

/*
DISCOVERIES:
- to invoke a method from another class in a  different file, use the syntax Class.method()
- BigSib did not need a main method to be incorporated into the main method of Greet

UNRESOLVED QUESTIONS:
- What is the benefit to invoking a class from a different file as a helper method?
*/


public class Greet {
	public static void main (String [] args) {
		BigSib.greet("Lauren");
		BigSib.greet("Gloria");
		BigSib.greet("Kevin");
	}


}

