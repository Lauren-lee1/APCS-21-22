/**
Dancing HotDogs: Lauren Lee, Jonathan Song
APCS
HW23: What does Equality Look like?
2021-10-24
time spent: 3.5 hrs
**/


import java.lang.Math;

public class Coin {

//attributes
  public double value;
  public String upFace;
  public String name;
  public int flipCtr;
  public int headsCtr;
  public int tailsCtr;
  public double bias = 0.5;

  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
    reset ( "heads", 0.5);
  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
    this();
    name = s;
    assignValue(s);
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
    this(s);
    upFace = nowFace;
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
    if (s == "penny") {
      value = 0.01;
    } else {
      if (s == "nickel") {
        value = 0.05;
      } else {
        if (s == "dime") {
          value = 0.10;
        } else {
          if (s == "quarter") {
            value = 0.25;
          }else {
              if (s == "half dollar") {
                  value = 0.50;
              } else {
                value = 1.00;
              }
            }
          }
       }
    }
    return value;
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
    flipCtr = 0;
    tailsCtr = 0;
    headsCtr = 0;
    upFace = s;
    bias = d;
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    double num = Math.random();
    if (num>bias) {
      headsCtr = headsCtr + 1;
      upFace = "heads";
    } else {
      tailsCtr = tailsCtr + 1;
      upFace = "tails";
    }
    flipCtr = flipCtr + 1;
    return upFace;
  }

  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    return upFace.equals(other.upFace);
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    return name + " -- " + upFace;
  }

}//end class
