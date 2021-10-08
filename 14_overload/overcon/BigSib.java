/**
Lauren Lee and Faize Huda
APCS
HW13: Where do BigSibs Come From?
2021-10-06
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

	public BigSib() {
		helloMsg=("Word up");
	}
	public BigSib(String HelloMessage1) {
		helloMsg=("Hey ya");
	}
	public BigSib(String HelloMessage2) {
		helloMsg=("Sup");
	}
	public BigSib(String HelloMessage3) {
		helloMsg=("Salutations");
	}


	public String greet(String name) {
		return (helloMsg + " " + name);
	}
}
