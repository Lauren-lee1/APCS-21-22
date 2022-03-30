// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW84 -- Stack: What Is It Good For?
// 2022-03-29t
// time spent: 0.8hrs

/***

  DISCO
   - Stacks can be used to reverse sequences and validating parenthesis
   - When our program encounters a closing parenthesis, it must first check if
     the stack is empty. Otherwise, it will try to get the last item of the
     stack, which doesn't exist.
   - One issue we ran into was how to efficiently and concisely check if an
     opening and closing bracket are of the same type. Our solution was to
     create two String variables, "OPENING" and "CLOSING". Each variable
     stores the three types of opening or closing brackets, such that the
     indexes of each correspond to each other. For example:
       OPENING = "([{"
       CLOSING = ")]}"
     Here, the opening and closing curly parenthesis share the same index, as
     does both other types. In order to easily check if an opening and closing
     parenthesis, you can just check if their indexes are equal.

  QCC
   - Do programming language compilers use stacks when validating parenthesis?
   - How does the efficiency of reversing a String via stacks compare with the
     efficiency of reversing a String via for loops? Both seem to be O(n), but
     using stacks might be more memory-intensive.

***/

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  public static final String OPENING = "([{";
  public static final String CLOSING = ")]}";

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    String out = "";
    Latkes stack = new Latkes(s.length());

    for (int i = 0; i < s.length(); i++)
      stack.push(s.substring(i, i + 1));

    for (int i = 0; i < s.length(); i++)
      out += stack.pop();

    return out;
  }

  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    Latkes stack = new Latkes(s.length());
    char currentChar;
    char popped;

    for (int i = 0; i < s.length(); i++) {
      currentChar = s.charAt(i);

      if (OPENING.indexOf(currentChar) != -1) {
        stack.push(currentChar + "");
      } else if (CLOSING.indexOf(currentChar) != -1) {

        if (stack.isEmpty())
          return false;

        popped = stack.pop().charAt(0);                // the ".charAt(0)" effectively converts the string returned by stack.pop() to a char

        if (OPENING.indexOf(popped) != CLOSING.indexOf(currentChar))
          return false;
      }
    }

    if (stack.isEmpty()) return true;
    return false;

    /*
    ALGO:
    go through each character
        if the character is an opening character,
            add it to the stack
        if the character is a closing character,
            if the character corresponds with the last item in the stack,
                pop()
            else
                return false
    if empty,
        return true
    else,
        return false
    */
  }

  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
