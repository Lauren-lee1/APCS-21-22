import java.util.Scanner;

public class Methods{

  public static void main(String[] args){
    //see if the two numbers inputed are divisible
    System.out.println("Exercise 2");
    Scanner in = new Scanner(System.in);
    System.out.println("Input a number:");
    int n = in.nextInt();
    System.out.println("Input a number:");
    int m = in.nextInt();
    System.out.println(isDivisible(n ,m));

    //see if three sticks will make atriangle based on the lengths
    System.out.println("Exercise 3");
    System.out.println("Input the length of the first stick");
    int sideLength1 = in.nextInt();
    System.out.println("Input the length of the second stick");
    int sideLength2 = in.nextInt();
    System.out.println("Input the length of the third stick");
    int sideLength3 = in.nextInt();
    System.out.println(isTriangle(sideLength1, sideLength2, sideLength3));

    //perform the Ackermann function with two inputed numbers
    System.out.println("Exercise 8");
    System.out.println("Input a number:");
    int x = in.nextInt();
    System.out.println("Input a number:");
    int y = in.nextInt();
    int results = Ackermann(x,y);
    if (isNegative(results) == true) {
      //result will be negative if the inputed numbers are non negative integers
      //An error statement will be outputed if the resulkt is negative
      System.out.println("please input a non negative number");
    } else {
      //if the inputed number is valid, then it displaces the result
    System.out.println(results);
    }
  }

  //exercise 3
  public static boolean isDivisible(int n, int m){
    return (n % m == 0); //returns true if divisible and false if not
  }

  public static boolean isTriangle(int sideLength1, int sideLength2, int sideLength3  ){
    if ((sideLength3 < sideLength1 + sideLength2) && (sideLength2 < sideLength1 + sideLength3) && (sideLength1 < sideLength2 + sideLength3)) {
      //if all side lengths are less than the sum of the other two side lengths, return true
      return true;
    } else {
      return false;
    }
  }


  public static int Ackermann(int m, int n){
    if (m==0) {
      return (n+1);
    } else if ((m>0) && (n==0)) {
      return Ackermann(m-1,1);
    } else if ((m>0) && (n>0)) {
      return Ackermann(m-1,Ackermann(m,n-1));
    } else {
      return -1;
    }
  }

  public static boolean isNegative(int x){
    return (x<0); // checks if either m or n is negative
    }
}
