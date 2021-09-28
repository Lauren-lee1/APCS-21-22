import java.util.Scanner;
import java.lang.Math;

public class Loops{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    //input a base and an exponent to calculate the exponent
    System.out.println("Exercise 3");
    System.out.println("Input a floating point:");
    double x = in.nextDouble();
    System.out.println("Input an integer exponent:");
    int n = in.nextInt();
    System.out.println(power(x, n));

    //input an integer to find factorial
    System.out.println("Exercise 4");
    System.out.println("Input an integer:");
    int f = in.nextInt();
    while (f<0) {
      //checks if number inputed is non negative and outputs an error message if so
      System.err.println("You must input an integer greater or equal to 0");
      System.out.println("Input a different integer:");
      f = in.nextInt();
    }
    System.out.println(factorial(f));

    System.out.println("Exercise 5");
    //step  3
    check(1);
    //step 4
    double z = 0.1;
    while (z<=100) {
      check(z);
      z = z*10;
    }
    //step 5
    double y = -0.1;
    while (y>=-100) {
      check(y);
      y = y*10;
      //gets less accurate going down the table
    }
  }

  public static double power(double x, int n) {
    //finds x to the n power with an iterative method
    double y = 1; //initializer
    if (n>=0) { //condition
      //if y is 0, 1 is returned
      while (n > 0) {
      y = y * x; //multiples x every loop
      n = n-1; //update
    }
    return y;
    } else {
      while (n < 0) {
        y = y * (1/x); //1/x for negative exponents
        n = n + 1;
        }
      return y;
    }
  }

  public static double factorial(double n) {
  //finds the factorial of n using an iterative method
    double m = 1;
    //m =1 so if n =0, 1 will be returned
    double w = n + 1; //must start with n+1
    while (n > 0) {
      m = m * (w-1);
      w = w-1; //multiple by the w-1
      n = n - 1; //update
    }
    return m;
    }

  public static double myexp(double x, double n) {
    double y = 1; //y is the zeroth term
    double c = 1;
    double f = x/1;
    while (c <= n) {
      y = y + f; //y i
      c = c+1; //c is the counter to n
      f = f*(x/c); // the predecessor is multiplied by x/i
    }
    return y;
  }


  public static void check(double x) {
    //creates a chart for myexp
    System.out.print(x);
    System.out.print("   ");
    System.out.print(myexp(x ,4));
    System.out.print("    ");
    System.out.println(Math.exp(x));
  }
}
