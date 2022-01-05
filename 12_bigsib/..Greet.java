/**
Lauren Lee and Faize Huda
APCS
HW12: On Elder Individuality and the Elimination of Radio Fuzz -- using instances/customizable variables
2021-10-05
**/

/**
DISCO
-void return types can't be converted to a string 
	- if I use void in my greet method and try to return the String greeting, I will get an error
- Instance variables are changable variables 
QCC
- I'm still confused as to what instances are and how to use them
**/

public class BigSib {
	public static void setHelloMsg(String msg) {
		System.out.print(msg);
	}
	public static String greet(String name) {
		return (" " + name + "\n" + "Salutations Dr.Spaceman" + "\n" + "Hey ya Kong Fooey" + "\n" + "Sup mom");
	}
}
