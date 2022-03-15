// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW76 -- We Got a Little Ol' Convoy
// 2022-03-14
// time spent: 1.0 hrs
// KTS: 1

/*
DISCO:
* in while loops, we set the conditional to temp.getNext()!=null because we want to avoid null pointer exceptions by exhausting all the nodes that aren't null.
QCC
*can we create an instance of an interface?
*what is the use of interface if we can write the class without implementing interface?
*/

/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------
  /*
  two cases:
  1. if head is just null, make new node
  2. go through each node & setnext()
  */
  public boolean add( String newVal )
  {
      if (_head == null){
        _size ++;
        _head = new LLNode(newVal, null);
      } else {
        LLNode temp = _head;
        while(temp.getNext() != null){
          temp = temp.getNext();
        }
        _size ++;
        temp.setNext(new LLNode(newVal, null));
      }
      return true;
  }


  // iterate until desired index and return the indexed node.
  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();
    LLNode temp = _head;
    for (int i = 0 ; i <= index ; i++){
      temp = temp.getNext();
    }
    return temp.getCargo();

    // YOUR CODE HERE
  }

  // similar to get, iterate until your desired index and replace it with newVal
  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    LLNode temp = _head;
    for (int i = 0 ; i <= index ; i++){
      temp = temp.getNext();
     }
     String old = temp.getCargo();
     temp.setCargo(newVal);
     return old;
    // YOUR CODE HERE
  }


  //return number of nodes in list
  public int size()
  {
    return _size;
    // YOUR CODE HERE
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {

    String ret = "{";
    LLNode temp = _head;

    while (temp!=null){
      ret = ret + temp.getCargo() + ",";
      temp = temp.getNext();
    }
    ret = ret + "}";
    return ret;
    // YOUR CODE HERE
  }


  //main method for testing
  public static void main( String[] args )
  {
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
