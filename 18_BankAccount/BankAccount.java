/*
Clueless Cats: Vansh saboo + Tiffany, Lauren Lee + Bo, Diana Akhmedova + Ajax
APCS
HW 18: CPA-One
2021-10-14
**/

/**
DISCO:
-  we can't reference non-static variables in a static context (ie.static method)
- we weren't able to use constructors but we don't know why
QCC:
- are constructors considered methods?
- would be constructors be considered methods in a UML diagram?
- How is the functionality of the static vs instance variable different because the work we do right now seems to use them interchangebly?
- How do we use constructors to fill in default information?
Clueless Cats's Latest and Greatest Q2 Response:
Te default constructor is already defined because we can initialize balance without any parameters.
Clueless Cats's Latest and Greatest Q3 Response:
- create a sample method that returns an integar
- in a seperate method with a String return method, convert the integer to a string
	(str) <int>
- return this String
*/

public class BankAccount{

	//create static variables for each attribute
	private static String name;
	private static String password;
	private static int pin;
	private static int accountNum;
	private static float balance;

	//set each attribute
	public static void setName(String fullName){
		name = fullName;
	}

	public static void setPass(String newPass){
		password = newPass;
	}

	public static void setPin(int newPin){
		pin = newPin;
	}

	public static void setAccNum(int accNum){
		accountNum = accNum;
	}

	public static void setBalance(){
		balance = 0;
	}

	//print out all info
	public static void printInfo(int accNum, String pass){
		if (accNum == accountNum && pass == password){
                	//if password and account number is correct, prints out the info
			System.out.println(name);
			System.out.println(password);
			System.out.println(pin);
			System.out.println(accountNum);
			System.out.println(balance);
		}else{ //if not correct print error message
			System.out.println("Your password or account number is wrong.");
		}
	}

	public static void deposit(int accNum, String pass, float amtDeposit) {
		 if (accNum == accountNum && pass == password){
			// if password and accountn umber correct, deposits money
			balance = balance + amtDeposit;
			System.out.println("You're new balance is now " + balance);
		}else{ //if not, doesn't
			System.out.println("Your password or username is incorrect");
		}
	}

	public static void withdraw(int accNum, String pass, float amtWithdraw) {
		if (accNum == accountNum && pass == password){
			if (balance - amtWithdraw < 0) { // does not allow withdrawal when it is not possible/will put people in debt
				System.out.println("You're broke, you can't withdraw");
			}else{
				balance = balance - amtWithdraw;
				System.out.println("You're new balance is now " + balance);
			}
		}else{
			System.out.println("Your password or username is incorrect");
		}
	}

	public static void main (String[] args) {
		//sets all info
		setName("John Doe");
		setPass("password");
		setPin(1234);
		setAccNum(123456789);
		setBalance();

		//prints info test
		printInfo(123456789, password);

		//tries depositing
		deposit(123456789, password, 50);

		//tests withdrawing
		withdraw(123456789, password, 40);
		//tests tring to withdraw too much money
		withdraw(123456789, password, 20);

		//tests trying to withdraw and deposit with wrong information
		deposit(12345, password, 20);
		withdraw(12345, password, 20);

		//print out updated info
		printInfo(123456789, password);
	}
}
