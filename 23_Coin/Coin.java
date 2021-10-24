/**
Dancing HotDogs: Lauren Lee, Johnathon Song
APCS
HW23: What does Equality Look like?
2021-10-24
time spent: 3.5 hrs
**/

/**
DISCO:
- when a variable is returned but it has not been defined, the default definiton is null
- import java.lang.Math to use Math methods like Math.random().
- Math.random() generates a psuedo random double from 0.0 to 1.0
QCC:
- our previous algo for flip() was much more complicated.
We mimiced a probability in a list. For example if the generated number was 0.5, 5 elements in the list would be heads and the other would be tails.
Then, we picked a random element to be picked for the result of the flip. However, I kept getting the same results. Why does this happen.
Old code:
public String flip() {
  String [] list;
  list = new String [9];
  double determine = Math.random();
  determine = (int) determine * 10;
  //heads
  if (determine > 5) {
    for (int i = 0; i < (int) determine - 1; i++){
      list[i] = "heads";
    }
    for (int i = (int) determine - 1; i <= 9; i++){
      list[i] = "tails";
    }
  } else {
    if (determine < 5){
      determine = 10 - determine;
      for (int i = 0; i < (int) determine - 1; i++){
        list[i] = "tails";
      }
      for (int i = (int) determine - 1; i <= 9; i++){
        list[i] = "heads";
      }
    } else {
      list[0] = "tails";
      list[1] = "heads";
      list[2] = "tails";
      list[3] = "heads";
      list[4] = "tails";
      list[5] = "heads";
      list[6] = "tails";
      list[7] = "heads";
      list[8] = "tails";
      list[9] = "heads";
    }
  }
  int num = (int) ((Math.random() * 10)-1);
  if (list[num] == "heads"){
    headsCtr = headsCtr + 1;
    flipCtr = flipCtr + 1;
    upFace = "heads";
    return "heads";
  } else {
    tailsCtr = tailsCtr + 1;
    flipCtr = flipCtr + 1;
    upFace = "tails";
    return "tails";
  }
}
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
  public double bias;

  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
    upFace = "heads";
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
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
    name = s;
    upFace = "heads";
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
    name = s;
    upFace = nowFace;
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
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
          value = 0.25;
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
      flipCtr = flipCtr + 1;
      upFace = "heads";
      return "heads";
    } else {
      tailsCtr = tailsCtr + 1;
      flipCtr = flipCtr + 1;
      upFace = "tails";
      return "tails";
    }
  }

  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    if (upFace == other.getUpFace()) {
      return true;
    } else {
      return false;
    }
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
