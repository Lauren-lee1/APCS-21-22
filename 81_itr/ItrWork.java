// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW81 -- Thank You, Next
// 2022-03-24
// time spent: 0.7hrs

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
     * The Iterator interface is used by a lot of classes we've discussed, such as Scanner
     * Other DISCO is covered in both summaries.

    QCC
     * In the function oddsB(), why do we need to typecast the output of it.next() to integer, when it is already
       a list of Integers?
     * What exactly is a List? We're aware it's an interface, but we've never been totally clear how it's used
     * We now understand interfaces better

    SUMMARY THE FIRST:
      - The Iterator interface is a general case that allows us to obtain elements one at a time from a variable
      - Contains the following methods:
         - hasNext() -> returns true if the iteration has more elements (words borrowed)
         - next()    -> returns the next item of the iteration
         - remove()  -> removes the last element of the iterator. should be called once after calling next.

    SUMMARY THE SECOND:
      - You have to create Iterator variables when you're not using a FOREACH loop
      - Both found() methods are searching to see if a certain target element.
         - foundA() doesn't require you to use an Iterator instance, while foundB() does
         - Same principle applies to oddsA() and oddsB()

**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for ( Integer i : L ) {
      if (i.equals(key)) return true;
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    Iterator it = L.iterator();
    while (it.hasNext()) {
      if (it.next().equals(key)) return true;
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> odds = new ArrayList<Integer>();
    for ( Integer i : L ) {
      if ( i % 2 == 1 ) odds.add(i);
    }
    return odds;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    Iterator it = L.iterator();
    List<Integer> odds = new ArrayList<Integer>();
    Integer next;

    while (it.hasNext()) {
      next = (Integer) it.next();
      if ( next % 2 == 1 ) odds.add(next);
    }

    return odds;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator it = L.iterator();

    while (it.hasNext()) {
      if ((Integer) it.next() % 2 == 0) it.remove();
    }
  }


  public static void main( String [] args )
  {
    //var type: List   obj type: ?
    List<Integer> L = new ArrayList<Integer>();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    System.out.print("{");
    for ( Integer i : L )
      System.out.print(i + ", ");
    System.out.println("}");

    // b) explicitly using an iterator
    System.out.print("{");
    Iterator it = L.iterator();
    while (it.hasNext())
      System.out.print(it.next() + ", ");
    System.out.println("}");

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
