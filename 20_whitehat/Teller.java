/**
Lauren Lee
APCS
HW20: External Audit
2021-10-09
**/

/**
DISCO:
-withdrawing negative will add money and depositing negative will withdraw money
QCC:
-what operations are possible from BankAccount's main() method but not Teller's
	- you cant change values of variables intialized in BankAccount.java
**/

public class Teller {
	public static void main(String[] args) {
		//Test all functionality
		System.out.println("Test all basic functionality");
		BankAccount ba = new BankAccount();
		ba.setName("John");
		ba.setPasswd("password");
    		ba.setPin((short) 1234);
    		ba.setAcctNum(123456789);
	        ba.setBalance(0.00);
		System.out.println(ba.toString());
		System.out.println(ba.authenticate(123456789, "password"));

		System.out.println("Tests basic functionality of deposit");
    	        ba.deposit(50.00);
		System.out.println(ba.toString());
		//balance should be 50

		System.out.println("Tests basic functionality of withdraw");
                ba.withdraw(10.00);
		System.out.println(ba.toString());
		//balance should be 40

		//Should produce errors when setPin, setAcctNum, authenticate, and withdraw are invoked
		System.out.println("tests error messages that are part of basic functionality");
		BankAccount error = new BankAccount();
		error.setName("Error");
		error.setPasswd("pass");
		System.out.println(error.setPin((short) 1234));
	        System.out.println(error.setAcctNum(123));
	        error.setBalance(0);
		System.out.println(error.withdraw(10));
 		System.out.println(error.toString());
	        System.out.println(error.authenticate(12345, "password"));

		System.out.println("tries to break code");
		BankAccount Break = new BankAccount();
		Break.setName("Break");
		Break.setPasswd("pass");
		Break.setPin((short) 1234);
		Break.setAcctNum(123456789);
		Break.setBalance(50);
		Break.deposit(-10);
		Break.withdraw(-20);
		//shouldn't be able to withdraw or deposit negative money, should produce an error message
		System.out.println(Break.toString());
		}
}
