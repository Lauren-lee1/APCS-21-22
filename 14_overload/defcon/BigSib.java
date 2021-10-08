/**
Lauren Lee 
APCS
HW14: Customize your creation
2021-10-07
**/

/**
DISCO
- constructors are created in the class witht the main method
-Constructors should have a return type and return something to be printed in the main method 
QCC
- can constructors be created in the helper class 
**/

public class BigSib {

	private String helloMsg;

	public BigSib(String msg) {
		helloMsg=msg;
	}
	public String greet(String name) {
		return (helloMsg + " " + name);
	}
}
