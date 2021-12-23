public class Driver{

  public static void main(String[] args){
    System.out.println();
    System.out.println("Testing compareTo() on Rationals");
    Rational r = new Rational(2,4);
    Rational s = new Rational(2,4);
    System.out.println(r.compareTo(s) + " ...should be 0");
    r.numerator = 1;
    r.denominator = 3;
    System.out.println(r.compareTo(s) + " ...should be -1");
    r.numerator = 9;
    r.denominator = 3;
    System.out.println(r.compareTo(s) + " ...should be 1");


    System.out.println();
    System.out.println("Testing equals() on Rationals");
    System.out.println(r.equals(s) + " ...should be false");
    r.numerator = 1;
    r.denominator = 2;
    System.out.println(r.equals(s) + " ...should be true");

    System.out.println();
    System.out.println("Testing compareTo() on Objects");
    Object b = new Rational(2,4);
    System.out.println(s.compareTo(b) + " ...should be 0");
    s.numerator = 1;
    s.denominator = 3;
/**
    b.numerator = 1;
    b.denominator = 3;
**///can't do this because b is a an object, not necessarily Rational
    System.out.println(s.compareTo(b) + " ...should be -1");
    s.numerator = 9;
    s.denominator = 3;
    System.out.println(s.compareTo(b) + " ...should be 1");

    System.out.println();
    System.out.println("Testing equals() on Objects");
    System.out.println(s.equals(b) + " ...should be false");
    s.numerator = 1;
    s.denominator = 2;
    System.out.println(s.equals(b) + " ...should be true");

    System.out.println();
    System.out.println("Testing on Objects not Rational");
    Integer c = new Integer(3);
    System.out.println(s.compareTo(c) + " ...should output error");

    }
}
