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
