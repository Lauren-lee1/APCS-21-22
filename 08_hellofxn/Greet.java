/*
Lauren Lee
APCS
HW08: Refactor Freshie Zero
2021-09-30
*/

/*
DISCOVERIES:
- at first, I thought I had to print greet() in the main method in order for the greeting to show up when I envoke it but I didn't need to return or print the greet function since greet() uses print already
UNRESOLVED QUESTIONS:
- why do we need to write "[] args" in the parameters of the main method?
- Is it more efficient to have the main method make a single function call rather than writing the whole function in the main method?
*/

public class Greet {
	public static void main (String [] args) {
		greet("Lauren");
		greet("Gloria");
		greet("Nora");
	}

	public static void greet(String name) {
		System.out.println("Hi " + name + ", how are you today" );
	}
}

