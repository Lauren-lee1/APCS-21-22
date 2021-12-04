
/*****************************************************
 * Perfect Purple Petunias (John Gupta-She, Lauren Lee, Emily Ortiz)
 * APCS pd08
 * HW42 -- Be More Rational
 * 2021-12-1
 * time spent: 0.5 hrs
 *****************************************************/

 /*****************************************************
DISCO:
*beware of instance variables/variables created by a function, java is pass-by-value, not reference!
*map out steps before starting to save you trouble
QCC:
* why does java throw up a "missing return statement" error when all cases are accounted for?
  *****************************************************/

public class Rational{

  private int numerator;
  private int denominator;

  public Rational(){
    numerator = 0;
    denominator = 1;
  }

  public Rational(int a, int b){
    if (b == 0){
      numerator = 0;
      denominator = 1;
      System.out.println("Denominator can't be 0. Rational set to 0/1.");
    }else{
      numerator = a;
      denominator = b;
    }
  }

  public String toString(){
    return numerator + "/" + denominator;
  }

  private double floatValue(){
    return (double)numerator/ (double) denominator;
  }

  private void multiply(Rational a){
    numerator = numerator * a.numerator;
    denominator = denominator * a.denominator;
  }

  private void divide(Rational a){
    numerator = numerator * a.denominator;
    denominator = denominator * a.numerator;
  }

  private void add(Rational a){
    numerator = numerator*a.denominator + a.numerator*denominator;
    denominator = a.denominator*denominator;
  }

  private void subtract(Rational a){
    numerator = numerator*a.denominator - a.numerator*denominator;
    denominator = a.denominator * denominator;
  }

  private int gcd(){
    int num = numerator;
    int den = denominator;
    while (num != den) {
      if (num > den) {
        num = num - den;
      }
      else if (den > num) {
        den = den - num;
      }
    }
    return num;
  }

  private void reduce(){
    int gcd = gcd();
    numerator = numerator / gcd;
    denominator = denominator / gcd;
  }

  private int compareTo(Rational a){
    if (numerator * a.denominator == denominator * a.numerator){
      return 0;
    } else if (numerator * a.denominator > denominator * a.numerator){
      return 1;
    } else {
      return -1;
    }
  }

  public static void main(String[] args){
    System.out.println();

    Rational def = new Rational();
    System.out.println("Default contructor: " + def + " ...should be 0/1");
    System.out.println("//====================================");

    Rational d0 = new Rational(1, 0);
    System.out.println("Denominator set to 0: " + d0 + " ...should be 0/1");
    System.out.println("//====================================");

    Rational r = new Rational(1,8);
    Rational s = new Rational(1,2);
    System.out.println("r: " + r + " ...should be 1/8");
    System.out.println("s: " + s + " ...should be 1/2");
    System.out.println("float value of r " + r.floatValue() + " ...should be 0.125");
    System.out.println("float value of s " + s.floatValue() + " ...should be 0.5");
    r.multiply(s);
    System.out.println("value of r after multiplication: " + r + " ...1/16");
    System.out.println("value of s after multiplication: " + s + " ...1/2");
    r.divide(s);
    System.out.println("value of r after division: " + r + " ...2/16");
    System.out.println("value of s after division: " + s + " ...1/2");
    r.add(s);
    System.out.println("value of r after addition: " + r + "...20/32");
    System.out.println("value of s after addition: " + s + "...1/2");
    System.out.println("gcd of r: " + r.gcd() + "...4");
    r.subtract(s);
    System.out.println("value of r after subtraction: " + r + "...8/64");
    System.out.println("value of s after subtraction: " + s + "...1/2");
    System.out.println("gcd of r: " + r.gcd() + "...2");
    r.reduce();
    s.reduce();
    System.out.println("value of r after reduction: " + r + "...1/8");
    System.out.println("value of s after reduction: " + s + "...1/2");
    System.out.println("r compared to s: " + r.compareTo(s) + "...-1");
    System.out.println("s compared to r: " + s.compareTo(r) + "...1");
    s.numerator = 2;
    r.numerator = 2;
    s.denominator = 3;
    r.denominator = 3;
    System.out.println("s compared to r: " + s.compareTo(r) + "...0");

/**
    System.out.println("//====================================");
    Rational r3 = new Rational(2, 3);
    Rational r4 = new Rational();

    System.out.println(r3);
    System.out.println(r4);
    System.out.println(r3.floatValue());
    r3.multiply(r4);
    System.out.println(r3);
    r3.divide(r4);
    System.out.println(r3);
    **/
  }

}
