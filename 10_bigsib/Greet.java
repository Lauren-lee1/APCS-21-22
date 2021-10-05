/*
Cool Computers: Lauren Lee, Bo, Gloria Lee, Flounder, Kevin Li, Kirby
APCS
HW10:Refactor Big Sib  One
2021-10-4
*/

/*
DISCOVERIES:
- to invoke a method from another funtion class using print, the helper method must use return instead of print


UNRESOLVED QUESTIONS:
- What is the benefit to invoking a class from a different file as a helper method?
- What is the benefit to haveing the helper class/method return  instead of print?
*/


public class Greet {
	public static void main (String [] args) {
		System.out.println(BigSib.greet("Crosby"));
		System.out.println(BigSib.greet("Stills"));
		System.out.println(BigSib.greet("Nash"));
	}


}

