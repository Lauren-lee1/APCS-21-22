/**
   Clyde "Thluffy" Sinclair
   APCS pd0
   HW18 -- building a more meaningful class
   2021-10-18
   instance variables for storing...
   account holder's full name
   account password
   4-digit PIN
   9-digit account number
   account balance
   and methods for...
   setting each attribute
   printing out all of an account’s info at once
   depositing money
   withdrawing money
**/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
    if (newPin >= 1000 && newPin <= 9998){
        pin = newPin;
    }
    else {
        pin = 9999;
        System.out.println("Try Again");
    }
     return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    if (newAcctNum >= 100000000 && newAcctNum <= 999999998){
	acctNum = newAcctNum;
    }
    else {
    acctNum = 999999999;
    System.out.println("Try Again");
    }
    return acctNum;
  }


  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
     balance = balance + depositAmount;
  }

  public Boolean withdraw( double withdrawAmount ) {
    if(balance - withdrawAmount < 0) {
	System.out.println("you're broke, you can't withdraw");
	return false;
    } else{
	balance = balance - withdrawAmount;
  	return true;
    }
  }

  public Boolean authenticate(int inputAcctNum, String inputPass) {
	return(acctNum == inputAcctNum && inputPass == passwd);
  }
  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }

  public static void main( String[] args ) {
    // INSERT YOUR METHOD CALLS FOR TESTING HERE
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
  }//end main()
}
