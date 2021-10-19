public class Teller {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		ba.setName("John");
		ba.setPasswd("password");
    		ba.setPin((short) 1234);
    		ba.setAcctNum(123456789);
	        ba.setBalance(0.00);
    	        ba.deposit(50.00);
                ba.withdraw(10.00);
	        //balance should be 40
		System.out.println(ba.toString());

		//Should produce errors when setPin, setAcctNum, authenticate, and withdraw are invoked
		BankAccount error = new BankAccount();
		error.setName("Error");
		error.setPasswd("pass");
		System.out.println(error.setPin((short) 12));
	        System.out.println(error.setAcctNum(123));
	        error.setBalance(0);
		System.out.println(error.withdraw(10));
 		System.out.println(error.toString());
	        System.out.println(error.authenticate(123, "pass"));
	}
}
