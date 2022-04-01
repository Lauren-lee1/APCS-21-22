/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 Algorithm (that did not work for this skeleton):
 Parsing right to left for subtraction purposes

  - take the scheme expression as a string array and push each element in the corresponding stack
    - take in closing parens and numbers to stack 2
    - take operators in stack 1

  - when met with a opening paren, perform the popped operation in stack 1 on the numbers in stack two until you reach a closing paren
  - Push the resulting number into stack 2

  - Continue pushing/popping/performing operations until you reach the end of the string array

 RECURSIVE ALGO THAT DIDN'T GO THROUGH
 BASE CASE:
   Just one number : return that number
 RECURSIVE CASE:
   NOT just one number
   Iterate through every argument of the operator, and call the function on that, and apply the operator to the result
 *
 * STACK OF CHOICE: llStack by Mykolyk
 * b/c we wanted to become more familiarized with LList because we are still unsure about it.
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    //have a variable for all operators
    final String operators = "+-*";

    //take out whitespace
    String[] noSpace = expr.split("\\s+");

    //using 2 stacks to solve expressions
    Stack<Integer> ops = new LLStack<Integer>();
    Stack<String> nums = new LLStack<String>();

    //for loop to ensure all elements are accounted for

    for (int i = noSpace.length-1; i >= 0; i--){
      //assigning everything as a String variable as we go through expression
      String item = noSpace[i];

      //assigning operators with int values (used indexOf again rather than checking for the specific operator)
      if (operators.indexOf(item) > -1) {
        ops.push(operators.indexOf(item) + 1); //+1 because index starts at 0
      }

      //commencing solving once we get a )
      else if(item.equals("(")) {
        int popped = ops.pop();
        nums.push(unload(popped, nums));
      }

      //adding numbers and (
      else {
        nums.push(item);
      }

    }
      //da final answer!
      return nums.pop();


  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    int unload = Integer.parseInt(numbers.pop());

    //adding
    if (op == 1) {
      while (!numbers.peekTop().equals(")"))
        unload += Integer.parseInt(numbers.pop());
    }
    //subtracting
    if (op == 2) {
      while (!numbers.peekTop().equals(")"))
        unload -= Integer.parseInt(numbers.pop());
    }
    //multiplying
    if (op == 3) {
      while (!numbers.peekTop().equals(")"))
        unload *= Integer.parseInt(numbers.pop());
    }
    numbers.pop();
    return Integer.toString(unload);

  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
  }//main()

}//end class Scheme
