/**
Lauren Lee 
APCS
HW14: Customize your creation
2021-10-07
**/

/**
DISCO
- to overload, the default constructor should not have parameters
- constructors go in the helper class 
QCC
- I'm still unsure how to overload and finish this specific part of the homework
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
