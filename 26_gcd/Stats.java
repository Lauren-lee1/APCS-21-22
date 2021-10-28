/**
Clueless Cats: Vansh Saboo + Tiffany, Lauren Lee + Bo, Diana Akhmedova + Ajax
APCS
HW26: GCD Three Ways
2021-10-27
Time Spent: 1 hour
DISCO:
- The gcd method used division and finding the modulo operation to find the greatest common factor, while the gcdEW uses the subtraction method based on which integer is greater to find the GCD.
QCC:
- Why do we have to return the function call in gcdER?
ALGO:
- If integer a is greater than b, subtract b from a until both numbers are equal, return the equal integer.
- If integer b is greater than a, subtract a from b until both numbers are equal, return the equal integer.
- If integer a is equal to b, return a.
**/

public class Stats {

  public static void main( String args[] ) {
    System.out.println("Brute-Force:");

    System.out.println(gcd(15, 18));
    System.out.println(gcd(3, 14));
    System.out.println(gcd(28, 16));
    System.out.println(gcd(17, 13));
    System.out.println(gcd(0, 0));

    System.out.println();
    System.out.println("Recursive:");

    System.out.println(gcdER(15, 18));
    System.out.println(gcdER(3, 14));
    System.out.println(gcdER(16, 28));
    System.out.println(gcd(17, 13));
    System.out.println(gcd(0, 0));

    System.out.println();
    System.out.println("Iterative While Loop:");

    System.out.println(gcdEW(15, 18));
    System.out.println(gcdEW(3, 14));
    System.out.println(gcdEW(16, 28));
    System.out.println(gcd(17, 13));
    System.out.println(gcd(0, 0));
  }

  public static int gcd( int a, int b ) {
    int divisor = 1;
    int gcd = 0;
    if ( a > b ) {
      while( divisor <= b ) {
        if ( a % divisor == 0 && b % divisor == 0 ) {
          gcd = divisor;
          divisor = divisor + 1;
        }
        else {
          divisor = divisor + 1;
        }
      }
      return gcd;
    }
    if ( b > a ) {
      while( divisor <= a ) {
        if ( a % divisor == 0 && b % divisor == 0 ) {
          gcd = divisor;
          divisor = divisor + 1;
        }
        else {
          divisor = divisor + 1;
        }
      }
      return gcd;
    }
    else {
      return a;
    }
  }

  public static int gcdER( int a, int b ) {
    if ( a == b ) {
      return a;
    }
    else if ( a > b ) {
      return gcdER( b, a - b );
    }
    else {
      return gcdER( a, b - a );
    }
  }

  public static int gcdEW( int a, int b ) {
    while ( a != b ) { // Repeat until a and b are equal
      if ( a > b ) {
        a -= b; // If a > b, decrease a by b
      }
      else {
        b -= a; // If b > a, decrease b by a
      }
    }
    return a;
  }
}
